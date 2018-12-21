package mybatis.mapper;

import java.util.List;

import mybatis.model.SysSupply;
import mybatis.model.SysSupplyExample;
import org.apache.ibatis.annotations.Param;

public interface SysSupplyMapper {
	List<SysSupply> allAppRecByWord0(@Param("start") int start, @Param("limit") int limit, @Param("word") String word);
	List<SysSupply> allAppRecByWord1(@Param("start") int start, @Param("limit") int limit, @Param("word") String word);
	List<SysSupply> allAppRecByWord2(@Param("start") int start, @Param("limit") int limit, @Param("word") String word);
	List<SysSupply> allAppRecByWord3(@Param("start") int start, @Param("limit") int limit, @Param("word") String word);
	List<SysSupply> allAppRec0(@Param("start") int start, @Param("limit") int limit);
	List<SysSupply> allAppRec1(@Param("start") int start, @Param("limit") int limit);
	List<SysSupply> allAppRec2(@Param("start") int start, @Param("limit") int limit);
	List<SysSupply> allAppRec3(@Param("start") int start, @Param("limit") int limit);
	int countMyAppRec(String account);
	int countMyAppRecByWord(@Param("account") String account, @Param("word") String word);
	
	int countAllAppRecByWord(String word);
	int countAllAppRec();
	
	int countAllBorrowByWord(String name);
	int countAllBorrow();
	/**
	 * 
	 * @param name
	 * @param account
	 * @return
	 */
	int countByWordAndAccount(@Param("account") String account, @Param("name") String name);
	/**
	 * 
	 * @param account
	 * @return
	 */
	int countMe(String account);
	
	int countPart(String name);
	
	int count();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int countByExample(SysSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int deleteByExample(SysSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int insert(SysSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int insertSelective(SysSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    List<SysSupply> selectByExample(SysSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    SysSupply selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysSupply record, @Param("example") SysSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysSupply record, @Param("example") SysSupplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysSupply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_supply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysSupply record);
}