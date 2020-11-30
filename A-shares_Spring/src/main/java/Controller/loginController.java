package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import Dao.FactoryDao;
import Model.FactoryModel;
import Model.Member;

public class loginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		FactoryDao FD = (FactoryDao) implCon.a2.getBean("FD");
		List<Member> list = FD.getMD().checklogin(account, password);
		if(list.size() != 0) {
			for(Member x : list) {
				F.getM().setName(x.getName());
				F.getM().setAccount(account);
				F.getM().setPassword(password);
				F.getM().setAssets(x.getAssets());
			}

			session.setAttribute("M", F.getM());
			return new ModelAndView("/home.jsp");
		}else {
			return new ModelAndView("/login.jsp");
		}
		
		
		
	}
	
}
