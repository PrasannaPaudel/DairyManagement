package org.muthaka.dairy.dao;

import org.muthaka.dairy.Models.Customers;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
public interface customerDao {
    public void addCustomer(Customers customer);

    public void updateCustomer(Customers customer);

    public List<Customers> listCustomer();

    public Customers getCustomerById(Integer customerId);
    public void removeCustomer (Integer customerId);
}
