package com.pos.facade;

import java.util.Calendar;
import java.util.List;
import com.pos.dao.DaoException;
import com.pos.dao.DiscountDao;
import com.pos.dto.DiscountListDto;
import com.pos.dto.ItemDto;
import com.pos.model.DiscountListModel;
import com.pos.model.DiscountModel;
import com.pos.model.ItemModel;

public class DiscountFacade {
	/*
	 * validates every element of itemDtoList from ItemDao returns the validated
	 * list
	 */

	public List<ItemDto> validateDiscount(List<ItemDto> itemDtoList)

	{
		/*
		 * retrieved data from database
		 */

		for (ItemDto itemDto : itemDtoList) {
			String discountType = itemDto.getDiscountType();
			try {
				DiscountDao discountDao = new DiscountDao();
				DiscountModel discountModel = discountDao
						.getDiscountDetails(discountType);
				// validation logic
				if (!validateDiscountExpiry(discountModel)) {
					itemDto.setDiscountType(0 + "");
				}
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		return itemDtoList;
	}

	private boolean validateDiscountExpiry(DiscountModel discountModel) {
		Calendar calEnrollDate = Calendar.getInstance();
		Calendar calExpiryDate = Calendar.getInstance();
		Calendar currentDate = Calendar.getInstance();
		calEnrollDate.setTime(discountModel.getEnrollmentDate());
		calExpiryDate.setTime(discountModel.getExpiryDate());
		if (!(discountModel.getDiscountType() >= 1)
				&& (discountModel.getDiscountType() <= 6)
				&& (calEnrollDate.before(currentDate))
				&& (calExpiryDate.after(currentDate))) {
			return false;
		}
		return true;
	}

	
}