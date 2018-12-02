package mybatis.service;

import com.github.pagehelper.Constant;
import mybatis.mapper.BaseMapper;
import mybatis.mapper.ScoreRecordMapper;
import mybatis.mapper.SysActivityMapper;
import mybatis.model.ScoreRecord;
import mybatis.model.ScoreRecordExample;
import org.apache.ibatis.session.SqlSession;

import javax.naming.ldap.ManageReferralControl;
import java.util.ArrayList;
import java.util.List;

import static mybatis.util.Constants.MANAGER;
import static mybatis.util.Constants.SUPRE_MANAGER;

public class ScoreRecordServiceImpl extends BaseMapper implements ScoreRecordService, Constant {

    @Override
    public synchronized Integer insert(ScoreRecord scoreRecord){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ScoreRecordMapper scoreRecordMapper=sqlSession.getMapper(ScoreRecordMapper.class);
            Integer insertNum=scoreRecordMapper.insertSelective(scoreRecord);
            return insertNum;
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
    public List<ScoreRecord> getMyScoreRecordList(String userAccount, Integer role){
        SqlSession sqlSession=this.getSqlSession();
        try{
            ScoreRecordMapper scoreRecordMapper=sqlSession.getMapper(ScoreRecordMapper.class);
            ScoreRecordExample example=new ScoreRecordExample();
            example.setOrderByClause(" sr_time desc");
            ScoreRecordExample.Criteria criteria=example.createCriteria();
            List<ScoreRecord> scoreRecordList=new ArrayList<>();
            if(role.equals(MANAGER)||role.equals(SUPRE_MANAGER)){
                criteria.andSrManagerAccountEqualTo(userAccount);
                scoreRecordList=scoreRecordMapper.selectByExample(example);
            }
            else{
                criteria.andSrAccountEqualTo(userAccount);
                scoreRecordList=scoreRecordMapper.selectByExample(example);
            }
            return scoreRecordList;
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
