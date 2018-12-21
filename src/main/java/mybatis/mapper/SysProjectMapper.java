package mybatis.mapper;

import java.util.List;
import mybatis.model.SysProject;
import mybatis.model.SysProjectExample;
import org.apache.ibatis.annotations.Param;

public interface SysProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int countByExample(SysProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int deleteByExample(SysProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int insert(SysProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int insertSelective(SysProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    List<SysProject> selectByExample(SysProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    SysProject selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysProject record, @Param("example") SysProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysProject record, @Param("example") SysProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_project
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysProject record);

    /**
     * 通过用户账号获取当前用户参加过的项目
     * @param projectAccount
     * @return
     */
    List<SysProject> getMyProjectList(String projectAccount);
}