package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.domain.GlobeKey;
import com.example.demo.service.manager.GlobeLabsRequest;

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
	public void getCode(String code) {
		System.out.println("CODE: " + code);

	}

}
