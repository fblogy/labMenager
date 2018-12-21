package mybatis.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table book_borrow_record
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class BookBorrowRecord {
	
	private SysUser user;
	
	private SysBook book;
    /**
     * Database Column Remarks:
     *   澶栭�?
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_borrow_record.book_id
     *
     * @mbggenerated
     */
    private Integer bookId;

    @Override
	public String toString() {
		return "BookBorrowRecord [user=" + user + ", book=" + book + ", bookId=" + bookId + ", bookBorrowAccount="
				+ bookBorrowAccount + ", bookBorrowTime=" + bookBorrowTime + "]";
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public SysBook getBook() {
		return book;
	}

	public void setBook(SysBook book) {
		this.book = book;
	}

	/**
     * Database Column Remarks:
     *   鍊熼槄浜�? 澶栭�?
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_borrow_record.book_borrow_account
     *
     * @mbggenerated
     */
    private String bookBorrowAccount;

    /**
     * Database Column Remarks:
     *   鍊熼槄鏃ユ湡
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_borrow_record.book_borrow_time
     *
     * @mbggenerated
     */
    private Date bookBorrowTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_borrow_record.book_id
     *
     * @return the value of book_borrow_record.book_id
     *
     * @mbggenerated
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_borrow_record.book_id
     *
     * @param bookId the value for book_borrow_record.book_id
     *
     * @mbggenerated
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_borrow_record.book_borrow_account
     *
     * @return the value of book_borrow_record.book_borrow_account
     *
     * @mbggenerated
     */
    public String getBookBorrowAccount() {
        return bookBorrowAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_borrow_record.book_borrow_account
     *
     * @param bookBorrowAccount the value for book_borrow_record.book_borrow_account
     *
     * @mbggenerated
     */
    public void setBookBorrowAccount(String bookBorrowAccount) {
        this.bookBorrowAccount = bookBorrowAccount == null ? null : bookBorrowAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_borrow_record.book_borrow_time
     *
     * @return the value of book_borrow_record.book_borrow_time
     *
     * @mbggenerated
     */
    public Date getBookBorrowTime() {
        return bookBorrowTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_borrow_record.book_borrow_time
     *
     * @param bookBorrowTime the value for book_borrow_record.book_borrow_time
     *
     * @mbggenerated
     */
    public void setBookBorrowTime(Date bookBorrowTime) {
        this.bookBorrowTime = bookBorrowTime;
    }
}