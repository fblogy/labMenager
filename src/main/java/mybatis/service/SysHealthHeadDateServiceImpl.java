package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysHealthHeadDateMapper;
import mybatis.model.SysHealthHeadDate;
import mybatis.model.SysHealthHeadDateExample;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class SysHealthHeadDateServiceImpl extends BaseMapper implements SysHealthHeadDateService {

    @Override
    public synchronized boolean update(Date date) {
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysHealthHeadDateMapper sysHealthHeadDateMapper = sqlSession.getMapper(SysHealthHeadDateMapper.class);
            SysHealthHeadDateExample example=new SysHealthHeadDateExample();
            SysHealthHeadDateExample.Criteria criteria=example.createCriteria();
            SysHealthHeadDate sysHealthHeadDate=new SysHealthHeadDate();
            sysHealthHeadDate.setId(1);//表里只有唯一一条数据
            sysHealthHeadDate.setHealthHeadDate(date);

            Integer updateNum=sysHealthHeadDateMapper.updateByPrimaryKey(sysHealthHeadDate);

            if(updateNum>0){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
            return false;

        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Date getDate(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysHealthHeadDateMapper sysHealthHeadDateMapper = sqlSession.getMapper(SysHealthHeadDateMapper.class);
            SysHealthHeadDateExample example=new SysHealthHeadDateExample();
            SysHealthHeadDateExample.Criteria criteria=example.createCriteria();
            SysHealthHeadDate sysHealthHeadDate=sysHealthHeadDateMapper.selectByPrimaryKey(1);
            return sysHealthHeadDate.getHealthHeadDate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        } finally {
            sqlSession.close();
        }
    }
}
