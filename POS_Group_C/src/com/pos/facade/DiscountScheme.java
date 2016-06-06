package com.pos.facade;

import java.util.ArrayList;
import java.util.List;
import com.pos.dao.DaoException;
import com.pos.dao.DiscountDao;
import com.pos.dto.DiscountListDto;
import com.pos.dto.ItemDto;
import com.pos.model.DiscountListModel;
import com.pos.model.ItemModel;

public class DiscountScheme {

	private static List<DiscountListModel> discountList = new ArrayList<DiscountListModel>();
	 private static List<DiscountListDto> discountDtoList = new ArrayList<DiscountListDto>();

	int discountPercent;
	

	// 20% OFF on a given item
	public void discount1(ItemModel itemModel) {
		discountPercent = 20;
		DiscountListModel discountListModel = new DiscountListModel();
		discountListModel.setItemModel(itemModel);
		discountListModel.setDiscountPercent(discountPercent);
		discountList.add(discountListModel);
	}

	// Buy one and get 30% OFF on second item of same type
	public void discount2(ItemModel itemModel) {
		discountPercent = 30;
		DiscountListModel discountListModel1 = new DiscountListModel();
		discountListModel1.setItemModel(itemModel);
		int count = 0;
		for (DiscountListModel discountListModel : discountList) {
			if ((discountListModel.getItemModel().getDiscountType() == 2)
					&& (discountListModel.getItemModel().getItemId()
							.equalsIgnoreCase(itemModel.getItemId()))) {
				count++;
			}
		}
		if (count % 2 == 0) {
			discountListModel1.setDiscountPercent(0);
		} else {

			discountListModel1.setDiscountPercent(discountPercent);
		}
		discountList.add(discountListModel1);

		
	}

	// Buy one get One FREE
	private void discount3(ItemModel itemModel) {
		DiscountListModel discountListModel = new DiscountListModel();
		// Giving zero discount on first item of its type
		discountListModel.setDiscountPercent(0);
		discountListModel.setItemModel(itemModel);
		discountList.add(discountListModel);

		// giving same item for FREE and adding it to discountList
		DiscountListModel discountListModel1 = new DiscountListModel();
		discountListModel1.setDiscountPercent(100);
		discountListModel1.setItemModel(itemModel);
		discountList.add(discountListModel1);
	}

	// Buy two get one FREE
	private void discount4(ItemModel itemModel) {
		discountPercent = 100;
		int count = 0;
		DiscountListModel discountListModel2 = new DiscountListModel();
		// counting how many items of this type exist in the list
		for (DiscountListModel discountListModel : discountList) {
			if ((discountListModel.getItemModel().getDiscountType() == 4)
					&& (discountListModel.getItemModel().getItemId()
							.equalsIgnoreCase(itemModel.getItemId()))) {
				count++;
			}
		}

		// adding second item to discountList and giving same item for FREE
		if (count % 3 == 2) {
			DiscountListModel discountListModel1 = new DiscountListModel();
			discountListModel1.setDiscountPercent(100);
			discountListModel1.setItemModel(itemModel);
			discountList.add(discountListModel1);
		}
		discountListModel2.setDiscountPercent(0);
		discountListModel2.setItemModel(itemModel);
		discountList.add(discountListModel2);
	}

	// buy 1, get 25% off on another item
	private void discount5(ItemModel itemModel) throws DaoException {
		DiscountListModel discountListModel = new DiscountListModel();
		int discountPercent = 25;
		int count = 0;
		for (DiscountListModel discountListModel1 : discountList) {
			if ((discountListModel1.getItemModel().getDiscountType() == 5)) {
				count++;
			}
		}
		if (count == 0) {
			discountListModel.setDiscountPercent(0);
			discountListModel.setItemModel(itemModel);
			discountList.add(discountListModel);
		} else {
			DiscountDao discountDao = new DiscountDao();

			// base and complementary ids for item
			String itemId = itemModel.getItemId();
			String complementaryItemId = discountDao
					.getComplementaryItem(itemId);
			String baseItemId = discountDao.getBaseItem(itemId);

			for (DiscountListModel discountListModelIterator : discountList) {
				if ((discountListModel.getItemModel().getDiscountType() == 5)) {

					// if base id exists
					if (discountListModelIterator.getItemModel().getItemId()
							.equalsIgnoreCase(baseItemId)
							&& (discountListModelIterator.getFlag() == false)) {
						discountListModel.setDiscountPercent(discountPercent);
						discountListModel.setItemModel(itemModel);
						discountListModelIterator.setFlag(true);
						discountList.add(discountListModel);
					}
					// if complementary id exists
					if (discountListModelIterator.getItemModel().getItemId()
							.equalsIgnoreCase(complementaryItemId)) {
						// changing discount percent of already existing
						// complementary item in the discount list
						discountListModelIterator
								.setDiscountPercent(discountPercent);
						discountListModel.setDiscountPercent(0);
						discountListModel.setFlag(true);
						discountListModel.setItemModel(itemModel);
						discountList.add(discountListModel);
					}
				}
			}
		}
	}

	// buy 1, get another item free
	private void discount6(ItemModel itemModel) throws DaoException {
		int discountPercent = 100;
		DiscountListModel discountListModel = new DiscountListModel();
		DiscountDao discountDao = new DiscountDao();

		// 1. getting complementary ids for item
		String itemId = itemModel.getItemId();
		String complementaryItemId = discountDao.getComplementaryItem(itemId);

		// 2. if complementary is to be given, adds base item and
		// complementary item
		if (complementaryItemId != null) {

			// adds complementary item
			DiscountListModel discountListModel1 = new DiscountListModel();
			discountListModel1.setDiscountPercent(discountPercent);
			discountListModel1.setItemModel(itemModel);
			discountList.add(discountListModel1);
		}

		for (DiscountListModel discountListModelIterator : discountList) {
			if ((discountListModel.getItemModel().getDiscountType() == 6)) {

				// if complementary id already exists in the discountList
				if (discountListModelIterator.getItemModel().getItemId()
						.equalsIgnoreCase(complementaryItemId)) {
					// changing discount percent of already existing
					// complementary item in the discount list
					discountListModelIterator
							.setDiscountPercent(discountPercent);
					discountListModel.setFlag(true);
				}
			}

			// adds base item
			discountListModel.setDiscountPercent(0);
			discountListModel.setItemModel(itemModel);
			discountList.add(discountListModel);

		}

	}

	// public List<DiscountListModel> findDiscountPercent(List<ItemDto>
	// itemDtoList) {


	public List<DiscountListDto> findDiscountPercent(List<ItemDto> itemDtoList) {
		DiscountListFacade discountListFacade = new DiscountListFacade();
		ItemFacade itemFacade = new ItemFacade();
		ItemModel itemModel = new ItemModel();

		try {
			for (ItemDto itemDto : itemDtoList) {
				itemModel = itemFacade.createModel(itemDto);
				int discountType = Integer.parseInt(itemDto.getDiscountType());
				if (discountType == 1) {
					discount1(itemModel);
				} else if (discountType == 2) {
					discount2(itemModel);
				} else if (discountType == 3) {
					discount3(itemModel);
				} else if (discountType == 4) {
					discount4(itemModel);
				} else if (discountType == 5) {
					discount5(itemModel);
				} else if (discountType == 6) {
					discount6(itemModel);
				}
			}
			for (DiscountListModel discountListModel : discountList) {
				DiscountListDto discountListDto = discountListFacade.createDiscountListDto(discountListModel);
				discountDtoList.add(discountListDto);
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}
		return discountDtoList;
	}
}
