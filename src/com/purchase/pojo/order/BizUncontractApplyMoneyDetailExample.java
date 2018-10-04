package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BizUncontractApplyMoneyDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizUncontractApplyMoneyDetailExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andProjectContentIsNull() {
            addCriterion("project_content is null");
            return (Criteria) this;
        }

        public Criteria andProjectContentIsNotNull() {
            addCriterion("project_content is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContentEqualTo(String value) {
            addCriterion("project_content =", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotEqualTo(String value) {
            addCriterion("project_content <>", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThan(String value) {
            addCriterion("project_content >", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThanOrEqualTo(String value) {
            addCriterion("project_content >=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThan(String value) {
            addCriterion("project_content <", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThanOrEqualTo(String value) {
            addCriterion("project_content <=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLike(String value) {
            addCriterion("project_content like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotLike(String value) {
            addCriterion("project_content not like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentIn(List<String> values) {
            addCriterion("project_content in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotIn(List<String> values) {
            addCriterion("project_content not in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentBetween(String value1, String value2) {
            addCriterion("project_content between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotBetween(String value1, String value2) {
            addCriterion("project_content not between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andQuantitiesIsNull() {
            addCriterion("quantities is null");
            return (Criteria) this;
        }

        public Criteria andQuantitiesIsNotNull() {
            addCriterion("quantities is not null");
            return (Criteria) this;
        }

        public Criteria andQuantitiesEqualTo(Double value) {
            addCriterion("quantities =", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesNotEqualTo(Double value) {
            addCriterion("quantities <>", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesGreaterThan(Double value) {
            addCriterion("quantities >", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesGreaterThanOrEqualTo(Double value) {
            addCriterion("quantities >=", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesLessThan(Double value) {
            addCriterion("quantities <", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesLessThanOrEqualTo(Double value) {
            addCriterion("quantities <=", value, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesIn(List<Double> values) {
            addCriterion("quantities in", values, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesNotIn(List<Double> values) {
            addCriterion("quantities not in", values, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesBetween(Double value1, Double value2) {
            addCriterion("quantities between", value1, value2, "quantities");
            return (Criteria) this;
        }

        public Criteria andQuantitiesNotBetween(Double value1, Double value2) {
            addCriterion("quantities not between", value1, value2, "quantities");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateIsNull() {
            addCriterion("apply_completion_rate is null");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateIsNotNull() {
            addCriterion("apply_completion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateEqualTo(Double value) {
            addCriterion("apply_completion_rate =", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateNotEqualTo(Double value) {
            addCriterion("apply_completion_rate <>", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateGreaterThan(Double value) {
            addCriterion("apply_completion_rate >", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateGreaterThanOrEqualTo(Double value) {
            addCriterion("apply_completion_rate >=", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateLessThan(Double value) {
            addCriterion("apply_completion_rate <", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateLessThanOrEqualTo(Double value) {
            addCriterion("apply_completion_rate <=", value, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateIn(List<Double> values) {
            addCriterion("apply_completion_rate in", values, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateNotIn(List<Double> values) {
            addCriterion("apply_completion_rate not in", values, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateBetween(Double value1, Double value2) {
            addCriterion("apply_completion_rate between", value1, value2, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApplyCompletionRateNotBetween(Double value1, Double value2) {
            addCriterion("apply_completion_rate not between", value1, value2, "applyCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateIsNull() {
            addCriterion("approval_completion_rate is null");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateIsNotNull() {
            addCriterion("approval_completion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateEqualTo(Double value) {
            addCriterion("approval_completion_rate =", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateNotEqualTo(Double value) {
            addCriterion("approval_completion_rate <>", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateGreaterThan(Double value) {
            addCriterion("approval_completion_rate >", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateGreaterThanOrEqualTo(Double value) {
            addCriterion("approval_completion_rate >=", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateLessThan(Double value) {
            addCriterion("approval_completion_rate <", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateLessThanOrEqualTo(Double value) {
            addCriterion("approval_completion_rate <=", value, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateIn(List<Double> values) {
            addCriterion("approval_completion_rate in", values, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateNotIn(List<Double> values) {
            addCriterion("approval_completion_rate not in", values, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateBetween(Double value1, Double value2) {
            addCriterion("approval_completion_rate between", value1, value2, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andApprovalCompletionRateNotBetween(Double value1, Double value2) {
            addCriterion("approval_completion_rate not between", value1, value2, "approvalCompletionRate");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andWarrantyDateIsNull() {
            addCriterion("warranty_date is null");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateIsNotNull() {
            addCriterion("warranty_date is not null");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateEqualTo(BigDecimal value) {
            addCriterion("warranty_date =", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotEqualTo(BigDecimal value) {
            addCriterion("warranty_date <>", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateGreaterThan(BigDecimal value) {
            addCriterion("warranty_date >", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("warranty_date >=", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateLessThan(BigDecimal value) {
            addCriterion("warranty_date <", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("warranty_date <=", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateIn(List<BigDecimal> values) {
            addCriterion("warranty_date in", values, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotIn(List<BigDecimal> values) {
            addCriterion("warranty_date not in", values, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("warranty_date between", value1, value2, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("warranty_date not between", value1, value2, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
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