package groot.workflow.code.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkOrderExample() {
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

        public Criteria andWoCodeIsNull() {
            addCriterion("wo_code is null");
            return (Criteria) this;
        }

        public Criteria andWoCodeIsNotNull() {
            addCriterion("wo_code is not null");
            return (Criteria) this;
        }

        public Criteria andWoCodeEqualTo(String value) {
            addCriterion("wo_code =", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeNotEqualTo(String value) {
            addCriterion("wo_code <>", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeGreaterThan(String value) {
            addCriterion("wo_code >", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeGreaterThanOrEqualTo(String value) {
            addCriterion("wo_code >=", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeLessThan(String value) {
            addCriterion("wo_code <", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeLessThanOrEqualTo(String value) {
            addCriterion("wo_code <=", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeLike(String value) {
            addCriterion("wo_code like", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeNotLike(String value) {
            addCriterion("wo_code not like", value, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeIn(List<String> values) {
            addCriterion("wo_code in", values, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeNotIn(List<String> values) {
            addCriterion("wo_code not in", values, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeBetween(String value1, String value2) {
            addCriterion("wo_code between", value1, value2, "woCode");
            return (Criteria) this;
        }

        public Criteria andWoCodeNotBetween(String value1, String value2) {
            addCriterion("wo_code not between", value1, value2, "woCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNull() {
            addCriterion("node_code is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("node_code is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("node_code =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("node_code <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("node_code >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("node_code >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("node_code <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("node_code <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("node_code like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("node_code not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("node_code in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("node_code not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("node_code between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("node_code not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andWoStatusIsNull() {
            addCriterion("wo_status is null");
            return (Criteria) this;
        }

        public Criteria andWoStatusIsNotNull() {
            addCriterion("wo_status is not null");
            return (Criteria) this;
        }

        public Criteria andWoStatusEqualTo(Integer value) {
            addCriterion("wo_status =", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotEqualTo(Integer value) {
            addCriterion("wo_status <>", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusGreaterThan(Integer value) {
            addCriterion("wo_status >", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wo_status >=", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusLessThan(Integer value) {
            addCriterion("wo_status <", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wo_status <=", value, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusIn(List<Integer> values) {
            addCriterion("wo_status in", values, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotIn(List<Integer> values) {
            addCriterion("wo_status not in", values, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusBetween(Integer value1, Integer value2) {
            addCriterion("wo_status between", value1, value2, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wo_status not between", value1, value2, "woStatus");
            return (Criteria) this;
        }

        public Criteria andWoReviewersIsNull() {
            addCriterion("wo_reviewers is null");
            return (Criteria) this;
        }

        public Criteria andWoReviewersIsNotNull() {
            addCriterion("wo_reviewers is not null");
            return (Criteria) this;
        }

        public Criteria andWoReviewersEqualTo(String value) {
            addCriterion("wo_reviewers =", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersNotEqualTo(String value) {
            addCriterion("wo_reviewers <>", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersGreaterThan(String value) {
            addCriterion("wo_reviewers >", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersGreaterThanOrEqualTo(String value) {
            addCriterion("wo_reviewers >=", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersLessThan(String value) {
            addCriterion("wo_reviewers <", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersLessThanOrEqualTo(String value) {
            addCriterion("wo_reviewers <=", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersLike(String value) {
            addCriterion("wo_reviewers like", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersNotLike(String value) {
            addCriterion("wo_reviewers not like", value, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersIn(List<String> values) {
            addCriterion("wo_reviewers in", values, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersNotIn(List<String> values) {
            addCriterion("wo_reviewers not in", values, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersBetween(String value1, String value2) {
            addCriterion("wo_reviewers between", value1, value2, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoReviewersNotBetween(String value1, String value2) {
            addCriterion("wo_reviewers not between", value1, value2, "woReviewers");
            return (Criteria) this;
        }

        public Criteria andWoSituationIsNull() {
            addCriterion("wo_situation is null");
            return (Criteria) this;
        }

        public Criteria andWoSituationIsNotNull() {
            addCriterion("wo_situation is not null");
            return (Criteria) this;
        }

        public Criteria andWoSituationEqualTo(String value) {
            addCriterion("wo_situation =", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationNotEqualTo(String value) {
            addCriterion("wo_situation <>", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationGreaterThan(String value) {
            addCriterion("wo_situation >", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationGreaterThanOrEqualTo(String value) {
            addCriterion("wo_situation >=", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationLessThan(String value) {
            addCriterion("wo_situation <", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationLessThanOrEqualTo(String value) {
            addCriterion("wo_situation <=", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationLike(String value) {
            addCriterion("wo_situation like", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationNotLike(String value) {
            addCriterion("wo_situation not like", value, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationIn(List<String> values) {
            addCriterion("wo_situation in", values, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationNotIn(List<String> values) {
            addCriterion("wo_situation not in", values, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationBetween(String value1, String value2) {
            addCriterion("wo_situation between", value1, value2, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoSituationNotBetween(String value1, String value2) {
            addCriterion("wo_situation not between", value1, value2, "woSituation");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeIsNull() {
            addCriterion("wo_createtime is null");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeIsNotNull() {
            addCriterion("wo_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeEqualTo(Date value) {
            addCriterion("wo_createtime =", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeNotEqualTo(Date value) {
            addCriterion("wo_createtime <>", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeGreaterThan(Date value) {
            addCriterion("wo_createtime >", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wo_createtime >=", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeLessThan(Date value) {
            addCriterion("wo_createtime <", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("wo_createtime <=", value, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeIn(List<Date> values) {
            addCriterion("wo_createtime in", values, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeNotIn(List<Date> values) {
            addCriterion("wo_createtime not in", values, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeBetween(Date value1, Date value2) {
            addCriterion("wo_createtime between", value1, value2, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("wo_createtime not between", value1, value2, "woCreatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeIsNull() {
            addCriterion("wo_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeIsNotNull() {
            addCriterion("wo_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeEqualTo(Date value) {
            addCriterion("wo_updatetime =", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeNotEqualTo(Date value) {
            addCriterion("wo_updatetime <>", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeGreaterThan(Date value) {
            addCriterion("wo_updatetime >", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wo_updatetime >=", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeLessThan(Date value) {
            addCriterion("wo_updatetime <", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("wo_updatetime <=", value, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeIn(List<Date> values) {
            addCriterion("wo_updatetime in", values, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeNotIn(List<Date> values) {
            addCriterion("wo_updatetime not in", values, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("wo_updatetime between", value1, value2, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("wo_updatetime not between", value1, value2, "woUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWoFlagIsNull() {
            addCriterion("wo_flag is null");
            return (Criteria) this;
        }

        public Criteria andWoFlagIsNotNull() {
            addCriterion("wo_flag is not null");
            return (Criteria) this;
        }

        public Criteria andWoFlagEqualTo(Integer value) {
            addCriterion("wo_flag =", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagNotEqualTo(Integer value) {
            addCriterion("wo_flag <>", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagGreaterThan(Integer value) {
            addCriterion("wo_flag >", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("wo_flag >=", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagLessThan(Integer value) {
            addCriterion("wo_flag <", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagLessThanOrEqualTo(Integer value) {
            addCriterion("wo_flag <=", value, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagIn(List<Integer> values) {
            addCriterion("wo_flag in", values, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagNotIn(List<Integer> values) {
            addCriterion("wo_flag not in", values, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagBetween(Integer value1, Integer value2) {
            addCriterion("wo_flag between", value1, value2, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("wo_flag not between", value1, value2, "woFlag");
            return (Criteria) this;
        }

        public Criteria andWoRemarkIsNull() {
            addCriterion("wo_remark is null");
            return (Criteria) this;
        }

        public Criteria andWoRemarkIsNotNull() {
            addCriterion("wo_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWoRemarkEqualTo(String value) {
            addCriterion("wo_remark =", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkNotEqualTo(String value) {
            addCriterion("wo_remark <>", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkGreaterThan(String value) {
            addCriterion("wo_remark >", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wo_remark >=", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkLessThan(String value) {
            addCriterion("wo_remark <", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkLessThanOrEqualTo(String value) {
            addCriterion("wo_remark <=", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkLike(String value) {
            addCriterion("wo_remark like", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkNotLike(String value) {
            addCriterion("wo_remark not like", value, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkIn(List<String> values) {
            addCriterion("wo_remark in", values, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkNotIn(List<String> values) {
            addCriterion("wo_remark not in", values, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkBetween(String value1, String value2) {
            addCriterion("wo_remark between", value1, value2, "woRemark");
            return (Criteria) this;
        }

        public Criteria andWoRemarkNotBetween(String value1, String value2) {
            addCriterion("wo_remark not between", value1, value2, "woRemark");
            return (Criteria) this;
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

        public Criteria andBusinessCodeIsNull() {
            addCriterion("business_code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeIsNotNull() {
            addCriterion("business_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeEqualTo(String value) {
            addCriterion("business_code =", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotEqualTo(String value) {
            addCriterion("business_code <>", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeGreaterThan(String value) {
            addCriterion("business_code >", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeGreaterThanOrEqualTo(String value) {
            addCriterion("business_code >=", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLessThan(String value) {
            addCriterion("business_code <", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLessThanOrEqualTo(String value) {
            addCriterion("business_code <=", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLike(String value) {
            addCriterion("business_code like", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotLike(String value) {
            addCriterion("business_code not like", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeIn(List<String> values) {
            addCriterion("business_code in", values, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotIn(List<String> values) {
            addCriterion("business_code not in", values, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeBetween(String value1, String value2) {
            addCriterion("business_code between", value1, value2, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotBetween(String value1, String value2) {
            addCriterion("business_code not between", value1, value2, "businessCode");
            return (Criteria) this;
        }

        public Criteria andWoApplicantIsNull() {
            addCriterion("wo_applicant is null");
            return (Criteria) this;
        }

        public Criteria andWoApplicantIsNotNull() {
            addCriterion("wo_applicant is not null");
            return (Criteria) this;
        }

        public Criteria andWoApplicantEqualTo(String value) {
            addCriterion("wo_applicant =", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantNotEqualTo(String value) {
            addCriterion("wo_applicant <>", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantGreaterThan(String value) {
            addCriterion("wo_applicant >", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("wo_applicant >=", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantLessThan(String value) {
            addCriterion("wo_applicant <", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantLessThanOrEqualTo(String value) {
            addCriterion("wo_applicant <=", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantLike(String value) {
            addCriterion("wo_applicant like", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantNotLike(String value) {
            addCriterion("wo_applicant not like", value, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantIn(List<String> values) {
            addCriterion("wo_applicant in", values, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantNotIn(List<String> values) {
            addCriterion("wo_applicant not in", values, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantBetween(String value1, String value2) {
            addCriterion("wo_applicant between", value1, value2, "woApplicant");
            return (Criteria) this;
        }

        public Criteria andWoApplicantNotBetween(String value1, String value2) {
            addCriterion("wo_applicant not between", value1, value2, "woApplicant");
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