package mybatis.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_meetingroom
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysMeetingroom {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_meetingroom.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   借用日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_meetingroom.room_date
     *
     * @mbggenerated
     */
    private Date roomDate;

    /**
     * Database Column Remarks:
     *   借用时间段 1-9
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_meetingroom.room_seg
     *
     * @mbggenerated
     */
    private Integer roomSeg;

    /**
     * Database Column Remarks:
     *   借用用户
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_meetingroom.room_account
     *
     * @mbggenerated
     */
    private String roomAccount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_meetingroom.id
     *
     * @return the value of sys_meetingroom.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_meetingroom.id
     *
     * @param id the value for sys_meetingroom.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_meetingroom.room_date
     *
     * @return the value of sys_meetingroom.room_date
     *
     * @mbggenerated
     */
    public Date getRoomDate() {
        return roomDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_meetingroom.room_date
     *
     * @param roomDate the value for sys_meetingroom.room_date
     *
     * @mbggenerated
     */
    public void setRoomDate(Date roomDate) {
        this.roomDate = roomDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_meetingroom.room_seg
     *
     * @return the value of sys_meetingroom.room_seg
     *
     * @mbggenerated
     */
    public Integer getRoomSeg() {
        return roomSeg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_meetingroom.room_seg
     *
     * @param roomSeg the value for sys_meetingroom.room_seg
     *
     * @mbggenerated
     */
    public void setRoomSeg(Integer roomSeg) {
        this.roomSeg = roomSeg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_meetingroom.room_account
     *
     * @return the value of sys_meetingroom.room_account
     *
     * @mbggenerated
     */
    public String getRoomAccount() {
        return roomAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_meetingroom.room_account
     *
     * @param roomAccount the value for sys_meetingroom.room_account
     *
     * @mbggenerated
     */
    public void setRoomAccount(String roomAccount) {
        this.roomAccount = roomAccount == null ? null : roomAccount.trim();
    }
}