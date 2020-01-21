package com.mindtree.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

}
/*
 * //public static void writeCustomerData(List<Customer> customers) {
 * XSSFWorkbook workbook = new XSSFWorkbook(); Sheet sheet =
 * workbook.createSheet("Customer Details"); Row headerRow = sheet.createRow(0);
 * headerRow.createCell(0).setCellValue("customerId");
 * headerRow.createCell(1).setCellValue("customerName");
 * headerRow.createCell(2).setCellValue("PhoneNum");
 * headerRow.createCell(3).setCellValue("checkInDate");
 * headerRow.createCell(4).setCellValue("checkOutDate");
 * headerRow.createCell(5).setCellValue("roomType");
 * headerRow.createCell(6).setCellValue("hobby");
 * headerRow.createCell(7).setCellValue("gender");
 * headerRow.createCell(8).setCellValue("comments");
 * headerRow.createCell(9).setCellValue("emailId"); int rowNum = 1; for
 * (Customer customer : customers) { Row row = sheet.createRow(rowNum++);
 * headerRow.createCell(0).setCellValue(customer.getCustomerId());
 * headerRow.createCell(1).setCellValue(customer.getCustomerName());
 * headerRow.createCell(2).setCellValue(customer.getPhoneNum());
 * headerRow.createCell(3).setCellValue(customer.getCheckInDate());
 * headerRow.createCell(4).setCellValue(customer.getCheckOutDate());
 * headerRow.createCell(5).setCellValue(customer.getRoomType());
 * headerRow.createCell(6).setCellValue(customer.getHobby());
 * headerRow.createCell(7).setCellValue(customer.getGender());
 * headerRow.createCell(8).setCellValue(customer.getComments());
 * headerRow.createCell(9).setCellValue(customer.getEmailId());
 * 
 * } try { FileOutputStream fileOutputStream = new
 * FileOutputStream("D:\\customer.xlsx"); workbook.write(fileOutputStream); }
 * catch (FileNotFoundException e) { }
 * 
 * }
 */