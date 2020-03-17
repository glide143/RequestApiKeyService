package com.mel.demo.controller;

import com.mel.demo.domain.GlobeKey;
import com.mel.demo.service.manager.GlobeLabsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/globe-lab-request", produces="application/json")
public class RequestApiController {
    @Autowired
    private GlobeLabsRequest service;

    @PostMapping(value = "/keys")
    @ResponseStatus(HttpStatus.CREATED)
    public GlobeKey displayUser(
            @RequestParam("app_id")
                    String appId,
            @RequestParam("app_secret")
                    String appSecret,
            @RequestParam("code")
                    String code) {

        return service.getKeys(appId, appSecret, code).orElse(null);
    }

    @GetMapping(value = "")
    public String displayCode(@RequestParam("code") String code) {
        return service.getCode(code).orElse(null);
    }

}
