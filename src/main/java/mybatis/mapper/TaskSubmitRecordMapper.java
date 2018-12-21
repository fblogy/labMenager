package mybatis.mapper;

import java.util.List;
import mybatis.model.TaskSubmitRecord;
import mybatis.model.TaskSubmitRecordExample;
import org.apache.ibatis.annotations.Param;

public interface TaskSubmitRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int countByExample(TaskSubmitRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int deleteByExample(TaskSubmitRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int insert(TaskSubmitRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int insertSelective(TaskSubmitRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    List<TaskSubmitRecord> selectByExample(TaskSubmitRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    TaskSubmitRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TaskSubmitRecord record, @Param("example") TaskSubmitRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TaskSubmitRecord record, @Param("example") TaskSubmitRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TaskSubmitRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_submit_record
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TaskSubmitRecord record);
}