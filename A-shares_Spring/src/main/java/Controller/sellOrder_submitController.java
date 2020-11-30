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

public class sellOrder_submitController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member M = (Member) session.getAttribute("M");
		Share_Order S_O = (Share_Order) session.getAttribute("S_O");
		
		FactoryModel F = (FactoryModel) implCon.a1.getBean("F");
		FactoryDao FD = (FactoryDao) implCon.a2.getBean("FD");
		
		List<Share_Order> list = (List) FD.getS_OD().queryRecord_code(M.getAccount(), S_O.getCode());
		
		if(list.size() != 0) {
			if(S_O.getLimit_price() < S_O.getPrice()) {
				Double final_price = S_O.getLimit_price() + (Math.random() * (S_O.getPrice() - S_O.getLimit_price()));
					for(Share_Order s : list) {
						Integer Q = s.getQuantity();
						Double fp = s.getAverage_price();
						Integer Quantity = Q - S_O.getQuantity();
						Double average_price = ((Q * fp) - (S_O.getQuantity() * final_price)) / (Q - S_O.getQuantity());
						SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = new Date();
						String times = timeFormat.format(date);
						FD.getS_OD().update_previousRecord(M.getAccount(), S_O.getCode(), average_price, Quantity, times);
						session.setAttribute("S_O", F.getS_O());
						return new ModelAndView("/order_closedDeal.jsp");
					}
				}else {
					return new ModelAndView("/pending_sellOrder.jsp");
				}	
			}else {
				return new ModelAndView("/not_enoughStocks.jsp");
			}
			return null;
		}
	}

