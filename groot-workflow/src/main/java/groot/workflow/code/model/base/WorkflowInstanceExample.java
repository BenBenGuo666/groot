package groot.workflow.code.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowInstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkflowInstanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWfInstanceCodeIsNull() {
            addCriterion("wf_instance_code is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeIsNotNull() {
            addCriterion("wf_instance_code is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeEqualTo(String value) {
            addCriterion("wf_instance_code =", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeNotEqualTo(String value) {
            addCriterion("wf_instance_code <>", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeGreaterThan(String value) {
            addCriterion("wf_instance_code >", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wf_instance_code >=", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeLessThan(String value) {
            addCriterion("wf_instance_code <", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeLessThanOrEqualTo(String value) {
            addCriterion("wf_instance_code <=", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeLike(String value) {
            addCriterion("wf_instance_code like", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeNotLike(String value) {
            addCriterion("wf_instance_code not like", value, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeIn(List<String> values) {
            addCriterion("wf_instance_code in", values, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeNotIn(List<String> values) {
            addCriterion("wf_instance_code not in", values, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeBetween(String value1, String value2) {
            addCriterion("wf_instance_code between", value1, value2, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCodeNotBetween(String value1, String value2) {
            addCriterion("wf_instance_code not between", value1, value2, "wfInstanceCode");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeIsNull() {
            addCriterion("wf_instance_createtime is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeIsNotNull() {
            addCriterion("wf_instance_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeEqualTo(Date value) {
            addCriterion("wf_instance_createtime =", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeNotEqualTo(Date value) {
            addCriterion("wf_instance_createtime <>", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeGreaterThan(Date value) {
            addCriterion("wf_instance_createtime >", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wf_instance_createtime >=", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeLessThan(Date value) {
            addCriterion("wf_instance_createtime <", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("wf_instance_createtime <=", value, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeIn(List<Date> values) {
            addCriterion("wf_instance_createtime in", values, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeNotIn(List<Date> values) {
            addCriterion("wf_instance_createtime not in", values, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeBetween(Date value1, Date value2) {
            addCriterion("wf_instance_createtime between", value1, value2, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("wf_instance_createtime not between", value1, value2, "wfInstanceCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeIsNull() {
            addCriterion("wf_instance_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeIsNotNull() {
            addCriterion("wf_instance_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeEqualTo(Date value) {
            addCriterion("wf_instance_updatetime =", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeNotEqualTo(Date value) {
            addCriterion("wf_instance_updatetime <>", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeGreaterThan(Date value) {
            addCriterion("wf_instance_updatetime >", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wf_instance_updatetime >=", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeLessThan(Date value) {
            addCriterion("wf_instance_updatetime <", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("wf_instance_updatetime <=", value, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeIn(List<Date> values) {
            addCriterion("wf_instance_updatetime in", values, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeNotIn(List<Date> values) {
            addCriterion("wf_instance_updatetime not in", values, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("wf_instance_updatetime between", value1, value2, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("wf_instance_updatetime not between", value1, value2, "wfInstanceUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorIsNull() {
            addCriterion("wf_instance_creator is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorIsNotNull() {
            addCriterion("wf_instance_creator is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorEqualTo(String value) {
            addCriterion("wf_instance_creator =", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorNotEqualTo(String value) {
            addCriterion("wf_instance_creator <>", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorGreaterThan(String value) {
            addCriterion("wf_instance_creator >", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("wf_instance_creator >=", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorLessThan(String value) {
            addCriterion("wf_instance_creator <", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorLessThanOrEqualTo(String value) {
            addCriterion("wf_instance_creator <=", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorLike(String value) {
            addCriterion("wf_instance_creator like", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorNotLike(String value) {
            addCriterion("wf_instance_creator not like", value, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorIn(List<String> values) {
            addCriterion("wf_instance_creator in", values, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorNotIn(List<String> values) {
            addCriterion("wf_instance_creator not in", values, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorBetween(String value1, String value2) {
            addCriterion("wf_instance_creator between", value1, value2, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceCreatorNotBetween(String value1, String value2) {
            addCriterion("wf_instance_creator not between", value1, value2, "wfInstanceCreator");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusIsNull() {
            addCriterion("wf_instance_status is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusIsNotNull() {
            addCriterion("wf_instance_status is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusEqualTo(Integer value) {
            addCriterion("wf_instance_status =", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusNotEqualTo(Integer value) {
            addCriterion("wf_instance_status <>", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusGreaterThan(Integer value) {
            addCriterion("wf_instance_status >", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wf_instance_status >=", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusLessThan(Integer value) {
            addCriterion("wf_instance_status <", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wf_instance_status <=", value, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusIn(List<Integer> values) {
            addCriterion("wf_instance_status in", values, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusNotIn(List<Integer> values) {
            addCriterion("wf_instance_status not in", values, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusBetween(Integer value1, Integer value2) {
            addCriterion("wf_instance_status between", value1, value2, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wf_instance_status not between", value1, value2, "wfInstanceStatus");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkIsNull() {
            addCriterion("wf_instance_remark is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkIsNotNull() {
            addCriterion("wf_instance_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkEqualTo(String value) {
            addCriterion("wf_instance_remark =", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkNotEqualTo(String value) {
            addCriterion("wf_instance_remark <>", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkGreaterThan(String value) {
            addCriterion("wf_instance_remark >", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wf_instance_remark >=", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkLessThan(String value) {
            addCriterion("wf_instance_remark <", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkLessThanOrEqualTo(String value) {
            addCriterion("wf_instance_remark <=", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkLike(String value) {
            addCriterion("wf_instance_remark like", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkNotLike(String value) {
            addCriterion("wf_instance_remark not like", value, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkIn(List<String> values) {
            addCriterion("wf_instance_remark in", values, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkNotIn(List<String> values) {
            addCriterion("wf_instance_remark not in", values, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkBetween(String value1, String value2) {
            addCriterion("wf_instance_remark between", value1, value2, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceRemarkNotBetween(String value1, String value2) {
            addCriterion("wf_instance_remark not between", value1, value2, "wfInstanceRemark");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationIsNull() {
            addCriterion("wf_instance_situation is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationIsNotNull() {
            addCriterion("wf_instance_situation is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationEqualTo(String value) {
            addCriterion("wf_instance_situation =", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationNotEqualTo(String value) {
            addCriterion("wf_instance_situation <>", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationGreaterThan(String value) {
            addCriterion("wf_instance_situation >", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationGreaterThanOrEqualTo(String value) {
            addCriterion("wf_instance_situation >=", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationLessThan(String value) {
            addCriterion("wf_instance_situation <", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationLessThanOrEqualTo(String value) {
            addCriterion("wf_instance_situation <=", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationLike(String value) {
            addCriterion("wf_instance_situation like", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationNotLike(String value) {
            addCriterion("wf_instance_situation not like", value, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationIn(List<String> values) {
            addCriterion("wf_instance_situation in", values, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationNotIn(List<String> values) {
            addCriterion("wf_instance_situation not in", values, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationBetween(String value1, String value2) {
            addCriterion("wf_instance_situation between", value1, value2, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceSituationNotBetween(String value1, String value2) {
            addCriterion("wf_instance_situation not between", value1, value2, "wfInstanceSituation");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextIsNull() {
            addCriterion("wf_instance_context is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextIsNotNull() {
            addCriterion("wf_instance_context is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextEqualTo(String value) {
            addCriterion("wf_instance_context =", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextNotEqualTo(String value) {
            addCriterion("wf_instance_context <>", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextGreaterThan(String value) {
            addCriterion("wf_instance_context >", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextGreaterThanOrEqualTo(String value) {
            addCriterion("wf_instance_context >=", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextLessThan(String value) {
            addCriterion("wf_instance_context <", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextLessThanOrEqualTo(String value) {
            addCriterion("wf_instance_context <=", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextLike(String value) {
            addCriterion("wf_instance_context like", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextNotLike(String value) {
            addCriterion("wf_instance_context not like", value, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextIn(List<String> values) {
            addCriterion("wf_instance_context in", values, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextNotIn(List<String> values) {
            addCriterion("wf_instance_context not in", values, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextBetween(String value1, String value2) {
            addCriterion("wf_instance_context between", value1, value2, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceContextNotBetween(String value1, String value2) {
            addCriterion("wf_instance_context not between", value1, value2, "wfInstanceContext");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagIsNull() {
            addCriterion("wf_instance_flag is null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagIsNotNull() {
            addCriterion("wf_instance_flag is not null");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagEqualTo(Integer value) {
            addCriterion("wf_instance_flag =", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagNotEqualTo(Integer value) {
            addCriterion("wf_instance_flag <>", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagGreaterThan(Integer value) {
            addCriterion("wf_instance_flag >", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("wf_instance_flag >=", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagLessThan(Integer value) {
            addCriterion("wf_instance_flag <", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagLessThanOrEqualTo(Integer value) {
            addCriterion("wf_instance_flag <=", value, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagIn(List<Integer> values) {
            addCriterion("wf_instance_flag in", values, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagNotIn(List<Integer> values) {
            addCriterion("wf_instance_flag not in", values, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagBetween(Integer value1, Integer value2) {
            addCriterion("wf_instance_flag between", value1, value2, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfInstanceFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("wf_instance_flag not between", value1, value2, "wfInstanceFlag");
            return (Criteria) this;
        }

        public Criteria andWfCodeIsNull() {
            addCriterion("wf_code is null");
            return (Criteria) this;
        }

        public Criteria andWfCodeIsNotNull() {
            addCriterion("wf_code is not null");
            return (Criteria) this;
        }

        public Criteria andWfCodeEqualTo(String value) {
            addCriterion("wf_code =", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotEqualTo(String value) {
            addCriterion("wf_code <>", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeGreaterThan(String value) {
            addCriterion("wf_code >", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wf_code >=", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLessThan(String value) {
            addCriterion("wf_code <", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLessThanOrEqualTo(String value) {
            addCriterion("wf_code <=", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeLike(String value) {
            addCriterion("wf_code like", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotLike(String value) {
            addCriterion("wf_code not like", value, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeIn(List<String> values) {
            addCriterion("wf_code in", values, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotIn(List<String> values) {
            addCriterion("wf_code not in", values, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeBetween(String value1, String value2) {
            addCriterion("wf_code between", value1, value2, "wfCode");
            return (Criteria) this;
        }

        public Criteria andWfCodeNotBetween(String value1, String value2) {
            addCriterion("wf_code not between", value1, value2, "wfCode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}