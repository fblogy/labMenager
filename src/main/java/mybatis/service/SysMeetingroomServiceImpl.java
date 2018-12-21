package mybatis.service;

import mybatis.mapper.BaseMapper;
import mybatis.mapper.SysMeetingroomMapper;
import mybatis.model.SysMeetingroom;
import mybatis.model.SysMeetingroomExample;
import mybatis.util.DateUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMeetingroomServiceImpl extends BaseMapper implements SysMeetingroomService{

    @Override
    public Integer insertList(List<SysMeetingroom> meetingroomList){
        SqlSession sqlSession=this.getSqlSession();

        Integer insertNum=0;
        try{
            SysMeetingroomMapper sysMeetingroomMapper=sqlSession.getMapper(SysMeetingroomMapper.class);
            for(SysMeetingroom sysMeetingroom:meetingroomList){
                SysMeetingroomExample example=new SysMeetingroomExample();
                SysMeetingroomExample.Criteria criteria=example.createCriteria();
                criteria.andRoomDateEqualTo(sysMeetingroom.getRoomDate());
                criteria.andRoomSegEqualTo(sysMeetingroom.getRoomSeg());
                List<SysMeetingroom> list =sysMeetingroomMapper.selectByExample(example);
                if(list.size()>0) {//这个时间段的会议室已经有人借，即冲突
                    return -1;
                }
            }
            insertNum=sysMeetingroomMapper.insertList(meetingroomList);
            if(insertNum==meetingroomList.size()){//全部插入成功
                sqlSession.commit();
                return insertNum;
            }else {
                sqlSession.rollback();
                return 0;
            }
        }
        catch (Exception ex){
            sqlSession.rollback();
            ex.printStackTrace();
            return 0;
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public List<SysMeetingroom> selectSysMeetingroomByRoomdate(SysMeetingroom sysMeetingroom){
        SqlSession sqlSession=this.getSqlSession();
        int orderInWeek=DateUtil.getDateIntOfWeek(sysMeetingroom.getRoomDate());
        Date beginDate=DateUtil.addDay(sysMeetingroom.getRoomDate(),1-orderInWeek);//获取周一
        Date endDate=DateUtil.addDay(sysMeetingroom.getRoomDate(),7-orderInWeek);//获取周日

        try{
            SysMeetingroomMapper sysMeetingroomMapper=sqlSession.getMapper(SysMeetingroomMapper.class);
            SysMeetingroomExample example=new SysMeetingroomExample();
            SysMeetingroomExample.Criteria criteria=example.createCriteria();
            criteria.andRoomDateBetween(beginDate,endDate);

            List<SysMeetingroom> sysMeetingroomList=sysMeetingroomMapper.selectByExample(example);
            return sysMeetingroomList;
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
    public Integer deleteSysMeetingroomByList(List<SysMeetingroom> sysMeetingroomList){
        SqlSession sqlSession=this.getSqlSession();
        Integer deleteNum=0;
        try{
            SysMeetingroomMapper sysMeetingroomMapper=sqlSession.getMapper(SysMeetingroomMapper.class);
            for(SysMeetingroom item:sysMeetingroomList){
                SysMeetingroomExample example=new SysMeetingroomExample();
                SysMeetingroomExample.Criteria criteria=example.createCriteria();
                criteria.andRoomDateEqualTo(item.getRoomDate());
                criteria.andRoomSegEqualTo(item.getRoomSeg());
                criteria.andRoomAccountEqualTo(item.getRoomAccount());
                deleteNum+=sysMeetingroomMapper.deleteByExample(example);
            }
            return deleteNum;
        }
        catch (Exception ex){
            ex.printStackTrace();
            sqlSession.rollback();
            return deleteNum;
        }
        finally {
            sqlSession.close();
        }
    }
}