package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Factory.beanFactoryModel;
import Model.FactoryModel;

public class test {

	public static void main(String[] args) {
		
		ApplicationContext a1=new AnnotationConfigApplicationContext(beanFactoryModel.class);
		
		FactoryModel f=(FactoryModel) a1.getBean("F");
		
		System.out.println(f.getM());
		System.out.println(f.getS());
		System.out.println(f.getS_O());
		
	}

}
