package com.example.demo.service.manager;

import com.example.demo.domain.GlobeKey;

public interface GlobeLabsRequest {
	public GlobeKey getKeys(String appId, String appSecret, String code);

	public void getCode(String code);
}
