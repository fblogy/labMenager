package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table score_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table score_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table score_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public ScoreRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
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
     * This method corresponds to the database table score_record
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
     * This method corresponds to the database table score_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table score_record
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
     * This class corresponds to the database table score_record
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

        public Criteria andSrGroupIsNull() {
            addCriterion("sr_group is null");
            return (Criteria) this;
        }

        public Criteria andSrGroupIsNotNull() {
            addCriterion("sr_group is not null");
            return (Criteria) this;
        }

        public Criteria andSrGroupEqualTo(String value) {
            addCriterion("sr_group =", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupNotEqualTo(String value) {
            addCriterion("sr_group <>", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupGreaterThan(String value) {
            addCriterion("sr_group >", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupGreaterThanOrEqualTo(String value) {
            addCriterion("sr_group >=", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupLessThan(String value) {
            addCriterion("sr_group <", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupLessThanOrEqualTo(String value) {
            addCriterion("sr_group <=", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupLike(String value) {
            addCriterion("sr_group like", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupNotLike(String value) {
            addCriterion("sr_group not like", value, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupIn(List<String> values) {
            addCriterion("sr_group in", values, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupNotIn(List<String> values) {
            addCriterion("sr_group not in", values, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupBetween(String value1, String value2) {
            addCriterion("sr_group between", value1, value2, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrGroupNotBetween(String value1, String value2) {
            addCriterion("sr_group not between", value1, value2, "srGroup");
            return (Criteria) this;
        }

        public Criteria andSrScoreIsNull() {
            addCriterion("sr_score is null");
            return (Criteria) this;
        }

        public Criteria andSrScoreIsNotNull() {
            addCriterion("sr_score is not null");
            return (Criteria) this;
        }

        public Criteria andSrScoreEqualTo(Integer value) {
            addCriterion("sr_score =", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotEqualTo(Integer value) {
            addCriterion("sr_score <>", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreGreaterThan(Integer value) {
            addCriterion("sr_score >", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("sr_score >=", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreLessThan(Integer value) {
            addCriterion("sr_score <", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreLessThanOrEqualTo(Integer value) {
            addCriterion("sr_score <=", value, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreIn(List<Integer> values) {
            addCriterion("sr_score in", values, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotIn(List<Integer> values) {
            addCriterion("sr_score not in", values, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreBetween(Integer value1, Integer value2) {
            addCriterion("sr_score between", value1, value2, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("sr_score not between", value1, value2, "srScore");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountIsNull() {
            addCriterion("sr_manager_account is null");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountIsNotNull() {
            addCriterion("sr_manager_account is not null");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountEqualTo(String value) {
            addCriterion("sr_manager_account =", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountNotEqualTo(String value) {
            addCriterion("sr_manager_account <>", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountGreaterThan(String value) {
            addCriterion("sr_manager_account >", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountGreaterThanOrEqualTo(String value) {
            addCriterion("sr_manager_account >=", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountLessThan(String value) {
            addCriterion("sr_manager_account <", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountLessThanOrEqualTo(String value) {
            addCriterion("sr_manager_account <=", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountLike(String value) {
            addCriterion("sr_manager_account like", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountNotLike(String value) {
            addCriterion("sr_manager_account not like", value, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountIn(List<String> values) {
            addCriterion("sr_manager_account in", values, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountNotIn(List<String> values) {
            addCriterion("sr_manager_account not in", values, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountBetween(String value1, String value2) {
            addCriterion("sr_manager_account between", value1, value2, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerAccountNotBetween(String value1, String value2) {
            addCriterion("sr_manager_account not between", value1, value2, "srManagerAccount");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameIsNull() {
            addCriterion("sr_manager_name is null");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameIsNotNull() {
            addCriterion("sr_manager_name is not null");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameEqualTo(String value) {
            addCriterion("sr_manager_name =", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameNotEqualTo(String value) {
            addCriterion("sr_manager_name <>", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameGreaterThan(String value) {
            addCriterion("sr_manager_name >", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameGreaterThanOrEqualTo(String value) {
            addCriterion("sr_manager_name >=", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameLessThan(String value) {
            addCriterion("sr_manager_name <", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameLessThanOrEqualTo(String value) {
            addCriterion("sr_manager_name <=", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameLike(String value) {
            addCriterion("sr_manager_name like", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameNotLike(String value) {
            addCriterion("sr_manager_name not like", value, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameIn(List<String> values) {
            addCriterion("sr_manager_name in", values, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameNotIn(List<String> values) {
            addCriterion("sr_manager_name not in", values, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameBetween(String value1, String value2) {
            addCriterion("sr_manager_name between", value1, value2, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrManagerNameNotBetween(String value1, String value2) {
            addCriterion("sr_manager_name not between", value1, value2, "srManagerName");
            return (Criteria) this;
        }

        public Criteria andSrAccountIsNull() {
            addCriterion("sr_account is null");
            return (Criteria) this;
        }

        public Criteria andSrAccountIsNotNull() {
            addCriterion("sr_account is not null");
            return (Criteria) this;
        }

        public Criteria andSrAccountEqualTo(String value) {
            addCriterion("sr_account =", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountNotEqualTo(String value) {
            addCriterion("sr_account <>", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountGreaterThan(String value) {
            addCriterion("sr_account >", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountGreaterThanOrEqualTo(String value) {
            addCriterion("sr_account >=", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountLessThan(String value) {
            addCriterion("sr_account <", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountLessThanOrEqualTo(String value) {
            addCriterion("sr_account <=", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountLike(String value) {
            addCriterion("sr_account like", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountNotLike(String value) {
            addCriterion("sr_account not like", value, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountIn(List<String> values) {
            addCriterion("sr_account in", values, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountNotIn(List<String> values) {
            addCriterion("sr_account not in", values, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountBetween(String value1, String value2) {
            addCriterion("sr_account between", value1, value2, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrAccountNotBetween(String value1, String value2) {
            addCriterion("sr_account not between", value1, value2, "srAccount");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNull() {
            addCriterion("sr_name is null");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNotNull() {
            addCriterion("sr_name is not null");
            return (Criteria) this;
        }

        public Criteria andSrNameEqualTo(String value) {
            addCriterion("sr_name =", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotEqualTo(String value) {
            addCriterion("sr_name <>", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThan(String value) {
            addCriterion("sr_name >", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThanOrEqualTo(String value) {
            addCriterion("sr_name >=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThan(String value) {
            addCriterion("sr_name <", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThanOrEqualTo(String value) {
            addCriterion("sr_name <=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLike(String value) {
            addCriterion("sr_name like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotLike(String value) {
            addCriterion("sr_name not like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameIn(List<String> values) {
            addCriterion("sr_name in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotIn(List<String> values) {
            addCriterion("sr_name not in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameBetween(String value1, String value2) {
            addCriterion("sr_name between", value1, value2, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotBetween(String value1, String value2) {
            addCriterion("sr_name not between", value1, value2, "srName");
            return (Criteria) this;
        }

        public Criteria andSrTimeIsNull() {
            addCriterion("sr_time is null");
            return (Criteria) this;
        }

        public Criteria andSrTimeIsNotNull() {
            addCriterion("sr_time is not null");
            return (Criteria) this;
        }

        public Criteria andSrTimeEqualTo(Date value) {
            addCriterion("sr_time =", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeNotEqualTo(Date value) {
            addCriterion("sr_time <>", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeGreaterThan(Date value) {
            addCriterion("sr_time >", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sr_time >=", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeLessThan(Date value) {
            addCriterion("sr_time <", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeLessThanOrEqualTo(Date value) {
            addCriterion("sr_time <=", value, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeIn(List<Date> values) {
            addCriterion("sr_time in", values, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeNotIn(List<Date> values) {
            addCriterion("sr_time not in", values, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeBetween(Date value1, Date value2) {
            addCriterion("sr_time between", value1, value2, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrTimeNotBetween(Date value1, Date value2) {
            addCriterion("sr_time not between", value1, value2, "srTime");
            return (Criteria) this;
        }

        public Criteria andSrRemarkIsNull() {
            addCriterion("sr_remark is null");
            return (Criteria) this;
        }

        public Criteria andSrRemarkIsNotNull() {
            addCriterion("sr_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSrRemarkEqualTo(String value) {
            addCriterion("sr_remark =", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkNotEqualTo(String value) {
            addCriterion("sr_remark <>", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkGreaterThan(String value) {
            addCriterion("sr_remark >", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sr_remark >=", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkLessThan(String value) {
            addCriterion("sr_remark <", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkLessThanOrEqualTo(String value) {
            addCriterion("sr_remark <=", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkLike(String value) {
            addCriterion("sr_remark like", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkNotLike(String value) {
            addCriterion("sr_remark not like", value, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkIn(List<String> values) {
            addCriterion("sr_remark in", values, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkNotIn(List<String> values) {
            addCriterion("sr_remark not in", values, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkBetween(String value1, String value2) {
            addCriterion("sr_remark between", value1, value2, "srRemark");
            return (Criteria) this;
        }

        public Criteria andSrRemarkNotBetween(String value1, String value2) {
            addCriterion("sr_remark not between", value1, value2, "srRemark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table score_record
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
     * This class corresponds to the database table score_record
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