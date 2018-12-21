package mybatis.service;

import mybatis.model.SysTask;

import java.util.List;

public interface SysTaskService {

    /**
     * 发布作业
     * @param sysTask
     * @return
     */
    boolean publishTask(SysTask sysTask);

    /**
     * 删除作业
     * @param id
     * @return
     */
    boolean deleteTaskById(Integer id);

    /**
     * 查找作业
     * @param id
     * @return
     */
    SysTask selectTaskById(Integer id);

    /**
     * 获取作业列表
     * @return
     */
    List<SysTask> getTaskList();

    /**
     * 获取我的作业，根据组别
     * @param group
     * @return
     */
    List<SysTask> getMyTaskList(String group);

}
