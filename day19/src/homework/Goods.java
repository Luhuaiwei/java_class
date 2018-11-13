package homework;

import java.util.Date;

public class Goods {
	private int goodsnum ;
	private Double price ;
	private Date date;
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Goods(int goodsnum, Double price, Date date2) {
		super();
		this.goodsnum = goodsnum;
		this.price = price;
		this.date = date2;
	}
	
}
