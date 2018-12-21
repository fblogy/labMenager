package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysAnnouncementMapper;
import mybatis.model.SysAnnouncement;
import mybatis.model.SysAnnouncementExample;
import mybatis.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SysAnnouncementServiceImpl extends BaseMapper implements SysAnnouncementService {

    @Override
    public boolean addAnnouncement(SysAnnouncement sysAnnouncement){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysAnnouncementMapper sysAnnouncementMapper=sqlSession.getMapper(SysAnnouncementMapper.class);
            Integer insertNum=sysAnnouncementMapper.insertSelective(sysAnnouncement);
            if(insertNum>0){
                return true;
            }
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

    @Override
    public Boolean delAnnouncement(Integer id){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysAnnouncementMapper sysAnnouncementMapper=sqlSession.getMapper(SysAnnouncementMapper.class);
            Integer delNum=sysAnnouncementMapper.deleteByPrimaryKey(id);
            if(delNum>0){
                return true;
            }
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

    @Override
    public List<SysAnnouncement> searchAnnouncement(String search){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysAnnouncementMapper sysAnnouncementMapper=sqlSession.getMapper(SysAnnouncementMapper.class);
            SysAnnouncementExample example=new SysAnnouncementExample();
            if(StringUtil.isNotEmpty(search)){
                SysAnnouncementExample.Criteria or=example.or();
                or.andAnTextLike("%"+search+"%");
                SysAnnouncementExample.Criteria or2=example.or();
                or2.andAnNameLike("%"+search+"%");
            }
            List<SysAnnouncement> sysAnnouncementList=sysAnnouncementMapper.selectByExample(example);
            return sysAnnouncementList;
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
    public List<SysAnnouncement> getAnnouncementList(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysAnnouncementMapper sysAnnouncementMapper=sqlSession.getMapper(SysAnnouncementMapper.class);
            SysAnnouncementExample example=new SysAnnouncementExample();
            List<SysAnnouncement> sysAnnouncementList=sysAnnouncementMapper.selectByExample(example);
            return sysAnnouncementList;
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
