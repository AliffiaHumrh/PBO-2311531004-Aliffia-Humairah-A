package DAO;

import java.util.List;
import model.Customer;

public interface CustomerDao {
	void save(Customer customerr);	
	public void delete(String id);
	public void update(Customer customer);
	public List<Customer> show();
}