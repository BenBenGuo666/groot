package groot.workflow.code.service.business.impl;

import groot.workflow.code.model.extension.NodeDto;
import groot.workflow.code.model.extension.WorkOrderDto;
import groot.workflow.code.model.extension.WorkflowInstanceDto;
import groot.workflow.code.service.business.WorkflowInstanceBusiness;
import groot.workflow.code.service.service.NodeService;
import groot.workflow.code.service.service.WorkOrderService;
import groot.workflow.code.service.service.WorkflowInstanceService;
import groot.workflow.constants.Constants;
import groot.workflow.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
@Service
@Slf4j
public class WorkflowInstanceBusinessImpl implements WorkflowInstanceBusiness {

    @Autowired
    private WorkflowInstanceService workflowInstanceService;
    @Autowired
    private NodeService nodeService;
    @Autowired
    private WorkOrderService workOrderService;

    private Map<String, WorkflowInstanceDto> wfiCache = new ConcurrentHashMap(100);

    private void putWfi(WorkflowInstanceDto wfi) {
        WorkflowInstanceDto workflowInstanceDto = new WorkflowInstanceDto();
        BeanUtils.copyProperties(wfi, workflowInstanceDto);
        synchronized (wfiCache) {
            if (wfi != null && StringUtil.isNotEmpty(workflowInstanceDto.getWfInstanceCode())) {
                wfiCache.put(workflowInstanceDto.getWfInstanceCode(), workflowInstanceDto);
            }
        }
    }

    private WorkflowInstanceDto getWfi(String key) {
        return wfiCache.get(key);
    }

    @Override
    public WorkflowInstanceDto finishInstance(WorkflowInstanceDto workflowInstanceDto) {
        workflowInstanceDto = WorkflowInstanceDto.buildFinish(workflowInstanceDto);
        boolean number = workflowInstanceService.modify(workflowInstanceDto);
        log.info("WorkflowInstanceBusiness.finishInstance is finished ---------------> number:" + number);
        return workflowInstanceDto;
    }


    private WorkOrderDto createWorkOrder(WorkflowInstanceDto workflowInstanceDto) {
        workflowInstanceDto.clearWorkOrder();
        WorkOrderDto workOrderDto = WorkOrderDto.buildInitial(workflowInstanceDto);
        workOrderDto.setNodeCode(workflowInstanceDto.getCurrent().getNodeCode());
        workOrderDto.setBusinessCode(workflowInstanceDto.getBusinessCode());
        boolean number = workOrderService.create(workOrderDto);
        log.info("workOrderBusiness.createWorkOrder is created ---------------> number:", number);
        return workOrderDto;
    }

    private NodeDto autoCheck(NodeDto nodeDto, WorkflowInstanceDto workflowInstanceDto){
        WorkOrderDto autoCheckWorkOrder = WorkOrderDto.buildInitial(workflowInstanceDto);
        autoCheckWorkOrder.setWoStatus(Constants.BeansConstans.WO_STATUS_FINISHED);
        autoCheckWorkOrder.setNodeCode(nodeDto.getNodeCode());
        autoCheckWorkOrder.setWoReviewers("admin");
        autoCheckWorkOrder.setWoApplicant(workflowInstanceDto.getWoApplicant());
        autoCheckWorkOrder.setWoCreatetime(new Date());
        autoCheckWorkOrder.setWoUpdatetime(new Date());
        workOrderService.create(autoCheckWorkOrder);
        return nodeDto;
    }

