package com.aktasci.helpinghands.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aktasci.helpinghands.domain.NeededSupport;
import com.aktasci.helpinghands.service.NeededSupportService;

@RestController
@RequestMapping("/neededSupport")
public class NeededSupportController {

	@Autowired
	NeededSupportService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public NeededSupport save(@RequestBody NeededSupport neededSupport) {
		return service.save(neededSupport);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
