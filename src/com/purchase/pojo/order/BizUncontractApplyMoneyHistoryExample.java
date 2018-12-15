package com.purchase.pojo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizUncontractApplyMoneyHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizUncontractApplyMoneyHistoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdIsNull() {
            addCriterion("uncontract_apply_money_id is null");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdIsNotNull() {
            addCriterion("uncontract_apply_money_id is not null");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdEqualTo(String value) {
            addCriterion("uncontract_apply_money_id =", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdNotEqualTo(String value) {
            addCriterion("uncontract_apply_money_id <>", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdGreaterThan(String value) {
            addCriterion("uncontract_apply_money_id >", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdGreaterThanOrEqualTo(String value) {
            addCriterion("uncontract_apply_money_id >=", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdLessThan(String value) {
            addCriterion("uncontract_apply_money_id <", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdLessThanOrEqualTo(String value) {
            addCriterion("uncontract_apply_money_id <=", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdLike(String value) {
            addCriterion("uncontract_apply_money_id like", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdNotLike(String value) {
            addCriterion("uncontract_apply_money_id not like", value, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdIn(List<String> values) {
            addCriterion("uncontract_apply_money_id in", values, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdNotIn(List<String> values) {
            addCriterion("uncontract_apply_money_id not in", values, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdBetween(String value1, String value2) {
            addCriterion("uncontract_apply_money_id between", value1, value2, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andUncontractApplyMoneyIdNotBetween(String value1, String value2) {
            addCriterion("uncontract_apply_money_id not between", value1, value2, "uncontractApplyMoneyId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsApprovalIsNull() {
            addCriterion("is_approval is null");
            return (Criteria) this;
        }

        public Criteria andIsApprovalIsNotNull() {
            addCriterion("is_approval is not null");
            return (Criteria) this;
        }

        public Criteria andIsApprovalEqualTo(Integer value) {
            addCriterion("is_approval =", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalNotEqualTo(Integer value) {
            addCriterion("is_approval <>", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalGreaterThan(Integer value) {
            addCriterion("is_approval >", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_approval >=", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalLessThan(Integer value) {
            addCriterion("is_approval <", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalLessThanOrEqualTo(Integer value) {
            addCriterion("is_approval <=", value, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalIn(List<Integer> values) {
            addCriterion("is_approval in", values, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalNotIn(List<Integer> values) {
            addCriterion("is_approval not in", values, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalBetween(Integer value1, Integer value2) {
            addCriterion("is_approval between", value1, value2, "isApproval");
            return (Criteria) this;
        }

        public Criteria andIsApprovalNotBetween(Integer value1, Integer value2) {
            addCriterion("is_approval not between", value1, value2, "isApproval");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNull() {
            addCriterion("approval_date is null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIsNotNull() {
            addCriterion("approval_date is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalDateEqualTo(Date value) {
            addCriterion("approval_date =", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotEqualTo(Date value) {
            addCriterion("approval_date <>", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThan(Date value) {
            addCriterion("approval_date >", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_date >=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThan(Date value) {
            addCriterion("approval_date <", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateLessThanOrEqualTo(Date value) {
            addCriterion("approval_date <=", value, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateIn(List<Date> values) {
            addCriterion("approval_date in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotIn(List<Date> values) {
            addCriterion("approval_date not in", values, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateBetween(Date value1, Date value2) {
            addCriterion("approval_date between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalDateNotBetween(Date value1, Date value2) {
            addCriterion("approval_date not between", value1, value2, "approvalDate");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNull() {
            addCriterion("approval_user is null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIsNotNull() {
            addCriterion("approval_user is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserEqualTo(String value) {
            addCriterion("approval_user =", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotEqualTo(String value) {
            addCriterion("approval_user <>", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThan(String value) {
            addCriterion("approval_user >", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserGreaterThanOrEqualTo(String value) {
            addCriterion("approval_user >=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThan(String value) {
            addCriterion("approval_user <", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLessThanOrEqualTo(String value) {
            addCriterion("approval_user <=", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserLike(String value) {
            addCriterion("approval_user like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotLike(String value) {
            addCriterion("approval_user not like", value, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserIn(List<String> values) {
            addCriterion("approval_user in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotIn(List<String> values) {
            addCriterion("approval_user not in", values, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserBetween(String value1, String value2) {
            addCriterion("approval_user between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNotBetween(String value1, String value2) {
            addCriterion("approval_user not between", value1, value2, "approvalUser");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameIsNull() {
            addCriterion("approval_user_name is null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameIsNotNull() {
            addCriterion("approval_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameEqualTo(String value) {
            addCriterion("approval_user_name =", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameNotEqualTo(String value) {
            addCriterion("approval_user_name <>", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameGreaterThan(String value) {
            addCriterion("approval_user_name >", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("approval_user_name >=", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameLessThan(String value) {
            addCriterion("approval_user_name <", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameLessThanOrEqualTo(String value) {
            addCriterion("approval_user_name <=", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameLike(String value) {
            addCriterion("approval_user_name like", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameNotLike(String value) {
            addCriterion("approval_user_name not like", value, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameIn(List<String> values) {
            addCriterion("approval_user_name in", values, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameNotIn(List<String> values) {
            addCriterion("approval_user_name not in", values, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameBetween(String value1, String value2) {
            addCriterion("approval_user_name between", value1, value2, "approvalUserName");
            return (Criteria) this;
        }

        public Criteria andApprovalUserNameNotBetween(String value1, String value2) {
            addCriterion("approval_user_name not between", value1, value2, "approvalUserName");
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