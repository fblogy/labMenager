package mybatis.mapper;

import mybatis.model.ActivityMembers;
import mybatis.model.SysGraduateDuty;
import mybatis.model.SysGraduateDutyExample;
import mybatis.service.ActivityMembersService;
import mybatis.service.ActivityMembersServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ActivityMembersTest extends BaseMapper{
    @Test
    public void test(){
        SqlSession sqlSession=this.getSqlSession();
        try{
//           ActivityMembersMapper activityMembersMapper=sqlSession.getMapper(ActivityMembersMapper.class);
//            ActivityMembersService activityMembersService=new ActivityMembersServiceImpl();
//            ActivityMembers activityMembers=new ActivityMembers();
//            activityMembers.setActivityId(15);
//            System.out.println(activityMembersService.getAttendCountByActivityIDAndAccount(activityMembers));
        }
        finally {
            sqlSession.close();
        }
    }
}
