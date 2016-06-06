package com.pos.model;

public class ItemModel {
	public String itemId;
	public String itemName;
	public double unitPrice;
	public int discountType;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getDiscountType() {
		return discountType;
	}
	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}
	@Override
	public String toString() {
		return "ItemModel [itemId=" + itemId + ", itemName=" + itemName
				+ ", unitPrice=" + unitPrice + ", discountType=" + discountType
				+ "]";
	}
	
	
}
