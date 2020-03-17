package com.mel.demo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mel.demo.domain.GlobeKey;
import com.mel.demo.service.manager.GlobeLabsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class GlobeLabsRequestImpl implements GlobeLabsRequest {
    private static final String AUTHENTICATION_URL = "http://developer.globelabs.com.ph/oauth/access_token";
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobeLabsRequestImpl.class);


    @Override
    public Optional<GlobeKey> getKeys(String appId, String appSecret, String code) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(AUTHENTICATION_URL)
                                                           .queryParam("app_id", appId)
                                                           .queryParam("app_secret", appSecret)
                                                           .queryParam("code", code);
       GlobeKey response = new RestTemplate().postForObject(builder.toUriString(), null, GlobeKey.class);

        return ofNullable(response);
    }

    @Override
    public Optional<String> getCode(String code) {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        ObjectMapper mapper = new ObjectMapper();
        Optional<String> jsonResult;
        try {
            jsonResult = ofNullable(mapper.writeValueAsString(map));
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
            return Optional.empty();
        }
        return jsonResult;
    }

}
