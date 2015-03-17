package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.DairyFeeds;
import org.muthaka.dairy.dao.mealDao;
import org.muthaka.dairy.service.MealService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public class MealServiceImplement implements MealService {

	private mealDao mealDAO;

	public void setMealDao(mealDao mealDAO) {
		this.mealDAO = mealDAO;
	}

	@Override @Transactional public void addFeeds(DairyFeeds dairyfeeds) {
		this.mealDAO.addFeeds(dairyfeeds);
	}

	@Override @Transactional public void updateFeeds(DairyFeeds dairyfeeds) {
		this.mealDAO.updateFeeds(dairyfeeds);
	}

	@Override @Transactional public List<DairyFeeds> listDairyFeeds() {
		return this.mealDAO.listDairyFeeds();
	}

	@Override @Transactional public DairyFeeds getFeedsById(Integer dairyId) {
		return this.mealDAO.getFeedsById(dairyId);
	}

	@Override @Transactional public void removeFeed(Integer dairyId) {

		this.mealDAO.removeFeed(dairyId);
	}

}
