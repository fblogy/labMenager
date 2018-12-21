package mybatis.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSession;

import mybatis.mapper.SupplyBorrowRecordMapper;
import mybatis.mapper.SysSupplyMapper;
import mybatis.mapper.SysUserMapper;
import mybatis.model.SupplyBorrowRecord;
import mybatis.model.SupplyBorrowRecordExample;
import mybatis.model.SysBook;
import mybatis.model.SysSupply;
import mybatis.model.SysSupplyExample;
import mybatis.model.SysUser;
import mybatis.model.SysUserExample;
import mybatis.util.DateUtil;

public class SysSupplyServiceImpl extends BaseMapper implements SysSupplyService {

	public int delete(int id) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int result =supplyMapper.deleteByPrimaryKey(id);
		ses.commit();
		ses.close();
		return result;
	}

	public List<Map<String, Object>> selectByPartSupplyName(String word,int s,int p,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();

		byte x1=-1;
		byte x2=-3;
		SysSupplyExample.Criteria criteria=example.createCriteria();
		SysSupplyExample.Criteria criteria1= example.createCriteria();
		SysSupplyExample.Criteria criteria2= example.createCriteria();
		SysSupplyExample.Criteria criteria3= example.createCriteria();

		criteria.andSupplyNameLike("%"+word+"%");
		criteria1.andSupplyNumberLike("%"+word+"%");
		criteria2.andSupplyPositionLike("%"+word+"%");
		criteria3.andSupplyBorrowerLike("%"+word+"%");

		criteria.andSupplyStatusNotBetween(x2, x1);
		criteria1.andSupplyStatusNotBetween(x2, x1);
		criteria2.andSupplyStatusNotBetween(x2, x1);
		criteria3.andSupplyStatusEqualTo((byte)0);

		example.or(criteria);
		example.or(criteria1);
		example.or(criteria2);
		example.or(criteria3);

		example.setLimit(p);
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}

		List<SysSupply> list=supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );
			if(supply.getSupplyStatus()==0){
				map.put("supplyBorrower", supply.getSupplyBorrower());
				Date d=supply.getSupplyBorrowTime();
				int year=DateUtil.getYear(d);
				int month=DateUtil.getMonth(d)+6;
				while(month>12){
					year++;
					month=month-12;
				}
				map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );
			}else{
				map.put("supplyMark"," " );
			}

			maplist.add(map);
		}
//		ses.commit();
		ses.close();
		System.out.println(list);
		return maplist;
	}

	public List<Map<String, Object>> selectAll(int p,int s,int sortFlag) {
		// TODO Auto-generated method stub

		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		byte x1=0;
		byte x2=1;
		criteria.andSupplyStatusBetween(x1, x2);

		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
		break;
	case 1:example.setOrderByClause("id DESC");
		break;
	case 2:example.setOrderByClause("supplyStatus ASC");
		break;
	case 3:example.setOrderByClause("supplyStatus DESC");
		break;
	}

		List<SysSupply> list=supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );
			if(supply.getSupplyStatus()==0){
				map.put("supplyBorrower", supply.getSupplyBorrower());
				Date d=supply.getSupplyBorrowTime();
				int year=DateUtil.getYear(d);
				int month=DateUtil.getMonth(d)+6;
				while(month>12){
					year++;
					month=month-12;
				}
				map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );
			}else{
				map.put("supplyMark"," " );
			}

			maplist.add(map);
		}

		ses.close();
		return maplist;
	}

	public int update(int id, String account, byte status) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);

		SysSupply supply=new SysSupply();
		supply.setId(id);
		supply.setSupplyStatus(status);


		if(status==0){
			//借书记录操作
			SysSupply b=supplyMapper.selectByPrimaryKey(id);
			

			Date time=new Date();
			supply.setSupplyBorrowTime(time);
			SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
			SysUserExample example=new SysUserExample();
			SysUserExample.Criteria criteria=example.createCriteria();
			criteria.andUserAccountEqualTo(account);
			List<SysUser> userlist=mapper.selectByExample(example);
			for(SysUser user:userlist){
				supply.setSupplyBorrower(user.getUserName());
			}
			
			SupplyBorrowRecord record=new SupplyBorrowRecord();
			record.setSupplyName(b.getSupplyName());
			record.setUserName(supply.getSupplyBorrower());
			record.setSupplyBorrowAccount(account);
			record.setSupplyBorrowTime(new Date());
			SupplyBorrowRecordMapper bm=ses.getMapper(SupplyBorrowRecordMapper.class);
			bm.insert(record);
		}
