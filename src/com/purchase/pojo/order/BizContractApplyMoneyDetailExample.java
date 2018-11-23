package com.purchase.pojo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BizContractApplyMoneyDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizContractApplyMoneyDetailExample() {
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

        public Criteria andPurchaseDetailIdIsNull() {
            addCriterion("purchase_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdIsNotNull() {
            addCriterion("purchase_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdEqualTo(String value) {
            addCriterion("purchase_detail_id =", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdNotEqualTo(String value) {
            addCriterion("purchase_detail_id <>", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdGreaterThan(String value) {
            addCriterion("purchase_detail_id >", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_detail_id >=", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdLessThan(String value) {
            addCriterion("purchase_detail_id <", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdLessThanOrEqualTo(String value) {
            addCriterion("purchase_detail_id <=", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdLike(String value) {
            addCriterion("purchase_detail_id like", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdNotLike(String value) {
            addCriterion("purchase_detail_id not like", value, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdIn(List<String> values) {
            addCriterion("purchase_detail_id in", values, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdNotIn(List<String> values) {
            addCriterion("purchase_detail_id not in", values, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdBetween(String value1, String value2) {
            addCriterion("purchase_detail_id between", value1, value2, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andPurchaseDetailIdNotBetween(String value1, String value2) {
            addCriterion("purchase_detail_id not between", value1, value2, "purchaseDetailId");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteIsNull() {
            addCriterion("construction_site is null");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteIsNotNull() {
            addCriterion("construction_site is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteEqualTo(String value) {
            addCriterion("construction_site =", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteNotEqualTo(String value) {
            addCriterion("construction_site <>", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteGreaterThan(String value) {
            addCriterion("construction_site >", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteGreaterThanOrEqualTo(String value) {
            addCriterion("construction_site >=", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteLessThan(String value) {
            addCriterion("construction_site <", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteLessThanOrEqualTo(String value) {
            addCriterion("construction_site <=", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteLike(String value) {
            addCriterion("construction_site like", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteNotLike(String value) {
            addCriterion("construction_site not like", value, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteIn(List<String> values) {
            addCriterion("construction_site in", values, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteNotIn(List<String> values) {
            addCriterion("construction_site not in", values, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteBetween(String value1, String value2) {
            addCriterion("construction_site between", value1, value2, "constructionSite");
            return (Criteria) this;
        }

        public Criteria andConstructionSiteNotBetween(String value1, String value2) {
            addCriterion("construction_site not between", value1, value2, "constructionSite");
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

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
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

        public Criteria andContractCountIsNull() {
            addCriterion("contract_count is null");
            return (Criteria) this;
        }

        public Criteria andContractCountIsNotNull() {
            addCriterion("contract_count is not null");
            return (Criteria) this;
        }

        public Criteria andContractCountEqualTo(Double value) {
            addCriterion("contract_count =", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountNotEqualTo(Double value) {
            addCriterion("contract_count <>", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountGreaterThan(Double value) {
            addCriterion("contract_count >", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_count >=", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountLessThan(Double value) {
            addCriterion("contract_count <", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountLessThanOrEqualTo(Double value) {
            addCriterion("contract_count <=", value, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountIn(List<Double> values) {
            addCriterion("contract_count in", values, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountNotIn(List<Double> values) {
            addCriterion("contract_count not in", values, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountBetween(Double value1, Double value2) {
            addCriterion("contract_count between", value1, value2, "contractCount");
            return (Criteria) this;
        }

        public Criteria andContractCountNotBetween(Double value1, Double value2) {
            addCriterion("contract_count not between", value1, value2, "contractCount");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutIsNull() {
            addCriterion("settle_amout is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutIsNotNull() {
            addCriterion("settle_amout is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutEqualTo(Double value) {
            addCriterion("settle_amout =", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutNotEqualTo(Double value) {
            addCriterion("settle_amout <>", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutGreaterThan(Double value) {
            addCriterion("settle_amout >", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutGreaterThanOrEqualTo(Double value) {
            addCriterion("settle_amout >=", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutLessThan(Double value) {
            addCriterion("settle_amout <", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutLessThanOrEqualTo(Double value) {
            addCriterion("settle_amout <=", value, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutIn(List<Double> values) {
            addCriterion("settle_amout in", values, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutNotIn(List<Double> values) {
            addCriterion("settle_amout not in", values, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutBetween(Double value1, Double value2) {
            addCriterion("settle_amout between", value1, value2, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettleAmoutNotBetween(Double value1, Double value2) {
            addCriterion("settle_amout not between", value1, value2, "settleAmout");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNull() {
            addCriterion("settle_price is null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIsNotNull() {
            addCriterion("settle_price is not null");
            return (Criteria) this;
        }

        public Criteria andSettlePriceEqualTo(BigDecimal value) {
            addCriterion("settle_price =", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotEqualTo(BigDecimal value) {
            addCriterion("settle_price <>", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThan(BigDecimal value) {
            addCriterion("settle_price >", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_price >=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThan(BigDecimal value) {
            addCriterion("settle_price <", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_price <=", value, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceIn(List<BigDecimal> values) {
            addCriterion("settle_price in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotIn(List<BigDecimal> values) {
            addCriterion("settle_price not in", values, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_price between", value1, value2, "settlePrice");
            return (Criteria) this;
        }

        public Criteria andSettlePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_price not between", value1, value2, "settlePrice");
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

        public Criteria andWarrantyDateEqualTo(Float value) {
            addCriterion("warranty_date =", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotEqualTo(Float value) {
            addCriterion("warranty_date <>", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateGreaterThan(Float value) {
            addCriterion("warranty_date >", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateGreaterThanOrEqualTo(Float value) {
            addCriterion("warranty_date >=", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateLessThan(Float value) {
            addCriterion("warranty_date <", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateLessThanOrEqualTo(Float value) {
            addCriterion("warranty_date <=", value, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateIn(List<Float> values) {
            addCriterion("warranty_date in", values, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotIn(List<Float> values) {
            addCriterion("warranty_date not in", values, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateBetween(Float value1, Float value2) {
            addCriterion("warranty_date between", value1, value2, "warrantyDate");
            return (Criteria) this;
        }

        public Criteria andWarrantyDateNotBetween(Float value1, Float value2) {
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