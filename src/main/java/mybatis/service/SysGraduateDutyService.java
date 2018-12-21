package mybatis.service;

import mybatis.model.SysGraduateDuty;
import java.util.List;

public interface SysGraduateDutyService {

    /**
     * 获取值日研究生列表
     * @return
     */
    List<SysGraduateDuty> getGraduateDutyList();

    /**
     * 更新值日研究生列表
     * @param sysGraduateDutyList
     * @return
     */
    boolean updateGraduateDutyList(List<SysGraduateDuty> sysGraduateDutyList);
}
