package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysRoleMapper;
import mybatis.model.SysRole;
import org.apache.ibatis.session.SqlSession;

public class SysRoleServiceImpl extends BaseMapper implements SysRoleService{

    @Override
    public boolean selectRolePrivilege(Integer roleInt, String priStr){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysRoleMapper sysRoleMapper=sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole=sysRoleMapper.selectRolePrivilege(roleInt,priStr);
            if(sysRole==null){
                return false;//没有权限
            }
            else {
                return true;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }
}
