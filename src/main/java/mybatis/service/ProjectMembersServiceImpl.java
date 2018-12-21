package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.ProjectMembersMapper;
import mybatis.mapper.SysProjectMapper;
import mybatis.model.ProjectMembers;
import mybatis.model.ProjectMembersExample;
import mybatis.model.SysProject;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import org.apache.ibatis.session.SqlSession;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectMembersServiceImpl extends BaseMapper implements ProjectMemberService, Constants {
    @Override
    public Integer applyToJoinProject(ProjectMembers projectMembers) {
        SqlSession sqlSession=this.getSqlSession();
        Integer insertNum=0;
        Date date=new Date();
        date= DateUtil.formatString(DateUtil.formatDate(date,FORMAT),FORMAT);//防止出现日期相等但是却判断不等的情况
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            SysProjectMapper sysProjectMapper=sqlSession.getMapper(SysProjectMapper.class);
            SysProject sysProject=sysProjectMapper.selectByPrimaryKey(projectMembers.getProjectId());
            Integer attendNum=this.getAttendCountByProjectID(projectMembers.getProjectId());
            if(attendNum>=sysProject.getProjectRequired()){
                return PROJECT_FULL;
            }
            else if(date.compareTo(sysProject.getProjectBeginTime())>0){
                return PROJECT_LATE;
            }
            else {
                ProjectMembersExample example=new ProjectMembersExample();
                ProjectMembersExample.Criteria criteria=example.createCriteria();
                criteria.andProjectIdEqualTo(projectMembers.getProjectId());
                criteria.andProjectAccountEqualTo(projectMembers.getProjectAccount());
                List<ProjectMembers> projectMembersList=projectMembersMapper.selectByExample(example);
                if(projectMembersList.size()>0){//已经报过名了
                    return PROJECT_ATTENDED;
                }
                else {
                    insertNum=projectMembersMapper.insertSelective(projectMembers);
                    if(insertNum>0){
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer applyToOutProject(ProjectMembers projectMembers){
        SqlSession sqlSession=this.getSqlSession();
        Integer deleteNum=0;
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            ProjectMembersExample example=new ProjectMembersExample();
            ProjectMembersExample.Criteria criteria=example.createCriteria();
            criteria.andProjectIdEqualTo(projectMembers.getProjectId());
            criteria.andProjectAccountEqualTo(projectMembers.getProjectAccount());
            deleteNum=projectMembersMapper.deleteByExample(example);
            return deleteNum;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer getAttendCountByProjectID(Integer projectID) {
        SqlSession sqlSession=this.getSqlSession();
        Integer attendNum=0;
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            ProjectMembersExample example=new ProjectMembersExample();
            ProjectMembersExample.Criteria criteria=example.createCriteria();
            criteria.andProjectIdEqualTo(projectID);
            criteria.andPmStatusEqualTo(1);//1表示审核通过
            attendNum=projectMembersMapper.countByExample(example);
            return attendNum;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer isPassProjectApply(ProjectMembers projectMembers){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);

            ProjectMembersExample example=new ProjectMembersExample();
            ProjectMembersExample.Criteria criteria=example.createCriteria();
            criteria.andProjectIdEqualTo(projectMembers.getProjectId());
            criteria.andProjectAccountEqualTo(projectMembers.getProjectAccount());

            ProjectMembers record=new ProjectMembers();
            record.setPmStatus(projectMembers.getPmStatus());

            Integer updateNum=projectMembersMapper.updateByExampleSelective(record,example);
            return updateNum;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean isAttendProject(String userAccount,Integer projectId){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            ProjectMembersExample example=new ProjectMembersExample();
            ProjectMembersExample.Criteria criteria=example.createCriteria();
            criteria.andProjectIdEqualTo(projectId);
            criteria.andProjectAccountEqualTo(userAccount);
            List<ProjectMembers> list=projectMembersMapper.selectByExample(example);
            if(list.size()>0){
                return true;
            }
            return false;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer getApplyStatus(String userAccount,Integer projectId){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            ProjectMembersExample example=new ProjectMembersExample();
            ProjectMembersExample.Criteria criteria=example.createCriteria();
            criteria.andProjectIdEqualTo(projectId);
            criteria.andProjectAccountEqualTo(userAccount);
            List<ProjectMembers> list=projectMembersMapper.selectByExample(example);
            //0待审核/1通过/-1淘汰/2我发起
            if(list.size()>0){
                return list.get(0).getPmStatus();
            }
            return 0;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<ProjectMembers> getApplyerList(String publisher){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ProjectMembersMapper projectMembersMapper=sqlSession.getMapper(ProjectMembersMapper.class);
            List<ProjectMembers> list=projectMembersMapper.getApplyerList(publisher);
            return list;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }
}
