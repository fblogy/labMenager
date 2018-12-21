package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysMeetingroomExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public SysMeetingroomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomDateIsNull() {
            addCriterion("room_date is null");
            return (Criteria) this;
        }

        public Criteria andRoomDateIsNotNull() {
            addCriterion("room_date is not null");
            return (Criteria) this;
        }

        public Criteria andRoomDateEqualTo(Date value) {
            addCriterionForJDBCDate("room_date =", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("room_date <>", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateGreaterThan(Date value) {
            addCriterionForJDBCDate("room_date >", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("room_date >=", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateLessThan(Date value) {
            addCriterionForJDBCDate("room_date <", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("room_date <=", value, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateIn(List<Date> values) {
            addCriterionForJDBCDate("room_date in", values, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("room_date not in", values, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("room_date between", value1, value2, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("room_date not between", value1, value2, "roomDate");
            return (Criteria) this;
        }

        public Criteria andRoomSegIsNull() {
            addCriterion("room_seg is null");
            return (Criteria) this;
        }

        public Criteria andRoomSegIsNotNull() {
            addCriterion("room_seg is not null");
            return (Criteria) this;
        }

        public Criteria andRoomSegEqualTo(Integer value) {
            addCriterion("room_seg =", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegNotEqualTo(Integer value) {
            addCriterion("room_seg <>", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegGreaterThan(Integer value) {
            addCriterion("room_seg >", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_seg >=", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegLessThan(Integer value) {
            addCriterion("room_seg <", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegLessThanOrEqualTo(Integer value) {
            addCriterion("room_seg <=", value, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegIn(List<Integer> values) {
            addCriterion("room_seg in", values, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegNotIn(List<Integer> values) {
            addCriterion("room_seg not in", values, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegBetween(Integer value1, Integer value2) {
            addCriterion("room_seg between", value1, value2, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomSegNotBetween(Integer value1, Integer value2) {
            addCriterion("room_seg not between", value1, value2, "roomSeg");
            return (Criteria) this;
        }

        public Criteria andRoomAccountIsNull() {
            addCriterion("room_account is null");
            return (Criteria) this;
        }

        public Criteria andRoomAccountIsNotNull() {
            addCriterion("room_account is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAccountEqualTo(String value) {
            addCriterion("room_account =", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountNotEqualTo(String value) {
            addCriterion("room_account <>", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountGreaterThan(String value) {
            addCriterion("room_account >", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountGreaterThanOrEqualTo(String value) {
            addCriterion("room_account >=", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountLessThan(String value) {
            addCriterion("room_account <", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountLessThanOrEqualTo(String value) {
            addCriterion("room_account <=", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountLike(String value) {
            addCriterion("room_account like", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountNotLike(String value) {
            addCriterion("room_account not like", value, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountIn(List<String> values) {
            addCriterion("room_account in", values, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountNotIn(List<String> values) {
            addCriterion("room_account not in", values, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountBetween(String value1, String value2) {
            addCriterion("room_account between", value1, value2, "roomAccount");
            return (Criteria) this;
        }

        public Criteria andRoomAccountNotBetween(String value1, String value2) {
            addCriterion("room_account not between", value1, value2, "roomAccount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_meetingroom
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_meetingroom
     *
     * @mbggenerated
     */
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