package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizProgrammeAcceptanceOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizProgrammeAcceptanceOrderExample() {
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

        public Criteria andContractNoIsNull() {
            addCriterion("contract_no is null");
            return (Criteria) this;
        }

        public Criteria andContractNoIsNotNull() {
            addCriterion("contract_no is not null");
            return (Criteria) this;
        }

        public Criteria andContractNoEqualTo(String value) {
            addCriterion("contract_no =", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotEqualTo(String value) {
            addCriterion("contract_no <>", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThan(String value) {
            addCriterion("contract_no >", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoGreaterThanOrEqualTo(String value) {
            addCriterion("contract_no >=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThan(String value) {
            addCriterion("contract_no <", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLessThanOrEqualTo(String value) {
            addCriterion("contract_no <=", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoLike(String value) {
            addCriterion("contract_no like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotLike(String value) {
            addCriterion("contract_no not like", value, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoIn(List<String> values) {
            addCriterion("contract_no in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotIn(List<String> values) {
            addCriterion("contract_no not in", values, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoBetween(String value1, String value2) {
            addCriterion("contract_no between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractNoNotBetween(String value1, String value2) {
            addCriterion("contract_no not between", value1, value2, "contractNo");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNull() {
            addCriterion("contract_money is null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIsNotNull() {
            addCriterion("contract_money is not null");
            return (Criteria) this;
        }

        public Criteria andContractMoneyEqualTo(BigDecimal value) {
            addCriterion("contract_money =", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotEqualTo(BigDecimal value) {
            addCriterion("contract_money <>", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThan(BigDecimal value) {
            addCriterion("contract_money >", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_money >=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThan(BigDecimal value) {
            addCriterion("contract_money <", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_money <=", value, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyIn(List<BigDecimal> values) {
            addCriterion("contract_money in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotIn(List<BigDecimal> values) {
            addCriterion("contract_money not in", values, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_money between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andContractMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_money not between", value1, value2, "contractMoney");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceIsNull() {
            addCriterion("apply_total_price is null");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceIsNotNull() {
            addCriterion("apply_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceEqualTo(BigDecimal value) {
            addCriterion("apply_total_price =", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("apply_total_price <>", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("apply_total_price >", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_total_price >=", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceLessThan(BigDecimal value) {
            addCriterion("apply_total_price <", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_total_price <=", value, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceIn(List<BigDecimal> values) {
            addCriterion("apply_total_price in", values, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("apply_total_price not in", values, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_total_price between", value1, value2, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andApplyTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_total_price not between", value1, value2, "applyTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceIsNull() {
            addCriterion("payment_total_price is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceIsNotNull() {
            addCriterion("payment_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceEqualTo(BigDecimal value) {
            addCriterion("payment_total_price =", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("payment_total_price <>", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("payment_total_price >", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment_total_price >=", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceLessThan(BigDecimal value) {
            addCriterion("payment_total_price <", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment_total_price <=", value, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceIn(List<BigDecimal> values) {
            addCriterion("payment_total_price in", values, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("payment_total_price not in", values, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment_total_price between", value1, value2, "paymentTotalPrice");
            return (Criteria) this;
        }

        public Criteria andPaymentTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment_total_price not between", value1, value2, "paymentTotalPrice");
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

        public Criteria andLastReviewRoleIsNull() {
            addCriterion("last_review_role is null");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleIsNotNull() {
            addCriterion("last_review_role is not null");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleEqualTo(Long value) {
            addCriterion("last_review_role =", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleNotEqualTo(Long value) {
            addCriterion("last_review_role <>", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleGreaterThan(Long value) {
            addCriterion("last_review_role >", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleGreaterThanOrEqualTo(Long value) {
            addCriterion("last_review_role >=", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleLessThan(Long value) {
            addCriterion("last_review_role <", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleLessThanOrEqualTo(Long value) {
            addCriterion("last_review_role <=", value, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleIn(List<Long> values) {
            addCriterion("last_review_role in", values, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleNotIn(List<Long> values) {
            addCriterion("last_review_role not in", values, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleBetween(Long value1, Long value2) {
            addCriterion("last_review_role between", value1, value2, "lastReviewRole");
            return (Criteria) this;
        }

        public Criteria andLastReviewRoleNotBetween(Long value1, Long value2) {
            addCriterion("last_review_role not between", value1, value2, "lastReviewRole");
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

        public Criteria andIsSaveSubmitIsNull() {
            addCriterion("is_save_submit is null");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitIsNotNull() {
            addCriterion("is_save_submit is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitEqualTo(Integer value) {
            addCriterion("is_save_submit =", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitNotEqualTo(Integer value) {
            addCriterion("is_save_submit <>", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitGreaterThan(Integer value) {
            addCriterion("is_save_submit >", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_save_submit >=", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitLessThan(Integer value) {
            addCriterion("is_save_submit <", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitLessThanOrEqualTo(Integer value) {
            addCriterion("is_save_submit <=", value, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitIn(List<Integer> values) {
            addCriterion("is_save_submit in", values, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitNotIn(List<Integer> values) {
            addCriterion("is_save_submit not in", values, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitBetween(Integer value1, Integer value2) {
            addCriterion("is_save_submit between", value1, value2, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andIsSaveSubmitNotBetween(Integer value1, Integer value2) {
            addCriterion("is_save_submit not between", value1, value2, "isSaveSubmit");
            return (Criteria) this;
        }

        public Criteria andUserItemIsNull() {
            addCriterion("user_item is null");
            return (Criteria) this;
        }

        public Criteria andUserItemIsNotNull() {
            addCriterion("user_item is not null");
            return (Criteria) this;
        }

        public Criteria andUserItemEqualTo(String value) {
            addCriterion("user_item =", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemNotEqualTo(String value) {
            addCriterion("user_item <>", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemGreaterThan(String value) {
            addCriterion("user_item >", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemGreaterThanOrEqualTo(String value) {
            addCriterion("user_item >=", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemLessThan(String value) {
            addCriterion("user_item <", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemLessThanOrEqualTo(String value) {
            addCriterion("user_item <=", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemLike(String value) {
            addCriterion("user_item like", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemNotLike(String value) {
            addCriterion("user_item not like", value, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemIn(List<String> values) {
            addCriterion("user_item in", values, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemNotIn(List<String> values) {
            addCriterion("user_item not in", values, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemBetween(String value1, String value2) {
            addCriterion("user_item between", value1, value2, "userItem");
            return (Criteria) this;
        }

        public Criteria andUserItemNotBetween(String value1, String value2) {
            addCriterion("user_item not between", value1, value2, "userItem");
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