package mybatis.service;

import mybatis.model.SysRole;

public interface SysRoleService {

    /**
     * 查找角色有无权限
     * @param roleInt
     * @param priStr
     * @return
     */
    boolean selectRolePrivilege(Integer roleInt,String priStr);


}
