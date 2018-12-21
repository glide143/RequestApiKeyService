package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.GlobeKey;
import com.example.demo.service.manager.GlobeLabsRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class RequestApiController {
	@Autowired
	private GlobeLabsRequest service;

	@RequestMapping(value = "/keys", method = RequestMethod.POST)
	public GlobeKey displayUser(@RequestParam("app_id") String appId, @RequestParam("app_secret") String appSecret,
			@RequestParam("code") String code) {

		return service.getKeys(appId, appSecret, code);
	}

	@RequestMapping(value = "/code", method = RequestMethod.GET)
	public String displayCode(@RequestParam("code") String code) throws JsonProcessingException {
		return service.getCode(code);
	}

}
