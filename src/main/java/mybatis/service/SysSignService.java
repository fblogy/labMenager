package mybatis.service;

import mybatis.model.SignUserAndCount;
import mybatis.model.SysSign;

import java.util.List;

public interface SysSignService {

    /**
     * 获得签到前三名
     * @param beginDate
     * @param endDate
     * @return
     */
    List<SignUserAndCount> getTopSignCountByYearAndMonth(String beginDate,String endDate);

    /**
     * 导入签到记录
     * @param sysSignList
     * @return
     */
    Integer insertList(List<SysSign> sysSignList);
}
