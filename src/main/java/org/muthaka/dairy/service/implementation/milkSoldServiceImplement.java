package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.MilkSold;
import org.muthaka.dairy.dao.milkSoldDao;
import org.muthaka.dairy.service.MilkSoldService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 3/10/2015.
 */
public class milkSoldServiceImplement implements MilkSoldService {

	private milkSoldDao soldDAO;

	public void setSoldDAO(milkSoldDao soldDAO) {
		this.soldDAO = soldDAO;
	}

	@Override @Transactional public void addMilkSold(MilkSold sell) {

		this.soldDAO.addMilkSold(sell);
	}

	@Override @Transactional public void updateMilkSold(MilkSold sell) {

		this.soldDAO.updateMilkSold(sell);
	}

	@Override @Transactional public List<MilkSold> listMilkSold() {

		return this.soldDAO.listMilkSold();
	}

	@Override @Transactional public MilkSold getMilkSoldById(Integer sellId) {
		return this.soldDAO.getMilkSoldById(sellId);
	}

	@Override @Transactional public void removeMilkSold(Integer sellId) {

		this.soldDAO.removeMilkSold(sellId);
	}

}
