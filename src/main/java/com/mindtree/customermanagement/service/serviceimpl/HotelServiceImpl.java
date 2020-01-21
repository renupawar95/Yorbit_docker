package com.mindtree.customermanagement.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.customermanagement.entity.Customer;
import com.mindtree.customermanagement.entity.Hotel;
import com.mindtree.customermanagement.exception.util.ErrorConstants;
import com.mindtree.customermanagement.repository.CustomerRepository;
import com.mindtree.customermanagement.repository.HotelRepository;
import com.mindtree.customermanagement.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public String addHotelsToDataBase(Hotel hotel) {
		for (Customer customer : hotel.getCustomers()) {
			customer.setHotel(hotel);

		}
		hotelRepository.save(hotel);
		return "Inserted";
	}

	@Override
	public List<Hotel> getAllDetailsOfHotelAlongwithCustomers(int hotelId) throws ServiceException {
		int count = 0;
		List<Hotel> hotels = hotelRepository.findAll();
		List<Hotel> result = new ArrayList<>();
		for (Hotel hotel : hotels) {
			if (hotelId == hotel.getHotelId()) {
				result.add(hotel);
				count++;
			}
		}
		if (count == 0) {
			throw new ServiceException(ErrorConstants.NoSuchHotelId);
		}
		return result;
	}

	@Override
	public List<Customer> getAllCustomersByRoomType(String roomType) {
		List<Customer> customers = customerRepository.findAll();
		List<Customer> result = new ArrayList<>();
		for (Customer customer : customers) {
			if (roomType.equalsIgnoreCase(customer.getRoomType())) {
				result.add(customer);

			}
		}
		return result;
	}

	@Override
	public String updateCustomerCheckInDate(int hotelId, int customerId, Customer customer) {

		int count = 0;
		List<Hotel> hotels = hotelRepository.findAll();
		for (Hotel hotel : hotels) {
			if (hotelId == hotel.getHotelId()) {
				for (Customer customers : hotel.getCustomers()) {
					if (customerId == customers.getCustomerId()) {
						count++;

						customers.setCheckInDate(customer.getCheckInDate());
						customers.setCheckOutDate(customer.getCheckOutDate());

						// customers.setPhoneNum(customer.getPhoneNum());
						customerRepository.save(customers);
					}
				}
			}
		}
		if (count == 0) {
			throw new ServiceException(ErrorConstants.NoSuchCustomerId);
		}
		return "updated";
	}

	@Override
	public String deleteCustomerById(int customerId) {
		List<Customer> customers = customerRepository.findAll();

		for (Customer customer : customers) {
			if (customerId == customer.getCustomerId()) {

				customerRepository.deleteById(customerId);
				;
			}

		}
		return "deleted";
	}

	@Override
	public List<Customer> getAllCustomerDataIntoExcelSheet() {
		return customerRepository.findAll();
	}

}
