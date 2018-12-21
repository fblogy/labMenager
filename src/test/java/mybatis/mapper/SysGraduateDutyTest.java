package mybatis.mapper;

import mybatis.model.SysGraduateDuty;
import mybatis.model.SysGraduateDutyExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SysGraduateDutyTest extends BaseMapper {

    @Test
    public void updateGraduateDutyTest(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysGraduateDutyMapper sysGraduateDutyMapper=sqlSession.getMapper(SysGraduateDutyMapper.class);
            List<SysGraduateDuty> sysGraduateDutyList=new ArrayList<>();
            SysGraduateDuty sysGraduateDuty1=new SysGraduateDuty();
            sysGraduateDuty1.setId(1);
            sysGraduateDuty1.setGraduateDutyAccount("9999999999");
            sysGraduateDuty1.setGraduateDutyName("好好先生");
            sysGraduateDuty1.setGraduateDutyPhone("5555555555");
            sysGraduateDuty1.setGraduateDutyOrderonweek(1);

            SysGraduateDuty sysGraduateDuty2=new SysGraduateDuty();
            sysGraduateDuty2.setId(2);
            sysGraduateDuty2.setGraduateDutyAccount("88888888888");
            sysGraduateDuty2.setGraduateDutyName("好好先生");
            sysGraduateDuty2.setGraduateDutyPhone("666666666");
            sysGraduateDuty2.setGraduateDutyOrderonweek(2);

            sysGraduateDutyList.add(sysGraduateDuty1);
            sysGraduateDutyList.add(sysGraduateDuty2);

            Integer updateNum=0;
            for(SysGraduateDuty item:sysGraduateDutyList){
                SysGraduateDutyExample example=new SysGraduateDutyExample();
                SysGraduateDutyExample.Criteria criteria=example.createCriteria();

                updateNum+=sysGraduateDutyMapper.updateByPrimaryKey(item);
            }
            if(updateNum==sysGraduateDutyList.size()){
                sqlSession.commit();
                System.out.println(updateNum);
            }
        }
        finally {
            sqlSession.close();
        }

    }
}
