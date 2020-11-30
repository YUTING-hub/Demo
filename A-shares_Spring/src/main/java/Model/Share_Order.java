package Model;

import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="Share_Order")
public class Share_Order {
//	@Id
//	@Column(name="ID")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Integer id;
	private String	account;
	private String 	company;		//股票名稱
	private Integer code;		//股票代號
	private String 	action;		//買或賣
	private Double	price;		//現股價
	private	Double 	limit_price;	//掛單價
	private	Integer quantity;	//掛單手數
	private	Double 	average_price;	//成交價
	private	Date 	datetime;	//成交時間
	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getLimit_price() {
		return limit_price;
	}
	public void setLimit_price(Double limit_price) {
		this.limit_price = limit_price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAverage_price() {
		return average_price;
	}
	public void setAverage_price(Double average_price) {
		this.average_price = average_price;
	}
	public Date getDatetime() {
		Date datetime = new Date();
		this.datetime = datetime;
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}	
	
}
	
	
