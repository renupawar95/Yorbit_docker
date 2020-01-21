package com.mindtree.customermanagement.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import com.mindtree.customermanagement.entity.Customer;
import com.mindtree.customermanagement.entity.Hotel;

@Service
public interface HotelService {

	public String addHotelsToDataBase(Hotel hotel);

	public List<Hotel> getAllDetailsOfHotelAlongwithCustomers(int hotelId);

	public List<Customer> getAllCustomersByRoomType(String roomType) throws ServiceException;

	public String updateCustomerCheckInDate(int hotelId, int customerId, Customer customer) throws ServiceException;

	public String deleteCustomerById(int customerId);

	public List<Customer> getAllCustomerDataIntoExcelSheet();

}
