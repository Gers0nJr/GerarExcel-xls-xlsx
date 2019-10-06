package br.com.gerson.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerson.model.Customer;
import br.com.gerson.util.ExcelGenerator;

@RestController
@RequestMapping("/api/customers")
public class ExportXlsxController {
	
	@GetMapping(value = "/download/customers.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
    
	
	List<Customer> customers = new ArrayList<>();
	
	customers.add(new Customer(1L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(2L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(3L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(4L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(5L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(6L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(7L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
	customers.add(new Customer(8L, "Gerson Junior", "Rua Nicola Gagliotti", 33));
    
    ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers);
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }

}
