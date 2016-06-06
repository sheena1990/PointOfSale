package com.pos.facade;

import com.pos.dto.DiscountListDto;
import com.pos.dto.ItemDto;
import com.pos.model.DiscountListModel;
import com.pos.model.ItemModel;

public class DiscountListFacade {
	

	/*
	 * Creates Dto of Processed Item List
	 */
	
	public DiscountListDto createDiscountListDto(
			DiscountListModel discountListModel) {
		ItemDto itemDto = new ItemDto();
		ItemModel itemModel = discountListModel.getItemModel();
		DiscountListDto discountListDto = new DiscountListDto();
		itemDto.setItemId(itemModel.getItemId());
		itemDto.setItemName(itemModel.getItemName());
		itemDto.setUnitPrice(itemModel.getUnitPrice() + "");
		itemDto.setDiscountType(itemModel.getDiscountType() + "");
		discountListDto.setItemDto(itemDto);
		discountListDto.setDiscountPercent(discountListModel
				.getDiscountPercent() + "");
		discountListDto.setFlag(discountListModel.getFlag() + "");
		discountListDto.setFlag(discountListModel.getAmount() + "");

		return discountListDto;
	}

	public DiscountListModel createDiscountListModel(
			DiscountListDto discountListDto) {
		DiscountListModel discountListModel = new DiscountListModel();
		// ItemDto itemDto = new ItemDto();

		ItemModel itemModel = new ItemModel();
		itemModel.setItemId(discountListDto.getItemDto().getItemId());
		itemModel.setItemName(discountListDto.getItemDto().getItemName());
		itemModel.setUnitPrice(Double.parseDouble(discountListDto.getItemDto()
				.getUnitPrice()));
		itemModel.setDiscountType(Integer.parseInt(discountListDto.getItemDto()
				.getDiscountType()));

		discountListModel.setItemModel(itemModel);

		discountListModel.setAmount(Double.parseDouble(discountListDto
				.getAmount()));
		discountListModel.setDiscountPercent(Integer.parseInt(discountListDto
				.getDiscountPercent()));
		discountListModel
				.setFlag(Boolean.getBoolean(discountListDto.getFlag()));

		return discountListModel;
	}


}
