package com.mindtree.customermanagement.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.customermanagement.entity.Customer;
import com.mindtree.customermanagement.entity.Hotel;
import com.mindtree.customermanagement.service.HotelService;

@RestController
public class AppController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/insertmanagerwithprojects")
	public ResponseEntity<Map<String, Object>> addHotelAlongWithCustomers(@RequestBody Hotel hotel) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", false);
		response.put("message", hotelService.addHotelsToDataBase(hotel));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);

	}

	@GetMapping("/gethoteldata/{hotelId}")
	public ResponseEntity<Map<String, Object>> getAllDetailsByHotelId(@PathVariable int hotelId)
			throws ServiceException {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", false);
		response.put("body", hotelService.getAllDetailsOfHotelAlongwithCustomers(hotelId));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);

	}

	@GetMapping("/gethotelcustomers/{roomType}")
	public ResponseEntity<Map<String, Object>> getAllCustomersByRoomType(@PathVariable String roomType) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", false);
		response.put("body", hotelService.getAllCustomersByRoomType(roomType));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);

	}

	@PutMapping("/updatedate/{hotelId}/{customerId}")
	public ResponseEntity<Map<String, Object>> updateCustomerData(@PathVariable int hotelId,
			@PathVariable int customerId, @RequestBody Customer customer) throws ServiceException {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", false);
		response.put("body", hotelService.updateCustomerCheckInDate(hotelId, customerId, customer));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);

	}

	@DeleteMapping("/deletedata/{customerId}")
	public ResponseEntity<Map<String, Object>> deleteCustomersByCustomerId(@PathVariable int customerId) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "projects");
		response.put("Error", false);
		response.put("body", hotelService.deleteCustomerById(customerId));
		response.put("Httpstatus", HttpStatus.FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);

	}

	@GetMapping("/gethoteldata")
	public List<Customer> getAllDetails() throws IOException
			 {
		/*
		 * Map<String, Object> response = new LinkedHashMap<String, Object>();
		 * response.put("header", "projects"); response.put("Error", false);
		 */
		List<Customer> result = hotelService.getAllCustomerDataIntoExcelSheet();
		  AppController.writeCustomerData(result);
		/*
		 * response.put("body", result);
		 * response.put("Httpstatus", HttpStatus.FOUND); return new
		 * ResponseEntity<Map<String, Object>>(response, HttpStatus.FOUND);
		 */
		  return result;
	}

	public static void writeCustomerData(List<Customer> customers) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Customer Details");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("customerId");
		headerRow.createCell(1).setCellValue("customerName");
		headerRow.createCell(2).setCellValue("PhoneNum");
		headerRow.createCell(3).setCellValue("checkInDate");
		headerRow.createCell(4).setCellValue("checkOutDate");
		headerRow.createCell(5).setCellValue("roomType");
		headerRow.createCell(6).setCellValue("hobby");
		headerRow.createCell(7).setCellValue("gender");
		headerRow.createCell(8).setCellValue("comments");
		headerRow.createCell(9).setCellValue("emailId");
		int rowNum = 1;
		for (Customer customer : customers) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(customer.getCustomerId());
			row.createCell(1).setCellValue(customer.getCustomerName());
			row.createCell(2).setCellValue(customer.getPhoneNum());
			row.createCell(3).setCellValue(customer.getCheckInDate());
			row.createCell(4).setCellValue(customer.getCheckOutDate());
			row.createCell(5).setCellValue(customer.getRoomType());
			row.createCell(6).setCellValue(customer.getHobby());
			row.createCell(7).setCellValue(customer.getGender());
			row.createCell(8).setCellValue(customer.getComments());
			row.createCell(9).setCellValue(customer.getEmailId());

		}
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("D:\\customer.xlsx");
			workbook.write(fileOutputStream);
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		}

	}
}
