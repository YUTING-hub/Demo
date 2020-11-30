package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import Dao.FactoryDao;
import Model.FactoryModel;
import Model.Share;
 
public class stock_searchController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int code = Integer.parseInt(request.getParameter("code"));
		
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		FactoryDao FD = (FactoryDao) implCon.a2.getBean("FD");
		
		List<Share> list = FD.getSD().queryCode(code);
		if(list.size() != 0) {
			for(Share x : list) {
				F.getS().setCode(x.getCode());
				F.getS().setCompany(x.getCompany());
				F.getS().setPrice(x.getPrice());
			}
			
			session.setAttribute("S", F.getS());
			return new ModelAndView("/stock_buyOrSell.jsp");
		}else {
			return new ModelAndView("/failure.jsp");
		}
	}

}
