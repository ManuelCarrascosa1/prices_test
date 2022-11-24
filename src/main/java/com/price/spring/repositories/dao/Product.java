package com.price.spring.repositories.dao;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long branId;
	private LocalDateTime startDate;
	private LocalDateTime EndDate;
	private int PriceList;
	private long productId;
	private int Priority;
	private double Price;
	private String Currency;
	private LocalDateTime LastUpdate;
	private String LastUpdateBy;
	
	public Product() {}

	public Product(long id, long branId, LocalDateTime startDate, LocalDateTime endDate, int priceList, long productId,
			int priority, double price, String currency, LocalDateTime lastUpdate, String LastUpdateBy) {
		super();
		this.id = id;
		this.branId = branId;
		this.startDate = startDate;
		this.EndDate = endDate;
		this.PriceList = priceList;
		this.productId = productId;
		this.Priority = priority;
		this.Price = price;
		this.Currency = currency;
		this.LastUpdate = lastUpdate;
		this.LastUpdateBy = LastUpdateBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public long getBranId() {
		return branId;
	}

	public void setBranId(long branId) {
		this.branId = branId;
	}

	




	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		EndDate = endDate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		LastUpdate = lastUpdate;
	}

	public int getPriceList() {
		return PriceList;
	}

	public void setPriceList(int priceList) {
		PriceList = priceList;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}


	
	public LocalDateTime getLastUpdate() {
		return LastUpdate;
	}

	public String getLastUpdateBy() {
		return LastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		LastUpdateBy = lastUpdateBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branId, Currency, EndDate, LastUpdate, LastUpdateBy, Price, PriceList, Priority, productId,
				startDate, id);
	}

	

	@Override
	public String toString() {
		return "Producto [id=" + id + ", BranId=" + branId + ", StartDate=" + startDate + ", EndDate=" + EndDate
				+ ", PriceList=" + PriceList + ", ProductId=" + productId + ", Priority=" + Priority + ", Price="
				+ Price + ", Currency=" + Currency + ", LastUpdate=" + LastUpdate + ", LastUpdateBy=" + LastUpdateBy
				+ "]";
	}
	
	

	
	

	
}
