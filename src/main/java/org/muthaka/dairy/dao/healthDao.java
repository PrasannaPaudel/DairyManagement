package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.Health;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface healthDao {
	public void addHealth(Health Health);

	public void updateHealth(Health Health);

	public List<Health> listHealth();

	public Health getHealthById(Integer healthId);

	public void removeHealth(Integer healthId);
}
