package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizBiddingManagementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizBiddingManagementExample() {
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

        public Criteria andBidUserIsNull() {
            addCriterion("bid_user is null");
            return (Criteria) this;
        }

        public Criteria andBidUserIsNotNull() {
            addCriterion("bid_user is not null");
            return (Criteria) this;
        }

        public Criteria andBidUserEqualTo(Long value) {
            addCriterion("bid_user =", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserNotEqualTo(Long value) {
            addCriterion("bid_user <>", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserGreaterThan(Long value) {
            addCriterion("bid_user >", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserGreaterThanOrEqualTo(Long value) {
            addCriterion("bid_user >=", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserLessThan(Long value) {
            addCriterion("bid_user <", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserLessThanOrEqualTo(Long value) {
            addCriterion("bid_user <=", value, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserIn(List<Long> values) {
            addCriterion("bid_user in", values, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserNotIn(List<Long> values) {
            addCriterion("bid_user not in", values, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserBetween(Long value1, Long value2) {
            addCriterion("bid_user between", value1, value2, "bidUser");
            return (Criteria) this;
        }

        public Criteria andBidUserNotBetween(Long value1, Long value2) {
            addCriterion("bid_user not between", value1, value2, "bidUser");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andCustomersIdIsNull() {
            addCriterion("customers_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomersIdIsNotNull() {
            addCriterion("customers_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomersIdEqualTo(Long value) {
            addCriterion("customers_id =", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdNotEqualTo(Long value) {
            addCriterion("customers_id <>", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdGreaterThan(Long value) {
            addCriterion("customers_id >", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customers_id >=", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdLessThan(Long value) {
            addCriterion("customers_id <", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdLessThanOrEqualTo(Long value) {
            addCriterion("customers_id <=", value, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdIn(List<Long> values) {
            addCriterion("customers_id in", values, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdNotIn(List<Long> values) {
            addCriterion("customers_id not in", values, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdBetween(Long value1, Long value2) {
            addCriterion("customers_id between", value1, value2, "customersId");
            return (Criteria) this;
        }

        public Criteria andCustomersIdNotBetween(Long value1, Long value2) {
            addCriterion("customers_id not between", value1, value2, "customersId");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageIsNull() {
            addCriterion("project_acreage is null");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageIsNotNull() {
            addCriterion("project_acreage is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageEqualTo(Double value) {
            addCriterion("project_acreage =", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageNotEqualTo(Double value) {
            addCriterion("project_acreage <>", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageGreaterThan(Double value) {
            addCriterion("project_acreage >", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageGreaterThanOrEqualTo(Double value) {
            addCriterion("project_acreage >=", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageLessThan(Double value) {
            addCriterion("project_acreage <", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageLessThanOrEqualTo(Double value) {
            addCriterion("project_acreage <=", value, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageIn(List<Double> values) {
            addCriterion("project_acreage in", values, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageNotIn(List<Double> values) {
            addCriterion("project_acreage not in", values, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageBetween(Double value1, Double value2) {
            addCriterion("project_acreage between", value1, value2, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectAcreageNotBetween(Double value1, Double value2) {
            addCriterion("project_acreage not between", value1, value2, "projectAcreage");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeIsNull() {
            addCriterion("project_price_budge is null");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeIsNotNull() {
            addCriterion("project_price_budge is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeEqualTo(BigDecimal value) {
            addCriterion("project_price_budge =", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeNotEqualTo(BigDecimal value) {
            addCriterion("project_price_budge <>", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeGreaterThan(BigDecimal value) {
            addCriterion("project_price_budge >", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_price_budge >=", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeLessThan(BigDecimal value) {
            addCriterion("project_price_budge <", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_price_budge <=", value, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeIn(List<BigDecimal> values) {
            addCriterion("project_price_budge in", values, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeNotIn(List<BigDecimal> values) {
            addCriterion("project_price_budge not in", values, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_price_budge between", value1, value2, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andProjectPriceBudgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_price_budge not between", value1, value2, "projectPriceBudge");
            return (Criteria) this;
        }

        public Criteria andFinalBidIsNull() {
            addCriterion("final_bid is null");
            return (Criteria) this;
        }

        public Criteria andFinalBidIsNotNull() {
            addCriterion("final_bid is not null");
            return (Criteria) this;
        }

        public Criteria andFinalBidEqualTo(BigDecimal value) {
            addCriterion("final_bid =", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidNotEqualTo(BigDecimal value) {
            addCriterion("final_bid <>", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidGreaterThan(BigDecimal value) {
            addCriterion("final_bid >", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_bid >=", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidLessThan(BigDecimal value) {
            addCriterion("final_bid <", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_bid <=", value, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidIn(List<BigDecimal> values) {
            addCriterion("final_bid in", values, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidNotIn(List<BigDecimal> values) {
            addCriterion("final_bid not in", values, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_bid between", value1, value2, "finalBid");
            return (Criteria) this;
        }

        public Criteria andFinalBidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_bid not between", value1, value2, "finalBid");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeIsNull() {
            addCriterion("estimate_start_time is null");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeIsNotNull() {
            addCriterion("estimate_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeEqualTo(Date value) {
            addCriterion("estimate_start_time =", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeNotEqualTo(Date value) {
            addCriterion("estimate_start_time <>", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeGreaterThan(Date value) {
            addCriterion("estimate_start_time >", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("estimate_start_time >=", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeLessThan(Date value) {
            addCriterion("estimate_start_time <", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("estimate_start_time <=", value, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeIn(List<Date> values) {
            addCriterion("estimate_start_time in", values, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeNotIn(List<Date> values) {
            addCriterion("estimate_start_time not in", values, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeBetween(Date value1, Date value2) {
            addCriterion("estimate_start_time between", value1, value2, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andEstimateStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("estimate_start_time not between", value1, value2, "estimateStartTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeIsNull() {
            addCriterion("bid_mark_time is null");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeIsNotNull() {
            addCriterion("bid_mark_time is not null");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeEqualTo(Date value) {
            addCriterion("bid_mark_time =", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeNotEqualTo(Date value) {
            addCriterion("bid_mark_time <>", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeGreaterThan(Date value) {
            addCriterion("bid_mark_time >", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bid_mark_time >=", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeLessThan(Date value) {
            addCriterion("bid_mark_time <", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeLessThanOrEqualTo(Date value) {
            addCriterion("bid_mark_time <=", value, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeIn(List<Date> values) {
            addCriterion("bid_mark_time in", values, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeNotIn(List<Date> values) {
            addCriterion("bid_mark_time not in", values, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeBetween(Date value1, Date value2) {
            addCriterion("bid_mark_time between", value1, value2, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andBidMarkTimeNotBetween(Date value1, Date value2) {
            addCriterion("bid_mark_time not between", value1, value2, "bidMarkTime");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoIsNull() {
            addCriterion("open_bid_info is null");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoIsNotNull() {
            addCriterion("open_bid_info is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoEqualTo(Integer value) {
            addCriterion("open_bid_info =", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoNotEqualTo(Integer value) {
            addCriterion("open_bid_info <>", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoGreaterThan(Integer value) {
            addCriterion("open_bid_info >", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_bid_info >=", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoLessThan(Integer value) {
            addCriterion("open_bid_info <", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoLessThanOrEqualTo(Integer value) {
            addCriterion("open_bid_info <=", value, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoIn(List<Integer> values) {
            addCriterion("open_bid_info in", values, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoNotIn(List<Integer> values) {
            addCriterion("open_bid_info not in", values, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoBetween(Integer value1, Integer value2) {
            addCriterion("open_bid_info between", value1, value2, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andOpenBidInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("open_bid_info not between", value1, value2, "openBidInfo");
            return (Criteria) this;
        }

        public Criteria andBidCauseIsNull() {
            addCriterion("bid_cause is null");
            return (Criteria) this;
        }

        public Criteria andBidCauseIsNotNull() {
            addCriterion("bid_cause is not null");
            return (Criteria) this;
        }

        public Criteria andBidCauseEqualTo(Integer value) {
            addCriterion("bid_cause =", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseNotEqualTo(Integer value) {
            addCriterion("bid_cause <>", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseGreaterThan(Integer value) {
            addCriterion("bid_cause >", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_cause >=", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseLessThan(Integer value) {
            addCriterion("bid_cause <", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseLessThanOrEqualTo(Integer value) {
            addCriterion("bid_cause <=", value, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseIn(List<Integer> values) {
            addCriterion("bid_cause in", values, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseNotIn(List<Integer> values) {
            addCriterion("bid_cause not in", values, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseBetween(Integer value1, Integer value2) {
            addCriterion("bid_cause between", value1, value2, "bidCause");
            return (Criteria) this;
        }

        public Criteria andBidCauseNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_cause not between", value1, value2, "bidCause");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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