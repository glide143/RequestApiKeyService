package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.domain.GlobeKey;
import com.example.demo.service.manager.GlobeLabsRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GlobeLabsRequestImpl implements GlobeLabsRequest {
	private static final String AUTHENTICATION_URL = "http://developer.globelabs.com.ph/oauth/access_token";

	@Override
	public GlobeKey getKeys(String appId, String appSecret, String code) {

		RestTemplate restTemplate = new RestTemplate();

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTHENTICATION_URL)
				.queryParam("app_id", appId).queryParam("app_secret", appSecret).queryParam("code", code);

		GlobeKey response = restTemplate.postForObject(builder.toUriString(), null, GlobeKey.class);

		return response;
	}

	@Override
	public String getCode(String code) {
		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		try {
			jsonResult = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}

}
