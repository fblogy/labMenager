package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysGroupMapper;
import mybatis.model.SysGroup;
import mybatis.model.SysGroupExample;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SysGroupServiceImpl extends BaseMapper implements SysGroupService  {

    @Override
    public String selectGroupNameByAccount(String account){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysGroupMapper sysGroupMapper=sqlSession.getMapper(SysGroupMapper.class);
            SysGroupExample example=new SysGroupExample();
            SysGroupExample.Criteria criteria=example.createCriteria();
            criteria.andGroupMemberEqualTo(account);
            List<SysGroup> sysGroupList=sysGroupMapper.selectByExample(example);
            return sysGroupList.get(0).getGroupName();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }
}
