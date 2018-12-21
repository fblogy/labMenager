package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysTaskMapper;
import mybatis.model.SysTask;
import mybatis.model.SysTaskExample;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SysTaskServiceImpl extends BaseMapper implements SysTaskService {
    @Override
    public boolean publishTask(SysTask sysTask){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            Integer insertNum=sysTaskMapper.insertSelective(sysTask);
            if(insertNum>0){
                return true;
            }
            return false;
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }
    @Override
    public boolean deleteTaskById(Integer id){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            Integer deleteNum=sysTaskMapper.deleteByPrimaryKey(id);
            if(deleteNum>0){
                return true;
            }
            return false;
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysTask> getTaskList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            SysTaskExample example=new SysTaskExample();
            example.setOrderByClause("task_pub_time desc");
            SysTaskExample.Criteria criteria=example.createCriteria();
            criteria.andIdGreaterThan(-1);
            List<SysTask> sysTaskList=sysTaskMapper.selectByExample(example);
            return sysTaskList;
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
    public List<SysTask> getMyTaskList(String group){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            SysTaskExample example=new SysTaskExample();
            example.setOrderByClause("task_pub_time desc");
            SysTaskExample.Criteria criteria=example.createCriteria();
            criteria.andTaskGroupEqualTo(group);
            List<SysTask> sysTaskList=sysTaskMapper.selectByExample(example);
            return sysTaskList;
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public SysTask selectTaskById(Integer id){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            SysTaskExample example=new SysTaskExample();
            SysTaskExample.Criteria criteria=example.createCriteria();
            criteria.andIdEqualTo(id);
            SysTask sysTask=sysTaskMapper.selectByPrimaryKey(id);
            return sysTask;
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }
}
