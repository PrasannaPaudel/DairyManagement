package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.DairyFeeds;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public interface MealService {

	public void addFeeds(DairyFeeds dairyfeeds);

	public void updateFeeds(DairyFeeds dairyfeeds);

	public List<DairyFeeds> listDairyFeeds();

	public DairyFeeds getFeedsById(Integer dairyId);

	public void removeFeed(Integer dairyId);

}
