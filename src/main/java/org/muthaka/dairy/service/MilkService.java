package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.MilkProduction;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public interface MilkService {

    public void addMilk(MilkProduction milkproduced);

    public void updateMilk(MilkProduction milkproduced);

    public List<MilkProduction> listMilkProduced();

    public MilkProduction getMilkById(Integer milkId);
    public MilkProduction getMilkByUuid(Integer milkUuid);
    public void removeMilk(Integer milkId);
}
