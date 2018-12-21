package mybatis.service;

import mybatis.model.SysGroup;

public interface SysGroupService {

    /**
     * 获取所在组
     * @param account
     * @return
     */
    String selectGroupNameByAccount(String account);

}
