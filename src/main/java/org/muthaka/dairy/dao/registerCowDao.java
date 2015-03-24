package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.CowRegistration;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface registerCowDao {

	public void addCow(CowRegistration cowReg);

	public void updateCow(CowRegistration cowReg);

	public List<CowRegistration> listCowReg();

	public List<CowRegistration> listStatusCowReg();

	public CowRegistration getCowById(Integer cowId);

	public CowRegistration getCowByUuid(Integer cowUuid);

	public void removeCow(Integer cowId);
}
