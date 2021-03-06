package mybatis.mapper;

import java.util.List;
import mybatis.model.SysAnnouncement;
import mybatis.model.SysAnnouncementExample;
import org.apache.ibatis.annotations.Param;

public interface SysAnnouncementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int countByExample(SysAnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int deleteByExample(SysAnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int insert(SysAnnouncement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int insertSelective(SysAnnouncement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    List<SysAnnouncement> selectByExample(SysAnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    SysAnnouncement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysAnnouncement record, @Param("example") SysAnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysAnnouncement record, @Param("example") SysAnnouncementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysAnnouncement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_announcement
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysAnnouncement record);
}