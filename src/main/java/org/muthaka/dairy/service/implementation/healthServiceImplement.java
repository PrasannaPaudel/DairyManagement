package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.Health;
import org.muthaka.dairy.dao.healthDao;
import org.muthaka.dairy.service.HealthService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public class healthServiceImplement implements HealthService {

	private healthDao healthDAO;

	public void setHealthDao(healthDao healthDAO) {
		this.healthDAO = healthDAO;
	}

	@Override @Transactional public void addHealth(Health health) {
		this.healthDAO.addHealth(health);
	}

	@Override @Transactional public void updateHealth(Health health) {
		this.healthDAO.updateHealth(health);
	}

	@Override @Transactional public List<Health> listHealth() {
		return this.healthDAO.listHealth();
	}

	@Override @Transactional public Health getHealthById(Integer healthId) {
		return this.healthDAO.getHealthById(healthId);
	}

	@Override @Transactional public void removeHealth(Integer healthId) {

		this.healthDAO.removeHealth(healthId);
	}
}
