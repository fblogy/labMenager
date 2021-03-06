package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysAnnouncementExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public SysAnnouncementExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
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
     * This method corresponds to the database table sys_announcement
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
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
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
     * This class corresponds to the database table sys_announcement
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

        public Criteria andAnDateIsNull() {
            addCriterion("an_date is null");
            return (Criteria) this;
        }

        public Criteria andAnDateIsNotNull() {
            addCriterion("an_date is not null");
            return (Criteria) this;
        }

        public Criteria andAnDateEqualTo(Date value) {
            addCriterionForJDBCDate("an_date =", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("an_date <>", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("an_date >", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("an_date >=", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateLessThan(Date value) {
            addCriterionForJDBCDate("an_date <", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("an_date <=", value, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateIn(List<Date> values) {
            addCriterionForJDBCDate("an_date in", values, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("an_date not in", values, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("an_date between", value1, value2, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("an_date not between", value1, value2, "anDate");
            return (Criteria) this;
        }

        public Criteria andAnAccountIsNull() {
            addCriterion("an_account is null");
            return (Criteria) this;
        }

        public Criteria andAnAccountIsNotNull() {
            addCriterion("an_account is not null");
            return (Criteria) this;
        }

        public Criteria andAnAccountEqualTo(String value) {
            addCriterion("an_account =", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountNotEqualTo(String value) {
            addCriterion("an_account <>", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountGreaterThan(String value) {
            addCriterion("an_account >", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountGreaterThanOrEqualTo(String value) {
            addCriterion("an_account >=", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountLessThan(String value) {
            addCriterion("an_account <", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountLessThanOrEqualTo(String value) {
            addCriterion("an_account <=", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountLike(String value) {
            addCriterion("an_account like", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountNotLike(String value) {
            addCriterion("an_account not like", value, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountIn(List<String> values) {
            addCriterion("an_account in", values, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountNotIn(List<String> values) {
            addCriterion("an_account not in", values, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountBetween(String value1, String value2) {
            addCriterion("an_account between", value1, value2, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnAccountNotBetween(String value1, String value2) {
            addCriterion("an_account not between", value1, value2, "anAccount");
            return (Criteria) this;
        }

        public Criteria andAnNameIsNull() {
            addCriterion("an_name is null");
            return (Criteria) this;
        }

        public Criteria andAnNameIsNotNull() {
            addCriterion("an_name is not null");
            return (Criteria) this;
        }

        public Criteria andAnNameEqualTo(String value) {
            addCriterion("an_name =", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameNotEqualTo(String value) {
            addCriterion("an_name <>", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameGreaterThan(String value) {
            addCriterion("an_name >", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameGreaterThanOrEqualTo(String value) {
            addCriterion("an_name >=", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameLessThan(String value) {
            addCriterion("an_name <", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameLessThanOrEqualTo(String value) {
            addCriterion("an_name <=", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameLike(String value) {
            addCriterion("an_name like", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameNotLike(String value) {
            addCriterion("an_name not like", value, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameIn(List<String> values) {
            addCriterion("an_name in", values, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameNotIn(List<String> values) {
            addCriterion("an_name not in", values, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameBetween(String value1, String value2) {
            addCriterion("an_name between", value1, value2, "anName");
            return (Criteria) this;
        }

        public Criteria andAnNameNotBetween(String value1, String value2) {
            addCriterion("an_name not between", value1, value2, "anName");
            return (Criteria) this;
        }

        public Criteria andAnTextIsNull() {
            addCriterion("an_text is null");
            return (Criteria) this;
        }

        public Criteria andAnTextIsNotNull() {
            addCriterion("an_text is not null");
            return (Criteria) this;
        }

        public Criteria andAnTextEqualTo(String value) {
            addCriterion("an_text =", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextNotEqualTo(String value) {
            addCriterion("an_text <>", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextGreaterThan(String value) {
            addCriterion("an_text >", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextGreaterThanOrEqualTo(String value) {
            addCriterion("an_text >=", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextLessThan(String value) {
            addCriterion("an_text <", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextLessThanOrEqualTo(String value) {
            addCriterion("an_text <=", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextLike(String value) {
            addCriterion("an_text like", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextNotLike(String value) {
            addCriterion("an_text not like", value, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextIn(List<String> values) {
            addCriterion("an_text in", values, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextNotIn(List<String> values) {
            addCriterion("an_text not in", values, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextBetween(String value1, String value2) {
            addCriterion("an_text between", value1, value2, "anText");
            return (Criteria) this;
        }

        public Criteria andAnTextNotBetween(String value1, String value2) {
            addCriterion("an_text not between", value1, value2, "anText");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_announcement
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
     * This class corresponds to the database table sys_announcement
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