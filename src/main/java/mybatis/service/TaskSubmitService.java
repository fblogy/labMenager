package mybatis.service;

import mybatis.model.SysTask;
import mybatis.model.TaskSubmitRecord;
import java.util.List;

public interface TaskSubmitService {
    /**
     * 提交作业
     * @param taskSubmitRecord
     * @return
     */
    Integer insert(TaskSubmitRecord taskSubmitRecord);

    /**
     * 重新提交作业
     * @param taskSubmitRecord
     * @return
     */
    boolean update(TaskSubmitRecord taskSubmitRecord);

    /**
     * 获取我提交的作业列表
     * @param account
     * @return
     */
    List<TaskSubmitRecord> getMySubmitList(String account);

    /**
     * 获得是否提交列表 1代表有提交/0代表未提交/-1代表过期/-2组长本人发布
     * @param sysTaskList
     * @return
     */
    List<Integer> getIsSubmitList(List<SysTask> sysTaskList ,String submitAccount);
}