//		if(status==1) {
//			SupplyBorrowRecordMapper bm2=ses.getMapper(SupplyBorrowRecordMapper.class);
//			SupplyBorrowRecordExample e=new SupplyBorrowRecordExample();
//			SupplyBorrowRecordExample.Criteria c=e.createCriteria();
//			c.andSupplyBorrowAccountEqualTo(account);
//			c.andUserNameEqualTo(supply.getSupplyBorrower());
//			
//		}
		int result=supplyMapper.updateByPrimaryKeySelective(supply);
		ses.commit();
		ses.close();
		return result;
	}


	public int insertNewSupply(SysSupply supply) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);

		System.out.println("insert iss ok");
		int result =supplyMapper.insert(supply);
		ses.commit();
		ses.close();
		return result;
	}
	public int count() {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.count();
		ses.close();
		return i;
	}

	public int countMyAppRecByWord(String account, String word) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countMyAppRecByWord(account,"%"+word+"%");
		ses.close();
		return i;
	}

	public List<SysSupply> selectMyAppRecByWord(String account, int p, int s, String word,int sortFlag) {
		// TODO Auto-generated method stub

		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		SysSupplyExample.Criteria criteria1= example.createCriteria();
		SysSupplyExample.Criteria criteria2= example.createCriteria();
		SysSupplyExample.Criteria criteria3= example.createCriteria();

		criteria.andSupplyNameLike("%"+word+"%");
		criteria1.andSupplyNumberLike("%"+word+"%");
		criteria2.andSupplyPositionLike("%"+word+"%");
		criteria3.andSupplyMarkLike("%"+word+"%");

		criteria.andSupplyBuyerEqualTo(account);
		criteria1.andSupplyBuyerEqualTo(account);
		criteria2.andSupplyBuyerEqualTo(account);
		criteria3.andSupplyBuyerEqualTo(account);


		SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		SysUserExample example1=new SysUserExample();
		SysUserExample.Criteria criteria5=example1.createCriteria();
		criteria5.andUserAccountEqualTo(account);
		List<SysUser> userlist=mapper.selectByExample(example1);

		if(userlist==null ||userlist.size()!=1){
			return null;
		}
		String name=null;
		for(SysUser user:userlist){
			name=user.getUserName();
		}

		example.or(criteria);
		example.or(criteria1);
		example.or(criteria2);
		example.or(criteria3);

		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}

		List<SysSupply> list=supplyMapper.selectByExample(example);

		for(SysSupply supply:list){
			supply.setSupplyBuyer(name);
		}

		ses.close();
		System.out.println(list);
		return list;
	}

	public int countMyAppRec(String account) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countMyAppRec(account);
		ses.close();
		return i;
	}

	public List<SysSupply> selectMyAppRec(String account, int p, int s,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();

		criteria.andSupplyBuyerEqualTo(account);

		SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		SysUserExample example1=new SysUserExample();
		SysUserExample.Criteria criteria5=example1.createCriteria();
		criteria5.andUserAccountEqualTo(account);
		List<SysUser> userlist=mapper.selectByExample(example1);

		if(userlist==null ||userlist.size()!=1){
			return null;
		}
		String name=null;
		for(SysUser user:userlist){
			name=user.getUserName();
		}

		example.or(criteria);

		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}


		List<SysSupply> list=supplyMapper.selectByExample(example);

		for(SysSupply supply:list){
			supply.setSupplyBuyer(name);
		}

		ses.close();
		System.out.println(list);
		return list;
	}

	public int countAllAppRecByWord(String word) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countAllAppRecByWord("%"+word+"%");

		ses.close();
		return i;
	}

	public List<SysSupply> selectAllAppRecByWord(int p, int s, String word,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		List<SysSupply> list=null;
		switch(sortFlag) {
		case 0:list= supplyMapper.allAppRecByWord0(s, p,"%"+word+"%");
			break;
		case 1:list= supplyMapper.allAppRecByWord1(s, p,"%"+word+"%");
			break;
		case 2:list= supplyMapper.allAppRecByWord2(s, p,"%"+word+"%");
			break;
		case 3:list= supplyMapper.allAppRecByWord3(s, p,"%"+word+"%");
			break;
		}
		ses.close();
		System.out.println(list);
		return list;
	}

	public int countAllAppRec() {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countAllAppRec();

		ses.close();
		return i;
	}

	public List<SysSupply> selectAllAppRec(int p, int s,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);


		List<SysSupply> list=null;
		switch(sortFlag) {
		case 0:list= supplyMapper.allAppRec0(s, p);
			break;
		case 1:list= supplyMapper.allAppRec1(s, p);
			break;
		case 2:list= supplyMapper.allAppRec2(s, p);
			break;
		case 3:list= supplyMapper.allAppRec3(s, p);
			break;
		}
