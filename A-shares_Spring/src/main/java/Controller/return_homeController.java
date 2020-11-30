package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import Model.FactoryModel;
import Model.Share_Order;

public class return_homeController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Share_Order S_O = (Share_Order) session.getAttribute("S_O");
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		session.setAttribute("S_O", F.getS_O());
		return new ModelAndView("/home.jsp");
	}

}
