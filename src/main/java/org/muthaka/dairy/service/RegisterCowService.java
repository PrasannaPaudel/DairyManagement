package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.CowRegistration;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
public interface RegisterCowService {

	public void addCow(CowRegistration cowreg);

	public void updateCow(CowRegistration cowreg);

	public List<CowRegistration> listCowReg();

	public CowRegistration getCowById(Integer cowId);

	public CowRegistration getCowByUuid(Integer cowUuid);

	public void removeCow(Integer cowId);

}
