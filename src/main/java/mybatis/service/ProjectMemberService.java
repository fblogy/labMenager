package mybatis.service;

import mybatis.model.ProjectMembers;

import java.util.List;

public interface ProjectMemberService {
    /**
     * 申请加入项目
     * @param projectMembers
     * @return
     */
    Integer applyToJoinProject(ProjectMembers projectMembers);

    /**
     * 审核报名是否通过
     * @param projectMembers
     * @return
     */
    Integer isPassProjectApply(ProjectMembers projectMembers);

    /**
     * 申请退出项目
     * @return
     */
    Integer applyToOutProject(ProjectMembers projectMembers);

    /**
     * 获得当前项目参加的人数
     * @param projectID
     * @return
     */
    Integer getAttendCountByProjectID(Integer projectID);

    /**
     * 判断是否有报名项目
     * @param userAccount
     * @param projectId
     * @return
     */
    boolean isAttendProject(String userAccount,Integer projectId);

    /**
     * 获取报名状态 0待审核/1通过/-1淘汰/2我发起
     * @param userAccount
     * @param projectId
     * @return
     */
    Integer getApplyStatus(String userAccount,Integer projectId);

    /**
     * 通过发布人账号获取发布人发布的所有项目的报名记录
     * @param publisher
     * @return
     */
    List<ProjectMembers> getApplyerList(String publisher);
}
