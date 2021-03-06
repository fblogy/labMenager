package mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookBorrowRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public BookBorrowRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
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
     * This method corresponds to the database table book_borrow_record
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
     * This method corresponds to the database table book_borrow_record
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_borrow_record
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
     * This class corresponds to the database table book_borrow_record
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountIsNull() {
            addCriterion("book_borrow_account is null");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountIsNotNull() {
            addCriterion("book_borrow_account is not null");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountEqualTo(String value) {
            addCriterion("book_borrow_account =", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountNotEqualTo(String value) {
            addCriterion("book_borrow_account <>", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountGreaterThan(String value) {
            addCriterion("book_borrow_account >", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountGreaterThanOrEqualTo(String value) {
            addCriterion("book_borrow_account >=", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountLessThan(String value) {
            addCriterion("book_borrow_account <", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountLessThanOrEqualTo(String value) {
            addCriterion("book_borrow_account <=", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountLike(String value) {
            addCriterion("book_borrow_account like", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountNotLike(String value) {
            addCriterion("book_borrow_account not like", value, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountIn(List<String> values) {
            addCriterion("book_borrow_account in", values, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountNotIn(List<String> values) {
            addCriterion("book_borrow_account not in", values, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountBetween(String value1, String value2) {
            addCriterion("book_borrow_account between", value1, value2, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowAccountNotBetween(String value1, String value2) {
            addCriterion("book_borrow_account not between", value1, value2, "bookBorrowAccount");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeIsNull() {
            addCriterion("book_borrow_time is null");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeIsNotNull() {
            addCriterion("book_borrow_time is not null");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeEqualTo(Date value) {
            addCriterion("book_borrow_time =", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeNotEqualTo(Date value) {
            addCriterion("book_borrow_time <>", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeGreaterThan(Date value) {
            addCriterion("book_borrow_time >", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("book_borrow_time >=", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeLessThan(Date value) {
            addCriterion("book_borrow_time <", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeLessThanOrEqualTo(Date value) {
            addCriterion("book_borrow_time <=", value, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeIn(List<Date> values) {
            addCriterion("book_borrow_time in", values, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeNotIn(List<Date> values) {
            addCriterion("book_borrow_time not in", values, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeBetween(Date value1, Date value2) {
            addCriterion("book_borrow_time between", value1, value2, "bookBorrowTime");
            return (Criteria) this;
        }

        public Criteria andBookBorrowTimeNotBetween(Date value1, Date value2) {
            addCriterion("book_borrow_time not between", value1, value2, "bookBorrowTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table book_borrow_record
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
     * This class corresponds to the database table book_borrow_record
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