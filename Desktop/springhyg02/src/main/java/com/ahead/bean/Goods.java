package com.ahead.bean;

public class Goods {
	int id;
	String name;
	String info;
	String imgsrc;
	int price;
	int typesId;
	public Goods() {}
	public Goods(int id, String name, String info, String imgsrc, int price, int typesId) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.imgsrc = imgsrc;
		this.price = price;
		this.typesId = typesId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTypesId() {
		return typesId;
	}
	public void setTypesId(int typesId) {
		this.typesId = typesId;
	}
	
	

	

	

}
