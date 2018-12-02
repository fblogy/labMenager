 package mybatis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSession;

import mybatis.mapper.BookBorrowRecordMapper;
import mybatis.mapper.SysBookMapper;
import mybatis.mapper.SysUserMapper;
import mybatis.model.BookBorrowRecord;
import mybatis.model.SysBook;
import mybatis.model.SysBookExample;
import mybatis.model.SysUser;
import mybatis.model.SysUserExample;
import mybatis.util.DateUtil;

 public class SysBookServiceImpl extends BaseMapper implements SysBookService{


	 public int insertNewBook(SysBook book){

		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int result =bookMapper.insert(book);
		 ses.commit();
		 ses.close();
		 return result;
	 }

	 public int delete(int id) {
//		System.out.println("service is ok");
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int result =bookMapper.deleteByPrimaryKey(id);
//		System.out.println("last is ok");
		 ses.commit();
		 ses.close();
		 return result;
	 }

	 public List<Map<String, Object>> selectByPartBook(String name,int p,int s) {
		 // TODO Auto-generated method stub

		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();

		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 byte x1=-1;
		 byte x2=-3;

		 SysBookExample.Criteria criteria1=bookExample.createCriteria();
		 SysBookExample.Criteria criteria2=bookExample.createCriteria();
		 SysBookExample.Criteria criteria3=bookExample.createCriteria();
		 SysBookExample.Criteria criteria4=bookExample.createCriteria();
		 criteria.andBookIsbnLike("%"+name+"%");
		 criteria1.andBookNameLike("%"+name+"%");
		 criteria2.andBookWriterLike("%"+name+"%");
		 criteria3.andBookPubLike("%"+name+"%");
		 criteria4.andBookBorrowerLike("%"+name+"%");

		 criteria.andBookStatusNotBetween(x2, x1);
		 criteria1.andBookStatusNotBetween(x2, x1);
		 criteria2.andBookStatusNotBetween(x2, x1);
		 criteria3.andBookStatusNotBetween(x2, x1);
		 criteria4.andBookStatusEqualTo((byte)0);

		 bookExample.or(criteria);
		 bookExample.or(criteria1);
		 bookExample.or(criteria2);
		 bookExample.or(criteria3);
		 bookExample.or(criteria4);


		 bookExample.setLimit(p);
		 bookExample.setStart(s);

		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());

			 map.put("bookStatus",book.getBookStatus() );
			 if(book.getBookStatus()==0){
				 map.put("bookBorrower", book.getBookBorrower());
				 Date d=book.getBookBorrowTime();
				 int year=DateUtil.getYear(d);
				 int month=DateUtil.getMonth(d)+6;
				 while(month>12){
					 year++;
					 month=month-12;
				 }
				 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
			 }else{
				 map.put("bookMark"," " );
			 }

			 maplist.add(map);
		 }
