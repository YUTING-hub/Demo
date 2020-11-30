package Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Member;

public class MemberDao implements implDao{

	public static void main(String[] args) {
		List<Member> md = new MemberDao().checklogin("KevinLu", "KevinLu");
		for(Member x : md) {
			System.out.println(x.getId());
		}

	}

	@Override
	public void add(Object o) {
		Session se = DbConn.getSession();
		Transaction tx = se.beginTransaction();
		se.save(o);
		tx.commit();
		se.close();
	}

	@Override
	public Object query(Integer id) {
		Session se = DbConn.getSession();
		Criteria criteria = se.createCriteria(Member.class);
		List<Member> m = criteria.list();
		return m;
	}
	
	//(登入)確認是否為會員
	public static List<Member> checklogin(String account, String password){
		Session se = DbConn.getSession();
		Query query = se.createQuery("from Member where account='"+account+"' and password='"+password+"'");
		List<Member> list = query.list();
		return list;
	}
	
	//(註冊)帳號是否重複
	public static List<Member> checkAccount(String account){
		Session se = DbConn.getSession();
		Query query = se.createQuery("from Member where account='"+account+"'");
		List<Member> list = query.list();
		return list;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(String name, String account) {
		Session se = DbConn.getSession();
		Transaction ts = se.beginTransaction();
		Query query = se.createQuery("update Member set name='"+name+"' where account='"+account+"'");
		query.executeUpdate();
		ts.commit();
		se.close();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public void delete(String name) {
		Session se = DbConn.getSession();
		Transaction ts = se.beginTransaction();
		Query query = se.createQuery("delete Member where='"+name+"'");
		query.executeUpdate();
		ts.commit();
		se.close();
	}

}
