package mybatis.service;

import com.github.pagehelper.Constant;
import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysTaskMapper;
import mybatis.mapper.TaskSubmitRecordMapper;
import mybatis.model.SysTask;
import mybatis.model.TaskSubmitRecord;
import mybatis.model.TaskSubmitRecordExample;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static mybatis.util.Constants.TASK_SUBMIT_LATE;

public class TaskSubmitServiceImpl extends BaseMapper implements TaskSubmitService , Constant {

    @Override
    public synchronized Integer insert(TaskSubmitRecord taskSubmitRecord){
        SqlSession sqlSession=this.getSqlSession();
        try{
            TaskSubmitRecordMapper taskSubmitRecordMapper=sqlSession.getMapper(TaskSubmitRecordMapper.class);
            SysTaskMapper sysTaskMapper=sqlSession.getMapper(SysTaskMapper.class);
            SysTask sysTask=sysTaskMapper.selectByPrimaryKey(taskSubmitRecord.getTaskId());
            Date endTime=sysTask.getTaskEndTime();//获取作业提交截至时间
            Date now=taskSubmitRecord.getTaskSubmitTime();
            if(now.compareTo(endTime)>0)
                return TASK_SUBMIT_LATE;//作业提交过期
            else {
                Integer insertNum=taskSubmitRecordMapper.insertSelective(taskSubmitRecord);
                return insertNum;
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
    public List<TaskSubmitRecord> getMySubmitList(String account){
        SqlSession sqlSession=this.getSqlSession();
        try{
            TaskSubmitRecordMapper taskSubmitRecordMapper=sqlSession.getMapper(TaskSubmitRecordMapper.class);
            TaskSubmitRecordExample example=new TaskSubmitRecordExample();
            TaskSubmitRecordExample.Criteria criteria=example.createCriteria();
            criteria.andTaskSubmitAccountEqualTo(account);
            List<TaskSubmitRecord> taskSubmitRecordList=taskSubmitRecordMapper.selectByExample(example);
            if(taskSubmitRecordList.size()>0){
                return taskSubmitRecordList;
            }
            else {
                return new ArrayList<>();
            }
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
    public List<Integer> getIsSubmitList(List<SysTask> sysTaskList ,String submitAccount){
        SqlSession sqlSession=this.getSqlSession();
        try{
            TaskSubmitRecordMapper taskSubmitRecordMapper=sqlSession.getMapper(TaskSubmitRecordMapper.class);
            List<Integer> isSubmitList=new ArrayList<>();
            Date now=new Date();
            for(SysTask item:sysTaskList){
                if(item.getTaskAccount().equals(submitAccount)){
                    isSubmitList.add(-2);//这个作业是组长本人发布的
                    continue;
                }
                if(now.compareTo(item.getTaskEndTime())>0){//已过作业提交截至日期,过期为-1
                    isSubmitList.add(-1);
                    continue;
                }
                TaskSubmitRecordExample example=new TaskSubmitRecordExample();
                TaskSubmitRecordExample.Criteria criteria=example.createCriteria();
                criteria.andTaskIdEqualTo(item.getId());
                criteria.andTaskSubmitAccountEqualTo(submitAccount);
                List<TaskSubmitRecord> taskSubmitRecordList=taskSubmitRecordMapper.selectByExample(example);
                if(taskSubmitRecordList.size()>0){//有记录，已提交
                    isSubmitList.add(1);
                }
                else {
                    isSubmitList.add(0);//无记录，未提交
                }
            }
            return isSubmitList;
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
    public boolean update(TaskSubmitRecord taskSubmitRecord){
        SqlSession sqlSession=this.getSqlSession();
        try{
            TaskSubmitRecordMapper taskSubmitRecordMapper=sqlSession.getMapper(TaskSubmitRecordMapper.class);
            Integer updateNum=taskSubmitRecordMapper.updateByPrimaryKeySelective(taskSubmitRecord);
            if(updateNum>0){
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
}
