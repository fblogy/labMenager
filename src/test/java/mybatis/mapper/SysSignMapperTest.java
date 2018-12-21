package mybatis.mapper;

import mybatis.model.SignUserAndCount;
import mybatis.model.SysRole;
import mybatis.model.SysRoleExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SysSignMapperTest extends BaseMapper{
    @Test
    public void getTopSignCountByYearAndMonthTest(){
        SqlSession sqlSession = this.getSqlSession();
        try {
            SysSignMapper sysSignMapper=sqlSession.getMapper(SysSignMapper.class);
            List<SignUserAndCount> list=new ArrayList<>();
            list=sysSignMapper.getTopSignCountByYearAndMonth("2018-08-01","2018-08-31",3);
            for(SignUserAndCount item:list){
                System.out.print(item.getUserAccount()+" "+item.getUserName()+" "+item.getSignCount());
            }
        } finally {
            sqlSession.close();
        }





    }
}