//		ses.commit();
		 ses.close();
		 return maplist;
	 }



	 /* (non-Javadoc)
	  * @see service.SysBookService#selectAll()
	  */
	 public List<Map<String, Object>> selectAll(int p,int s) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 byte x1=-1;
		 byte x2=-3;
		 criteria.andBookStatusNotBetween(x2, x1);
		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());

			 map.put("bookStatus",book.getBookStatus() );
			 if(book.getBookStatus()==0){
				 Date d=book.getBookBorrowTime();
				 int year=DateUtil.getYear(d);
				 int month=DateUtil.getMonth(d)+6;
				 while(month>12){
					 year++;
					 month=month-12;
				 }
				 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
				 map.put("bookBorrower", book.getBookBorrower());
			 }else{
				 map.put("bookMark","  " );
			 }

			 maplist.add(map);
		 }

		 ses.close();
		 return maplist;
	 }

	 public int update(int id, String account, byte status) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBook book=new SysBook();
		 book.setId(id);
		 book.setBookStatus(status);

		 if(status==0){
			 //借书记录操作
			 BookBorrowRecordMapper rm=ses.getMapper(BookBorrowRecordMapper.class);
			 BookBorrowRecord record=new BookBorrowRecord();
			 record.setBookId(id);
			 record.setBookBorrowAccount(account);
			 record.setBookBorrowTime(new Date());
			 rm.insert(record);

			 SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
			 SysUserExample example=new SysUserExample();
			 SysUserExample.Criteria criteria=example.createCriteria();
			 criteria.andUserAccountEqualTo(account);
			 List<SysUser> userlist=mapper.selectByExample(example);
			 for(SysUser user:userlist){
				 book.setBookBorrower(user.getUserName());
			 }
			 book.setBookBorrowTime(new Date());

		 }
		 int result=bookMapper.updateByPrimaryKeySelective(book);

		 ses.commit();
		 ses.close();
		 return result;
	 }





	 public int count() {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.count();
		 ses.close();
		 return i;
	 }

	 public int countPart(String name) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();
		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.countPart(name);
		 ses.close();
		 return i;
	 }

	 public List<Map<String, Object>> selectByMyBorrow(String account, int p, int s) {
		 // TODO Auto-generated method stub

		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 criteria.andBookStatusEqualTo((byte)0);
		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);

		 SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		 SysUserExample example=new SysUserExample();
		 SysUserExample.Criteria criteria1=example.createCriteria();
		 criteria1.andUserAccountEqualTo(account);
		 List<SysUser> userlist=mapper.selectByExample(example);

		 if(userlist==null ||userlist.size()==0){
			 return null;
		 }
		 for(SysUser user:userlist){
			 criteria.andBookBorrowerEqualTo(user.getUserName());
		 }
		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		 if(booklist.size()==0){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 0);
			 maplist.add(map);
			 return maplist;
		 }else
		 {
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 1);
			 maplist.add(map);
		 }
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());
			 Date d=book.getBookBorrowTime();
			 int year=DateUtil.getYear(d);
			 int month=DateUtil.getMonth(d)+6;
			 while(month>12){
				 year++;
				 month=month-12;
			 }
			 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
			 map.put("bookStatus",book.getBookStatus() );
			 map.put("bookBorrower", book.getBookBorrower());


			 maplist.add(map);
		 }

		 ses.close();
		 return maplist;
	 }

	 public int countMe(String account) {
		 // TODO Auto-generated method stubs
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);

		 int i=bookMapper.countMe(account);

		 ses.close();
		 return i;
	 }

	 public List<Map<String, Object>> selectMyBorrowByWords(String account, int p, int s, String name) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 SysBookExample.Criteria criteria1=bookExample.createCriteria();
		 SysBookExample.Criteria criteria2=bookExample.createCriteria();
		 SysBookExample.Criteria criteria3=bookExample.createCriteria();
		 SysBookExample.Criteria criteria4=bookExample.createCriteria();

		 SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		 SysUserExample example=new SysUserExample();
		 SysUserExample.Criteria criteria5=example.createCriteria();
		 criteria5.andUserAccountEqualTo(account);
		 List<SysUser> userlist=mapper.selectByExample(example);

		 if(userlist==null ||userlist.size()!=1){
			 return null;
		 }
		 for(SysUser user:userlist){
			 criteria.andBookBorrowerEqualTo(user.getUserName());
			 criteria1.andBookBorrowerEqualTo(user.getUserName());
			 criteria2.andBookBorrowerEqualTo(user.getUserName());
			 criteria3.andBookBorrowerEqualTo(user.getUserName());
			 criteria4.andBookBorrowerEqualTo(user.getUserName());
		 }

		 criteria.andBookIsbnLike("%"+name+"%");
		 criteria1.andBookNameLike("%"+name+"%");
		 criteria2.andBookWriterLike("%"+name+"%");
		 criteria3.andBookPubLike("%"+name+"%");
		 criteria4.andBookBorrowerLike("%"+name+"%");

		 criteria.andBookStatusEqualTo((byte)0);
		 criteria1.andBookStatusEqualTo((byte)0);
		 criteria2.andBookStatusEqualTo((byte)0);
		 criteria3.andBookStatusEqualTo((byte)0);
		 criteria4.andBookStatusEqualTo((byte)0);

		 bookExample.or(criteria);
		 bookExample.or(criteria1);
		 bookExample.or(criteria2);
		 bookExample.or(criteria3);
		 bookExample.or(criteria4);

		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		 if(booklist.size()==0){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 0);
			 maplist.add(map);
			 return maplist;
		 }else
		 {
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 1);
			 maplist.add(map);
		 }
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());
			 Date d=book.getBookBorrowTime();
			 int year=DateUtil.getYear(d);
			 int month=DateUtil.getMonth(d)+6;
			 while(month>12){
				 year++;
				 month=month-12;
			 }
			 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
			 map.put("bookStatus",book.getBookStatus() );
			 map.put("bookBorrower", book.getBookBorrower());


			 maplist.add(map);
		 }

		 ses.close();
		 return maplist;
	 }

	 public int countMyBorrowPart(String account, String name) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);

		 int i=bookMapper.countByWordAndAccount(account, name);

		 ses.close();
		 return i;
	 }

	 public int countAllBorrow() {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);

		 int i=bookMapper.countAllBorrow();

		 ses.close();
		 return i;
	 }

	 public List<Map<String, Object>> selectAllBorrow(int p, int s) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 criteria.andBookStatusEqualTo((byte)0);
		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		 if(booklist.size()==0){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 0);
			 maplist.add(map);
			 return maplist;
		 }else
		 {
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 1);
			 maplist.add(map);
		 }
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());
			 Date d=book.getBookBorrowTime();
			 int year=DateUtil.getYear(d);
			 int month=DateUtil.getMonth(d)+6;
			 while(month>12){
				 year++;
				 month=month-12;
			 }
			 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
			 map.put("bookStatus",book.getBookStatus() );
			 map.put("bookBorrower", book.getBookBorrower());


			 maplist.add(map);
		 }

		 ses.close();
		 return maplist;
	 }

	 public int countAllBorrowByWord(String name) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);

		 int i=bookMapper.countAllBorrowByWord(name);

		 ses.close();
		 return i;
	 }

	 public List<Map<String, Object>> selectAllBorrowByWord(int p, int s, String name) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 SysBookExample.Criteria criteria1=bookExample.createCriteria();
		 SysBookExample.Criteria criteria2=bookExample.createCriteria();
		 SysBookExample.Criteria criteria3=bookExample.createCriteria();
		 SysBookExample.Criteria criteria4=bookExample.createCriteria();


		 criteria.andBookIsbnLike("%"+name+"%");
		 criteria1.andBookNameLike("%"+name+"%");
		 criteria2.andBookWriterLike("%"+name+"%");
		 criteria3.andBookPubLike("%"+name+"%");
		 criteria4.andBookBorrowerLike("%"+name+"%");

		 criteria.andBookStatusEqualTo((byte)0);
		 criteria1.andBookStatusEqualTo((byte)0);
		 criteria2.andBookStatusEqualTo((byte)0);
		 criteria3.andBookStatusEqualTo((byte)0);
		 criteria4.andBookStatusEqualTo((byte)0);

		 bookExample.or(criteria);
		 bookExample.or(criteria1);
		 bookExample.or(criteria2);
		 bookExample.or(criteria3);
		 bookExample.or(criteria4);

		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);
		 List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		 if(booklist.size()==0){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 0);
			 maplist.add(map);
			 return maplist;
		 }else
		 {
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("info", 1);
			 maplist.add(map);
		 }
		 for(SysBook book:booklist){
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("id", book.getId());
			 map.put("isbn",book.getBookIsbn() );
			 map.put("bookName",book.getBookName());
			 map.put("bookWriter", book.getBookWriter());
			 map.put("bookPub", book.getBookPub());
			 Date d=book.getBookBorrowTime();
			 int year=DateUtil.getYear(d);
			 int month=DateUtil.getMonth(d)+6;
			 while(month>12){
				 year++;
				 month=month-12;
			 }
			 map.put("bookMark","预计归还时间："+year+"年"+month+"月" );
			 map.put("bookStatus",book.getBookStatus() );
			 map.put("bookBorrower", book.getBookBorrower());


			 maplist.add(map);
		 }

		 ses.close();
		 return maplist;
	 }

	 public int countAllAppRecByWord(String word) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.countAllAppRecByWord("%"+word+"%");

		 ses.close();
		 return i;
	 }

	 public List<SysBook> selectAllAppRecByWord(int p, int s, String word) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);

		 List<SysBook> booklist= bookMapper.allAppRecByWord(s, p,"%"+word+"%");

		 ses.close();
		 System.out.println(booklist);
		 return booklist;
	 }

	 public int countAllAppRec() {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.countAllAppRec();

		 ses.close();
		 return i;
	 }

	 public List<SysBook> selectAllAppRec(int p, int s) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);


		 List<SysBook> booklist= bookMapper.allAppRec(s, p);


		 ses.close();
		 System.out.println(booklist);
		 return booklist;
	 }

	 public int countMyAppRecByWord(String account, String word) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.countMyAppRecByWord(account,"%"+word+"%");

		 ses.close();
		 return i;
	 }
	 //我的申请  找出我的所有申请
	 public List<SysBook> selectMyAppRecByWord(String account, int p, int s, String word) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();
		 SysBookExample.Criteria criteria1=bookExample.createCriteria();
		 SysBookExample.Criteria criteria2=bookExample.createCriteria();
		 SysBookExample.Criteria criteria3=bookExample.createCriteria();
		 SysBookExample.Criteria criteria4=bookExample.createCriteria();



		 criteria.andBookMarkLike("%"+word+"%");
		 criteria1.andBookNameLike("%"+word+"%");
		 criteria2.andBookWriterLike("%"+word+"%");
		 criteria3.andBookPubLike("%"+word+"%");
		 criteria4.andBookMarkLike("%"+word+"%");

		 criteria.andBookBuyerEqualTo(account);
		 criteria1.andBookBuyerEqualTo(account);
		 criteria2.andBookBuyerEqualTo(account);
		 criteria3.andBookBuyerEqualTo(account);
		 criteria4.andBookBuyerEqualTo(account);

		 SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		 SysUserExample example=new SysUserExample();
		 SysUserExample.Criteria criteria5=example.createCriteria();
		 criteria5.andUserAccountEqualTo(account);
		 List<SysUser> userlist=mapper.selectByExample(example);

		 if(userlist==null ||userlist.size()!=1){
			 return null;
		 }
		 String name=null;
		 for(SysUser user:userlist){
			 name=user.getUserName();
		 }

		 bookExample.or(criteria);
		 bookExample.or(criteria1);
		 bookExample.or(criteria2);
		 bookExample.or(criteria3);
		 bookExample.or(criteria4);

		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);

		 for(SysBook book:booklist){
			 book.setBookBuyer(name);
		 }

		 ses.close();
		 System.out.println(booklist);
		 return booklist;
	 }

	 public int countMyAppRec(String account) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 int i=bookMapper.countMyAppRec(account);

		 ses.close();
		 return i;
	 }

	 public List<SysBook> selectMyAppRec(String account, int p, int s) {
		 // TODO Auto-generated method stub
		 SqlSession ses=this.getSqlSession();

		 SysBookMapper bookMapper=ses.getMapper(SysBookMapper.class);
		 SysBookExample bookExample=new SysBookExample();
		 SysBookExample.Criteria criteria=bookExample.createCriteria();

		 criteria.andBookBuyerEqualTo(account);

		 SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		 SysUserExample example=new SysUserExample();
		 SysUserExample.Criteria criteria5=example.createCriteria();
		 criteria5.andUserAccountEqualTo(account);
		 List<SysUser> userlist=mapper.selectByExample(example);

		 if(userlist==null ||userlist.size()!=1){
			 return null;
		 }
		 String name=null;
		 for(SysUser user:userlist){
			 name=user.getUserName();
		 }

		 bookExample.or(criteria);

		 bookExample.setLimit(p);     //设置pagesize和开始start
		 bookExample.setStart(s);


		 List<SysBook> booklist= bookMapper.selectByExample(bookExample);

		 for(SysBook book:booklist){
			 book.setBookBuyer(name);
		 }

		 ses.close();
		 return booklist;
	 }

 }