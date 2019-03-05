package com.purchase.pojo.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizInstructOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizInstructOrderExample() {
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

        public Criteria andPmIdIsNull() {
            addCriterion("pm_id is null");
            return (Criteria) this;
        }

        public Criteria andPmIdIsNotNull() {
            addCriterion("pm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPmIdEqualTo(String value) {
            addCriterion("pm_id =", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotEqualTo(String value) {
            addCriterion("pm_id <>", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdGreaterThan(String value) {
            addCriterion("pm_id >", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdGreaterThanOrEqualTo(String value) {
            addCriterion("pm_id >=", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdLessThan(String value) {
            addCriterion("pm_id <", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdLessThanOrEqualTo(String value) {
            addCriterion("pm_id <=", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdLike(String value) {
            addCriterion("pm_id like", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotLike(String value) {
            addCriterion("pm_id not like", value, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdIn(List<String> values) {
            addCriterion("pm_id in", values, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotIn(List<String> values) {
            addCriterion("pm_id not in", values, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdBetween(String value1, String value2) {
            addCriterion("pm_id between", value1, value2, "pmId");
            return (Criteria) this;
        }

        public Criteria andPmIdNotBetween(String value1, String value2) {
            addCriterion("pm_id not between", value1, value2, "pmId");
            return (Criteria) this;
        }

        public Criteria andInstructNoIsNull() {
            addCriterion("instruct_no is null");
            return (Criteria) this;
        }

        public Criteria andInstructNoIsNotNull() {
            addCriterion("instruct_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstructNoEqualTo(String value) {
            addCriterion("instruct_no =", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoNotEqualTo(String value) {
            addCriterion("instruct_no <>", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoGreaterThan(String value) {
            addCriterion("instruct_no >", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoGreaterThanOrEqualTo(String value) {
            addCriterion("instruct_no >=", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoLessThan(String value) {
            addCriterion("instruct_no <", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoLessThanOrEqualTo(String value) {
            addCriterion("instruct_no <=", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoLike(String value) {
            addCriterion("instruct_no like", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoNotLike(String value) {
            addCriterion("instruct_no not like", value, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoIn(List<String> values) {
            addCriterion("instruct_no in", values, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoNotIn(List<String> values) {
            addCriterion("instruct_no not in", values, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoBetween(String value1, String value2) {
            addCriterion("instruct_no between", value1, value2, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructNoNotBetween(String value1, String value2) {
            addCriterion("instruct_no not between", value1, value2, "instructNo");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIsNull() {
            addCriterion("instruct_type is null");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIsNotNull() {
            addCriterion("instruct_type is not null");
            return (Criteria) this;
        }

        public Criteria andInstructTypeEqualTo(Integer value) {
            addCriterion("instruct_type =", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotEqualTo(Integer value) {
            addCriterion("instruct_type <>", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeGreaterThan(Integer value) {
            addCriterion("instruct_type >", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("instruct_type >=", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLessThan(Integer value) {
            addCriterion("instruct_type <", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeLessThanOrEqualTo(Integer value) {
            addCriterion("instruct_type <=", value, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeIn(List<Integer> values) {
            addCriterion("instruct_type in", values, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotIn(List<Integer> values) {
            addCriterion("instruct_type not in", values, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeBetween(Integer value1, Integer value2) {
            addCriterion("instruct_type between", value1, value2, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("instruct_type not between", value1, value2, "instructType");
            return (Criteria) this;
        }

        public Criteria andInstructCentextIsNull() {
            addCriterion("instruct_centext is null");
            return (Criteria) this;
        }

        public Criteria andInstructCentextIsNotNull() {
            addCriterion("instruct_centext is not null");
            return (Criteria) this;
        }

        public Criteria andInstructCentextEqualTo(String value) {
            addCriterion("instruct_centext =", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextNotEqualTo(String value) {
            addCriterion("instruct_centext <>", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextGreaterThan(String value) {
            addCriterion("instruct_centext >", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextGreaterThanOrEqualTo(String value) {
            addCriterion("instruct_centext >=", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextLessThan(String value) {
            addCriterion("instruct_centext <", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextLessThanOrEqualTo(String value) {
            addCriterion("instruct_centext <=", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextLike(String value) {
            addCriterion("instruct_centext like", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextNotLike(String value) {
            addCriterion("instruct_centext not like", value, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextIn(List<String> values) {
            addCriterion("instruct_centext in", values, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextNotIn(List<String> values) {
            addCriterion("instruct_centext not in", values, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextBetween(String value1, String value2) {
            addCriterion("instruct_centext between", value1, value2, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andInstructCentextNotBetween(String value1, String value2) {
            addCriterion("instruct_centext not between", value1, value2, "instructCentext");
            return (Criteria) this;
        }

        public Criteria andCommandDateIsNull() {
            addCriterion("command_date is null");
            return (Criteria) this;
        }

        public Criteria andCommandDateIsNotNull() {
            addCriterion("command_date is not null");
            return (Criteria) this;
        }

        public Criteria andCommandDateEqualTo(Date value) {
            addCriterion("command_date =", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateNotEqualTo(Date value) {
            addCriterion("command_date <>", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateGreaterThan(Date value) {
            addCriterion("command_date >", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateGreaterThanOrEqualTo(Date value) {
            addCriterion("command_date >=", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateLessThan(Date value) {
            addCriterion("command_date <", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateLessThanOrEqualTo(Date value) {
            addCriterion("command_date <=", value, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateIn(List<Date> values) {
            addCriterion("command_date in", values, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateNotIn(List<Date> values) {
            addCriterion("command_date not in", values, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateBetween(Date value1, Date value2) {
            addCriterion("command_date between", value1, value2, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandDateNotBetween(Date value1, Date value2) {
            addCriterion("command_date not between", value1, value2, "commandDate");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameIsNull() {
            addCriterion("command_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameIsNotNull() {
            addCriterion("command_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameEqualTo(String value) {
            addCriterion("command_user_name =", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameNotEqualTo(String value) {
            addCriterion("command_user_name <>", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameGreaterThan(String value) {
            addCriterion("command_user_name >", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("command_user_name >=", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameLessThan(String value) {
            addCriterion("command_user_name <", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameLessThanOrEqualTo(String value) {
            addCriterion("command_user_name <=", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameLike(String value) {
            addCriterion("command_user_name like", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameNotLike(String value) {
            addCriterion("command_user_name not like", value, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameIn(List<String> values) {
            addCriterion("command_user_name in", values, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameNotIn(List<String> values) {
            addCriterion("command_user_name not in", values, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameBetween(String value1, String value2) {
            addCriterion("command_user_name between", value1, value2, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCommandUserNameNotBetween(String value1, String value2) {
            addCriterion("command_user_name not between", value1, value2, "commandUserName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andEditDateIsNull() {
            addCriterion("edit_date is null");
            return (Criteria) this;
        }

        public Criteria andEditDateIsNotNull() {
            addCriterion("edit_date is not null");
            return (Criteria) this;
        }

        public Criteria andEditDateEqualTo(Date value) {
            addCriterion("edit_date =", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotEqualTo(Date value) {
            addCriterion("edit_date <>", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateGreaterThan(Date value) {
            addCriterion("edit_date >", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_date >=", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateLessThan(Date value) {
            addCriterion("edit_date <", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateLessThanOrEqualTo(Date value) {
            addCriterion("edit_date <=", value, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateIn(List<Date> values) {
            addCriterion("edit_date in", values, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotIn(List<Date> values) {
            addCriterion("edit_date not in", values, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateBetween(Date value1, Date value2) {
            addCriterion("edit_date between", value1, value2, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditDateNotBetween(Date value1, Date value2) {
            addCriterion("edit_date not between", value1, value2, "editDate");
            return (Criteria) this;
        }

        public Criteria andEditUserIsNull() {
            addCriterion("edit_user is null");
            return (Criteria) this;
        }

        public Criteria andEditUserIsNotNull() {
            addCriterion("edit_user is not null");
            return (Criteria) this;
        }

        public Criteria andEditUserEqualTo(Long value) {
            addCriterion("edit_user =", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserNotEqualTo(Long value) {
            addCriterion("edit_user <>", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserGreaterThan(Long value) {
            addCriterion("edit_user >", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserGreaterThanOrEqualTo(Long value) {
            addCriterion("edit_user >=", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserLessThan(Long value) {
            addCriterion("edit_user <", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserLessThanOrEqualTo(Long value) {
            addCriterion("edit_user <=", value, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserIn(List<Long> values) {
            addCriterion("edit_user in", values, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserNotIn(List<Long> values) {
            addCriterion("edit_user not in", values, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserBetween(Long value1, Long value2) {
            addCriterion("edit_user between", value1, value2, "editUser");
            return (Criteria) this;
        }

        public Criteria andEditUserNotBetween(Long value1, Long value2) {
            addCriterion("edit_user not between", value1, value2, "editUser");
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