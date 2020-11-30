package Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import Dao.FactoryDao;
import Model.FactoryModel;
import Model.Member;
import Model.Share;

public class stock_buyOrSellController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member M = (Member) session.getAttribute("M");
		Share S = (Share) session.getAttribute("S");
		
		Double limit_price = Double.parseDouble((request.getParameter("limit_price")));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int action = Integer.parseInt(request.getParameter("action"));
		
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		
		F.getS_O().setAccount(M.getAccount());
		F.getS_O().setCompany(S.getCompany());
		F.getS_O().setCode(S.getCode());
		F.getS_O().setAction(String.valueOf(action));
		F.getS_O().setPrice(S.getPrice());
		F.getS_O().setLimit_price(limit_price);
		F.getS_O().setQuantity(quantity);
		session.setAttribute("S_O", F.getS_O());
		
		if(action == 0) {
			return new ModelAndView("/buy_orders.jsp");
		}else {
			return new ModelAndView("/sell_orders.jsp");
		}
	}

}
