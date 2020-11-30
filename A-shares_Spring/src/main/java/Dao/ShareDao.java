package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Share;

public class ShareDao implements implDao{

	public static void main(String[] args) {
		List<Share> list = new ShareDao().queryCode(200017);
		for(Share x : list) {
			System.out.println(x.getCompany()+"\t"+x.getPrice());
		}
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object query(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//股價代號查詢公司及股價
	public List<Share> queryCode(Integer code) {
		Session se = DbConn.getSession();
//		SQLQuery sq = se.createSQLQuery("select * from Share");
//		sq.addEntity(Share.class);
		Query query = se.createQuery("From Share where code='"+code+"'");
		List<Share> list = query.list();
		return list;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
