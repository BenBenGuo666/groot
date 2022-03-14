package groot.workflow.code.model.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NodeExample() {
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

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNull() {
            addCriterion("node_type is null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIsNotNull() {
            addCriterion("node_type is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTypeEqualTo(Integer value) {
            addCriterion("node_type =", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotEqualTo(Integer value) {
            addCriterion("node_type <>", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThan(Integer value) {
            addCriterion("node_type >", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_type >=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThan(Integer value) {
            addCriterion("node_type <", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("node_type <=", value, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeIn(List<Integer> values) {
            addCriterion("node_type in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotIn(List<Integer> values) {
            addCriterion("node_type not in", values, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeBetween(Integer value1, Integer value2) {
            addCriterion("node_type between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("node_type not between", value1, value2, "nodeType");
            return (Criteria) this;
        }

        public Criteria andNodePrevIsNull() {
            addCriterion("node_prev is null");
            return (Criteria) this;
        }

        public Criteria andNodePrevIsNotNull() {
            addCriterion("node_prev is not null");
            return (Criteria) this;
        }

        public Criteria andNodePrevEqualTo(String value) {
            addCriterion("node_prev =", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevNotEqualTo(String value) {
            addCriterion("node_prev <>", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevGreaterThan(String value) {
            addCriterion("node_prev >", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevGreaterThanOrEqualTo(String value) {
            addCriterion("node_prev >=", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevLessThan(String value) {
            addCriterion("node_prev <", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevLessThanOrEqualTo(String value) {
            addCriterion("node_prev <=", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevLike(String value) {
            addCriterion("node_prev like", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevNotLike(String value) {
            addCriterion("node_prev not like", value, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevIn(List<String> values) {
            addCriterion("node_prev in", values, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevNotIn(List<String> values) {
            addCriterion("node_prev not in", values, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevBetween(String value1, String value2) {
            addCriterion("node_prev between", value1, value2, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodePrevNotBetween(String value1, String value2) {
            addCriterion("node_prev not between", value1, value2, "nodePrev");
            return (Criteria) this;
        }

        public Criteria andNodeNextIsNull() {
            addCriterion("node_next is null");
            return (Criteria) this;
        }

        public Criteria andNodeNextIsNotNull() {
            addCriterion("node_next is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNextEqualTo(String value) {
            addCriterion("node_next =", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextNotEqualTo(String value) {
            addCriterion("node_next <>", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextGreaterThan(String value) {
            addCriterion("node_next >", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextGreaterThanOrEqualTo(String value) {
            addCriterion("node_next >=", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextLessThan(String value) {
            addCriterion("node_next <", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextLessThanOrEqualTo(String value) {
            addCriterion("node_next <=", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextLike(String value) {
            addCriterion("node_next like", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextNotLike(String value) {
            addCriterion("node_next not like", value, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextIn(List<String> values) {
            addCriterion("node_next in", values, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextNotIn(List<String> values) {
            addCriterion("node_next not in", values, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextBetween(String value1, String value2) {
            addCriterion("node_next between", value1, value2, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeNextNotBetween(String value1, String value2) {
            addCriterion("node_next not between", value1, value2, "nodeNext");
            return (Criteria) this;
        }

        public Criteria andNodeBackedIsNull() {
            addCriterion("node_backed is null");
            return (Criteria) this;
        }

        public Criteria andNodeBackedIsNotNull() {
            addCriterion("node_backed is not null");
            return (Criteria) this;
        }

        public Criteria andNodeBackedEqualTo(String value) {
            addCriterion("node_backed =", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedNotEqualTo(String value) {
            addCriterion("node_backed <>", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedGreaterThan(String value) {
            addCriterion("node_backed >", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedGreaterThanOrEqualTo(String value) {
            addCriterion("node_backed >=", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedLessThan(String value) {
            addCriterion("node_backed <", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedLessThanOrEqualTo(String value) {
            addCriterion("node_backed <=", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedLike(String value) {
            addCriterion("node_backed like", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedNotLike(String value) {
            addCriterion("node_backed not like", value, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedIn(List<String> values) {
            addCriterion("node_backed in", values, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedNotIn(List<String> values) {
            addCriterion("node_backed not in", values, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedBetween(String value1, String value2) {
            addCriterion("node_backed between", value1, value2, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeBackedNotBetween(String value1, String value2) {
            addCriterion("node_backed not between", value1, value2, "nodeBacked");
            return (Criteria) this;
        }

        public Criteria andNodeParentIsNull() {
            addCriterion("node_parent is null");
            return (Criteria) this;
        }

        public Criteria andNodeParentIsNotNull() {
            addCriterion("node_parent is not null");
            return (Criteria) this;
        }

        public Criteria andNodeParentEqualTo(String value) {
            addCriterion("node_parent =", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentNotEqualTo(String value) {
            addCriterion("node_parent <>", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentGreaterThan(String value) {
            addCriterion("node_parent >", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentGreaterThanOrEqualTo(String value) {
            addCriterion("node_parent >=", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentLessThan(String value) {
            addCriterion("node_parent <", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentLessThanOrEqualTo(String value) {
            addCriterion("node_parent <=", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentLike(String value) {
            addCriterion("node_parent like", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentNotLike(String value) {
            addCriterion("node_parent not like", value, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentIn(List<String> values) {
            addCriterion("node_parent in", values, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentNotIn(List<String> values) {
            addCriterion("node_parent not in", values, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentBetween(String value1, String value2) {
            addCriterion("node_parent between", value1, value2, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeParentNotBetween(String value1, String value2) {
            addCriterion("node_parent not between", value1, value2, "nodeParent");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionIsNull() {
            addCriterion("node_expression is null");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionIsNotNull() {
            addCriterion("node_expression is not null");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionEqualTo(String value) {
            addCriterion("node_expression =", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionNotEqualTo(String value) {
            addCriterion("node_expression <>", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionGreaterThan(String value) {
            addCriterion("node_expression >", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("node_expression >=", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionLessThan(String value) {
            addCriterion("node_expression <", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionLessThanOrEqualTo(String value) {
            addCriterion("node_expression <=", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionLike(String value) {
            addCriterion("node_expression like", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionNotLike(String value) {
            addCriterion("node_expression not like", value, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionIn(List<String> values) {
            addCriterion("node_expression in", values, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionNotIn(List<String> values) {
            addCriterion("node_expression not in", values, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionBetween(String value1, String value2) {
            addCriterion("node_expression between", value1, value2, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andNodeExpressionNotBetween(String value1, String value2) {
            addCriterion("node_expression not between", value1, value2, "nodeExpression");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeIsNull() {
            addCriterion("workflow_code_and_node_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeIsNotNull() {
            addCriterion("workflow_code_and_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeEqualTo(String value) {
            addCriterion("workflow_code_and_node_code =", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeNotEqualTo(String value) {
            addCriterion("workflow_code_and_node_code <>", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeGreaterThan(String value) {
            addCriterion("workflow_code_and_node_code >", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("workflow_code_and_node_code >=", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeLessThan(String value) {
            addCriterion("workflow_code_and_node_code <", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("workflow_code_and_node_code <=", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeLike(String value) {
            addCriterion("workflow_code_and_node_code like", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeNotLike(String value) {
            addCriterion("workflow_code_and_node_code not like", value, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeIn(List<String> values) {
            addCriterion("workflow_code_and_node_code in", values, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeNotIn(List<String> values) {
            addCriterion("workflow_code_and_node_code not in", values, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeBetween(String value1, String value2) {
            addCriterion("workflow_code_and_node_code between", value1, value2, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowCodeAndNodeCodeNotBetween(String value1, String value2) {
            addCriterion("workflow_code_and_node_code not between", value1, value2, "workflowCodeAndNodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeIsNull() {
            addCriterion("node_createtime is null");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeIsNotNull() {
            addCriterion("node_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeEqualTo(Date value) {
            addCriterion("node_createtime =", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeNotEqualTo(Date value) {
            addCriterion("node_createtime <>", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeGreaterThan(Date value) {
            addCriterion("node_createtime >", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("node_createtime >=", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeLessThan(Date value) {
            addCriterion("node_createtime <", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("node_createtime <=", value, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeIn(List<Date> values) {
            addCriterion("node_createtime in", values, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeNotIn(List<Date> values) {
            addCriterion("node_createtime not in", values, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeBetween(Date value1, Date value2) {
            addCriterion("node_createtime between", value1, value2, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("node_createtime not between", value1, value2, "nodeCreatetime");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorIsNull() {
            addCriterion("node_creator is null");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorIsNotNull() {
            addCriterion("node_creator is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorEqualTo(String value) {
            addCriterion("node_creator =", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorNotEqualTo(String value) {
            addCriterion("node_creator <>", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorGreaterThan(String value) {
            addCriterion("node_creator >", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("node_creator >=", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorLessThan(String value) {
            addCriterion("node_creator <", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorLessThanOrEqualTo(String value) {
            addCriterion("node_creator <=", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorLike(String value) {
            addCriterion("node_creator like", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorNotLike(String value) {
            addCriterion("node_creator not like", value, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorIn(List<String> values) {
            addCriterion("node_creator in", values, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorNotIn(List<String> values) {
            addCriterion("node_creator not in", values, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorBetween(String value1, String value2) {
            addCriterion("node_creator between", value1, value2, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeCreatorNotBetween(String value1, String value2) {
            addCriterion("node_creator not between", value1, value2, "nodeCreator");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeIsNull() {
            addCriterion("node_modifytime is null");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeIsNotNull() {
            addCriterion("node_modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeEqualTo(Date value) {
            addCriterion("node_modifytime =", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeNotEqualTo(Date value) {
            addCriterion("node_modifytime <>", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeGreaterThan(Date value) {
            addCriterion("node_modifytime >", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("node_modifytime >=", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeLessThan(Date value) {
            addCriterion("node_modifytime <", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeLessThanOrEqualTo(Date value) {
            addCriterion("node_modifytime <=", value, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeIn(List<Date> values) {
            addCriterion("node_modifytime in", values, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeNotIn(List<Date> values) {
            addCriterion("node_modifytime not in", values, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeBetween(Date value1, Date value2) {
            addCriterion("node_modifytime between", value1, value2, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifytimeNotBetween(Date value1, Date value2) {
            addCriterion("node_modifytime not between", value1, value2, "nodeModifytime");
            return (Criteria) this;
        }

        public Criteria andNodeModifierIsNull() {
            addCriterion("node_modifier is null");
            return (Criteria) this;
        }

        public Criteria andNodeModifierIsNotNull() {
            addCriterion("node_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andNodeModifierEqualTo(String value) {
            addCriterion("node_modifier =", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierNotEqualTo(String value) {
            addCriterion("node_modifier <>", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierGreaterThan(String value) {
            addCriterion("node_modifier >", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierGreaterThanOrEqualTo(String value) {
            addCriterion("node_modifier >=", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierLessThan(String value) {
            addCriterion("node_modifier <", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierLessThanOrEqualTo(String value) {
            addCriterion("node_modifier <=", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierLike(String value) {
            addCriterion("node_modifier like", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierNotLike(String value) {
            addCriterion("node_modifier not like", value, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierIn(List<String> values) {
            addCriterion("node_modifier in", values, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierNotIn(List<String> values) {
            addCriterion("node_modifier not in", values, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierBetween(String value1, String value2) {
            addCriterion("node_modifier between", value1, value2, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodeModifierNotBetween(String value1, String value2) {
            addCriterion("node_modifier not between", value1, value2, "nodeModifier");
            return (Criteria) this;
        }

        public Criteria andNodePermissionIsNull() {
            addCriterion("node_permission is null");
            return (Criteria) this;
        }

        public Criteria andNodePermissionIsNotNull() {
            addCriterion("node_permission is not null");
            return (Criteria) this;
        }

        public Criteria andNodePermissionEqualTo(String value) {
            addCriterion("node_permission =", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionNotEqualTo(String value) {
            addCriterion("node_permission <>", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionGreaterThan(String value) {
            addCriterion("node_permission >", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionGreaterThanOrEqualTo(String value) {
            addCriterion("node_permission >=", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionLessThan(String value) {
            addCriterion("node_permission <", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionLessThanOrEqualTo(String value) {
            addCriterion("node_permission <=", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionLike(String value) {
            addCriterion("node_permission like", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionNotLike(String value) {
            addCriterion("node_permission not like", value, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionIn(List<String> values) {
            addCriterion("node_permission in", values, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionNotIn(List<String> values) {
            addCriterion("node_permission not in", values, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionBetween(String value1, String value2) {
            addCriterion("node_permission between", value1, value2, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodePermissionNotBetween(String value1, String value2) {
            addCriterion("node_permission not between", value1, value2, "nodePermission");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIsNull() {
            addCriterion("node_status is null");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIsNotNull() {
            addCriterion("node_status is not null");
            return (Criteria) this;
        }

        public Criteria andNodeStatusEqualTo(Integer value) {
            addCriterion("node_status =", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotEqualTo(Integer value) {
            addCriterion("node_status <>", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusGreaterThan(Integer value) {
            addCriterion("node_status >", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_status >=", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusLessThan(Integer value) {
            addCriterion("node_status <", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("node_status <=", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIn(List<Integer> values) {
            addCriterion("node_status in", values, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotIn(List<Integer> values) {
            addCriterion("node_status not in", values, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusBetween(Integer value1, Integer value2) {
            addCriterion("node_status between", value1, value2, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("node_status not between", value1, value2, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeIsNull() {
            addCriterion("node_remarke is null");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeIsNotNull() {
            addCriterion("node_remarke is not null");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeEqualTo(String value) {
            addCriterion("node_remarke =", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeNotEqualTo(String value) {
            addCriterion("node_remarke <>", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeGreaterThan(String value) {
            addCriterion("node_remarke >", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeGreaterThanOrEqualTo(String value) {
            addCriterion("node_remarke >=", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeLessThan(String value) {
            addCriterion("node_remarke <", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeLessThanOrEqualTo(String value) {
            addCriterion("node_remarke <=", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeLike(String value) {
            addCriterion("node_remarke like", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeNotLike(String value) {
            addCriterion("node_remarke not like", value, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeIn(List<String> values) {
            addCriterion("node_remarke in", values, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeNotIn(List<String> values) {
            addCriterion("node_remarke not in", values, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeBetween(String value1, String value2) {
            addCriterion("node_remarke between", value1, value2, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeRemarkeNotBetween(String value1, String value2) {
            addCriterion("node_remarke not between", value1, value2, "nodeRemarke");
            return (Criteria) this;
        }

        public Criteria andNodeUrlIsNull() {
            addCriterion("node_url is null");
            return (Criteria) this;
        }

        public Criteria andNodeUrlIsNotNull() {
            addCriterion("node_url is not null");
            return (Criteria) this;
        }

        public Criteria andNodeUrlEqualTo(String value) {
            addCriterion("node_url =", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlNotEqualTo(String value) {
            addCriterion("node_url <>", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlGreaterThan(String value) {
            addCriterion("node_url >", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("node_url >=", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlLessThan(String value) {
            addCriterion("node_url <", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlLessThanOrEqualTo(String value) {
            addCriterion("node_url <=", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlLike(String value) {
            addCriterion("node_url like", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlNotLike(String value) {
            addCriterion("node_url not like", value, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlIn(List<String> values) {
            addCriterion("node_url in", values, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlNotIn(List<String> values) {
            addCriterion("node_url not in", values, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlBetween(String value1, String value2) {
            addCriterion("node_url between", value1, value2, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeUrlNotBetween(String value1, String value2) {
            addCriterion("node_url not between", value1, value2, "nodeUrl");
            return (Criteria) this;
        }

        public Criteria andNodeFlagIsNull() {
            addCriterion("node_flag is null");
            return (Criteria) this;
        }

        public Criteria andNodeFlagIsNotNull() {
            addCriterion("node_flag is not null");
            return (Criteria) this;
        }

        public Criteria andNodeFlagEqualTo(Integer value) {
            addCriterion("node_flag =", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagNotEqualTo(Integer value) {
            addCriterion("node_flag <>", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagGreaterThan(Integer value) {
            addCriterion("node_flag >", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_flag >=", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagLessThan(Integer value) {
            addCriterion("node_flag <", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagLessThanOrEqualTo(Integer value) {
            addCriterion("node_flag <=", value, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagIn(List<Integer> values) {
            addCriterion("node_flag in", values, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagNotIn(List<Integer> values) {
            addCriterion("node_flag not in", values, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagBetween(Integer value1, Integer value2) {
            addCriterion("node_flag between", value1, value2, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andNodeFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("node_flag not between", value1, value2, "nodeFlag");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(Integer value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(Integer value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(Integer value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(Integer value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(Integer value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<Integer> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<Integer> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(Integer value1, Integer value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyIsNull() {
            addCriterion("node_classify is null");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyIsNotNull() {
            addCriterion("node_classify is not null");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyEqualTo(String value) {
            addCriterion("node_classify =", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyNotEqualTo(String value) {
            addCriterion("node_classify <>", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyGreaterThan(String value) {
            addCriterion("node_classify >", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("node_classify >=", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyLessThan(String value) {
            addCriterion("node_classify <", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyLessThanOrEqualTo(String value) {
            addCriterion("node_classify <=", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyLike(String value) {
            addCriterion("node_classify like", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyNotLike(String value) {
            addCriterion("node_classify not like", value, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyIn(List<String> values) {
            addCriterion("node_classify in", values, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyNotIn(List<String> values) {
            addCriterion("node_classify not in", values, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyBetween(String value1, String value2) {
            addCriterion("node_classify between", value1, value2, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeClassifyNotBetween(String value1, String value2) {
            addCriterion("node_classify not between", value1, value2, "nodeClassify");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusIsNull() {
            addCriterion("node_gen_wo_status is null");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusIsNotNull() {
            addCriterion("node_gen_wo_status is not null");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusEqualTo(Integer value) {
            addCriterion("node_gen_wo_status =", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusNotEqualTo(Integer value) {
            addCriterion("node_gen_wo_status <>", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusGreaterThan(Integer value) {
            addCriterion("node_gen_wo_status >", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_gen_wo_status >=", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusLessThan(Integer value) {
            addCriterion("node_gen_wo_status <", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("node_gen_wo_status <=", value, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusIn(List<Integer> values) {
            addCriterion("node_gen_wo_status in", values, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusNotIn(List<Integer> values) {
            addCriterion("node_gen_wo_status not in", values, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusBetween(Integer value1, Integer value2) {
            addCriterion("node_gen_wo_status between", value1, value2, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeGenWoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("node_gen_wo_status not between", value1, value2, "nodeGenWoStatus");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionIsNull() {
            addCriterion("node_limit_permission is null");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionIsNotNull() {
            addCriterion("node_limit_permission is not null");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionEqualTo(Integer value) {
            addCriterion("node_limit_permission =", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionNotEqualTo(Integer value) {
            addCriterion("node_limit_permission <>", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionGreaterThan(Integer value) {
            addCriterion("node_limit_permission >", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_limit_permission >=", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionLessThan(Integer value) {
            addCriterion("node_limit_permission <", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("node_limit_permission <=", value, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionIn(List<Integer> values) {
            addCriterion("node_limit_permission in", values, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionNotIn(List<Integer> values) {
            addCriterion("node_limit_permission not in", values, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionBetween(Integer value1, Integer value2) {
            addCriterion("node_limit_permission between", value1, value2, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeLimitPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("node_limit_permission not between", value1, value2, "nodeLimitPermission");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckIsNull() {
            addCriterion("node_auto_check is null");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckIsNotNull() {
            addCriterion("node_auto_check is not null");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckEqualTo(Integer value) {
            addCriterion("node_auto_check =", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckNotEqualTo(Integer value) {
            addCriterion("node_auto_check <>", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckGreaterThan(Integer value) {
            addCriterion("node_auto_check >", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_auto_check >=", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckLessThan(Integer value) {
            addCriterion("node_auto_check <", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckLessThanOrEqualTo(Integer value) {
            addCriterion("node_auto_check <=", value, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckIn(List<Integer> values) {
            addCriterion("node_auto_check in", values, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckNotIn(List<Integer> values) {
            addCriterion("node_auto_check not in", values, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckBetween(Integer value1, Integer value2) {
            addCriterion("node_auto_check between", value1, value2, "nodeAutoCheck");
            return (Criteria) this;
        }

        public Criteria andNodeAutoCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("node_auto_check not between", value1, value2, "nodeAutoCheck");
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