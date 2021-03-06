package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskSubmitRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public TaskSubmitRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
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
     * This method corresponds to the database table task_submit_record
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
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
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
     * This class corresponds to the database table task_submit_record
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountIsNull() {
            addCriterion("task_submit_account is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountIsNotNull() {
            addCriterion("task_submit_account is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountEqualTo(String value) {
            addCriterion("task_submit_account =", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountNotEqualTo(String value) {
            addCriterion("task_submit_account <>", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountGreaterThan(String value) {
            addCriterion("task_submit_account >", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountGreaterThanOrEqualTo(String value) {
            addCriterion("task_submit_account >=", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountLessThan(String value) {
            addCriterion("task_submit_account <", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountLessThanOrEqualTo(String value) {
            addCriterion("task_submit_account <=", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountLike(String value) {
            addCriterion("task_submit_account like", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountNotLike(String value) {
            addCriterion("task_submit_account not like", value, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountIn(List<String> values) {
            addCriterion("task_submit_account in", values, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountNotIn(List<String> values) {
            addCriterion("task_submit_account not in", values, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountBetween(String value1, String value2) {
            addCriterion("task_submit_account between", value1, value2, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitAccountNotBetween(String value1, String value2) {
            addCriterion("task_submit_account not between", value1, value2, "taskSubmitAccount");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeIsNull() {
            addCriterion("task_submit_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeIsNotNull() {
            addCriterion("task_submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeEqualTo(Date value) {
            addCriterion("task_submit_time =", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeNotEqualTo(Date value) {
            addCriterion("task_submit_time <>", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeGreaterThan(Date value) {
            addCriterion("task_submit_time >", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_submit_time >=", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeLessThan(Date value) {
            addCriterion("task_submit_time <", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("task_submit_time <=", value, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeIn(List<Date> values) {
            addCriterion("task_submit_time in", values, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeNotIn(List<Date> values) {
            addCriterion("task_submit_time not in", values, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("task_submit_time between", value1, value2, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("task_submit_time not between", value1, value2, "taskSubmitTime");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameIsNull() {
            addCriterion("task_submit_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameIsNotNull() {
            addCriterion("task_submit_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameEqualTo(String value) {
            addCriterion("task_submit_name =", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameNotEqualTo(String value) {
            addCriterion("task_submit_name <>", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameGreaterThan(String value) {
            addCriterion("task_submit_name >", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_submit_name >=", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameLessThan(String value) {
            addCriterion("task_submit_name <", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameLessThanOrEqualTo(String value) {
            addCriterion("task_submit_name <=", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameLike(String value) {
            addCriterion("task_submit_name like", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameNotLike(String value) {
            addCriterion("task_submit_name not like", value, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameIn(List<String> values) {
            addCriterion("task_submit_name in", values, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameNotIn(List<String> values) {
            addCriterion("task_submit_name not in", values, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameBetween(String value1, String value2) {
            addCriterion("task_submit_name between", value1, value2, "taskSubmitName");
            return (Criteria) this;
        }

        public Criteria andTaskSubmitNameNotBetween(String value1, String value2) {
            addCriterion("task_submit_name not between", value1, value2, "taskSubmitName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task_submit_record
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
     * This class corresponds to the database table task_submit_record
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