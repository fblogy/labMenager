package mybatis.service;

import java.util.List;
import mybatis.model.SysHealthHead;

public interface SysHealthHeadService {

    /**
     * 批量插入卫生负责人记录
     * @param sysHealthHeadList
     * @return
     */
    Integer insertList(List<SysHealthHead> sysHealthHeadList);

    /**
     * 插入之前删除所有
     * @return
     */
    Integer deleteAll();

    /**
     * 获取所有记录
     * @return
     */
    List<SysHealthHead> getHealthHeadList();


}
