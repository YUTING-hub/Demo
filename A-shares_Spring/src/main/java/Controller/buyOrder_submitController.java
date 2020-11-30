package Controller;

import java.text.SimpleDateFormat;
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
import Model.Share_Order;

public class buyOrder_submitController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member M = (Member) session.getAttribute("M");
		Share_Order S_O = (Share_Order) session.getAttribute("S_O");
		
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		FactoryDao FD = (FactoryDao) implCon.a2.getBean("FD");
		
		List<Share_Order> list = (List) FD.getS_OD().queryRecord_code(M.getAccount(), S_O.getCode());
		
		if(S_O.getAction().equals("0")) {
			String buy = S_O.getAction();
			buy = "買";
			if(S_O.getLimit_price() > S_O.getPrice()) {
				if(M.getAssets() > S_O.getLimit_price() * S_O.getQuantity() * 100) {
					Double final_price = S_O.getLimit_price() - (Math.random() * (S_O.getLimit_price() - S_O.getPrice()));
					if(list.size() != 0) {
						for(Share_Order s : list) {
							Integer Q = s.getQuantity();
							Double fp = s.getAverage_price();
							Integer Quantity = Q + S_O.getQuantity();
							Double average_price = ((Q * fp) + (S_O.getQuantity() * final_price)) / (Q + S_O.getQuantity());
							
							SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date date = new Date();
							String times = timeFormat.format(date); 
							
							FD.getS_OD().update_previousRecord(S_O.getAccount(), S_O.getCode(), S_O.getLimit_price(), Quantity, times);
							
//							F.getS_O().setAccount(S_O.getAccount());
//							F.getS_O().setCompany(S_O.getCompany());
//							F.getS_O().setCode(S_O.getCode());
//							F.getS_O().setAction(buy);
//							F.getS_O().setPrice(S_O.getPrice());
//							F.getS_O().setLimit_price(S_O.getLimit_price());
//							F.getS_O().setQuantity(Quantity);
//							F.getS_O().setAverage_price(average_price);
//							F.getS_O().setDatetime(new Date());
//							FD.getS_OD().add(F.getS_O());
							session.setAttribute("S_O", F.getS_O());
							return new ModelAndView("/order_closedDeal.jsp");
						}
					}else {
						F.getS_O().setAccount(S_O.getAccount());
						F.getS_O().setCompany(S_O.getCompany());
						F.getS_O().setCode(S_O.getCode());
						F.getS_O().setAction(buy);
						F.getS_O().setPrice(S_O.getPrice());
						F.getS_O().setLimit_price(S_O.getLimit_price());
						F.getS_O().setQuantity(S_O.getQuantity());
						F.getS_O().setAverage_price(final_price);
						F.getS_O().setDatetime(new Date());
						FD.getS_OD().add(F.getS_O());
						session.setAttribute("S_O", F.getS_O());
						return new ModelAndView("/order_closedDeal.jsp");
					}
				}else {
					return new ModelAndView("/not_enough.jsp");
				}	
			}else {
				return new ModelAndView("/pending_buyOrder.jsp");
			}
		}
		return null;
	}
}