package mybatis.service;

import mybatis.model.SysMeetingroom;

import java.util.List;

public interface SysMeetingroomService {

    /**
     * 借用会议室
     *
     * @paramList<SysMeetingroom>
     * @return
     */
    Integer insertList(List<SysMeetingroom> meetingroomList);

    /**
     * 通过日期加载当前周的会议室预约情况
     * @param sysMeetingroom
     * @return
     */
    List<SysMeetingroom> selectSysMeetingroomByRoomdate(SysMeetingroom sysMeetingroom);

    /**
     * 删除当周的会议室借记录
     * @param sysMeetingroomList
     * @return
     */
    Integer deleteSysMeetingroomByList(List<SysMeetingroom> sysMeetingroomList);



}
