package mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseMapper {
    protected static SqlSessionFactory sqlSessionFactory;

    public BaseMapper(){
        //创建Spring容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        sqlSessionFactory=(SqlSessionFactory) ctx.getBean("sqlSessionFactory");
    }
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(false);//当前所有操作为一次事务
    }
}
