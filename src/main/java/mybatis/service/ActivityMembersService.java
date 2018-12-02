package mybatis.service;

import mybatis.model.ActivityMembers;

public interface ActivityMembersService {

    /**
     * 插入一条记录,报名活动,考虑是否超出最大人数以及开始时间
     * @param activityMembers
     * @return
     */
    Integer insert(ActivityMembers activityMembers);

    /**
     * 退出活动
     * @param activityMembers
     * @return
     */
    Integer outActivity(ActivityMembers activityMembers);

    /**
     * 获取活动参与人数
     * @param activityID
     * @return
     */
    Integer getAttendCountByActivityID(Integer activityID);
}
