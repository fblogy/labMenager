package mybatis.service;

import java.util.List;
import java.util.Map;

import mybatis.model.SysBook;

public interface SysBookService {

	//个人端模糊搜索图书申请清单的数量
	int countMyAppRecByWord(String account,String word);
	//个人端模糊搜索图书申请清单
	List<SysBook> selectMyAppRecByWord(String account,int p,int s,String word);

	//个人端图书申请清单的数量
	int countMyAppRec(String account);
	//个人端图书申请清单
	List<SysBook> selectMyAppRec(String account,int p,int s);

	//管理员端模糊搜索图书申请清单的数量
	int countAllAppRecByWord(String word);
	//管理员端模糊搜索图书申请清单
	List<SysBook> selectAllAppRecByWord(int p,int s,String word);

	//管理员端图书申请清单的数量
	int countAllAppRec();
	//管理员端图书申请清单
	List<SysBook> selectAllAppRec(int p,int s);

	//管理员端模糊搜索借出的图书清单的数量
	int countAllBorrowByWord(String name);
	//管理员端模糊搜索借出的图书清单
	List<Map<String, Object>> selectAllBorrowByWord(int p,int s,String name);

	//管理员端借出的图书清单的数量
	int countAllBorrow();
	//管理员端借出的图书清单
	List<Map<String, Object>> selectAllBorrow(int p,int s);

	//我的图书模糊搜索数量
	int countMyBorrowPart(String account,String name);
	//我的图书模糊搜索
	List<Map<String,Object>> selectMyBorrowByWords(String account,int p,int s ,String name);

	//我借的图书清单
	List<Map<String, Object>> selectByMyBorrow(String account,int p,int s);

	//我的图书数量
	int countMe(String account);

	//模糊搜索图书数量
	int countPart(String name);
	//所有图书数量
	int count();

	//删除书籍
	int delete(int id);

	//所有书籍模糊搜索
	List<Map<String, Object>> selectByPartBook(String name,int p,int s);


	//全部书籍信息
	List<Map<String, Object>> selectAll(int p,int s);

	int update(int id,String account,byte status);


	int insertNewBook(SysBook book);
	
}