//		List<SysSupply> list= supplyMapper.allAppRec(s, p);

		ses.close();
		System.out.println(list);
		return list;
	}

	public int countAllBorrowByWord(String name) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countAllBorrowByWord(name);

		ses.close();
		return i;
	}

	public List<Map<String, Object>> selectAllBorrowByWord(int p, int s, String word,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		SysSupplyExample.Criteria criteria1=example.createCriteria();
		SysSupplyExample.Criteria criteria2=example.createCriteria();
		SysSupplyExample.Criteria criteria3=example.createCriteria();

		criteria.andSupplyNameLike("%"+word+"%");
		criteria1.andSupplyNumberLike("%"+word+"%");
		criteria2.andSupplyPositionLike("%"+word+"%");
		criteria3.andSupplyBorrowerLike("%"+word+"%");

		criteria.andSupplyStatusEqualTo((byte)0);
		criteria1.andSupplyStatusEqualTo((byte)0);
		criteria2.andSupplyStatusEqualTo((byte)0);
		criteria3.andSupplyStatusEqualTo((byte)0);

		example.or(criteria);
		example.or(criteria1);
		example.or(criteria2);
		example.or(criteria3);

		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}


		List<SysSupply> list= supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		if(list.size()==0){
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
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );

			map.put("supplyBorrower", supply.getSupplyBorrower());
			Date d=supply.getSupplyBorrowTime();
			int year=DateUtil.getYear(d);
			int month=DateUtil.getMonth(d)+6;
			while(month>12){
				year++;
				month=month-12;
			}
			map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );

			maplist.add(map);
		}

		ses.close();
		return maplist;
	}

	public int countAllBorrow() {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countAllBorrow();

		ses.close();
		return i;
	}

	public List<Map<String, Object>> selectAllBorrow(int p, int s,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();


		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		criteria.andSupplyStatusEqualTo((byte)0);
		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}


		List<SysSupply> list= supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		if(list.size()==0){
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
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );

			map.put("supplyBorrower", supply.getSupplyBorrower());
			Date d=supply.getSupplyBorrowTime();
			int year=DateUtil.getYear(d);
			int month=DateUtil.getMonth(d)+6;
			while(month>12){
				year++;
				month=month-12;
			}
			map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );


			maplist.add(map);
		}

		ses.close();
		return maplist;
	}

	public int countMyBorrowPart(String account, String name) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);

		int i=supplyMapper.countByWordAndAccount(account, name);

		ses.close();
		return i;
	}

	public List<Map<String, Object>> selectMyBorrowByWords(String account, int p, int s, String word,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		SysSupplyExample.Criteria criteria1=example.createCriteria();
		SysSupplyExample.Criteria criteria2=example.createCriteria();
		SysSupplyExample.Criteria criteria3=example.createCriteria();


		SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		SysUserExample example1=new SysUserExample();
		SysUserExample.Criteria criteria5=example1.createCriteria();
		criteria5.andUserAccountEqualTo(account);
		List<SysUser> userlist=mapper.selectByExample(example1);

		if(userlist==null ||userlist.size()!=1){
			return null;
		}
		for(SysUser user:userlist){
			criteria.andSupplyBorrowerEqualTo(user.getUserName());
			criteria1.andSupplyBorrowerEqualTo(user.getUserName());
			criteria2.andSupplyBorrowerEqualTo(user.getUserName());
			criteria3.andSupplyBorrowerEqualTo(user.getUserName());
		}

		criteria.andSupplyNameLike("%"+word+"%");
		criteria1.andSupplyNumberLike("%"+word+"%");
		criteria2.andSupplyPositionLike("%"+word+"%");
		criteria3.andSupplyBorrowerLike("%"+word+"%");

		criteria.andSupplyStatusEqualTo((byte)0);
		criteria1.andSupplyStatusEqualTo((byte)0);
		criteria2.andSupplyStatusEqualTo((byte)0);
		criteria3.andSupplyStatusEqualTo((byte)0);

		example.or(criteria);
		example.or(criteria1);
		example.or(criteria2);
		example.or(criteria3);

		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}


		List<SysSupply> list= supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		if(list.size()==0){
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
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );
			if(supply.getSupplyStatus()==0){
				map.put("supplyBorrower", supply.getSupplyBorrower());
				Date d=supply.getSupplyBorrowTime();
				int year=DateUtil.getYear(d);
				int month=DateUtil.getMonth(d)+6;
				while(month>12){
					year++;
					month=month-12;
				}
				map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );
			}else{
				map.put("supplyMark"," " );
			}

			maplist.add(map);
		}

		ses.close();
		return maplist;
	}

	public List<Map<String, Object>> selectByMyBorrow(String account, int p, int s,int sortFlag) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();


		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		SysSupplyExample example=new SysSupplyExample();
		SysSupplyExample.Criteria criteria=example.createCriteria();
		criteria.andSupplyStatusEqualTo((byte)0);
		example.setLimit(p);     //设置pagesize和开始start
		example.setStart(s);
		switch(sortFlag) {
		case 0:example.setOrderByClause("id ASC");
			break;
		case 1:example.setOrderByClause("id DESC");
			break;
		case 2:example.setOrderByClause("supplyStatus ASC");
			break;
		case 3:example.setOrderByClause("supplyStatus DESC");
			break;
		}

		SysUserMapper mapper=ses.getMapper(SysUserMapper.class);
		SysUserExample example1=new SysUserExample();
		SysUserExample.Criteria criteria1=example1.createCriteria();
		criteria1.andUserAccountEqualTo(account);
		List<SysUser> userlist=mapper.selectByExample(example1);

		if(userlist==null ||userlist.size()==0){
			return null;
		}
		for(SysUser user:userlist){
			criteria.andSupplyBorrowerEqualTo(user.getUserName());
		}
		List<SysSupply> list= supplyMapper.selectByExample(example);
		List<Map<String, Object>> maplist=new ArrayList<Map<String,Object>>();

		if(list.size()==0){
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
		for(SysSupply supply:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", supply.getId());
			map.put("supplyNumber",supply.getSupplyNumber());
			map.put("supplyName",supply.getSupplyName());
			map.put("supplyBuyTime", supply.getSupplyBuyTime());
			map.put("supplyPosition", supply.getSupplyPosition());

			map.put("supplyStatus",supply.getSupplyStatus() );
			if(supply.getSupplyStatus()==0){
				map.put("supplyBorrower", supply.getSupplyBorrower());
				Date d=supply.getSupplyBorrowTime();
				int year=DateUtil.getYear(d);
				int month=DateUtil.getMonth(d)+6;
				while(month>12){
					year++;
					month=month-12;
				}
				map.put("supplyMark","预计归还时间："+year+"年"+month+"月" );
			}else{
				map.put("supplyMark"," " );
			}

			maplist.add(map);
		}

		ses.close();
		return maplist;
	}

	public int countMe(String account) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();

		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);

		int i=supplyMapper.countMe(account);

		ses.close();
		return i;
	}

	public int countPart(String name) {
		// TODO Auto-generated method stub
		SqlSession ses=this.getSqlSession();
		SysSupplyMapper supplyMapper=ses.getMapper(SysSupplyMapper.class);
		int i=supplyMapper.countPart(name);
		ses.close();
		return i;
	}


}
