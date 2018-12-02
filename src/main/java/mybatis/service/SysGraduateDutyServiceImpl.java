package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysGraduateDutyMapper;
import mybatis.model.SysGraduateDuty;
import mybatis.model.SysGraduateDutyExample;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SysGraduateDutyServiceImpl extends BaseMapper implements SysGraduateDutyService {

    @Override
    public List<SysGraduateDuty> getGraduateDutyList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysGraduateDutyMapper sysGraduateDutyMapper=sqlSession.getMapper(SysGraduateDutyMapper.class);
            SysGraduateDutyExample example=new SysGraduateDutyExample();
            SysGraduateDutyExample.Criteria criteria=example.createCriteria();
            criteria.andGraduateDutyOrderonweekGreaterThan(-1);
            List<SysGraduateDuty> graduateDutyList=sysGraduateDutyMapper.selectByExample(example);
            return graduateDutyList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }

    }

    @Override
    public synchronized boolean updateGraduateDutyList(List<SysGraduateDuty> sysGraduateDutyList){
        SqlSession sqlSession=this.getSqlSession();
        Integer updateNum=0;
        try{
            SysGraduateDutyMapper sysGraduateDutyMapper=sqlSession.getMapper(SysGraduateDutyMapper.class);
            for(SysGraduateDuty item:sysGraduateDutyList){
                updateNum+=sysGraduateDutyMapper.updateByPrimaryKey(item);
            }
            if(updateNum==sysGraduateDutyList.size()){
                sqlSession.commit();
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }
}