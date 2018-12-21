package mybatis.mapper;

import mybatis.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SysRoleMapperTest extends BaseMapper {
    @Test
    public void rolePriTest(){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysRoleMapper sysRoleMapper=sqlSession.getMapper(SysRoleMapper.class);
            SysRole sysRole=sysRoleMapper.selectRolePrivilege(6,"53");
            if(sysRole==null){
                System.out.println("没有权限");
            }
            else {
                System.out.println(sysRole.getId());
            }
        }
        finally {
            sqlSession.close();
        }
    }
}
