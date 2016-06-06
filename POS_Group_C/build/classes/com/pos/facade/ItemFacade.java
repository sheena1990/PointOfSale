package com.pos.facade;

import java.util.ArrayList;
import java.util.List;

import com.pos.dao.DaoException;
import com.pos.dao.ItemDao;
import com.pos.dto.ItemDto;
import com.pos.model.ItemModel;

public class ItemFacade {	
	private static List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
	
	//Searches for the item based on ItemId and adds into the list 
	
	public List<ItemDto> addItem(String itemId) {
		try {
			
			ItemDao itemDao = new ItemDao();
			ItemModel item = itemDao.getItem(itemId);
			if(item.getItemName()!=null)
			itemDtoList.add(createDto(item));
			return itemDtoList;			
		} catch (DaoException e) {		
			e.printStackTrace();
			return null;
		}
	}

	public ItemDto createDto(ItemModel item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemId(item.getItemId());
		itemDto.setItemName(item.getItemName());
		itemDto.setUnitPrice(item.getUnitPrice() + "");
		itemDto.setDiscountType(item.getDiscountType() + "");
		return itemDto;
	}
	
	public ItemModel createModel(ItemDto itemDto) {
		ItemModel itemModel = new ItemModel();
		itemModel.setItemId(itemDto.getItemId());
		itemModel.setItemName(itemDto.getItemName());
		itemModel.setUnitPrice(Double.parseDouble(itemDto.getUnitPrice()));
		itemModel.setDiscountType(Integer.parseInt(itemDto.getDiscountType()));
		return itemModel;
	}
}
