package mybatis.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_group
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_group.id
     *
     * @mbggenerated
     */
    private Short id;

    /**
     * Database Column Remarks:
     *   小组名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_group.group_name
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * Database Column Remarks:
     *   组员学号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_group.group_member
     *
     * @mbggenerated
     */
    private String groupMember;

    /**
     * Database Column Remarks:
     *   身份 1组长/0组员
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_group.identity
     *
     * @mbggenerated
     */
    private Byte identity;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_group.id
     *
     * @return the value of sys_group.id
     *
     * @mbggenerated
     */
    public Short getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_group.id
     *
     * @param id the value for sys_group.id
     *
     * @mbggenerated
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_group.group_name
     *
     * @return the value of sys_group.group_name
     *
     * @mbggenerated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_group.group_name
     *
     * @param groupName the value for sys_group.group_name
     *
     * @mbggenerated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_group.group_member
     *
     * @return the value of sys_group.group_member
     *
     * @mbggenerated
     */
    public String getGroupMember() {
        return groupMember;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_group.group_member
     *
     * @param groupMember the value for sys_group.group_member
     *
     * @mbggenerated
     */
    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember == null ? null : groupMember.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_group.identity
     *
     * @return the value of sys_group.identity
     *
     * @mbggenerated
     */
    public Byte getIdentity() {
        return identity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_group.identity
     *
     * @param identity the value for sys_group.identity
     *
     * @mbggenerated
     */
    public void setIdentity(Byte identity) {
        this.identity = identity;
    }
}