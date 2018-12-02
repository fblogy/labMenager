package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.ProjectMembersMapper;
import mybatis.mapper.SysProjectMapper;
import mybatis.model.*;
import mybatis.util.Constants;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysProjectServiceImpl extends BaseMapper implements SysProjectService, Constants {

    @Override
    public boolean addProject(SysProject sysProject){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            Integer insertNum=sysProjectMapper.insertSelective(sysProject);
            if(insertNum>0){
                /**
                 * 项目发布成功后默认把项目负责人加入到项目报名里，且默认审核通过
                 */
                ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
                ProjectMembers projectMembers=new ProjectMembers();
                projectMembers.setProjectId(sysProject.getId());
                projectMembers.setProjectAccount(sysProject.getProjectAccount());
                projectMembers.setPmStatus(1);//默认审核通过
                projectMembers.setPmTime(new Date());
                projectMembers.setPmReason("项目发起人");
                projectMembersMapper.insertSelective(projectMembers);
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
    public boolean deleteProjectByID(SysProject sysProject){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            Integer deleteNum=sysProjectMapper.deleteByPrimaryKey(sysProject.getId());
            if(deleteNum>0){
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
    public synchronized boolean modifyProjectByID(SysProject sysProject){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            Integer updateNum=sysProjectMapper.updateByPrimaryKeySelective(sysProject);
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

    @Override
    public List<SysProject> getOverProjectList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            Date today=new Date();
            SysProjectExample example=new SysProjectExample();
            SysProjectExample.Criteria criteria=example.createCriteria();
            criteria.andProjectStatusEqualTo(PROJECT_END);
            criteria.andProjectEndTimeLessThan(today);
            List<SysProject> sysProjectList=sysProjectMapper.selectByExample(example);
            return sysProjectList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return new ArrayList<>();

        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysProject> getDoingProjectList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            Date today=new Date();
            SysProjectExample example=new SysProjectExample();
            SysProjectExample.Criteria criteria=example.createCriteria();
            criteria.andProjectStatusEqualTo(PROJECT_DOING);
            criteria.andProjectBeginTimeLessThanOrEqualTo(today);
            criteria.andProjectEndTimeGreaterThanOrEqualTo(today);
            List<SysProject> sysProjectList=sysProjectMapper.selectByExample(example);
            return sysProjectList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysProject> getMyProjectList(String userAccount ,Integer role){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            List<SysProject> sysProjectList=new ArrayList<>();
            if(role.equals(PROJECT_RESPONSER)){//项目负责人获取我发布的项目
                SysProjectExample example=new SysProjectExample();
                SysProjectExample.Criteria criteria=example.createCriteria();
                criteria.andProjectAccountEqualTo(userAccount);
                sysProjectList=sysProjectMapper.selectByExample(example);
            }
            else{//其他人获取我参加的项目
                sysProjectList=sysProjectMapper.getMyProjectList(userAccount);
            }
            return sysProjectList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }
}