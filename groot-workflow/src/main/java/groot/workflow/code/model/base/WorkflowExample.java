package groot.workflow.code.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkflowExample() {
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

        public Criteria andWfNameIsNull() {
            addCriterion("wf_name is null");
            return (Criteria) this;
        }

        public Criteria andWfNameIsNotNull() {
            addCriterion("wf_name is not null");
            return (Criteria) this;
        }

        public Criteria andWfNameEqualTo(String value) {
            addCriterion("wf_name =", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotEqualTo(String value) {
            addCriterion("wf_name <>", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameGreaterThan(String value) {
            addCriterion("wf_name >", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameGreaterThanOrEqualTo(String value) {
            addCriterion("wf_name >=", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLessThan(String value) {
            addCriterion("wf_name <", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLessThanOrEqualTo(String value) {
            addCriterion("wf_name <=", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameLike(String value) {
            addCriterion("wf_name like", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotLike(String value) {
            addCriterion("wf_name not like", value, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameIn(List<String> values) {
            addCriterion("wf_name in", values, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotIn(List<String> values) {
            addCriterion("wf_name not in", values, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameBetween(String value1, String value2) {
            addCriterion("wf_name between", value1, value2, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfNameNotBetween(String value1, String value2) {
            addCriterion("wf_name not between", value1, value2, "wfName");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeIsNull() {
            addCriterion("wf_createtime is null");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeIsNotNull() {
            addCriterion("wf_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeEqualTo(Date value) {
            addCriterion("wf_createtime =", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeNotEqualTo(Date value) {
            addCriterion("wf_createtime <>", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeGreaterThan(Date value) {
            addCriterion("wf_createtime >", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wf_createtime >=", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeLessThan(Date value) {
            addCriterion("wf_createtime <", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("wf_createtime <=", value, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeIn(List<Date> values) {
            addCriterion("wf_createtime in", values, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeNotIn(List<Date> values) {
            addCriterion("wf_createtime not in", values, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeBetween(Date value1, Date value2) {
            addCriterion("wf_createtime between", value1, value2, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("wf_createtime not between", value1, value2, "wfCreatetime");
            return (Criteria) this;
        }

        public Criteria andWfCreatorIsNull() {
            addCriterion("wf_creator is null");
            return (Criteria) this;
        }

        public Criteria andWfCreatorIsNotNull() {
            addCriterion("wf_creator is not null");
            return (Criteria) this;
        }

        public Criteria andWfCreatorEqualTo(String value) {
            addCriterion("wf_creator =", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorNotEqualTo(String value) {
            addCriterion("wf_creator <>", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorGreaterThan(String value) {
            addCriterion("wf_creator >", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("wf_creator >=", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorLessThan(String value) {
            addCriterion("wf_creator <", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorLessThanOrEqualTo(String value) {
            addCriterion("wf_creator <=", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorLike(String value) {
            addCriterion("wf_creator like", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorNotLike(String value) {
            addCriterion("wf_creator not like", value, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorIn(List<String> values) {
            addCriterion("wf_creator in", values, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorNotIn(List<String> values) {
            addCriterion("wf_creator not in", values, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorBetween(String value1, String value2) {
            addCriterion("wf_creator between", value1, value2, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfCreatorNotBetween(String value1, String value2) {
            addCriterion("wf_creator not between", value1, value2, "wfCreator");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeIsNull() {
            addCriterion("wf_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeIsNotNull() {
            addCriterion("wf_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeEqualTo(Date value) {
            addCriterion("wf_modifytime =", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeNotEqualTo(Date value) {
            addCriterion("wf_modifytime <>", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeGreaterThan(Date value) {
            addCriterion("wf_modifytime >", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("wf_modifytime >=", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeLessThan(Date value) {
            addCriterion("wf_modifytime <", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("wf_modifytime <=", value, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeIn(List<Date> values) {
            addCriterion("wf_modifytime in", values, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeNotIn(List<Date> values) {
            addCriterion("wf_modifytime not in", values, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeBetween(Date value1, Date value2) {
            addCriterion("wf_modifytime between", value1, value2, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("wf_modifytime not between", value1, value2, "wfModifytime");
            return (Criteria) this;
        }

        public Criteria andWfModifierIsNull() {
            addCriterion("wf_modifier is null");
            return (Criteria) this;
        }

        public Criteria andWfModifierIsNotNull() {
            addCriterion("wf_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andWfModifierEqualTo(String value) {
            addCriterion("wf_modifier =", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierNotEqualTo(String value) {
            addCriterion("wf_modifier <>", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierGreaterThan(String value) {
            addCriterion("wf_modifier >", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierGreaterThanOrEqualTo(String value) {
            addCriterion("wf_modifier >=", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierLessThan(String value) {
            addCriterion("wf_modifier <", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierLessThanOrEqualTo(String value) {
            addCriterion("wf_modifier <=", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierLike(String value) {
            addCriterion("wf_modifier like", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierNotLike(String value) {
            addCriterion("wf_modifier not like", value, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierIn(List<String> values) {
            addCriterion("wf_modifier in", values, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierNotIn(List<String> values) {
            addCriterion("wf_modifier not in", values, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierBetween(String value1, String value2) {
            addCriterion("wf_modifier between", value1, value2, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfModifierNotBetween(String value1, String value2) {
            addCriterion("wf_modifier not between", value1, value2, "wfModifier");
            return (Criteria) this;
        }

        public Criteria andWfRemarkIsNull() {
            addCriterion("wf_remark is null");
            return (Criteria) this;
        }

        public Criteria andWfRemarkIsNotNull() {
            addCriterion("wf_remark is not null");
            return (Criteria) this;
        }

        public Criteria andWfRemarkEqualTo(String value) {
            addCriterion("wf_remark =", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkNotEqualTo(String value) {
            addCriterion("wf_remark <>", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkGreaterThan(String value) {
            addCriterion("wf_remark >", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("wf_remark >=", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkLessThan(String value) {
            addCriterion("wf_remark <", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkLessThanOrEqualTo(String value) {
            addCriterion("wf_remark <=", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkLike(String value) {
            addCriterion("wf_remark like", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkNotLike(String value) {
            addCriterion("wf_remark not like", value, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkIn(List<String> values) {
            addCriterion("wf_remark in", values, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkNotIn(List<String> values) {
            addCriterion("wf_remark not in", values, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkBetween(String value1, String value2) {
            addCriterion("wf_remark between", value1, value2, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfRemarkNotBetween(String value1, String value2) {
            addCriterion("wf_remark not between", value1, value2, "wfRemark");
            return (Criteria) this;
        }

        public Criteria andWfPermissionIsNull() {
            addCriterion("wf_permission is null");
            return (Criteria) this;
        }

        public Criteria andWfPermissionIsNotNull() {
            addCriterion("wf_permission is not null");
            return (Criteria) this;
        }

        public Criteria andWfPermissionEqualTo(String value) {
            addCriterion("wf_permission =", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionNotEqualTo(String value) {
            addCriterion("wf_permission <>", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionGreaterThan(String value) {
            addCriterion("wf_permission >", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("wf_permission >=", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionLessThan(String value) {
            addCriterion("wf_permission <", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionLessThanOrEqualTo(String value) {
            addCriterion("wf_permission <=", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionLike(String value) {
            addCriterion("wf_permission like", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionNotLike(String value) {
            addCriterion("wf_permission not like", value, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionIn(List<String> values) {
            addCriterion("wf_permission in", values, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionNotIn(List<String> values) {
            addCriterion("wf_permission not in", values, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionBetween(String value1, String value2) {
            addCriterion("wf_permission between", value1, value2, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfPermissionNotBetween(String value1, String value2) {
            addCriterion("wf_permission not between", value1, value2, "wfPermission");
            return (Criteria) this;
        }

        public Criteria andWfFlagIsNull() {
            addCriterion("wf_flag is null");
            return (Criteria) this;
        }

        public Criteria andWfFlagIsNotNull() {
            addCriterion("wf_flag is not null");
            return (Criteria) this;
        }

        public Criteria andWfFlagEqualTo(Integer value) {
            addCriterion("wf_flag =", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagNotEqualTo(Integer value) {
            addCriterion("wf_flag <>", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagGreaterThan(Integer value) {
            addCriterion("wf_flag >", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("wf_flag >=", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagLessThan(Integer value) {
            addCriterion("wf_flag <", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagLessThanOrEqualTo(Integer value) {
            addCriterion("wf_flag <=", value, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagIn(List<Integer> values) {
            addCriterion("wf_flag in", values, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagNotIn(List<Integer> values) {
            addCriterion("wf_flag not in", values, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagBetween(Integer value1, Integer value2) {
            addCriterion("wf_flag between", value1, value2, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("wf_flag not between", value1, value2, "wfFlag");
            return (Criteria) this;
        }

        public Criteria andWfStatusIsNull() {
            addCriterion("wf_status is null");
            return (Criteria) this;
        }

        public Criteria andWfStatusIsNotNull() {
            addCriterion("wf_status is not null");
            return (Criteria) this;
        }

        public Criteria andWfStatusEqualTo(Integer value) {
            addCriterion("wf_status =", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotEqualTo(Integer value) {
            addCriterion("wf_status <>", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusGreaterThan(Integer value) {
            addCriterion("wf_status >", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wf_status >=", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusLessThan(Integer value) {
            addCriterion("wf_status <", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wf_status <=", value, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusIn(List<Integer> values) {
            addCriterion("wf_status in", values, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotIn(List<Integer> values) {
            addCriterion("wf_status not in", values, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusBetween(Integer value1, Integer value2) {
            addCriterion("wf_status between", value1, value2, "wfStatus");
            return (Criteria) this;
        }

        public Criteria andWfStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wf_status not between", value1, value2, "wfStatus");
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