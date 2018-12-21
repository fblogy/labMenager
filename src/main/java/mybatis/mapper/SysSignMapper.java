package mybatis.mapper;

import java.util.Date;
import java.util.List;

import mybatis.model.SignUserAndCount;
import mybatis.model.SysHealthHead;
import mybatis.model.SysSign;
import mybatis.model.SysSignExample;
import org.apache.ibatis.annotations.Param;

public interface SysSignMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int countByExample(SysSignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int deleteByExample(SysSignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int insert(SysSign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int insertSelective(SysSign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    List<SysSign> selectByExample(SysSignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    SysSign selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSign record, @Param("example") SysSignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSign record, @Param("example") SysSignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_sign
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSign record);

    /**
     * 显示签到次数前count位学生
     * @param beginDate
     * @param endDate
     * @param limit
     * @return
     */
    List<SignUserAndCount> getTopSignCountByYearAndMonth(@Param("beginDate") String beginDate, @Param("endDate") String endDate, @Param("limit") Integer limit);

    /**
     * 批量插入
     * @param sysSignList
     * @return
     */
    int insertList(List<SysSign> sysSignList);

}