package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.FactoryDao;
import Dao.MemberDao;
import Dao.ShareDao;
import Dao.Share_OrderDao;

@Configuration
public class beanFactoryDao {
	@Bean(name = "MD")
	public MemberDao getMD() {
		return new MemberDao();
	}
	
	@Bean(name = "SD")
	public ShareDao getSD() {
		return new ShareDao();
	}
	
	@Bean(name = "S_OD")
	public Share_OrderDao getS_OD() {
		return new Share_OrderDao();
	}
	
	@Bean(name = "FD")
	public FactoryDao getFD() {
		FactoryDao fd = new FactoryDao();
		fd.setMD(getMD());
		fd.setSD(getSD());
		fd.setS_OD(getS_OD());
		return fd;
	}
}
