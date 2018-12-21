package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysHealthHeadMapper;
import mybatis.model.SysHealthHead;
import mybatis.model.SysHealthHeadExample;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SysHealthHeadServiceImpl extends BaseMapper implements SysHealthHeadService {

    @Override
    public Integer insertList(List<SysHealthHead> sysHealthHeadList) {
        SqlSession sqlSession=this.getSqlSession();
        int insertNum=0;
        try{
            SysHealthHeadMapper sysHealthHeadMapper=sqlSession.getMapper(SysHealthHeadMapper.class);
            insertNum=sysHealthHeadMapper.insertList(sysHealthHeadList);
            if(insertNum==sysHealthHeadList.size()){
                return insertNum;
            }
            else{
                return 0;
            }
        }
        catch(Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer deleteAll() {
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysHealthHeadMapper sysHealthHeadMapper=sqlSession.getMapper(SysHealthHeadMapper.class);
            SysHealthHeadExample example=new SysHealthHeadExample();
            SysHealthHeadExample.Criteria criteria=example.createCriteria();
            criteria.andIdGreaterThan(-1);//全部删除
            Integer deleteNum=sysHealthHeadMapper.deleteByExample(example);
            return deleteNum;
        }
        catch(Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return -1;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysHealthHead> getHealthHeadList() {
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysHealthHeadMapper sysHealthHeadMapper=sqlSession.getMapper(SysHealthHeadMapper.class);
            SysHealthHeadExample example=new SysHealthHeadExample();
            example.setOrderByClause("health_week_order asc");
            SysHealthHeadExample.Criteria criteria=example.createCriteria();
            criteria.andIdGreaterThan(-1);//选择全部
            List<SysHealthHead> sysHealthHeadList=sysHealthHeadMapper.selectByExample(example);
            return sysHealthHeadList;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }
}
