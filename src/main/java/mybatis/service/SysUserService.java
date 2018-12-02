package mybatis.service;

import mybatis.model.SysRole;
import mybatis.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 用户登录
     *
     * @paramSysUser
     * @return
     */
    Integer login(SysUser sysUser);

    /**
     * 用户增加
     *
     * @paramSysUser
     * @return
     */
    Integer addSysUser(SysUser sysUser);

    /**
     * 批量导入用户
     * @param sysUserList
     * @return
     */
    String addSysUserList(List<SysUser> sysUserList);

    /**
     * 查询积分
     * @param sysUser
     * @return
     */
    Integer getScoreByAccount(SysUser sysUser);

    /**
     * 查询我的积分排名
     * @param userAccount
     * @return
     */
    Integer getScoreRank(String userAccount);

    /**
     * 通过用户查询角色
     *
     * @paramSysUser
     * @return
     */
    List<SysRole> selectRoleByUser(SysUser sysUser);

    /**
     * 通过账号查找组别
     * @param userAccount
     * @return
     */
    String selectGroupByAccount(String userAccount);

    /**
     * 查找用户是否存在
     * @param userAccount
     * @return
     */
    boolean isExist(String userAccount);

    /**
     * 通过条件查询用户
     * @return
     */
    List<SysUser> selectUserList(String search);

    /**
     * 通过账号列表查询用户列表
     * @param accountList
     * @return
     */
    List<SysUser> selectUserNameByAccount(List<String> accountList);


    /**
     * 通过账号查找姓名
     * @param account
     * @return
     */
    String selectUserNameByAccount(String account);

    /**
     * 通过账号删除用户
     */
    boolean deleteUserByAccount(SysUser sysUser);

    /**
     * 更新工作位
     * @param sysUserList
     * @return
     */
    Integer updateSysUserSeat(List<SysUser> sysUserList);

    /**
     * 获得工作位列表
     * @return
     */
    List<SysUser> getSeatList();

    /**
     * 修改密码
     * @param sysUser
     * @return
     */
    Boolean modifyPass(SysUser sysUser);



}
