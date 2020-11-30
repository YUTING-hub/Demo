package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Factory.beanFactoryModel;

public interface implDao {
	
	//Model 工廠管理功能
	ApplicationContext a1 = new AnnotationConfigApplicationContext(beanFactoryModel.class);
	
	//新增
	void add(Object o);
	
	//查詢
	Object query(Integer id);
	
	//修改
	void update(Object o);
	
	//刪除
	void delete(Integer id);
}
