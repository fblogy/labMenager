package mybatis.mapper;

import mybatis.model.SysHealthHead;
import mybatis.service.SysHealthHeadService;
import mybatis.service.SysHealthHeadServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SysHealthHeadTest extends BaseMapper{

    @Test
    public void insertListTest(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysHealthHeadMapper sysHealthHeadMapper=sqlSession.getMapper(SysHealthHeadMapper.class);
            SysHealthHeadService sysHealthHeadService=new SysHealthHeadServiceImpl();

            List<SysHealthHead> sysHealthHeadList=new ArrayList<>();
            SysHealthHead sysHealthHead1=new SysHealthHead();
            SysHealthHead sysHealthHead2=new SysHealthHead();
            sysHealthHead1.setId(3);
            sysHealthHead1.setHealthAccount("221600416");
            sysHealthHead1.setHealthName("黄海山");
            sysHealthHead1.setHealthWeekOrder(1);

            sysHealthHead2.setId(4);
            sysHealthHead2.setHealthAccount("221600417");
            sysHealthHead2.setHealthName("黄海涛");
            sysHealthHead2.setHealthWeekOrder(2);

            sysHealthHeadList.add(sysHealthHead1);
            sysHealthHeadList.add(sysHealthHead2);

            Integer inserNum=sysHealthHeadService.insertList(sysHealthHeadList);
            System.out.println(inserNum);
        }
        finally {
            sqlSession.close();
        }
    }
}
