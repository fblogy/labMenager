package mybatis.service;

import mybatis.model.UserRole;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface UserRoleService {

    /**
     * 批量删除用户拥有的角色
     * @param userRoleArrayList
     * @return
     */
    Integer deleteList(ArrayList<UserRole> userRoleArrayList);

    /**
     * 为用户批量增加角色
     * @param userRoleList
     * @return
     */
    Integer insertList(ArrayList<UserRole> userRoleList);


}
