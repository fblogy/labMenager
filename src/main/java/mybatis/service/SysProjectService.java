package mybatis.service;

import mybatis.model.SysProject;

import java.util.List;

public interface SysProjectService {

    /**
     * 发布项目
     * @param sysProject
     * @return
     */
    boolean addProject(SysProject sysProject);

    /**
     * 删除项目
     * @param sysProject
     * @return
     */
    boolean deleteProjectByID(SysProject sysProject);

    /**
     * 修改项目
     * @param sysProject
     * @return
     */
    boolean modifyProjectByID(SysProject sysProject);

    /**
     * 获得已结束的项目列表
     * @return
     */
    List<SysProject> getOverProjectList();

    /**
     * 获取正在进行的项目列表
     * @return
     */
    List<SysProject> getDoingProjectList();

    /**
     * 项目负责人获取我发布的项目列表
     * 其他角色获取我参加的项目列表
     * @return
     */
    List<SysProject> getMyProjectList(String userAccount,Integer role);
}