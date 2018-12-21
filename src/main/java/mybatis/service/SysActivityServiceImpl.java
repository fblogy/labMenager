package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysActivityMapper;
import mybatis.model.SysActivity;
import mybatis.model.SysActivityExample;
import mybatis.util.Constants;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysActivityServiceImpl extends BaseMapper implements SysActivityService, Constants {

    @Override
    public SysActivity addActivity(SysActivity sysActivity){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            Integer insertNum=sysActivityMapper.insertSelective(sysActivity);
            if(insertNum>0){
                return sysActivity;
            }
            else {
                return null;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer modifyActivity(SysActivity sysActivity){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            Integer updateNum=sysActivityMapper.updateByPrimaryKeySelective(sysActivity);
            return updateNum;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean deleteActivityByID(SysActivity sysActivity){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            Integer insertNum=sysActivityMapper.deleteByPrimaryKey(sysActivity.getId());
            if(insertNum>0){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysActivity> getMyActivityListByUserAccount(SysActivity sysActivity){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            List<SysActivity> sysActivityList=sysActivityMapper.getMyActivityList(sysActivity.getActivityAccount());
            return sysActivityList;
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
    public List<SysActivity> getApplyingActivityList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            Date date=new Date();
            SysActivityExample example=new SysActivityExample();
            SysActivityExample.Criteria criteria=example.createCriteria();
            example.setOrderByClause("activity_begin_time desc");
            criteria.andActivityEndTimeLessThan(date);
            criteria.andActivityStatusEqualTo(ACTIVITY_WAITING);
            List<SysActivity> sysActivityList=sysActivityMapper.selectByExample(example);
            return sysActivityList;
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
    public List<SysActivity> getOverActivityList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            Date date=new Date();
            SysActivityExample example=new SysActivityExample();
            SysActivityExample.Criteria criteria=example.createCriteria();
            example.setOrderByClause("activity_end_time desc");
            criteria.andActivityEndTimeLessThan(date);
            criteria.andActivityStatusEqualTo(ACTIVITY_OVER);
            List<SysActivity> sysActivityList=sysActivityMapper.selectByExample(example);
            return sysActivityList;
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
    public List<SysActivity> getHoldingActivityList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            List<SysActivity> sysActivityList=new ArrayList<>();
            Date date=new Date();
            SysActivityExample example=new SysActivityExample();
            SysActivityExample.Criteria criteria=example.createCriteria();
            example.setOrderByClause("activity_begin_time asc");
            criteria.andActivityBeginTimeGreaterThan(date);
            criteria.andActivityStatusEqualTo(ACTIVITY_SUCCESS.shortValue());//审核成功的活动
            sysActivityList=sysActivityMapper.selectByExample(example);
            return sysActivityList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<SysActivity>();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean isPassActivity(Short result, Integer activityID){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);

            SysActivity sysActivity=new SysActivity();
            sysActivity.setActivityStatus(result);
            sysActivity.setId(activityID);
            int updateNum=sysActivityMapper.updateByPrimaryKeySelective(sysActivity);
            if(updateNum>0)
                return true;
            else
                return false;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

}
