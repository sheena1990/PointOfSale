package com.pos.facade;

import java.util.Calendar;
import java.util.Date;

import com.pos.dao.DaoException;
import com.pos.dao.LoyaltyCardDao;
import com.pos.model.LoyaltyCard;

public class LoyaltyCardFacade {

	public boolean verifyLoyaltyCard(String loyaltyCardId) {
		try {
			LoyaltyCardDao loyaltyCardDao = new LoyaltyCardDao();
			LoyaltyCard loyaltyCard = loyaltyCardDao
					.getLoyaltyCardDetailes(loyaltyCardId);
			if (loyaltyCard == null) {
				return false;
			}
			Calendar calEnrollDate = Calendar.getInstance();
			Calendar calExpiryDate = Calendar.getInstance();
			Calendar currentDate = Calendar.getInstance();
			calEnrollDate.setTime(loyaltyCard.getLoyaltyExpiryDate());
			calExpiryDate.setTime(loyaltyCard.getLoyaltyExpiryDate());
			if (currentDate.before(calEnrollDate)
					&& currentDate.after(calExpiryDate)) {
				return false;
			}
			return true;

		} catch (DaoException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public int updateLoyaltyPoints(String loyaltyCardId,String loyaltyPoints){
		
		try {
		LoyaltyCardDao	loyaltyCardDao = new LoyaltyCardDao();
			LoyaltyCard loyaltyCard = loyaltyCardDao
					.getLoyaltyCardDetailes(loyaltyCardId);
			int tempLoyaltyPoints=Integer.parseInt(loyaltyPoints);
			if (tempLoyaltyPoints<0) {
				return -1;
			}else if(tempLoyaltyPoints >loyaltyCard.getLoyaltyCardPoints()){
				return 0;
			}else{
				int loyaltyPointsRemained=loyaltyCard.getLoyaltyCardPoints()-tempLoyaltyPoints;
				int updateStatus=loyaltyCardDao.updateLoyaltyPoints(loyaltyCardId, loyaltyPointsRemained);
				return tempLoyaltyPoints;
			}
		} catch (DaoException e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	
}
