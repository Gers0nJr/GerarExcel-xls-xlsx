package br.com.gerson.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jxls.template.SimpleExporter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerson.model.Person;

@RestController
@RequestMapping("/")
public class ExportXlsController {
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public void export(HttpServletResponse response) {
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person("Gerson", "Junior"));
		persons.add(new Person("Wislane", "Costa"));
		persons.add(new Person("Caio", "Henrique"));
		persons.add(new Person("Joana", "Rogerio"));
		persons.add(new Person("Gerson", "Batista"));
		persons.add(new Person("Samilly", "Dias"));
		persons.add(new Person("Maria", "Augusta"));
		persons.add(new Person("Victor", "Vinicus"));
		
		List<String> headers = Arrays.asList("First Name", "Last Name");
		
		try {
			
			response.addHeader("Content-disposition", "attachment; filename=People.xls");
			response.setContentType("application/vnd.ms-excel");
			new SimpleExporter().gridExport(headers, persons, "firstName, lastName, ", response.getOutputStream());
			response.flushBuffer();
			
		} catch (IOException e) {
			
			
			
		}
	}

}
