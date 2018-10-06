package com.purchase.pojo.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizProgrammeAcceptanceOrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizProgrammeAcceptanceOrderDetailExample() {
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

        public Criteria andRectifyContentIsNull() {
            addCriterion("rectify_content is null");
            return (Criteria) this;
        }

        public Criteria andRectifyContentIsNotNull() {
            addCriterion("rectify_content is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyContentEqualTo(String value) {
            addCriterion("rectify_content =", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentNotEqualTo(String value) {
            addCriterion("rectify_content <>", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentGreaterThan(String value) {
            addCriterion("rectify_content >", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_content >=", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentLessThan(String value) {
            addCriterion("rectify_content <", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentLessThanOrEqualTo(String value) {
            addCriterion("rectify_content <=", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentLike(String value) {
            addCriterion("rectify_content like", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentNotLike(String value) {
            addCriterion("rectify_content not like", value, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentIn(List<String> values) {
            addCriterion("rectify_content in", values, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentNotIn(List<String> values) {
            addCriterion("rectify_content not in", values, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentBetween(String value1, String value2) {
            addCriterion("rectify_content between", value1, value2, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyContentNotBetween(String value1, String value2) {
            addCriterion("rectify_content not between", value1, value2, "rectifyContent");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureIsNull() {
            addCriterion("rectify_measure is null");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureIsNotNull() {
            addCriterion("rectify_measure is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureEqualTo(String value) {
            addCriterion("rectify_measure =", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureNotEqualTo(String value) {
            addCriterion("rectify_measure <>", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureGreaterThan(String value) {
            addCriterion("rectify_measure >", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureGreaterThanOrEqualTo(String value) {
            addCriterion("rectify_measure >=", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureLessThan(String value) {
            addCriterion("rectify_measure <", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureLessThanOrEqualTo(String value) {
            addCriterion("rectify_measure <=", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureLike(String value) {
            addCriterion("rectify_measure like", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureNotLike(String value) {
            addCriterion("rectify_measure not like", value, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureIn(List<String> values) {
            addCriterion("rectify_measure in", values, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureNotIn(List<String> values) {
            addCriterion("rectify_measure not in", values, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureBetween(String value1, String value2) {
            addCriterion("rectify_measure between", value1, value2, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andRectifyMeasureNotBetween(String value1, String value2) {
            addCriterion("rectify_measure not between", value1, value2, "rectifyMeasure");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateIsNull() {
            addCriterion("play_over_date is null");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateIsNotNull() {
            addCriterion("play_over_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateEqualTo(Date value) {
            addCriterion("play_over_date =", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateNotEqualTo(Date value) {
            addCriterion("play_over_date <>", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateGreaterThan(Date value) {
            addCriterion("play_over_date >", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("play_over_date >=", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateLessThan(Date value) {
            addCriterion("play_over_date <", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateLessThanOrEqualTo(Date value) {
            addCriterion("play_over_date <=", value, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateIn(List<Date> values) {
            addCriterion("play_over_date in", values, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateNotIn(List<Date> values) {
            addCriterion("play_over_date not in", values, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateBetween(Date value1, Date value2) {
            addCriterion("play_over_date between", value1, value2, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andPlayOverDateNotBetween(Date value1, Date value2) {
            addCriterion("play_over_date not between", value1, value2, "playOverDate");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagIsNull() {
            addCriterion("rectify_flag is null");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagIsNotNull() {
            addCriterion("rectify_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagEqualTo(Integer value) {
            addCriterion("rectify_flag =", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagNotEqualTo(Integer value) {
            addCriterion("rectify_flag <>", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagGreaterThan(Integer value) {
            addCriterion("rectify_flag >", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("rectify_flag >=", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagLessThan(Integer value) {
            addCriterion("rectify_flag <", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagLessThanOrEqualTo(Integer value) {
            addCriterion("rectify_flag <=", value, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagIn(List<Integer> values) {
            addCriterion("rectify_flag in", values, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagNotIn(List<Integer> values) {
            addCriterion("rectify_flag not in", values, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagBetween(Integer value1, Integer value2) {
            addCriterion("rectify_flag between", value1, value2, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andRectifyFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("rectify_flag not between", value1, value2, "rectifyFlag");
            return (Criteria) this;
        }

        public Criteria andActualOverDateIsNull() {
            addCriterion("actual_over_date is null");
            return (Criteria) this;
        }

        public Criteria andActualOverDateIsNotNull() {
            addCriterion("actual_over_date is not null");
            return (Criteria) this;
        }

        public Criteria andActualOverDateEqualTo(Date value) {
            addCriterion("actual_over_date =", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateNotEqualTo(Date value) {
            addCriterion("actual_over_date <>", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateGreaterThan(Date value) {
            addCriterion("actual_over_date >", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateGreaterThanOrEqualTo(Date value) {
            addCriterion("actual_over_date >=", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateLessThan(Date value) {
            addCriterion("actual_over_date <", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateLessThanOrEqualTo(Date value) {
            addCriterion("actual_over_date <=", value, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateIn(List<Date> values) {
            addCriterion("actual_over_date in", values, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateNotIn(List<Date> values) {
            addCriterion("actual_over_date not in", values, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateBetween(Date value1, Date value2) {
            addCriterion("actual_over_date between", value1, value2, "actualOverDate");
            return (Criteria) this;
        }

        public Criteria andActualOverDateNotBetween(Date value1, Date value2) {
            addCriterion("actual_over_date not between", value1, value2, "actualOverDate");
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