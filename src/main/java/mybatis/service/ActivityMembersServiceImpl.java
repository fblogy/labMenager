package mybatis.service;

import mybatis.mapper.ActivityMembersMapper;
import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysActivityMapper;
import mybatis.model.ActivityMembers;
import mybatis.model.ActivityMembersExample;
import mybatis.model.SysActivity;
import mybatis.model.SysActivityExample;
import mybatis.util.Constants;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityMembersServiceImpl extends BaseMapper implements ActivityMembersService, Constants {
    @Override
    public Integer insert(ActivityMembers activityMembers){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ActivityMembersMapper activityMembersMapper=sqlSession.getMapper(ActivityMembersMapper.class);

            SysActivityMapper sysActivityMapper=sqlSession.getMapper(SysActivityMapper.class);
            SysActivity sysActivity=sysActivityMapper.selectByPrimaryKey(activityMembers.getActivityId());
            Date curDate=new Date();
            Integer currentAccount=this.getAttendCountByActivityID(activityMembers.getActivityId());
            Short max=sysActivity.getActivityMax();
            if((curDate.compareTo(sysActivity.getActivityBeginTime()))>0){
                return ACTIVITY_LATE;
            }
            else if (currentAccount.shortValue()>=max){
                return ACTIVITY_FULL;
            }
            else {
                ActivityMembersExample example=new ActivityMembersExample();
                ActivityMembersExample.Criteria criteria=example.createCriteria();
                criteria.andActivityIdEqualTo(activityMembers.getActivityId());
                criteria.andActivityAccountEqualTo(activityMembers.getActivityAccount());
                List<ActivityMembers> activityMembersList=activityMembersMapper.selectByExample(example);
                if(activityMembersList.size()>0){//已经报过名
                    return ACTIVITY_ATTENDED;
                }
                else {
                    int insertNum=activityMembersMapper.insertSelective(activityMembers);
                    if(insertNum>0){
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
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
    public Integer getAttendCountByActivityID(Integer activityID){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ActivityMembersMapper activityMembersMapper=sqlSession.getMapper(ActivityMembersMapper.class);
            ActivityMembersExample example=new ActivityMembersExample();
            ActivityMembersExample.Criteria criteria=example.createCriteria();
            criteria.andActivityIdEqualTo(activityID);
            Integer attendCount=activityMembersMapper.countByExample(example);
            return attendCount;
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
    public Integer outActivity(ActivityMembers activityMembers){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ActivityMembersMapper activityMembersMapper=sqlSession.getMapper(ActivityMembersMapper.class);
            ActivityMembersExample example=new ActivityMembersExample();
            ActivityMembersExample.Criteria criteria=example.createCriteria();
            criteria.andActivityIdEqualTo(activityMembers.getActivityId());
            criteria.andActivityAccountEqualTo(activityMembers.getActivityAccount());
            Integer deleteNum=activityMembersMapper.deleteByExample(example);
            return deleteNum;
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
}
