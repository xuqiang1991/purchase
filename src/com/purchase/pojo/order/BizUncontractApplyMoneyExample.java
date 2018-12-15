package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizUncontractApplyMoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizUncontractApplyMoneyExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("apply_user is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(Long value) {
            addCriterion("apply_user =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(Long value) {
            addCriterion("apply_user <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(Long value) {
            addCriterion("apply_user >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_user >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(Long value) {
            addCriterion("apply_user <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(Long value) {
            addCriterion("apply_user <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(List<Long> values) {
            addCriterion("apply_user in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(List<Long> values) {
            addCriterion("apply_user not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(Long value1, Long value2) {
            addCriterion("apply_user between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(Long value1, Long value2) {
            addCriterion("apply_user not between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagIsNull() {
            addCriterion("instruct_order_flag is null");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagIsNotNull() {
            addCriterion("instruct_order_flag is not null");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagEqualTo(Integer value) {
            addCriterion("instruct_order_flag =", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagNotEqualTo(Integer value) {
            addCriterion("instruct_order_flag <>", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagGreaterThan(Integer value) {
            addCriterion("instruct_order_flag >", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("instruct_order_flag >=", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagLessThan(Integer value) {
            addCriterion("instruct_order_flag <", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagLessThanOrEqualTo(Integer value) {
            addCriterion("instruct_order_flag <=", value, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagIn(List<Integer> values) {
            addCriterion("instruct_order_flag in", values, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagNotIn(List<Integer> values) {
            addCriterion("instruct_order_flag not in", values, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagBetween(Integer value1, Integer value2) {
            addCriterion("instruct_order_flag between", value1, value2, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("instruct_order_flag not between", value1, value2, "instructOrderFlag");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoIsNull() {
            addCriterion("instruct_order_no is null");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoIsNotNull() {
            addCriterion("instruct_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoEqualTo(String value) {
            addCriterion("instruct_order_no =", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoNotEqualTo(String value) {
            addCriterion("instruct_order_no <>", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoGreaterThan(String value) {
            addCriterion("instruct_order_no >", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("instruct_order_no >=", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoLessThan(String value) {
            addCriterion("instruct_order_no <", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoLessThanOrEqualTo(String value) {
            addCriterion("instruct_order_no <=", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoLike(String value) {
            addCriterion("instruct_order_no like", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoNotLike(String value) {
            addCriterion("instruct_order_no not like", value, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoIn(List<String> values) {
            addCriterion("instruct_order_no in", values, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoNotIn(List<String> values) {
            addCriterion("instruct_order_no not in", values, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoBetween(String value1, String value2) {
            addCriterion("instruct_order_no between", value1, value2, "instructOrderNo");
            return (Criteria) this;
        }

        public Criteria andInstructOrderNoNotBetween(String value1, String value2) {
            addCriterion("instruct_order_no not between", value1, value2, "instructOrderNo");
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

        public Criteria andApplyPriceIsNull() {
            addCriterion("apply_price is null");
            return (Criteria) this;
        }

        public Criteria andApplyPriceIsNotNull() {
            addCriterion("apply_price is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPriceEqualTo(BigDecimal value) {
            addCriterion("apply_price =", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotEqualTo(BigDecimal value) {
            addCriterion("apply_price <>", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceGreaterThan(BigDecimal value) {
            addCriterion("apply_price >", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_price >=", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceLessThan(BigDecimal value) {
            addCriterion("apply_price <", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_price <=", value, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceIn(List<BigDecimal> values) {
            addCriterion("apply_price in", values, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotIn(List<BigDecimal> values) {
            addCriterion("apply_price not in", values, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_price between", value1, value2, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andApplyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_price not between", value1, value2, "applyPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNull() {
            addCriterion("actual_price is null");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNotNull() {
            addCriterion("actual_price is not null");
            return (Criteria) this;
        }

        public Criteria andActualPriceEqualTo(BigDecimal value) {
            addCriterion("actual_price =", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotEqualTo(BigDecimal value) {
            addCriterion("actual_price <>", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThan(BigDecimal value) {
            addCriterion("actual_price >", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_price >=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThan(BigDecimal value) {
            addCriterion("actual_price <", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_price <=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIn(List<BigDecimal> values) {
            addCriterion("actual_price in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotIn(List<BigDecimal> values) {
            addCriterion("actual_price not in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_price between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_price not between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Long value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Long value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Long value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Long value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Long> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Long> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Long value1, Long value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserIsNull() {
            addCriterion("next_review_user is null");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserIsNotNull() {
            addCriterion("next_review_user is not null");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserEqualTo(Long value) {
            addCriterion("next_review_user =", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserNotEqualTo(Long value) {
            addCriterion("next_review_user <>", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserGreaterThan(Long value) {
            addCriterion("next_review_user >", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserGreaterThanOrEqualTo(Long value) {
            addCriterion("next_review_user >=", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserLessThan(Long value) {
            addCriterion("next_review_user <", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserLessThanOrEqualTo(Long value) {
            addCriterion("next_review_user <=", value, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserIn(List<Long> values) {
            addCriterion("next_review_user in", values, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserNotIn(List<Long> values) {
            addCriterion("next_review_user not in", values, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserBetween(Long value1, Long value2) {
            addCriterion("next_review_user between", value1, value2, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewUserNotBetween(Long value1, Long value2) {
            addCriterion("next_review_user not between", value1, value2, "nextReviewUser");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleIsNull() {
            addCriterion("next_review_role is null");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleIsNotNull() {
            addCriterion("next_review_role is not null");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleEqualTo(Long value) {
            addCriterion("next_review_role =", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNotEqualTo(Long value) {
            addCriterion("next_review_role <>", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleGreaterThan(Long value) {
            addCriterion("next_review_role >", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleGreaterThanOrEqualTo(Long value) {
            addCriterion("next_review_role >=", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleLessThan(Long value) {
            addCriterion("next_review_role <", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleLessThanOrEqualTo(Long value) {
            addCriterion("next_review_role <=", value, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleIn(List<Long> values) {
            addCriterion("next_review_role in", values, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNotIn(List<Long> values) {
            addCriterion("next_review_role not in", values, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleBetween(Long value1, Long value2) {
            addCriterion("next_review_role between", value1, value2, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNotBetween(Long value1, Long value2) {
            addCriterion("next_review_role not between", value1, value2, "nextReviewRole");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameIsNull() {
            addCriterion("next_review_role_name is null");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameIsNotNull() {
            addCriterion("next_review_role_name is not null");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameEqualTo(String value) {
            addCriterion("next_review_role_name =", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameNotEqualTo(String value) {
            addCriterion("next_review_role_name <>", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameGreaterThan(String value) {
            addCriterion("next_review_role_name >", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("next_review_role_name >=", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameLessThan(String value) {
            addCriterion("next_review_role_name <", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameLessThanOrEqualTo(String value) {
            addCriterion("next_review_role_name <=", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameLike(String value) {
            addCriterion("next_review_role_name like", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameNotLike(String value) {
            addCriterion("next_review_role_name not like", value, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameIn(List<String> values) {
            addCriterion("next_review_role_name in", values, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameNotIn(List<String> values) {
            addCriterion("next_review_role_name not in", values, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameBetween(String value1, String value2) {
            addCriterion("next_review_role_name between", value1, value2, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andNextReviewRoleNameNotBetween(String value1, String value2) {
            addCriterion("next_review_role_name not between", value1, value2, "nextReviewRoleName");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserIsNull() {
            addCriterion("last_review_user is null");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserIsNotNull() {
            addCriterion("last_review_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserEqualTo(Long value) {
            addCriterion("last_review_user =", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserNotEqualTo(Long value) {
            addCriterion("last_review_user <>", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserGreaterThan(Long value) {
            addCriterion("last_review_user >", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserGreaterThanOrEqualTo(Long value) {
            addCriterion("last_review_user >=", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserLessThan(Long value) {
            addCriterion("last_review_user <", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserLessThanOrEqualTo(Long value) {
            addCriterion("last_review_user <=", value, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserIn(List<Long> values) {
            addCriterion("last_review_user in", values, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserNotIn(List<Long> values) {
            addCriterion("last_review_user not in", values, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserBetween(Long value1, Long value2) {
            addCriterion("last_review_user between", value1, value2, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewUserNotBetween(Long value1, Long value2) {
            addCriterion("last_review_user not between", value1, value2, "lastReviewUser");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateIsNull() {
            addCriterion("last_review_date is null");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateIsNotNull() {
            addCriterion("last_review_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateEqualTo(Date value) {
            addCriterion("last_review_date =", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateNotEqualTo(Date value) {
            addCriterion("last_review_date <>", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateGreaterThan(Date value) {
            addCriterion("last_review_date >", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_review_date >=", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateLessThan(Date value) {
            addCriterion("last_review_date <", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateLessThanOrEqualTo(Date value) {
            addCriterion("last_review_date <=", value, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateIn(List<Date> values) {
            addCriterion("last_review_date in", values, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateNotIn(List<Date> values) {
            addCriterion("last_review_date not in", values, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateBetween(Date value1, Date value2) {
            addCriterion("last_review_date between", value1, value2, "lastReviewDate");
            return (Criteria) this;
        }

        public Criteria andLastReviewDateNotBetween(Date value1, Date value2) {
            addCriterion("last_review_date not between", value1, value2, "lastReviewDate");
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