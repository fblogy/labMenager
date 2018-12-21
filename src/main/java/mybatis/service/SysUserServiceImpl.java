package mybatis.service;

import mybatis.mapper.SysUserMapper;
import mybatis.model.SysRole;
import mybatis.model.SysUser;
import mybatis.model.SysUserExample;
import mybatis.mapper.BaseMapper;
import mybatis.util.Constants;
import mybatis.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SysUserServiceImpl extends BaseMapper implements SysUserService, Constants {

    @Override
    public Integer login(SysUser user){
        SqlSession sqlSession=this.getSqlSession();
        Integer loginNum=0;//登录结果
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);

            SysUserExample sysUserExample=new SysUserExample();
            SysUserExample.Criteria criteria=sysUserExample.createCriteria();
            criteria.andUserAccountEqualTo(user.getUserAccount());
            List<SysUser> list=sysUserMapper.selectByExample(sysUserExample);
            if(list.size()<=0){//说明用户账号不存在
                loginNum=-1;
            }
            else{
                SysUserExample sysUserExample2=new SysUserExample();
                SysUserExample.Criteria criteria2=sysUserExample2.createCriteria();
                criteria2.andUserAccountEqualTo(user.getUserAccount());
                criteria2.andUserPasswordEqualTo(user.getUserPassword());
                List<SysUser> list2=sysUserMapper.selectByExample(sysUserExample2);
                loginNum=list2.size();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
        finally {
            sqlSession.close();
        }
        return loginNum;
    }

    @Override
    public synchronized Boolean modifyPass(SysUser sysUser){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);

            SysUserExample sysUserExample=new SysUserExample();
            SysUserExample.Criteria criteria=sysUserExample.createCriteria();
            criteria.andUserAccountEqualTo(sysUser.getUserAccount());
            SysUser record=new SysUser();
            record.setUserPassword(sysUser.getUserPassword());
            int upNum=sysUserMapper.updateByExampleSelective(record,sysUserExample);
            if(upNum>0){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public Integer getScoreByAccount(SysUser sysUser){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);

            SysUserExample sysUserExample=new SysUserExample();
            SysUserExample.Criteria criteria=sysUserExample.createCriteria();
            criteria.andUserAccountEqualTo(sysUser.getUserAccount());
            List<SysUser> sysUserList=sysUserMapper.selectByExample(sysUserExample);
            if(sysUserList.size()>0){
                return sysUserList.get(0).getUserScore();
            }
            else {
                return -1;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public synchronized Integer modifyScoreByAccounts(List<String> userAccount ,Integer score){
        SqlSession sqlSession=this.getSqlSession();
        Integer updateNum;
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            updateNum=sysUserMapper.modifyScoreList(userAccount,score);
            return updateNum;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
        finally {
            sqlSession.close();
        }

    }

    @Override
    public Integer getScoreRank(String userAccount){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            Integer rank=sysUserMapper.getScoreRank(userAccount);
            return rank+1;//数据库第一名为0
        }
        catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public synchronized Integer addSysUser(SysUser user){
        SqlSession sqlSession=this.getSqlSession();
        Integer addUserNum=0;//插入结果
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserAccountEqualTo(user.getUserAccount());
            List<SysUser> list=sysUserMapper.selectByExample(example);
            if(list.size()==0){
                addUserNum=sysUserMapper.insertSelective(user);
            }
            else{//说明已存在
                addUserNum=-1;
            }
        }
        catch(Exception ex){
            sqlSession.rollback();
            return 0;
        }
        finally {
            sqlSession.close();
        }

        return addUserNum;
    }

    @Override
    public String addSysUserList(List<SysUser> sysUserList){
        SqlSession sqlSession=this.getSqlSession();
        Integer addUserNum=0;//插入结果
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            for(int i=0;i<sysUserList.size();++i){
                if(isExist(sysUserList.get(i).getUserAccount())){
                    return "-"+sysUserList.get(i).getUserAccount();
                }
            }
            addUserNum=sysUserMapper.insertList(sysUserList);
            return addUserNum+"";
        }
        catch(Exception ex){
            sqlSession.rollback();
            return 0+"";
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysRole> selectRoleByUser(SysUser sysUser){
        SqlSession sqlSession=this.getSqlSession();
        List<SysRole> roleList;
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            roleList=sysUserMapper.selectRoleByUser(sysUser);
        }
        finally {
            sqlSession.close();
        }
        return roleList;
    }

    @Override
    public List<SysUser> selectUserList(String search){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            if(StringUtil.isNotEmpty(search)){
                SysUserExample.Criteria or=example.or();//sql语句中自动去除第一个or
                or.andUserNameLike("%"+search+"%");
                SysUserExample.Criteria or2=example.or();
                or2.andUserSexLike("%"+search+"%");
                SysUserExample.Criteria or3=example.or();
                or3.andUserAccountLike("%"+search+"%");
                SysUserExample.Criteria or4=example.or();
                or4.andUserGroupLike("%"+search+"%");
                SysUserExample.Criteria or5=example.or();
                or5.andUserPhoneLike("%"+search+"%");
            }
            List<SysUser> list=sysUserMapper.selectByExample(example);
            return list;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysUser> selectUserNameByAccount(List<String> accountList){
        SqlSession sqlSession=this.getSqlSession();
        List<SysUser> userList=new ArrayList<>();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            for(String account:accountList){
                SysUserExample example=new SysUserExample();
                SysUserExample.Criteria criteria=example.createCriteria();
                criteria.andUserAccountEqualTo(account);
                List<SysUser> list=sysUserMapper.selectByExample(example);
                if(list.size()>0){
                    userList.add(list.get(0));
                }
            }
            return userList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public String selectGroupByAccount(String userAccount){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserAccountEqualTo(userAccount);
            List<SysUser> list=sysUserMapper.selectByExample(example);
            if(list.size()>0) {
                return list.get(0).getUserGroup();
            }
            else {
                return null;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public boolean isExist(String userAccount){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserAccountEqualTo(userAccount);
            List<SysUser> list=sysUserMapper.selectByExample(example);
            if(list.size()>0) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public String selectUserNameByAccount(String account){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserAccountEqualTo(account);
            List<SysUser> list=sysUserMapper.selectByExample(example);
            if(list.size()>0) {
                return list.get(0).getUserName();
            }
            else {
                return null;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public synchronized boolean deleteUserByAccount(SysUser sysUser){
        SqlSession sqlSession=this.getSqlSession();
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserAccountEqualTo(sysUser.getUserAccount());
            Integer deleteNum=sysUserMapper.deleteByExample(example);
            if(deleteNum>0){
                return true;
            }
            else {
                sqlSession.rollback();
                return false;
            }
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return false;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
     public synchronized Integer updateSysUserSeat(List<SysUser> sysUserList){
        SqlSession sqlSession=this.getSqlSession();
        Integer updateNum=0;
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            for(SysUser item:sysUserList){
                SysUserExample exampleCheck=new SysUserExample();
                SysUserExample.Criteria criteriaCheck=exampleCheck.createCriteria();
                criteriaCheck.andUserSeatEqualTo(item.getUserSeat());
                List<SysUser> list=sysUserMapper.selectByExample(exampleCheck);
                if(list.size()>0){//这个座位目前有人,取消他的座位,座位号设为负一
                    SysUser sysUser=new SysUser();
                    sysUser.setId(list.get(0).getId());
                    sysUser.setUserSeat(NO_SEAT);
                    sysUserMapper.updateByPrimaryKeySelective(sysUser);
                }
                SysUserExample example=new SysUserExample();
                SysUserExample.Criteria criteria=example.createCriteria();
                criteria.andUserAccountEqualTo(item.getUserAccount());
                updateNum+=sysUserMapper.updateByExampleSelective(item,example);
            }
            return updateNum;
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return updateNum;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysUser> getSeatList(){
        SqlSession sqlSession=this.getSqlSession();
        List<SysUser> userList;
        try{
            SysUserMapper sysUserMapper=sqlSession.getMapper(SysUserMapper.class);
            SysUserExample example=new SysUserExample();
            SysUserExample.Criteria criteria=example.createCriteria();
            criteria.andUserSeatGreaterThan(NO_SEAT);
            example.setOrderByClause("user_seat asc");

            userList=sysUserMapper.selectByExample(example);
            return userList;
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






















