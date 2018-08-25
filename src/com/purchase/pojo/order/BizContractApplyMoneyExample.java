package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizContractApplyMoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizContractApplyMoneyExample() {
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

        public Criteria andSourceOrderIdIsNull() {
            addCriterion("source_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdIsNotNull() {
            addCriterion("source_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdEqualTo(String value) {
            addCriterion("source_order_id =", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdNotEqualTo(String value) {
            addCriterion("source_order_id <>", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdGreaterThan(String value) {
            addCriterion("source_order_id >", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_order_id >=", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdLessThan(String value) {
            addCriterion("source_order_id <", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdLessThanOrEqualTo(String value) {
            addCriterion("source_order_id <=", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdLike(String value) {
            addCriterion("source_order_id like", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdNotLike(String value) {
            addCriterion("source_order_id not like", value, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdIn(List<String> values) {
            addCriterion("source_order_id in", values, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdNotIn(List<String> values) {
            addCriterion("source_order_id not in", values, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdBetween(String value1, String value2) {
            addCriterion("source_order_id between", value1, value2, "sourceOrderId");
            return (Criteria) this;
        }

        public Criteria andSourceOrderIdNotBetween(String value1, String value2) {
            addCriterion("source_order_id not between", value1, value2, "sourceOrderId");
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
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

        public Criteria andCostDepartApprovalIsNull() {
            addCriterion("cost_depart_approval is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalIsNotNull() {
            addCriterion("cost_depart_approval is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalEqualTo(Boolean value) {
            addCriterion("cost_depart_approval =", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalNotEqualTo(Boolean value) {
            addCriterion("cost_depart_approval <>", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalGreaterThan(Boolean value) {
            addCriterion("cost_depart_approval >", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cost_depart_approval >=", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalLessThan(Boolean value) {
            addCriterion("cost_depart_approval <", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalLessThanOrEqualTo(Boolean value) {
            addCriterion("cost_depart_approval <=", value, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalIn(List<Boolean> values) {
            addCriterion("cost_depart_approval in", values, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalNotIn(List<Boolean> values) {
            addCriterion("cost_depart_approval not in", values, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalBetween(Boolean value1, Boolean value2) {
            addCriterion("cost_depart_approval between", value1, value2, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartApprovalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cost_depart_approval not between", value1, value2, "costDepartApproval");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserIsNull() {
            addCriterion("cost_depart_user is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserIsNotNull() {
            addCriterion("cost_depart_user is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserEqualTo(String value) {
            addCriterion("cost_depart_user =", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserNotEqualTo(String value) {
            addCriterion("cost_depart_user <>", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserGreaterThan(String value) {
            addCriterion("cost_depart_user >", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserGreaterThanOrEqualTo(String value) {
            addCriterion("cost_depart_user >=", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserLessThan(String value) {
            addCriterion("cost_depart_user <", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserLessThanOrEqualTo(String value) {
            addCriterion("cost_depart_user <=", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserLike(String value) {
            addCriterion("cost_depart_user like", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserNotLike(String value) {
            addCriterion("cost_depart_user not like", value, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserIn(List<String> values) {
            addCriterion("cost_depart_user in", values, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserNotIn(List<String> values) {
            addCriterion("cost_depart_user not in", values, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserBetween(String value1, String value2) {
            addCriterion("cost_depart_user between", value1, value2, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartUserNotBetween(String value1, String value2) {
            addCriterion("cost_depart_user not between", value1, value2, "costDepartUser");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateIsNull() {
            addCriterion("cost_depart_date is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateIsNotNull() {
            addCriterion("cost_depart_date is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateEqualTo(Date value) {
            addCriterion("cost_depart_date =", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateNotEqualTo(Date value) {
            addCriterion("cost_depart_date <>", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateGreaterThan(Date value) {
            addCriterion("cost_depart_date >", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("cost_depart_date >=", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateLessThan(Date value) {
            addCriterion("cost_depart_date <", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateLessThanOrEqualTo(Date value) {
            addCriterion("cost_depart_date <=", value, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateIn(List<Date> values) {
            addCriterion("cost_depart_date in", values, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateNotIn(List<Date> values) {
            addCriterion("cost_depart_date not in", values, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateBetween(Date value1, Date value2) {
            addCriterion("cost_depart_date between", value1, value2, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartDateNotBetween(Date value1, Date value2) {
            addCriterion("cost_depart_date not between", value1, value2, "costDepartDate");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionIsNull() {
            addCriterion("cost_depart_opinion is null");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionIsNotNull() {
            addCriterion("cost_depart_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionEqualTo(String value) {
            addCriterion("cost_depart_opinion =", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionNotEqualTo(String value) {
            addCriterion("cost_depart_opinion <>", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionGreaterThan(String value) {
            addCriterion("cost_depart_opinion >", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("cost_depart_opinion >=", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionLessThan(String value) {
            addCriterion("cost_depart_opinion <", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionLessThanOrEqualTo(String value) {
            addCriterion("cost_depart_opinion <=", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionLike(String value) {
            addCriterion("cost_depart_opinion like", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionNotLike(String value) {
            addCriterion("cost_depart_opinion not like", value, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionIn(List<String> values) {
            addCriterion("cost_depart_opinion in", values, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionNotIn(List<String> values) {
            addCriterion("cost_depart_opinion not in", values, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionBetween(String value1, String value2) {
            addCriterion("cost_depart_opinion between", value1, value2, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andCostDepartOpinionNotBetween(String value1, String value2) {
            addCriterion("cost_depart_opinion not between", value1, value2, "costDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalIsNull() {
            addCriterion("project_depart_approval is null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalIsNotNull() {
            addCriterion("project_depart_approval is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalEqualTo(Boolean value) {
            addCriterion("project_depart_approval =", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalNotEqualTo(Boolean value) {
            addCriterion("project_depart_approval <>", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalGreaterThan(Boolean value) {
            addCriterion("project_depart_approval >", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("project_depart_approval >=", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalLessThan(Boolean value) {
            addCriterion("project_depart_approval <", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalLessThanOrEqualTo(Boolean value) {
            addCriterion("project_depart_approval <=", value, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalIn(List<Boolean> values) {
            addCriterion("project_depart_approval in", values, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalNotIn(List<Boolean> values) {
            addCriterion("project_depart_approval not in", values, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalBetween(Boolean value1, Boolean value2) {
            addCriterion("project_depart_approval between", value1, value2, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartApprovalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("project_depart_approval not between", value1, value2, "projectDepartApproval");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserIsNull() {
            addCriterion("project_depart_user is null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserIsNotNull() {
            addCriterion("project_depart_user is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserEqualTo(String value) {
            addCriterion("project_depart_user =", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserNotEqualTo(String value) {
            addCriterion("project_depart_user <>", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserGreaterThan(String value) {
            addCriterion("project_depart_user >", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserGreaterThanOrEqualTo(String value) {
            addCriterion("project_depart_user >=", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserLessThan(String value) {
            addCriterion("project_depart_user <", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserLessThanOrEqualTo(String value) {
            addCriterion("project_depart_user <=", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserLike(String value) {
            addCriterion("project_depart_user like", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserNotLike(String value) {
            addCriterion("project_depart_user not like", value, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserIn(List<String> values) {
            addCriterion("project_depart_user in", values, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserNotIn(List<String> values) {
            addCriterion("project_depart_user not in", values, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserBetween(String value1, String value2) {
            addCriterion("project_depart_user between", value1, value2, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartUserNotBetween(String value1, String value2) {
            addCriterion("project_depart_user not between", value1, value2, "projectDepartUser");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateIsNull() {
            addCriterion("project_depart_date is null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateIsNotNull() {
            addCriterion("project_depart_date is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateEqualTo(Date value) {
            addCriterion("project_depart_date =", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateNotEqualTo(Date value) {
            addCriterion("project_depart_date <>", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateGreaterThan(Date value) {
            addCriterion("project_depart_date >", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("project_depart_date >=", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateLessThan(Date value) {
            addCriterion("project_depart_date <", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateLessThanOrEqualTo(Date value) {
            addCriterion("project_depart_date <=", value, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateIn(List<Date> values) {
            addCriterion("project_depart_date in", values, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateNotIn(List<Date> values) {
            addCriterion("project_depart_date not in", values, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateBetween(Date value1, Date value2) {
            addCriterion("project_depart_date between", value1, value2, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartDateNotBetween(Date value1, Date value2) {
            addCriterion("project_depart_date not between", value1, value2, "projectDepartDate");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionIsNull() {
            addCriterion("project_depart_opinion is null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionIsNotNull() {
            addCriterion("project_depart_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionEqualTo(String value) {
            addCriterion("project_depart_opinion =", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionNotEqualTo(String value) {
            addCriterion("project_depart_opinion <>", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionGreaterThan(String value) {
            addCriterion("project_depart_opinion >", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("project_depart_opinion >=", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionLessThan(String value) {
            addCriterion("project_depart_opinion <", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionLessThanOrEqualTo(String value) {
            addCriterion("project_depart_opinion <=", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionLike(String value) {
            addCriterion("project_depart_opinion like", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionNotLike(String value) {
            addCriterion("project_depart_opinion not like", value, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionIn(List<String> values) {
            addCriterion("project_depart_opinion in", values, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionNotIn(List<String> values) {
            addCriterion("project_depart_opinion not in", values, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionBetween(String value1, String value2) {
            addCriterion("project_depart_opinion between", value1, value2, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andProjectDepartOpinionNotBetween(String value1, String value2) {
            addCriterion("project_depart_opinion not between", value1, value2, "projectDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalIsNull() {
            addCriterion("manager_depart_approval is null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalIsNotNull() {
            addCriterion("manager_depart_approval is not null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalEqualTo(Boolean value) {
            addCriterion("manager_depart_approval =", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalNotEqualTo(Boolean value) {
            addCriterion("manager_depart_approval <>", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalGreaterThan(Boolean value) {
            addCriterion("manager_depart_approval >", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("manager_depart_approval >=", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalLessThan(Boolean value) {
            addCriterion("manager_depart_approval <", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalLessThanOrEqualTo(Boolean value) {
            addCriterion("manager_depart_approval <=", value, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalIn(List<Boolean> values) {
            addCriterion("manager_depart_approval in", values, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalNotIn(List<Boolean> values) {
            addCriterion("manager_depart_approval not in", values, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalBetween(Boolean value1, Boolean value2) {
            addCriterion("manager_depart_approval between", value1, value2, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartApprovalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("manager_depart_approval not between", value1, value2, "managerDepartApproval");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserIsNull() {
            addCriterion("manager_depart_user is null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserIsNotNull() {
            addCriterion("manager_depart_user is not null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserEqualTo(String value) {
            addCriterion("manager_depart_user =", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotEqualTo(String value) {
            addCriterion("manager_depart_user <>", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserGreaterThan(String value) {
            addCriterion("manager_depart_user >", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserGreaterThanOrEqualTo(String value) {
            addCriterion("manager_depart_user >=", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserLessThan(String value) {
            addCriterion("manager_depart_user <", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserLessThanOrEqualTo(String value) {
            addCriterion("manager_depart_user <=", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserLike(String value) {
            addCriterion("manager_depart_user like", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotLike(String value) {
            addCriterion("manager_depart_user not like", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserIn(List<String> values) {
            addCriterion("manager_depart_user in", values, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotIn(List<String> values) {
            addCriterion("manager_depart_user not in", values, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserBetween(String value1, String value2) {
            addCriterion("manager_depart_user between", value1, value2, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotBetween(String value1, String value2) {
            addCriterion("manager_depart_user not between", value1, value2, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateIsNull() {
            addCriterion("manager_depart_date is null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateIsNotNull() {
            addCriterion("manager_depart_date is not null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateEqualTo(Date value) {
            addCriterion("manager_depart_date =", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateNotEqualTo(Date value) {
            addCriterion("manager_depart_date <>", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateGreaterThan(Date value) {
            addCriterion("manager_depart_date >", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("manager_depart_date >=", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateLessThan(Date value) {
            addCriterion("manager_depart_date <", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateLessThanOrEqualTo(Date value) {
            addCriterion("manager_depart_date <=", value, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateIn(List<Date> values) {
            addCriterion("manager_depart_date in", values, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateNotIn(List<Date> values) {
            addCriterion("manager_depart_date not in", values, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateBetween(Date value1, Date value2) {
            addCriterion("manager_depart_date between", value1, value2, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartDateNotBetween(Date value1, Date value2) {
            addCriterion("manager_depart_date not between", value1, value2, "managerDepartDate");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionIsNull() {
            addCriterion("manager_depart_opinion is null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionIsNotNull() {
            addCriterion("manager_depart_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionEqualTo(String value) {
            addCriterion("manager_depart_opinion =", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionNotEqualTo(String value) {
            addCriterion("manager_depart_opinion <>", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionGreaterThan(String value) {
            addCriterion("manager_depart_opinion >", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("manager_depart_opinion >=", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionLessThan(String value) {
            addCriterion("manager_depart_opinion <", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionLessThanOrEqualTo(String value) {
            addCriterion("manager_depart_opinion <=", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionLike(String value) {
            addCriterion("manager_depart_opinion like", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionNotLike(String value) {
            addCriterion("manager_depart_opinion not like", value, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionIn(List<String> values) {
            addCriterion("manager_depart_opinion in", values, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionNotIn(List<String> values) {
            addCriterion("manager_depart_opinion not in", values, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionBetween(String value1, String value2) {
            addCriterion("manager_depart_opinion between", value1, value2, "managerDepartOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerDepartOpinionNotBetween(String value1, String value2) {
            addCriterion("manager_depart_opinion not between", value1, value2, "managerDepartOpinion");
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