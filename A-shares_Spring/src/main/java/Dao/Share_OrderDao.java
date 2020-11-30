package Dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Share_Order;

public class Share_OrderDao implements implDao{

	public static void main(String[] args) {
		Share_OrderDao S_OD = new Share_OrderDao();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String times = timeFormat.format(date); 
		S_OD.update_previousRecord("KevinLu", 200011, 7.2, 2, times);
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object queryRecord(String account) {
		Session se = DbConn.getSession();
		Criteria criteria = se.createCriteria(Share_Order.class);
		List<Share_Order> l_so = criteria.list();
		return l_so;
	}
	
	public Object queryRecord_code(String account,int code) {
		Session se = DbConn.getSession();
		Criteria criteria = se.createCriteria(Share_Order.class);
		List<Share_Order> l_so = criteria.list();
		return l_so;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public void update_previousRecord(String account,int code,Double limit_price,Integer quantity,String datetime) {
		Session se = DbConn.getSession();
		Transaction tx= se.beginTransaction();
		Share_OrderDao x = new Share_OrderDao();
		List<Share_Order> l_so =  (List<Share_Order>) x.queryRecord_code(account, code);
		if(l_so.size() != 0) {
			for(Share_Order so : l_so) {
				Double final_price =  so.getLimit_price() - (Math.random() * (so.getLimit_price() - so.getPrice()));
				Double average_price = ((so.getQuantity() * so.getAverage_price()) + (quantity * final_price)) / (so.getQuantity() + quantity);
				Query query = se.createQuery("update Share_Order set quantity='"+quantity+"',average_price='"+average_price+"',datetime='"+datetime+"' where account='"+account+"' and code='"+code+"'");
				query.executeUpdate();
				tx.commit();
				se.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}