package mybatis.mapper;

import mybatis.model.SysRole;
import mybatis.model.SysSign;
import mybatis.model.SysUser;
import mybatis.model.SysUserExample;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserMapperTest extends BaseMapper{
    @Test
    public void loginTest(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);

            SysUserExample sysUserExample=new SysUserExample();
            SysUserExample.Criteria criteria=sysUserExample.createCriteria();
            criteria.andUserAccountEqualTo("221600416");
            criteria.andUserPasswordEqualTo("123456");

            List<SysUser> list=sysUserMapper.selectByExample(sysUserExample);
            System.out.println("数组大小");
            System.out.println(list.get(0).getUserName());
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void SelectRoleByUser(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);

            SysUser sysUser=new SysUser();
            sysUser.setUserAccount("221600417");
            List<SysRole> list =sysUserMapper.selectRoleByUser(sysUser);
            for(SysRole role:list){
                System.out.println(role.getRoleName());
            }
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    @Transactional
    public void testRollBack(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            //SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysSignMapper sysSignMapper=sqlSession.getMapper(SysSignMapper.class);

            SysSign sysSign1=new SysSign();
            SysSign sysSign2=new SysSign();
            SysSign sysSign3=new SysSign();

            sysSign1.setSignAccount("221600416");
            sysSign1.setSignName("黄海山1");
            sysSign1.setSignTime(new Date());

            sysSign2.setSignAccount("221600418");
            sysSign2.setSignName("黄海山2");
            sysSign2.setSignTime(null);

            sysSign3.setSignAccount("221600418");
            sysSign3.setSignName("黄海山3");
            sysSign3.setSignTime(new Date());

            sysSignMapper.insert(sysSign1);
            sysSignMapper.insert(sysSign2);
            sysSignMapper.insert(sysSign3);

//            List<SysSign> sysSignList=new ArrayList<>();
//            sysSignList.add(sysSign1);
//            sysSignList.add(sysSign2);
//            sysSignList.add(sysSign3);
//
//            Integer insertNum=sysSignMapper.insertList(sysSignList);
//            System.out.println("insertNum:"+insertNum);
        }
        catch (RuntimeException ex){
            sqlSession.rollback();
            System.out.println("Exception");
        }
        finally {
            sqlSession.close();
        }

    }
}
