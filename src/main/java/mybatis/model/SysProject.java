package mybatis.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_project
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class SysProject {
    /**
     * Database Column Remarks:
     *   项目编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   项目名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_name
     *
     * @mbggenerated
     */
    private String projectName;

    /**
     * Database Column Remarks:
     *   项目负责人账号 外键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_account
     *
     * @mbggenerated
     */
    private String projectAccount;

    /**
     * Database Column Remarks:
     *   项目负责人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_user_name
     *
     * @mbggenerated
     */
    private String projectUserName;

    /**
     * Database Column Remarks:
     *   需求最大人数
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_required
     *
     * @mbggenerated
     */
    private Integer projectRequired;

    /**
     * Database Column Remarks:
     *   项目状态 0:未开始/1:已开始/2:已结束
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_status
     *
     * @mbggenerated
     */
    private Integer projectStatus;

    /**
     * Database Column Remarks:
     *   项目报名截至日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_begin_time
     *
     * @mbggenerated
     */
    private Date projectBeginTime;

    /**
     * Database Column Remarks:
     *   项目结束时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_end_time
     *
     * @mbggenerated
     */
    private Date projectEndTime;

    /**
     * Database Column Remarks:
     *   项目获奖情况
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_honor
     *
     * @mbggenerated
     */
    private String projectHonor;

    /**
     * Database Column Remarks:
     *   项目说明
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_project.project_remark
     *
     * @mbggenerated
     */
    private String projectRemark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.id
     *
     * @return the value of sys_project.id
     *
     * @mbggenerated
     */

    /**
     * 当前报名人数
     */
    private Integer projectCur;
    private String projectBeginTimeStr;
    private String projectEndTimeStr;

    /**
     * 当前登录用户对项目的状态  0未报名 1已报名 2我发起   所有项目页面
     * @return
     */
    private Integer myStatus;

    /**
     * 报名状态 0待审核/1通过/-1淘汰/2我发起  我的项目页面
     */
    private Integer applyStatus;

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getMyStatus() {
        return myStatus;
    }

    public void setMyStatus(Integer myStatus) {
        this.myStatus = myStatus;
    }

    public Integer getProjectCur() {
        return projectCur;
    }

    public void setProjectCur(Integer projectCur) {
        this.projectCur = projectCur;
    }

    public String getProjectBeginTimeStr() {
        return projectBeginTimeStr;
    }

    public void setProjectBeginTimeStr(String projectBeginTimeStr) {
        this.projectBeginTimeStr = projectBeginTimeStr;
    }

    public String getProjectEndTimeStr() {
        return projectEndTimeStr;
    }

    public void setProjectEndTimeStr(String projectEndTimeStr) {
        this.projectEndTimeStr = projectEndTimeStr;
    }

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.id
     *
     * @param id the value for sys_project.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_name
     *
     * @return the value of sys_project.project_name
     *
     * @mbggenerated
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_name
     *
     * @param projectName the value for sys_project.project_name
     *
     * @mbggenerated
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_account
     *
     * @return the value of sys_project.project_account
     *
     * @mbggenerated
     */
    public String getProjectAccount() {
        return projectAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_account
     *
     * @param projectAccount the value for sys_project.project_account
     *
     * @mbggenerated
     */
    public void setProjectAccount(String projectAccount) {
        this.projectAccount = projectAccount == null ? null : projectAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_user_name
     *
     * @return the value of sys_project.project_user_name
     *
     * @mbggenerated
     */
    public String getProjectUserName() {
        return projectUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_user_name
     *
     * @param projectUserName the value for sys_project.project_user_name
     *
     * @mbggenerated
     */
    public void setProjectUserName(String projectUserName) {
        this.projectUserName = projectUserName == null ? null : projectUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_required
     *
     * @return the value of sys_project.project_required
     *
     * @mbggenerated
     */
    public Integer getProjectRequired() {
        return projectRequired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_required
     *
     * @param projectRequired the value for sys_project.project_required
     *
     * @mbggenerated
     */
    public void setProjectRequired(Integer projectRequired) {
        this.projectRequired = projectRequired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_status
     *
     * @return the value of sys_project.project_status
     *
     * @mbggenerated
     */
    public Integer getProjectStatus() {
        return projectStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_status
     *
     * @param projectStatus the value for sys_project.project_status
     *
     * @mbggenerated
     */
    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_begin_time
     *
     * @return the value of sys_project.project_begin_time
     *
     * @mbggenerated
     */
    public Date getProjectBeginTime() {
        return projectBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_begin_time
     *
     * @param projectBeginTime the value for sys_project.project_begin_time
     *
     * @mbggenerated
     */
    public void setProjectBeginTime(Date projectBeginTime) {
        this.projectBeginTime = projectBeginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_end_time
     *
     * @return the value of sys_project.project_end_time
     *
     * @mbggenerated
     */
    public Date getProjectEndTime() {
        return projectEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_end_time
     *
     * @param projectEndTime the value for sys_project.project_end_time
     *
     * @mbggenerated
     */
    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_honor
     *
     * @return the value of sys_project.project_honor
     *
     * @mbggenerated
     */
    public String getProjectHonor() {
        return projectHonor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_honor
     *
     * @param projectHonor the value for sys_project.project_honor
     *
     * @mbggenerated
     */
    public void setProjectHonor(String projectHonor) {
        this.projectHonor = projectHonor == null ? null : projectHonor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_project.project_remark
     *
     * @return the value of sys_project.project_remark
     *
     * @mbggenerated
     */
    public String getProjectRemark() {
        return projectRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_project.project_remark
     *
     * @param projectRemark the value for sys_project.project_remark
     *
     * @mbggenerated
     */
    public void setProjectRemark(String projectRemark) {
        this.projectRemark = projectRemark == null ? null : projectRemark.trim();
    }
}