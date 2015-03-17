package org.muthaka.dairy.service.implementation;

import org.muthaka.dairy.Models.Customers;
import org.muthaka.dairy.dao.customerDao;
import org.muthaka.dairy.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public class customerServiceImplement implements CustomerService {

	private customerDao customerDAO;

	public void setCustomerDao(customerDao customer) {
		this.customerDAO = customer;
	}

	@Override @Transactional public void addCustomer(Customers customer) {
		this.customerDAO.addCustomer(customer);
	}

	@Override @Transactional public void updateCustomer(Customers customer) {
		this.customerDAO.updateCustomer(customer);
	}

	@Override @Transactional public List<Customers> listCustomer() {
		return this.customerDAO.listCustomer();
	}

	@Override @Transactional public Customers getCustomerById(Integer customerId) {
		return this.customerDAO.getCustomerById(customerId);
	}

	@Override @Transactional public void removeCustomer(Integer customerId) {

		this.customerDAO.removeCustomer(customerId);
	}

}
