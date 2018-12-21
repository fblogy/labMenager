package mybatis.service;

import mybatis.model.SysActivity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysActivityService {

    /**
     * 增加活动
     * @param sysActivity
     * @return
     */
    SysActivity addActivity(SysActivity sysActivity);

    /**
     * 修改活动
     * @param sysActivity
     * @return
     */
    Integer modifyActivity(SysActivity sysActivity);

    /**
     * 删除活动通过id
     * @param sysActivity
     * @return
     */
    boolean deleteActivityByID(SysActivity sysActivity);

    /**
     * 我参加的活动列表
     * @param sysActivity
     * @return
     */
    List<SysActivity> getMyActivityListByUserAccount(SysActivity sysActivity);

    /**
     * 获得已结束的活动列表
     * @return
     */
    List<SysActivity> getOverActivityList();

    /**
     * 获得正在进行的活动列表
     * @return
     */
    List<SysActivity> getHoldingActivityList();

    /**
     * 获取申请中的活动列表
     * @return
     */
    List<SysActivity> getApplyingActivityList();

    /**
     * 是否通过审核该活动
     * @param result
     * @return
     */
    boolean isPassActivity(Short result ,Integer activityID);



}
