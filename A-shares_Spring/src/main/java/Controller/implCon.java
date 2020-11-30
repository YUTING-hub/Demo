package Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Factory.beanFactoryDao;
import Factory.beanFactoryModel;

public interface implCon {
	ApplicationContext a1=new AnnotationConfigApplicationContext(beanFactoryModel.class);
	ApplicationContext a2=new AnnotationConfigApplicationContext(beanFactoryDao.class);;

}
