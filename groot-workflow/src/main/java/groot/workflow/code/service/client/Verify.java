package groot.workflow.code.service.client;

import groot.workflow.code.model.extension.WorkflowInstanceVo;
import groot.workflow.util.StringUtil;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/24
 */
public class Verify {

    public static VerifyModel verifyCreateWfInstance(WorkflowInstanceVo vo) {
        VerifyModel verify = new VerifyModel();
        String message = "参数不通过，缺少必要参数:";
        if (StringUtil.isEmpty(vo.getApplicant())) {
            message += "applicant|";
            verify.setVerify(false);
        }
        if (StringUtil.isEmpty(vo.getBusinessCode())) {
            message += "businessCode|";
            verify.setVerify(false);
        }
        if (StringUtil.isEmpty(vo.getWfCode())) {
            message += "wfCode";
            verify.setVerify(false);
        }
        if (!verify.getVerify()) {
            verify.setMessage(message);
        }
        return verify;
    }

    public static VerifyModel verifyReview(WorkflowInstanceVo vo) {
        VerifyModel verify = new VerifyModel();
        String message = "缺少参数或数值异常:";
        if (StringUtil.isEmpty(vo.getWfInstanceCode())) {
            message += "wfInstanceCode|";
            verify.setVerify(false);
        }
        if (StringUtil.isEmpty(vo.getReviewers())) {
            message += "reviewers|";
            verify.setVerify(false);
        }
        int array[] = {-1, 0, 1, 2, 3};
        Integer status = Integer.valueOf(vo.getStatus());
        if (StringUtil.isEmpty(vo.getStatus())) {
            message += "status|";
            verify.setVerify(false);
        } else if (status == null || notInArray(status, array)) {
            message += "status 数值异常|";
            verify.setVerify(false);
        }
        if (StringUtil.isEmpty(vo.getWoCode())) {
            message += "woCode|";
            verify.setVerify(false);
        }
        if (!verify.getVerify()) {
            verify.setMessage(message);
        }
        return verify;
    }

    private static boolean notInArray(int num, int[] array) {
        return !inArray(num, array);
    }

    private static boolean inArray(int num, int[] array) {
        for (int i = 0; i < array.length; i++)
            if (num == array[i])
                return true;
        return false;
    }

}
