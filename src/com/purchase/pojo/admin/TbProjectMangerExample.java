package com.purchase.pojo.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbProjectMangerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbProjectMangerExample() {
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

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNull() {
            addCriterion("contract_price is null");
            return (Criteria) this;
        }

        public Criteria andContractPriceIsNotNull() {
            addCriterion("contract_price is not null");
            return (Criteria) this;
        }

        public Criteria andContractPriceEqualTo(BigDecimal value) {
            addCriterion("contract_price =", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotEqualTo(BigDecimal value) {
            addCriterion("contract_price <>", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThan(BigDecimal value) {
            addCriterion("contract_price >", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_price >=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThan(BigDecimal value) {
            addCriterion("contract_price <", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("contract_price <=", value, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceIn(List<BigDecimal> values) {
            addCriterion("contract_price in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotIn(List<BigDecimal> values) {
            addCriterion("contract_price not in", values, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_price between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andContractPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("contract_price not between", value1, value2, "contractPrice");
            return (Criteria) this;
        }

        public Criteria andSettleTypeIsNull() {
            addCriterion("settle_type is null");
            return (Criteria) this;
        }

        public Criteria andSettleTypeIsNotNull() {
            addCriterion("settle_type is not null");
            return (Criteria) this;
        }

        public Criteria andSettleTypeEqualTo(Integer value) {
            addCriterion("settle_type =", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeNotEqualTo(Integer value) {
            addCriterion("settle_type <>", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeGreaterThan(Integer value) {
            addCriterion("settle_type >", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("settle_type >=", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeLessThan(Integer value) {
            addCriterion("settle_type <", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("settle_type <=", value, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeIn(List<Integer> values) {
            addCriterion("settle_type in", values, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeNotIn(List<Integer> values) {
            addCriterion("settle_type not in", values, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeBetween(Integer value1, Integer value2) {
            addCriterion("settle_type between", value1, value2, "settleType");
            return (Criteria) this;
        }

        public Criteria andSettleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("settle_type not between", value1, value2, "settleType");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andNatureIsNull() {
            addCriterion("nature is null");
            return (Criteria) this;
        }

        public Criteria andNatureIsNotNull() {
            addCriterion("nature is not null");
            return (Criteria) this;
        }

        public Criteria andNatureEqualTo(Integer value) {
            addCriterion("nature =", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotEqualTo(Integer value) {
            addCriterion("nature <>", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThan(Integer value) {
            addCriterion("nature >", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("nature >=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThan(Integer value) {
            addCriterion("nature <", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureLessThanOrEqualTo(Integer value) {
            addCriterion("nature <=", value, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureIn(List<Integer> values) {
            addCriterion("nature in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotIn(List<Integer> values) {
            addCriterion("nature not in", values, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureBetween(Integer value1, Integer value2) {
            addCriterion("nature between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("nature not between", value1, value2, "nature");
            return (Criteria) this;
        }

        public Criteria andProgressPlanIsNull() {
            addCriterion("progress_plan is null");
            return (Criteria) this;
        }

        public Criteria andProgressPlanIsNotNull() {
            addCriterion("progress_plan is not null");
            return (Criteria) this;
        }

        public Criteria andProgressPlanEqualTo(Integer value) {
            addCriterion("progress_plan =", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanNotEqualTo(Integer value) {
            addCriterion("progress_plan <>", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanGreaterThan(Integer value) {
            addCriterion("progress_plan >", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanGreaterThanOrEqualTo(Integer value) {
            addCriterion("progress_plan >=", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanLessThan(Integer value) {
            addCriterion("progress_plan <", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanLessThanOrEqualTo(Integer value) {
            addCriterion("progress_plan <=", value, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanIn(List<Integer> values) {
            addCriterion("progress_plan in", values, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanNotIn(List<Integer> values) {
            addCriterion("progress_plan not in", values, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanBetween(Integer value1, Integer value2) {
            addCriterion("progress_plan between", value1, value2, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProgressPlanNotBetween(Integer value1, Integer value2) {
            addCriterion("progress_plan not between", value1, value2, "progressPlan");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNull() {
            addCriterion("project_manager is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNotNull() {
            addCriterion("project_manager is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerEqualTo(Long value) {
            addCriterion("project_manager =", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotEqualTo(Long value) {
            addCriterion("project_manager <>", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThan(Long value) {
            addCriterion("project_manager >", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThanOrEqualTo(Long value) {
            addCriterion("project_manager >=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThan(Long value) {
            addCriterion("project_manager <", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThanOrEqualTo(Long value) {
            addCriterion("project_manager <=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIn(List<Long> values) {
            addCriterion("project_manager in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotIn(List<Long> values) {
            addCriterion("project_manager not in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerBetween(Long value1, Long value2) {
            addCriterion("project_manager between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotBetween(Long value1, Long value2) {
            addCriterion("project_manager not between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderIsNull() {
            addCriterion("budget_leader is null");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderIsNotNull() {
            addCriterion("budget_leader is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderEqualTo(Long value) {
            addCriterion("budget_leader =", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderNotEqualTo(Long value) {
            addCriterion("budget_leader <>", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderGreaterThan(Long value) {
            addCriterion("budget_leader >", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderGreaterThanOrEqualTo(Long value) {
            addCriterion("budget_leader >=", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderLessThan(Long value) {
            addCriterion("budget_leader <", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderLessThanOrEqualTo(Long value) {
            addCriterion("budget_leader <=", value, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderIn(List<Long> values) {
            addCriterion("budget_leader in", values, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderNotIn(List<Long> values) {
            addCriterion("budget_leader not in", values, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderBetween(Long value1, Long value2) {
            addCriterion("budget_leader between", value1, value2, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andBudgetLeaderNotBetween(Long value1, Long value2) {
            addCriterion("budget_leader not between", value1, value2, "budgetLeader");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNull() {
            addCriterion("developer is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNotNull() {
            addCriterion("developer is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperEqualTo(String value) {
            addCriterion("developer =", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotEqualTo(String value) {
            addCriterion("developer <>", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThan(String value) {
            addCriterion("developer >", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThanOrEqualTo(String value) {
            addCriterion("developer >=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThan(String value) {
            addCriterion("developer <", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThanOrEqualTo(String value) {
            addCriterion("developer <=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLike(String value) {
            addCriterion("developer like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotLike(String value) {
            addCriterion("developer not like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperIn(List<String> values) {
            addCriterion("developer in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotIn(List<String> values) {
            addCriterion("developer not in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperBetween(String value1, String value2) {
            addCriterion("developer between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotBetween(String value1, String value2) {
            addCriterion("developer not between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameIsNull() {
            addCriterion("developer_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameIsNotNull() {
            addCriterion("developer_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameEqualTo(String value) {
            addCriterion("developer_leader_name =", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameNotEqualTo(String value) {
            addCriterion("developer_leader_name <>", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameGreaterThan(String value) {
            addCriterion("developer_leader_name >", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("developer_leader_name >=", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameLessThan(String value) {
            addCriterion("developer_leader_name <", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("developer_leader_name <=", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameLike(String value) {
            addCriterion("developer_leader_name like", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameNotLike(String value) {
            addCriterion("developer_leader_name not like", value, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameIn(List<String> values) {
            addCriterion("developer_leader_name in", values, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameNotIn(List<String> values) {
            addCriterion("developer_leader_name not in", values, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameBetween(String value1, String value2) {
            addCriterion("developer_leader_name between", value1, value2, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderNameNotBetween(String value1, String value2) {
            addCriterion("developer_leader_name not between", value1, value2, "developerLeaderName");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneIsNull() {
            addCriterion("developer_leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneIsNotNull() {
            addCriterion("developer_leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneEqualTo(String value) {
            addCriterion("developer_leader_phone =", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneNotEqualTo(String value) {
            addCriterion("developer_leader_phone <>", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneGreaterThan(String value) {
            addCriterion("developer_leader_phone >", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("developer_leader_phone >=", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneLessThan(String value) {
            addCriterion("developer_leader_phone <", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("developer_leader_phone <=", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneLike(String value) {
            addCriterion("developer_leader_phone like", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneNotLike(String value) {
            addCriterion("developer_leader_phone not like", value, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneIn(List<String> values) {
            addCriterion("developer_leader_phone in", values, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneNotIn(List<String> values) {
            addCriterion("developer_leader_phone not in", values, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneBetween(String value1, String value2) {
            addCriterion("developer_leader_phone between", value1, value2, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andDeveloperLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("developer_leader_phone not between", value1, value2, "developerLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorIsNull() {
            addCriterion("consignor is null");
            return (Criteria) this;
        }

        public Criteria andConsignorIsNotNull() {
            addCriterion("consignor is not null");
            return (Criteria) this;
        }

        public Criteria andConsignorEqualTo(String value) {
            addCriterion("consignor =", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorNotEqualTo(String value) {
            addCriterion("consignor <>", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorGreaterThan(String value) {
            addCriterion("consignor >", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorGreaterThanOrEqualTo(String value) {
            addCriterion("consignor >=", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorLessThan(String value) {
            addCriterion("consignor <", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorLessThanOrEqualTo(String value) {
            addCriterion("consignor <=", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorLike(String value) {
            addCriterion("consignor like", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorNotLike(String value) {
            addCriterion("consignor not like", value, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorIn(List<String> values) {
            addCriterion("consignor in", values, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorNotIn(List<String> values) {
            addCriterion("consignor not in", values, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorBetween(String value1, String value2) {
            addCriterion("consignor between", value1, value2, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorNotBetween(String value1, String value2) {
            addCriterion("consignor not between", value1, value2, "consignor");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameIsNull() {
            addCriterion("consignor_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameIsNotNull() {
            addCriterion("consignor_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameEqualTo(String value) {
            addCriterion("consignor_leader_name =", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameNotEqualTo(String value) {
            addCriterion("consignor_leader_name <>", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameGreaterThan(String value) {
            addCriterion("consignor_leader_name >", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("consignor_leader_name >=", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameLessThan(String value) {
            addCriterion("consignor_leader_name <", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("consignor_leader_name <=", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameLike(String value) {
            addCriterion("consignor_leader_name like", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameNotLike(String value) {
            addCriterion("consignor_leader_name not like", value, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameIn(List<String> values) {
            addCriterion("consignor_leader_name in", values, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameNotIn(List<String> values) {
            addCriterion("consignor_leader_name not in", values, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameBetween(String value1, String value2) {
            addCriterion("consignor_leader_name between", value1, value2, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderNameNotBetween(String value1, String value2) {
            addCriterion("consignor_leader_name not between", value1, value2, "consignorLeaderName");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneIsNull() {
            addCriterion("consignor_leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneIsNotNull() {
            addCriterion("consignor_leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneEqualTo(String value) {
            addCriterion("consignor_leader_phone =", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneNotEqualTo(String value) {
            addCriterion("consignor_leader_phone <>", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneGreaterThan(String value) {
            addCriterion("consignor_leader_phone >", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("consignor_leader_phone >=", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneLessThan(String value) {
            addCriterion("consignor_leader_phone <", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("consignor_leader_phone <=", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneLike(String value) {
            addCriterion("consignor_leader_phone like", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneNotLike(String value) {
            addCriterion("consignor_leader_phone not like", value, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneIn(List<String> values) {
            addCriterion("consignor_leader_phone in", values, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneNotIn(List<String> values) {
            addCriterion("consignor_leader_phone not in", values, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneBetween(String value1, String value2) {
            addCriterion("consignor_leader_phone between", value1, value2, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andConsignorLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("consignor_leader_phone not between", value1, value2, "consignorLeaderPhone");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNull() {
            addCriterion("contract_sign_date is null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIsNotNull() {
            addCriterion("contract_sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractSignDateEqualTo(Date value) {
            addCriterion("contract_sign_date =", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotEqualTo(Date value) {
            addCriterion("contract_sign_date <>", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThan(Date value) {
            addCriterion("contract_sign_date >", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_sign_date >=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThan(Date value) {
            addCriterion("contract_sign_date <", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateLessThanOrEqualTo(Date value) {
            addCriterion("contract_sign_date <=", value, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateIn(List<Date> values) {
            addCriterion("contract_sign_date in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotIn(List<Date> values) {
            addCriterion("contract_sign_date not in", values, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateBetween(Date value1, Date value2) {
            addCriterion("contract_sign_date between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andContractSignDateNotBetween(Date value1, Date value2) {
            addCriterion("contract_sign_date not between", value1, value2, "contractSignDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andOverDateIsNull() {
            addCriterion("over_date is null");
            return (Criteria) this;
        }

        public Criteria andOverDateIsNotNull() {
            addCriterion("over_date is not null");
            return (Criteria) this;
        }

        public Criteria andOverDateEqualTo(Date value) {
            addCriterion("over_date =", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateNotEqualTo(Date value) {
            addCriterion("over_date <>", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateGreaterThan(Date value) {
            addCriterion("over_date >", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("over_date >=", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateLessThan(Date value) {
            addCriterion("over_date <", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateLessThanOrEqualTo(Date value) {
            addCriterion("over_date <=", value, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateIn(List<Date> values) {
            addCriterion("over_date in", values, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateNotIn(List<Date> values) {
            addCriterion("over_date not in", values, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateBetween(Date value1, Date value2) {
            addCriterion("over_date between", value1, value2, "overDate");
            return (Criteria) this;
        }

        public Criteria andOverDateNotBetween(Date value1, Date value2) {
            addCriterion("over_date not between", value1, value2, "overDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIsNull() {
            addCriterion("acceptance_date is null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIsNotNull() {
            addCriterion("acceptance_date is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateEqualTo(Date value) {
            addCriterion("acceptance_date =", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotEqualTo(Date value) {
            addCriterion("acceptance_date <>", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateGreaterThan(Date value) {
            addCriterion("acceptance_date >", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateGreaterThanOrEqualTo(Date value) {
            addCriterion("acceptance_date >=", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateLessThan(Date value) {
            addCriterion("acceptance_date <", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateLessThanOrEqualTo(Date value) {
            addCriterion("acceptance_date <=", value, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateIn(List<Date> values) {
            addCriterion("acceptance_date in", values, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotIn(List<Date> values) {
            addCriterion("acceptance_date not in", values, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateBetween(Date value1, Date value2) {
            addCriterion("acceptance_date between", value1, value2, "acceptanceDate");
            return (Criteria) this;
        }

        public Criteria andAcceptanceDateNotBetween(Date value1, Date value2) {
            addCriterion("acceptance_date not between", value1, value2, "acceptanceDate");
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