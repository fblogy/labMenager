package mybatis.service;

import java.util.List;
import java.util.Map;

import mybatis.model.SysBook;
import mybatis.model.SysSupply;

public interface SysSupplyService {
	// 个人端模糊搜索物资申请清单的数量
	int countMyAppRecByWord(String account, String word);

	// 个人端模糊搜索物资申请清单
	List<SysSupply> selectMyAppRecByWord(String account, int p, int s, String word,int sortFlag);

	// 个人端物资申请清单的数量
	int countMyAppRec(String account);

	// 个人端物资申请清单
	List<SysSupply> selectMyAppRec(String account, int p, int s,int sortFlag);

	// 管理员端模糊搜索物资申请清单的数量
	int countAllAppRecByWord(String word);

	// 管理员端模糊搜索物资申请清单
	List<SysSupply> selectAllAppRecByWord(int p, int s, String word,int sortFlag);

	// 管理员端物资申请清单的数量
	int countAllAppRec();

	// 管理员端物资申请清单
	List<SysSupply> selectAllAppRec(int p, int s,int sortFlag);

	// 管理员端模糊搜索借出的物资清单的数量
	int countAllBorrowByWord(String name);

	// 管理员端模糊搜索借出的物资清单
	List<Map<String, Object>> selectAllBorrowByWord(int p, int s, String name,int sortFlag);

	// 管理员端借出的物资清单的数量
	int countAllBorrow();

	// 管理员端借出的物资清单
	List<Map<String, Object>> selectAllBorrow(int p, int s,int sortFlag);

	// 我的物资模糊搜索数量
	int countMyBorrowPart(String account, String name);

	// 我的物资模糊搜索
	List<Map<String, Object>> selectMyBorrowByWords(String account, int p, int s, String name,int sortFlag);

	// 我借的物资清单
	List<Map<String, Object>> selectByMyBorrow(String account, int p, int s,int sortFlag);

	// 我的物资数量
	int countMe(String account);

	// 模糊搜索物资数量
	int countPart(String name);

	// 所有物资数量
	int count();

	// 删除物资
	int delete(int id);

	// 物资模糊搜索
	List<Map<String, Object>> selectByPartSupplyName(String name, int s, int p,int sortFlag);

	// 全部物资信息 （已购买的即 status为0或1）
	List<Map<String, Object>> selectAll(int p, int s,int sortFlag);

	// 更新物资状态 初始状态为-3 -2失败 -1成功 1还在 0借出
	int update(int id, String account, byte status);

	int insertNewSupply(SysSupply supply);
}