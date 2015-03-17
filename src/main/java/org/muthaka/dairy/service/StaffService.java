package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.Staff;

import java.util.List;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
public interface StaffService {

	public void addStaff(Staff staff);

	public void updateStaff(Staff staff);

	public List<Staff> listStaff();

	public Staff getStaffById(Integer staffId);

	public Staff getStaffByUuid(String staffUuid);

	public void removeStaff(Staff staff);
}