    /**
     * 默认发第二个节点工单
     *
     * @param workflowInstanceDto
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public WorkflowInstanceDto createWorkflowInstance(WorkflowInstanceDto workflowInstanceDto) {
        boolean number = workflowInstanceService.create(workflowInstanceDto);
        log.info("workflowInstanceService.create is created ---------------> number:", number);
        workflowInstanceDto.setCurrent(nodeService.queryHead(workflowInstanceDto.getWfCode()));
        WorkOrderDto firstWorkOrder = WorkOrderDto.buildInitial(workflowInstanceDto);
        firstWorkOrder.setWoStatus(Constants.BeansConstans.WO_STATUS_FINISHED);
        workflowInstanceDto.setWorkOrderDto(firstWorkOrder);
        workflowInstanceDto = consume(workflowInstanceDto);


        return workflowInstanceDto;
    }

    @Override
    public List<WorkflowInstanceDto> queryWorkflowInstance(Map<String, Object> queryMap) {
        return workflowInstanceService.query(queryMap);
    }

    @Override
    public boolean modifyWorkflowInstance(WorkflowInstanceDto workflowInstanceDto) {
        return workflowInstanceService.modify(workflowInstanceDto);
    }

    @Override
    public boolean deleteWorkflowInstance(String id) {
        return workflowInstanceService.removeById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public WorkflowInstanceDto consume(WorkflowInstanceDto workflowInstanceDto) {
        workflowInstanceDto.setWoApplicant(workflowInstanceDto.getWorkOrderDto().getWoApplicant());
        WorkOrderDto currentWorkOrderDto = workflowInstanceDto.getWorkOrderDto();
        NodeDto currentNode = workflowInstanceDto.getCurrent();
        switch (currentWorkOrderDto.getWoStatus()) {
            case Constants.BeansConstans.WO_STATUS_FINISHED:
                NodeDto next = nodeService.queryNext(currentNode.getNodeCode());
                if (Constants.WorkflowConstans.NO_GEN_WORKORDER_STATUS == next.getNodeGenWoStatus()) {
                    next = nodeService.queryNext(next.getNodeCode());
                }
                workflowInstanceDto.setCurrent(next);
                if (StringUtil.isNotEmpty(next.getNodeClassify()) && Constants.WorkflowConstans.TAIL_NODE.equals(next.getNodeClassify())) {
                    return finishInstance(workflowInstanceDto);
                }
                if(next.getNodeAutoCheck()!=null&&next.getNodeAutoCheck()==1){
                    autoCheck(next,workflowInstanceDto);
                    next = nodeService.queryNext(next.getNodeCode());
                    workflowInstanceDto.setCurrent(next);
                }
                break;
            case Constants.BeansConstans.WO_STATUS_BACKED:
                if (currentNode == null) {
                    log.error("WorkflowInstanceBusiness.createWorkOrder error --------------------->currentNode:" + currentNode);
                    break;
                }
                NodeDto prev = nodeService.queryPrev(currentNode.getNodeCode());
                if (StringUtil.isNotEmpty(prev.getNodeClassify()) && Constants.WorkflowConstans.HEAD_NODE.equals(prev.getNodeClassify())) {
                    workflowInstanceDto.setCurrent(currentNode);
                } else {
                    workflowInstanceDto.setCurrent(prev);
                }
                break;
        }
        workflowInstanceDto.clearWorkOrder();
        workflowInstanceDto.setWorkOrderDto(createWorkOrder(workflowInstanceDto));
        return workflowInstanceDto;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public WorkflowInstanceDto review(WorkflowInstanceDto workflowInstanceDto) {
        WorkOrderDto workOrderDto = workflowInstanceDto.getWorkOrderDto();
        workOrderDto.setWoRemark(workflowInstanceDto.getWfInstanceRemark());
        workOrderDto.setWoUpdatetime(new Date());
        workOrderDto.setWoReviewers(workflowInstanceDto.getReviewers());
        workOrderService.modify(workOrderDto);
        WorkflowInstanceDto result = new WorkflowInstanceDto();
        if (Constants.BeansConstans.WO_STATUS_FINISHED == workOrderDto.getWoStatus()
                || Constants.BeansConstans.WO_STATUS_BACKED == workOrderDto.getWoStatus()) {
            result = consume(workflowInstanceDto);
        }
        return result;
    }

    @Override
    public WorkflowInstanceDto buildWorkflowInstance(WorkflowInstanceDto workflowInstanceDto) {
        WorkOrderDto workOrder = workOrderService.get(workflowInstanceDto.getWoCode());
        workOrder.setWoStatus(workflowInstanceDto.getWoStatus());
        workOrder.setWoApplicant(workflowInstanceDto.getWoApplicant());
        workOrder.setWoRemark(workflowInstanceDto.getWfInstanceRemark());
        workflowInstanceDto.setWorkOrderDto(workOrder);
        NodeDto current = nodeService.queryByNodeCode(workOrder.getNodeCode());
        workflowInstanceDto.setCurrent(current);
        workflowInstanceDto.setBusinessCode(workOrder.getBusinessCode());
//        putWfi(workflowInstanceDto);
        return workflowInstanceDto;
    }
}
