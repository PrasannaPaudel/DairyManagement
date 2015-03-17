package org.muthaka.dairy.dao;

/**
 * Created by MUTHAKA on 2/20/2015.
 */

import org.muthaka.dairy.Models.MilkProduction;

import java.util.List;

public interface milkDao {

	public void addMilk(MilkProduction milkproduced);

	public void updateMilk(MilkProduction milkproduced);

	public List<MilkProduction> listMilkProduced();

	public MilkProduction getMilkById(Integer milkId);

	public MilkProduction getMilkByUuid(Integer milkUuid);

	public void removeMilk(Integer milkId);

}
