package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Model.FactoryModel;
import Model.Member;
import Model.Share;
import Model.Share_Order;

@Configuration
public class beanFactoryModel {
	@Bean(name="M")
	public Member getM() {
		return new Member();		
	}
	
	@Bean(name="S")
	public Share getS() {
		return new Share();		
	}
	
	@Bean(name="S_O")
	public Share_Order getS_O() {
		return new Share_Order();		
	}
	
	@Bean(name="F")
	public FactoryModel getF() {
		FactoryModel f = new FactoryModel();
		f.setM(getM());
		f.setS(getS());
		f.setS_O(getS_O());
		return f;
	}
}
