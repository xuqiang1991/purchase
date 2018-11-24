package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizPaymentOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizPaymentOrderExample() {
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

        public Criteria andPurchaseNoIsNull() {
            addCriterion("purchase_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIsNotNull() {
            addCriterion("purchase_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoEqualTo(String value) {
            addCriterion("purchase_no =", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotEqualTo(String value) {
            addCriterion("purchase_no <>", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThan(String value) {
            addCriterion("purchase_no >", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_no >=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThan(String value) {
            addCriterion("purchase_no <", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_no <=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLike(String value) {
            addCriterion("purchase_no like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotLike(String value) {
            addCriterion("purchase_no not like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIn(List<String> values) {
            addCriterion("purchase_no in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotIn(List<String> values) {
            addCriterion("purchase_no not in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoBetween(String value1, String value2) {
            addCriterion("purchase_no between", value1, value2, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotBetween(String value1, String value2) {
            addCriterion("purchase_no not between", value1, value2, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIsNull() {
            addCriterion("contract_order_no is null");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIsNotNull() {
            addCriterion("contract_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoEqualTo(String value) {
            addCriterion("contract_order_no =", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotEqualTo(String value) {
            addCriterion("contract_order_no <>", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoGreaterThan(String value) {
            addCriterion("contract_order_no >", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_order_no >=", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLessThan(String value) {
            addCriterion("contract_order_no <", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLessThanOrEqualTo(String value) {
            addCriterion("contract_order_no <=", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoLike(String value) {
            addCriterion("contract_order_no like", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotLike(String value) {
            addCriterion("contract_order_no not like", value, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoIn(List<String> values) {
            addCriterion("contract_order_no in", values, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotIn(List<String> values) {
            addCriterion("contract_order_no not in", values, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoBetween(String value1, String value2) {
            addCriterion("contract_order_no between", value1, value2, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andContractOrderNoNotBetween(String value1, String value2) {
            addCriterion("contract_order_no not between", value1, value2, "contractOrderNo");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("apply_type is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(Integer value) {
            addCriterion("apply_type =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(Integer value) {
            addCriterion("apply_type <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(Integer value) {
            addCriterion("apply_type >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_type >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(Integer value) {
            addCriterion("apply_type <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("apply_type <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<Integer> values) {
            addCriterion("apply_type in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<Integer> values) {
            addCriterion("apply_type not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("apply_type between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_type not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyNatureIsNull() {
            addCriterion("apply_nature is null");
            return (Criteria) this;
        }

        public Criteria andApplyNatureIsNotNull() {
            addCriterion("apply_nature is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNatureEqualTo(Integer value) {
            addCriterion("apply_nature =", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureNotEqualTo(Integer value) {
            addCriterion("apply_nature <>", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureGreaterThan(Integer value) {
            addCriterion("apply_nature >", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_nature >=", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureLessThan(Integer value) {
            addCriterion("apply_nature <", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureLessThanOrEqualTo(Integer value) {
            addCriterion("apply_nature <=", value, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureIn(List<Integer> values) {
            addCriterion("apply_nature in", values, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureNotIn(List<Integer> values) {
            addCriterion("apply_nature not in", values, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureBetween(Integer value1, Integer value2) {
            addCriterion("apply_nature between", value1, value2, "applyNature");
            return (Criteria) this;
        }

        public Criteria andApplyNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_nature not between", value1, value2, "applyNature");
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

        public Criteria andApplyUserPhoneIsNull() {
            addCriterion("apply_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneIsNotNull() {
            addCriterion("apply_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneEqualTo(String value) {
            addCriterion("apply_user_phone =", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotEqualTo(String value) {
            addCriterion("apply_user_phone <>", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneGreaterThan(String value) {
            addCriterion("apply_user_phone >", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user_phone >=", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLessThan(String value) {
            addCriterion("apply_user_phone <", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("apply_user_phone <=", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneLike(String value) {
            addCriterion("apply_user_phone like", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotLike(String value) {
            addCriterion("apply_user_phone not like", value, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneIn(List<String> values) {
            addCriterion("apply_user_phone in", values, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotIn(List<String> values) {
            addCriterion("apply_user_phone not in", values, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneBetween(String value1, String value2) {
            addCriterion("apply_user_phone between", value1, value2, "applyUserPhone");
            return (Criteria) this;
        }

        public Criteria andApplyUserPhoneNotBetween(String value1, String value2) {
            addCriterion("apply_user_phone not between", value1, value2, "applyUserPhone");
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("contract_id like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("contract_id not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
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

        public Criteria andApprovalPriceIsNull() {
            addCriterion("approval_price is null");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceIsNotNull() {
            addCriterion("approval_price is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceEqualTo(BigDecimal value) {
            addCriterion("approval_price =", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceNotEqualTo(BigDecimal value) {
            addCriterion("approval_price <>", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceGreaterThan(BigDecimal value) {
            addCriterion("approval_price >", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("approval_price >=", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceLessThan(BigDecimal value) {
            addCriterion("approval_price <", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("approval_price <=", value, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceIn(List<BigDecimal> values) {
            addCriterion("approval_price in", values, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceNotIn(List<BigDecimal> values) {
            addCriterion("approval_price not in", values, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approval_price between", value1, value2, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andApprovalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("approval_price not between", value1, value2, "approvalPrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceIsNull() {
            addCriterion("guarantee_price is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceIsNotNull() {
            addCriterion("guarantee_price is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceEqualTo(BigDecimal value) {
            addCriterion("guarantee_price =", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceNotEqualTo(BigDecimal value) {
            addCriterion("guarantee_price <>", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceGreaterThan(BigDecimal value) {
            addCriterion("guarantee_price >", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_price >=", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceLessThan(BigDecimal value) {
            addCriterion("guarantee_price <", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_price <=", value, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceIn(List<BigDecimal> values) {
            addCriterion("guarantee_price in", values, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceNotIn(List<BigDecimal> values) {
            addCriterion("guarantee_price not in", values, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_price between", value1, value2, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andGuaranteePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_price not between", value1, value2, "guaranteePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceIsNull() {
            addCriterion("advance_price is null");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceIsNotNull() {
            addCriterion("advance_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceEqualTo(BigDecimal value) {
            addCriterion("advance_price =", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceNotEqualTo(BigDecimal value) {
            addCriterion("advance_price <>", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceGreaterThan(BigDecimal value) {
            addCriterion("advance_price >", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_price >=", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceLessThan(BigDecimal value) {
            addCriterion("advance_price <", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("advance_price <=", value, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceIn(List<BigDecimal> values) {
            addCriterion("advance_price in", values, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceNotIn(List<BigDecimal> values) {
            addCriterion("advance_price not in", values, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_price between", value1, value2, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andAdvancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("advance_price not between", value1, value2, "advancePrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNull() {
            addCriterion("other_price is null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNotNull() {
            addCriterion("other_price is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceEqualTo(BigDecimal value) {
            addCriterion("other_price =", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotEqualTo(BigDecimal value) {
            addCriterion("other_price <>", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThan(BigDecimal value) {
            addCriterion("other_price >", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price >=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThan(BigDecimal value) {
            addCriterion("other_price <", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price <=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIn(List<BigDecimal> values) {
            addCriterion("other_price in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotIn(List<BigDecimal> values) {
            addCriterion("other_price not in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price between", value1, value2, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price not between", value1, value2, "otherPrice");
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

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Integer value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Integer value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Integer value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Integer value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Integer> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Integer> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andSpqxTermIsNull() {
            addCriterion("spqx_term is null");
            return (Criteria) this;
        }

        public Criteria andSpqxTermIsNotNull() {
            addCriterion("spqx_term is not null");
            return (Criteria) this;
        }

        public Criteria andSpqxTermEqualTo(Integer value) {
            addCriterion("spqx_term =", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermNotEqualTo(Integer value) {
            addCriterion("spqx_term <>", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermGreaterThan(Integer value) {
            addCriterion("spqx_term >", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("spqx_term >=", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermLessThan(Integer value) {
            addCriterion("spqx_term <", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermLessThanOrEqualTo(Integer value) {
            addCriterion("spqx_term <=", value, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermIn(List<Integer> values) {
            addCriterion("spqx_term in", values, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermNotIn(List<Integer> values) {
            addCriterion("spqx_term not in", values, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermBetween(Integer value1, Integer value2) {
            addCriterion("spqx_term between", value1, value2, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andSpqxTermNotBetween(Integer value1, Integer value2) {
            addCriterion("spqx_term not between", value1, value2, "spqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermIsNull() {
            addCriterion("blqx_term is null");
            return (Criteria) this;
        }

        public Criteria andBlqxTermIsNotNull() {
            addCriterion("blqx_term is not null");
            return (Criteria) this;
        }

        public Criteria andBlqxTermEqualTo(Integer value) {
            addCriterion("blqx_term =", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermNotEqualTo(Integer value) {
            addCriterion("blqx_term <>", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermGreaterThan(Integer value) {
            addCriterion("blqx_term >", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermGreaterThanOrEqualTo(Integer value) {
            addCriterion("blqx_term >=", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermLessThan(Integer value) {
            addCriterion("blqx_term <", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermLessThanOrEqualTo(Integer value) {
            addCriterion("blqx_term <=", value, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermIn(List<Integer> values) {
            addCriterion("blqx_term in", values, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermNotIn(List<Integer> values) {
            addCriterion("blqx_term not in", values, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermBetween(Integer value1, Integer value2) {
            addCriterion("blqx_term between", value1, value2, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andBlqxTermNotBetween(Integer value1, Integer value2) {
            addCriterion("blqx_term not between", value1, value2, "blqxTerm");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoIsNull() {
            addCriterion("payment_voucher_no is null");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoIsNotNull() {
            addCriterion("payment_voucher_no is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoEqualTo(String value) {
            addCriterion("payment_voucher_no =", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoNotEqualTo(String value) {
            addCriterion("payment_voucher_no <>", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoGreaterThan(String value) {
            addCriterion("payment_voucher_no >", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoGreaterThanOrEqualTo(String value) {
            addCriterion("payment_voucher_no >=", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoLessThan(String value) {
            addCriterion("payment_voucher_no <", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoLessThanOrEqualTo(String value) {
            addCriterion("payment_voucher_no <=", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoLike(String value) {
            addCriterion("payment_voucher_no like", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoNotLike(String value) {
            addCriterion("payment_voucher_no not like", value, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoIn(List<String> values) {
            addCriterion("payment_voucher_no in", values, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoNotIn(List<String> values) {
            addCriterion("payment_voucher_no not in", values, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoBetween(String value1, String value2) {
            addCriterion("payment_voucher_no between", value1, value2, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andPaymentVoucherNoNotBetween(String value1, String value2) {
            addCriterion("payment_voucher_no not between", value1, value2, "paymentVoucherNo");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateIsNull() {
            addCriterion("advance_rate is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateIsNotNull() {
            addCriterion("advance_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateEqualTo(Double value) {
            addCriterion("advance_rate =", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateNotEqualTo(Double value) {
            addCriterion("advance_rate <>", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateGreaterThan(Double value) {
            addCriterion("advance_rate >", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateGreaterThanOrEqualTo(Double value) {
            addCriterion("advance_rate >=", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateLessThan(Double value) {
            addCriterion("advance_rate <", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateLessThanOrEqualTo(Double value) {
            addCriterion("advance_rate <=", value, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateIn(List<Double> values) {
            addCriterion("advance_rate in", values, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateNotIn(List<Double> values) {
            addCriterion("advance_rate not in", values, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateBetween(Double value1, Double value2) {
            addCriterion("advance_rate between", value1, value2, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceRateNotBetween(Double value1, Double value2) {
            addCriterion("advance_rate not between", value1, value2, "advanceRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNull() {
            addCriterion("cost_rate is null");
            return (Criteria) this;
        }

        public Criteria andCostRateIsNotNull() {
            addCriterion("cost_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCostRateEqualTo(Double value) {
            addCriterion("cost_rate =", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotEqualTo(Double value) {
            addCriterion("cost_rate <>", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThan(Double value) {
            addCriterion("cost_rate >", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateGreaterThanOrEqualTo(Double value) {
            addCriterion("cost_rate >=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThan(Double value) {
            addCriterion("cost_rate <", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateLessThanOrEqualTo(Double value) {
            addCriterion("cost_rate <=", value, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateIn(List<Double> values) {
            addCriterion("cost_rate in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotIn(List<Double> values) {
            addCriterion("cost_rate not in", values, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateBetween(Double value1, Double value2) {
            addCriterion("cost_rate between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andCostRateNotBetween(Double value1, Double value2) {
            addCriterion("cost_rate not between", value1, value2, "costRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateIsNull() {
            addCriterion("financial_rate is null");
            return (Criteria) this;
        }

        public Criteria andFinancialRateIsNotNull() {
            addCriterion("financial_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialRateEqualTo(Double value) {
            addCriterion("financial_rate =", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateNotEqualTo(Double value) {
            addCriterion("financial_rate <>", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateGreaterThan(Double value) {
            addCriterion("financial_rate >", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateGreaterThanOrEqualTo(Double value) {
            addCriterion("financial_rate >=", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateLessThan(Double value) {
            addCriterion("financial_rate <", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateLessThanOrEqualTo(Double value) {
            addCriterion("financial_rate <=", value, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateIn(List<Double> values) {
            addCriterion("financial_rate in", values, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateNotIn(List<Double> values) {
            addCriterion("financial_rate not in", values, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateBetween(Double value1, Double value2) {
            addCriterion("financial_rate between", value1, value2, "financialRate");
            return (Criteria) this;
        }

        public Criteria andFinancialRateNotBetween(Double value1, Double value2) {
            addCriterion("financial_rate not between", value1, value2, "financialRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(Double value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(Double value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(Double value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(Double value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(Double value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(Double value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<Double> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<Double> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(Double value1, Double value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(Double value1, Double value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andContractVolumeIsNull() {
            addCriterion("contract_volume is null");
            return (Criteria) this;
        }

        public Criteria andContractVolumeIsNotNull() {
            addCriterion("contract_volume is not null");
            return (Criteria) this;
        }

        public Criteria andContractVolumeEqualTo(Double value) {
            addCriterion("contract_volume =", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeNotEqualTo(Double value) {
            addCriterion("contract_volume <>", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeGreaterThan(Double value) {
            addCriterion("contract_volume >", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_volume >=", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeLessThan(Double value) {
            addCriterion("contract_volume <", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeLessThanOrEqualTo(Double value) {
            addCriterion("contract_volume <=", value, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeIn(List<Double> values) {
            addCriterion("contract_volume in", values, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeNotIn(List<Double> values) {
            addCriterion("contract_volume not in", values, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeBetween(Double value1, Double value2) {
            addCriterion("contract_volume between", value1, value2, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andContractVolumeNotBetween(Double value1, Double value2) {
            addCriterion("contract_volume not between", value1, value2, "contractVolume");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureIsNull() {
            addCriterion("finish_measure is null");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureIsNotNull() {
            addCriterion("finish_measure is not null");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureEqualTo(Double value) {
            addCriterion("finish_measure =", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureNotEqualTo(Double value) {
            addCriterion("finish_measure <>", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureGreaterThan(Double value) {
            addCriterion("finish_measure >", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureGreaterThanOrEqualTo(Double value) {
            addCriterion("finish_measure >=", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureLessThan(Double value) {
            addCriterion("finish_measure <", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureLessThanOrEqualTo(Double value) {
            addCriterion("finish_measure <=", value, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureIn(List<Double> values) {
            addCriterion("finish_measure in", values, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureNotIn(List<Double> values) {
            addCriterion("finish_measure not in", values, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureBetween(Double value1, Double value2) {
            addCriterion("finish_measure between", value1, value2, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andFinishMeasureNotBetween(Double value1, Double value2) {
            addCriterion("finish_measure not between", value1, value2, "finishMeasure");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIsNull() {
            addCriterion("amount_paid is null");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIsNotNull() {
            addCriterion("amount_paid is not null");
            return (Criteria) this;
        }

        public Criteria andAmountPaidEqualTo(Double value) {
            addCriterion("amount_paid =", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotEqualTo(Double value) {
            addCriterion("amount_paid <>", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidGreaterThan(Double value) {
            addCriterion("amount_paid >", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidGreaterThanOrEqualTo(Double value) {
            addCriterion("amount_paid >=", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidLessThan(Double value) {
            addCriterion("amount_paid <", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidLessThanOrEqualTo(Double value) {
            addCriterion("amount_paid <=", value, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidIn(List<Double> values) {
            addCriterion("amount_paid in", values, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotIn(List<Double> values) {
            addCriterion("amount_paid not in", values, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidBetween(Double value1, Double value2) {
            addCriterion("amount_paid between", value1, value2, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andAmountPaidNotBetween(Double value1, Double value2) {
            addCriterion("amount_paid not between", value1, value2, "amountPaid");
            return (Criteria) this;
        }

        public Criteria andPaidProportionIsNull() {
            addCriterion("paid_proportion is null");
            return (Criteria) this;
        }

        public Criteria andPaidProportionIsNotNull() {
            addCriterion("paid_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andPaidProportionEqualTo(Double value) {
            addCriterion("paid_proportion =", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionNotEqualTo(Double value) {
            addCriterion("paid_proportion <>", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionGreaterThan(Double value) {
            addCriterion("paid_proportion >", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("paid_proportion >=", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionLessThan(Double value) {
            addCriterion("paid_proportion <", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionLessThanOrEqualTo(Double value) {
            addCriterion("paid_proportion <=", value, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionIn(List<Double> values) {
            addCriterion("paid_proportion in", values, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionNotIn(List<Double> values) {
            addCriterion("paid_proportion not in", values, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionBetween(Double value1, Double value2) {
            addCriterion("paid_proportion between", value1, value2, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaidProportionNotBetween(Double value1, Double value2) {
            addCriterion("paid_proportion not between", value1, value2, "paidProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionIsNull() {
            addCriterion("payment_proportion is null");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionIsNotNull() {
            addCriterion("payment_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionEqualTo(Double value) {
            addCriterion("payment_proportion =", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionNotEqualTo(Double value) {
            addCriterion("payment_proportion <>", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionGreaterThan(Double value) {
            addCriterion("payment_proportion >", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionGreaterThanOrEqualTo(Double value) {
            addCriterion("payment_proportion >=", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionLessThan(Double value) {
            addCriterion("payment_proportion <", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionLessThanOrEqualTo(Double value) {
            addCriterion("payment_proportion <=", value, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionIn(List<Double> values) {
            addCriterion("payment_proportion in", values, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionNotIn(List<Double> values) {
            addCriterion("payment_proportion not in", values, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionBetween(Double value1, Double value2) {
            addCriterion("payment_proportion between", value1, value2, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andPaymentProportionNotBetween(Double value1, Double value2) {
            addCriterion("payment_proportion not between", value1, value2, "paymentProportion");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(Integer value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(Integer value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(Integer value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(Integer value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<Integer> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<Integer> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateIsNull() {
            addCriterion("special_tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateIsNotNull() {
            addCriterion("special_tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateEqualTo(Double value) {
            addCriterion("special_tax_rate =", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateNotEqualTo(Double value) {
            addCriterion("special_tax_rate <>", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateGreaterThan(Double value) {
            addCriterion("special_tax_rate >", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateGreaterThanOrEqualTo(Double value) {
            addCriterion("special_tax_rate >=", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateLessThan(Double value) {
            addCriterion("special_tax_rate <", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateLessThanOrEqualTo(Double value) {
            addCriterion("special_tax_rate <=", value, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateIn(List<Double> values) {
            addCriterion("special_tax_rate in", values, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateNotIn(List<Double> values) {
            addCriterion("special_tax_rate not in", values, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateBetween(Double value1, Double value2) {
            addCriterion("special_tax_rate between", value1, value2, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andSpecialTaxRateNotBetween(Double value1, Double value2) {
            addCriterion("special_tax_rate not between", value1, value2, "specialTaxRate");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIsNull() {
            addCriterion("quality_grade is null");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIsNotNull() {
            addCriterion("quality_grade is not null");
            return (Criteria) this;
        }

        public Criteria andQualityGradeEqualTo(Integer value) {
            addCriterion("quality_grade =", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotEqualTo(Integer value) {
            addCriterion("quality_grade <>", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeGreaterThan(Integer value) {
            addCriterion("quality_grade >", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality_grade >=", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeLessThan(Integer value) {
            addCriterion("quality_grade <", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeLessThanOrEqualTo(Integer value) {
            addCriterion("quality_grade <=", value, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeIn(List<Integer> values) {
            addCriterion("quality_grade in", values, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotIn(List<Integer> values) {
            addCriterion("quality_grade not in", values, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeBetween(Integer value1, Integer value2) {
            addCriterion("quality_grade between", value1, value2, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("quality_grade not between", value1, value2, "qualityGrade");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorIsNull() {
            addCriterion("quality_assessor is null");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorIsNotNull() {
            addCriterion("quality_assessor is not null");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorEqualTo(Long value) {
            addCriterion("quality_assessor =", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorNotEqualTo(Long value) {
            addCriterion("quality_assessor <>", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorGreaterThan(Long value) {
            addCriterion("quality_assessor >", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorGreaterThanOrEqualTo(Long value) {
            addCriterion("quality_assessor >=", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorLessThan(Long value) {
            addCriterion("quality_assessor <", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorLessThanOrEqualTo(Long value) {
            addCriterion("quality_assessor <=", value, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorIn(List<Long> values) {
            addCriterion("quality_assessor in", values, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorNotIn(List<Long> values) {
            addCriterion("quality_assessor not in", values, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorBetween(Long value1, Long value2) {
            addCriterion("quality_assessor between", value1, value2, "qualityAssessor");
            return (Criteria) this;
        }

        public Criteria andQualityAssessorNotBetween(Long value1, Long value2) {
            addCriterion("quality_assessor not between", value1, value2, "qualityAssessor");
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

        public Criteria andManagerDepartUserEqualTo(Long value) {
            addCriterion("manager_depart_user =", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotEqualTo(Long value) {
            addCriterion("manager_depart_user <>", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserGreaterThan(Long value) {
            addCriterion("manager_depart_user >", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserGreaterThanOrEqualTo(Long value) {
            addCriterion("manager_depart_user >=", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserLessThan(Long value) {
            addCriterion("manager_depart_user <", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserLessThanOrEqualTo(Long value) {
            addCriterion("manager_depart_user <=", value, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserIn(List<Long> values) {
            addCriterion("manager_depart_user in", values, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotIn(List<Long> values) {
            addCriterion("manager_depart_user not in", values, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserBetween(Long value1, Long value2) {
            addCriterion("manager_depart_user between", value1, value2, "managerDepartUser");
            return (Criteria) this;
        }

        public Criteria andManagerDepartUserNotBetween(Long value1, Long value2) {
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

        public Criteria andFinancePaymentApprovalIsNull() {
            addCriterion("finance_payment_approval is null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalIsNotNull() {
            addCriterion("finance_payment_approval is not null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalEqualTo(Boolean value) {
            addCriterion("finance_payment_approval =", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalNotEqualTo(Boolean value) {
            addCriterion("finance_payment_approval <>", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalGreaterThan(Boolean value) {
            addCriterion("finance_payment_approval >", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("finance_payment_approval >=", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalLessThan(Boolean value) {
            addCriterion("finance_payment_approval <", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalLessThanOrEqualTo(Boolean value) {
            addCriterion("finance_payment_approval <=", value, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalIn(List<Boolean> values) {
            addCriterion("finance_payment_approval in", values, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalNotIn(List<Boolean> values) {
            addCriterion("finance_payment_approval not in", values, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalBetween(Boolean value1, Boolean value2) {
            addCriterion("finance_payment_approval between", value1, value2, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentApprovalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("finance_payment_approval not between", value1, value2, "financePaymentApproval");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserIsNull() {
            addCriterion("finance_payment_user is null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserIsNotNull() {
            addCriterion("finance_payment_user is not null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserEqualTo(Long value) {
            addCriterion("finance_payment_user =", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserNotEqualTo(Long value) {
            addCriterion("finance_payment_user <>", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserGreaterThan(Long value) {
            addCriterion("finance_payment_user >", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserGreaterThanOrEqualTo(Long value) {
            addCriterion("finance_payment_user >=", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserLessThan(Long value) {
            addCriterion("finance_payment_user <", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserLessThanOrEqualTo(Long value) {
            addCriterion("finance_payment_user <=", value, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserIn(List<Long> values) {
            addCriterion("finance_payment_user in", values, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserNotIn(List<Long> values) {
            addCriterion("finance_payment_user not in", values, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserBetween(Long value1, Long value2) {
            addCriterion("finance_payment_user between", value1, value2, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentUserNotBetween(Long value1, Long value2) {
            addCriterion("finance_payment_user not between", value1, value2, "financePaymentUser");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateIsNull() {
            addCriterion("finance_payment_date is null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateIsNotNull() {
            addCriterion("finance_payment_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateEqualTo(Date value) {
            addCriterion("finance_payment_date =", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateNotEqualTo(Date value) {
            addCriterion("finance_payment_date <>", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateGreaterThan(Date value) {
            addCriterion("finance_payment_date >", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("finance_payment_date >=", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateLessThan(Date value) {
            addCriterion("finance_payment_date <", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateLessThanOrEqualTo(Date value) {
            addCriterion("finance_payment_date <=", value, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateIn(List<Date> values) {
            addCriterion("finance_payment_date in", values, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateNotIn(List<Date> values) {
            addCriterion("finance_payment_date not in", values, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateBetween(Date value1, Date value2) {
            addCriterion("finance_payment_date between", value1, value2, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentDateNotBetween(Date value1, Date value2) {
            addCriterion("finance_payment_date not between", value1, value2, "financePaymentDate");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionIsNull() {
            addCriterion("finance_payment_opinion is null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionIsNotNull() {
            addCriterion("finance_payment_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionEqualTo(String value) {
            addCriterion("finance_payment_opinion =", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionNotEqualTo(String value) {
            addCriterion("finance_payment_opinion <>", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionGreaterThan(String value) {
            addCriterion("finance_payment_opinion >", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("finance_payment_opinion >=", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionLessThan(String value) {
            addCriterion("finance_payment_opinion <", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionLessThanOrEqualTo(String value) {
            addCriterion("finance_payment_opinion <=", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionLike(String value) {
            addCriterion("finance_payment_opinion like", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionNotLike(String value) {
            addCriterion("finance_payment_opinion not like", value, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionIn(List<String> values) {
            addCriterion("finance_payment_opinion in", values, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionNotIn(List<String> values) {
            addCriterion("finance_payment_opinion not in", values, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionBetween(String value1, String value2) {
            addCriterion("finance_payment_opinion between", value1, value2, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andFinancePaymentOpinionNotBetween(String value1, String value2) {
            addCriterion("finance_payment_opinion not between", value1, value2, "financePaymentOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewFailIsNull() {
            addCriterion("review_fail is null");
            return (Criteria) this;
        }

        public Criteria andReviewFailIsNotNull() {
            addCriterion("review_fail is not null");
            return (Criteria) this;
        }

        public Criteria andReviewFailEqualTo(Boolean value) {
            addCriterion("review_fail =", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailNotEqualTo(Boolean value) {
            addCriterion("review_fail <>", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailGreaterThan(Boolean value) {
            addCriterion("review_fail >", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailGreaterThanOrEqualTo(Boolean value) {
            addCriterion("review_fail >=", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailLessThan(Boolean value) {
            addCriterion("review_fail <", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailLessThanOrEqualTo(Boolean value) {
            addCriterion("review_fail <=", value, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailIn(List<Boolean> values) {
            addCriterion("review_fail in", values, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailNotIn(List<Boolean> values) {
            addCriterion("review_fail not in", values, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailBetween(Boolean value1, Boolean value2) {
            addCriterion("review_fail between", value1, value2, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewFailNotBetween(Boolean value1, Boolean value2) {
            addCriterion("review_fail not between", value1, value2, "reviewFail");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIsNull() {
            addCriterion("review_opinion is null");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIsNotNull() {
            addCriterion("review_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionEqualTo(String value) {
            addCriterion("review_opinion =", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotEqualTo(String value) {
            addCriterion("review_opinion <>", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionGreaterThan(String value) {
            addCriterion("review_opinion >", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("review_opinion >=", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLessThan(String value) {
            addCriterion("review_opinion <", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLessThanOrEqualTo(String value) {
            addCriterion("review_opinion <=", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionLike(String value) {
            addCriterion("review_opinion like", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotLike(String value) {
            addCriterion("review_opinion not like", value, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionIn(List<String> values) {
            addCriterion("review_opinion in", values, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotIn(List<String> values) {
            addCriterion("review_opinion not in", values, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionBetween(String value1, String value2) {
            addCriterion("review_opinion between", value1, value2, "reviewOpinion");
            return (Criteria) this;
        }

        public Criteria andReviewOpinionNotBetween(String value1, String value2) {
            addCriterion("review_opinion not between", value1, value2, "reviewOpinion");
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