package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.MilkProduction;
import org.muthaka.dairy.dao.milkDao;
import org.muthaka.dairy.service.MilkService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public class milkServiceImplement implements MilkService {

	private milkDao milkDAO;

	public void setMilkDao(milkDao milkDAO) {
		this.milkDAO = milkDAO;
	}

	@Override @Transactional public void addMilk(MilkProduction milkproduced) {
		this.milkDAO.addMilk(milkproduced);
	}

	@Override @Transactional public void updateMilk(MilkProduction milkproduced) {
		this.milkDAO.updateMilk(milkproduced);
	}

	@Override @Transactional public List<MilkProduction> listMilkProduced() {
		return this.milkDAO.listMilkProduced();
	}

	@Override @Transactional public MilkProduction getMilkById(Integer milkId) {
		return this.milkDAO.getMilkById(milkId);
	}

	@Override @Transactional public MilkProduction getMilkByUuid(Integer milkUuid) {
		return this.milkDAO.getMilkByUuid(milkUuid);
	}

	@Override @Transactional public void removeMilk(Integer milkId) {

		this.milkDAO.removeMilk(milkId);
	}

}
