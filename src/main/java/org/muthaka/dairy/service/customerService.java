package org.muthaka.dairy.service;

import org.muthaka.dairy.Models.Customers;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface CustomerService {

	public void addCustomer(Customers customer);

	public void updateCustomer(Customers customer);

	public List<Customers> listCustomer();

	public Customers getCustomerById(Integer customerId);

	public void removeCustomer(Integer customerId);

}
