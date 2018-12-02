package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysActivityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public SysActivityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
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
     * This method corresponds to the database table sys_activity
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
     * This method corresponds to the database table sys_activity
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_activity
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
     * This class corresponds to the database table sys_activity
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

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityPositionIsNull() {
            addCriterion("activity_position is null");
            return (Criteria) this;
        }

        public Criteria andActivityPositionIsNotNull() {
            addCriterion("activity_position is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPositionEqualTo(String value) {
            addCriterion("activity_position =", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionNotEqualTo(String value) {
            addCriterion("activity_position <>", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionGreaterThan(String value) {
            addCriterion("activity_position >", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionGreaterThanOrEqualTo(String value) {
            addCriterion("activity_position >=", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionLessThan(String value) {
            addCriterion("activity_position <", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionLessThanOrEqualTo(String value) {
            addCriterion("activity_position <=", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionLike(String value) {
            addCriterion("activity_position like", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionNotLike(String value) {
            addCriterion("activity_position not like", value, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionIn(List<String> values) {
            addCriterion("activity_position in", values, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionNotIn(List<String> values) {
            addCriterion("activity_position not in", values, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionBetween(String value1, String value2) {
            addCriterion("activity_position between", value1, value2, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityPositionNotBetween(String value1, String value2) {
            addCriterion("activity_position not between", value1, value2, "activityPosition");
            return (Criteria) this;
        }

        public Criteria andActivityAccountIsNull() {
            addCriterion("activity_account is null");
            return (Criteria) this;
        }

        public Criteria andActivityAccountIsNotNull() {
            addCriterion("activity_account is not null");
            return (Criteria) this;
        }

        public Criteria andActivityAccountEqualTo(String value) {
            addCriterion("activity_account =", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountNotEqualTo(String value) {
            addCriterion("activity_account <>", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountGreaterThan(String value) {
            addCriterion("activity_account >", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountGreaterThanOrEqualTo(String value) {
            addCriterion("activity_account >=", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountLessThan(String value) {
            addCriterion("activity_account <", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountLessThanOrEqualTo(String value) {
            addCriterion("activity_account <=", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountLike(String value) {
            addCriterion("activity_account like", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountNotLike(String value) {
            addCriterion("activity_account not like", value, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountIn(List<String> values) {
            addCriterion("activity_account in", values, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountNotIn(List<String> values) {
            addCriterion("activity_account not in", values, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountBetween(String value1, String value2) {
            addCriterion("activity_account between", value1, value2, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityAccountNotBetween(String value1, String value2) {
            addCriterion("activity_account not between", value1, value2, "activityAccount");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIsNull() {
            addCriterion("activity_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIsNotNull() {
            addCriterion("activity_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeEqualTo(Date value) {
            addCriterion("activity_begin_time =", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotEqualTo(Date value) {
            addCriterion("activity_begin_time <>", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeGreaterThan(Date value) {
            addCriterion("activity_begin_time >", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_begin_time >=", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeLessThan(Date value) {
            addCriterion("activity_begin_time <", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_begin_time <=", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIn(List<Date> values) {
            addCriterion("activity_begin_time in", values, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotIn(List<Date> values) {
            addCriterion("activity_begin_time not in", values, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeBetween(Date value1, Date value2) {
            addCriterion("activity_begin_time between", value1, value2, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_begin_time not between", value1, value2, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNull() {
            addCriterion("activity_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNotNull() {
            addCriterion("activity_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeEqualTo(Date value) {
            addCriterion("activity_end_time =", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotEqualTo(Date value) {
            addCriterion("activity_end_time <>", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThan(Date value) {
            addCriterion("activity_end_time >", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_end_time >=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThan(Date value) {
            addCriterion("activity_end_time <", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_end_time <=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIn(List<Date> values) {
            addCriterion("activity_end_time in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotIn(List<Date> values) {
            addCriterion("activity_end_time not in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeBetween(Date value1, Date value2) {
            addCriterion("activity_end_time between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_end_time not between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyIsNull() {
            addCriterion("activity_money is null");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyIsNotNull() {
            addCriterion("activity_money is not null");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyEqualTo(Double value) {
            addCriterion("activity_money =", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyNotEqualTo(Double value) {
            addCriterion("activity_money <>", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyGreaterThan(Double value) {
            addCriterion("activity_money >", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("activity_money >=", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyLessThan(Double value) {
            addCriterion("activity_money <", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyLessThanOrEqualTo(Double value) {
            addCriterion("activity_money <=", value, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyIn(List<Double> values) {
            addCriterion("activity_money in", values, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyNotIn(List<Double> values) {
            addCriterion("activity_money not in", values, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyBetween(Double value1, Double value2) {
            addCriterion("activity_money between", value1, value2, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMoneyNotBetween(Double value1, Double value2) {
            addCriterion("activity_money not between", value1, value2, "activityMoney");
            return (Criteria) this;
        }

        public Criteria andActivityMinIsNull() {
            addCriterion("activity_min is null");
            return (Criteria) this;
        }

        public Criteria andActivityMinIsNotNull() {
            addCriterion("activity_min is not null");
            return (Criteria) this;
        }

        public Criteria andActivityMinEqualTo(Short value) {
            addCriterion("activity_min =", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinNotEqualTo(Short value) {
            addCriterion("activity_min <>", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinGreaterThan(Short value) {
            addCriterion("activity_min >", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinGreaterThanOrEqualTo(Short value) {
            addCriterion("activity_min >=", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinLessThan(Short value) {
            addCriterion("activity_min <", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinLessThanOrEqualTo(Short value) {
            addCriterion("activity_min <=", value, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinIn(List<Short> values) {
            addCriterion("activity_min in", values, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinNotIn(List<Short> values) {
            addCriterion("activity_min not in", values, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinBetween(Short value1, Short value2) {
            addCriterion("activity_min between", value1, value2, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMinNotBetween(Short value1, Short value2) {
            addCriterion("activity_min not between", value1, value2, "activityMin");
            return (Criteria) this;
        }

        public Criteria andActivityMaxIsNull() {
            addCriterion("activity_max is null");
            return (Criteria) this;
        }

        public Criteria andActivityMaxIsNotNull() {
            addCriterion("activity_max is not null");
            return (Criteria) this;
        }

        public Criteria andActivityMaxEqualTo(Short value) {
            addCriterion("activity_max =", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxNotEqualTo(Short value) {
            addCriterion("activity_max <>", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxGreaterThan(Short value) {
            addCriterion("activity_max >", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxGreaterThanOrEqualTo(Short value) {
            addCriterion("activity_max >=", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxLessThan(Short value) {
            addCriterion("activity_max <", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxLessThanOrEqualTo(Short value) {
            addCriterion("activity_max <=", value, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxIn(List<Short> values) {
            addCriterion("activity_max in", values, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxNotIn(List<Short> values) {
            addCriterion("activity_max not in", values, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxBetween(Short value1, Short value2) {
            addCriterion("activity_max between", value1, value2, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityMaxNotBetween(Short value1, Short value2) {
            addCriterion("activity_max not between", value1, value2, "activityMax");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(Short value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(Short value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(Short value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(Short value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(Short value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<Short> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<Short> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(Short value1, Short value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(Short value1, Short value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIsNull() {
            addCriterion("activity_remark is null");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIsNotNull() {
            addCriterion("activity_remark is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkEqualTo(String value) {
            addCriterion("activity_remark =", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotEqualTo(String value) {
            addCriterion("activity_remark <>", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkGreaterThan(String value) {
            addCriterion("activity_remark >", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("activity_remark >=", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLessThan(String value) {
            addCriterion("activity_remark <", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLessThanOrEqualTo(String value) {
            addCriterion("activity_remark <=", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkLike(String value) {
            addCriterion("activity_remark like", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotLike(String value) {
            addCriterion("activity_remark not like", value, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkIn(List<String> values) {
            addCriterion("activity_remark in", values, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotIn(List<String> values) {
            addCriterion("activity_remark not in", values, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkBetween(String value1, String value2) {
            addCriterion("activity_remark between", value1, value2, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityRemarkNotBetween(String value1, String value2) {
            addCriterion("activity_remark not between", value1, value2, "activityRemark");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameIsNull() {
            addCriterion("activity_user_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameIsNotNull() {
            addCriterion("activity_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameEqualTo(String value) {
            addCriterion("activity_user_name =", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameNotEqualTo(String value) {
            addCriterion("activity_user_name <>", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameGreaterThan(String value) {
            addCriterion("activity_user_name >", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_user_name >=", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameLessThan(String value) {
            addCriterion("activity_user_name <", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameLessThanOrEqualTo(String value) {
            addCriterion("activity_user_name <=", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameLike(String value) {
            addCriterion("activity_user_name like", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameNotLike(String value) {
            addCriterion("activity_user_name not like", value, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameIn(List<String> values) {
            addCriterion("activity_user_name in", values, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameNotIn(List<String> values) {
            addCriterion("activity_user_name not in", values, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameBetween(String value1, String value2) {
            addCriterion("activity_user_name between", value1, value2, "activityUserName");
            return (Criteria) this;
        }

        public Criteria andActivityUserNameNotBetween(String value1, String value2) {
            addCriterion("activity_user_name not between", value1, value2, "activityUserName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_activity
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
     * This class corresponds to the database table sys_activity
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