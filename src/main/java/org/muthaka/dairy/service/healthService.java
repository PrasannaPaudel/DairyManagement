package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.Health;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface HealthService {

    public void addHealth(Health health);

    public void updateHealth(Health health);

    public List<Health> listHealth();

    public Health getHealthById(Integer healthId);

    public void removeHealth(Integer healthId);
}
