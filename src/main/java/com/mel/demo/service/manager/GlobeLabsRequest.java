package com.mel.demo.service.manager;

import com.mel.demo.domain.GlobeKey;

import java.util.Optional;

public interface GlobeLabsRequest {
	 Optional<GlobeKey> getKeys(String appId, String appSecret, String code);

	 Optional<String> getCode(String code);
}
