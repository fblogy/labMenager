package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysUserMapper;
import mybatis.mapper.UserRoleMapper;
import mybatis.model.SysUser;
import mybatis.model.SysUserExample;
import mybatis.model.UserRole;
import mybatis.model.UserRoleExample;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class UserRoleServiceImpl extends BaseMapper implements UserRoleService {

    @Override
    public Integer deleteList(ArrayList<UserRole> userRoleArrayList){
        SqlSession sqlSession=this.getSqlSession();
        Integer deleteNum=0;
        try{
            UserRoleMapper userRoleMapper=sqlSession.getMapper(UserRoleMapper.class);
            for(UserRole userRole:userRoleArrayList){
                UserRoleExample example=new UserRoleExample();
                UserRoleExample.Criteria criteria=example.createCriteria();
                criteria.andUserAccountEqualTo(userRole.getUserAccount());
                criteria.andRoleIdEqualTo(userRole.getRoleId());
                deleteNum+=userRoleMapper.deleteByExample(example);
            }
            return deleteNum;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return deleteNum;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer insertList(ArrayList<UserRole> userRoleList){
        SqlSession sqlSession=this.getSqlSession();
        Integer addNum=0;
        try{
            UserRoleMapper userRoleMapper=sqlSession.getMapper(UserRoleMapper.class);
            addNum=userRoleMapper.insertList(userRoleList);
            return addNum;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return addNum;
        }
        finally {
            sqlSession.close();
        }
    }
}
