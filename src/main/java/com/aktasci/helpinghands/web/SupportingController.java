package com.aktasci.helpinghands.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aktasci.helpinghands.domain.Supporting;
import com.aktasci.helpinghands.service.SupportingService;

@RestController
@RequestMapping("/supporting")
public class SupportingController {

	@Autowired
	SupportingService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Supporting save(@RequestBody Supporting supporting) {
		return service.save(supporting);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	
}
