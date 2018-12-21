package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysHealthHeadMapper;
import mybatis.mapper.SysSignMapper;
import mybatis.model.SignUserAndCount;
import mybatis.model.SysSign;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSignServiceImpl extends BaseMapper implements SysSignService, Constants {

    @Override
    public List<SignUserAndCount> getTopSignCountByYearAndMonth(String beginDate,String endDate){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysSignMapper sysSignMapper=sqlSession.getMapper(SysSignMapper.class);
            List<SignUserAndCount> signUserAndCountList=sysSignMapper.getTopSignCountByYearAndMonth(beginDate,endDate,SIGN_TOP_COUNT);
            return signUserAndCountList;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer insertList(List<SysSign> sysSignList){
        SqlSession sqlSession=this.getSqlSession();
        int insertNum=0;
        try{
            SysSignMapper sysSignMapper=sqlSession.getMapper(SysSignMapper.class);
            insertNum=sysSignMapper.insertList(sysSignList);
            if(insertNum==sysSignList.size()){
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
}
