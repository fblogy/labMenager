package mybatis.service;

import mybatis.model.SysAnnouncement;

import java.util.List;

public interface SysAnnouncementService {

    /**
     * 添加一条公告
     * @param sysAnnouncement
     * @return
     */
    boolean addAnnouncement(SysAnnouncement sysAnnouncement);

    /**
     * 搜索公告,提供姓名和正文的模糊搜索
     * @param search
     * @return
     */
    List<SysAnnouncement> searchAnnouncement(String search);

    /**
     * 获取通知列表
     * @return
     */
    List<SysAnnouncement> getAnnouncementList();

    /**
     * 通过主键删除通知
     * @param id
     * @return
     */
    Boolean delAnnouncement(Integer id);

}
