package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.MilkSold;

import java.util.List;

/**
 * Created by MUTHAKA on 3/10/2015.
 */
public interface milkSoldDao {

	public void addMilkSold(MilkSold sell);

	public void updateMilkSold(MilkSold sell);

	public List<MilkSold> listMilkSold();

	public MilkSold getMilkSoldById(Integer sellId);

	public void removeMilkSold(Integer sellId);
}
