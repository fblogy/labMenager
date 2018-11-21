package mybatis.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_graduate_duty
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysGraduateDuty {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_graduate_duty.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   星期数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_graduate_duty.graduate_duty_orderOnWeek
     *
     * @mbggenerated
     */
    private Integer graduateDutyOrderonweek;

    /**
     * Database Column Remarks:
     *   联系方式
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_graduate_duty.graduate_duty_phone
     *
     * @mbggenerated
     */
    private String graduateDutyPhone;

    /**
     * Database Column Remarks:
     *   值日生账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_graduate_duty.graduate_duty_account
     *
     * @mbggenerated
     */
    private String graduateDutyAccount;

    /**
     * Database Column Remarks:
     *   值日生姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_graduate_duty.graduate_duty_name
     *
     * @mbggenerated
     */
    private String graduateDutyName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_graduate_duty.id
     *
     * @return the value of sys_graduate_duty.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_graduate_duty.id
     *
     * @param id the value for sys_graduate_duty.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_graduate_duty.graduate_duty_orderOnWeek
     *
     * @return the value of sys_graduate_duty.graduate_duty_orderOnWeek
     *
     * @mbggenerated
     */
    public Integer getGraduateDutyOrderonweek() {
        return graduateDutyOrderonweek;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_graduate_duty.graduate_duty_orderOnWeek
     *
     * @param graduateDutyOrderonweek the value for sys_graduate_duty.graduate_duty_orderOnWeek
     *
     * @mbggenerated
     */
    public void setGraduateDutyOrderonweek(Integer graduateDutyOrderonweek) {
        this.graduateDutyOrderonweek = graduateDutyOrderonweek;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_graduate_duty.graduate_duty_phone
     *
     * @return the value of sys_graduate_duty.graduate_duty_phone
     *
     * @mbggenerated
     */
    public String getGraduateDutyPhone() {
        return graduateDutyPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_graduate_duty.graduate_duty_phone
     *
     * @param graduateDutyPhone the value for sys_graduate_duty.graduate_duty_phone
     *
     * @mbggenerated
     */
    public void setGraduateDutyPhone(String graduateDutyPhone) {
        this.graduateDutyPhone = graduateDutyPhone == null ? null : graduateDutyPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_graduate_duty.graduate_duty_account
     *
     * @return the value of sys_graduate_duty.graduate_duty_account
     *
     * @mbggenerated
     */
    public String getGraduateDutyAccount() {
        return graduateDutyAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_graduate_duty.graduate_duty_account
     *
     * @param graduateDutyAccount the value for sys_graduate_duty.graduate_duty_account
     *
     * @mbggenerated
     */
    public void setGraduateDutyAccount(String graduateDutyAccount) {
        this.graduateDutyAccount = graduateDutyAccount == null ? null : graduateDutyAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_graduate_duty.graduate_duty_name
     *
     * @return the value of sys_graduate_duty.graduate_duty_name
     *
     * @mbggenerated
     */
    public String getGraduateDutyName() {
        return graduateDutyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_graduate_duty.graduate_duty_name
     *
     * @param graduateDutyName the value for sys_graduate_duty.graduate_duty_name
     *
     * @mbggenerated
     */
    public void setGraduateDutyName(String graduateDutyName) {
        this.graduateDutyName = graduateDutyName == null ? null : graduateDutyName.trim();
    }
}