package com.youthSupport.controller;// Spring Controller (backend)


import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

    @GetMapping("/data")
    public Map getData(
            @RequestParam String openApiVlak,
            @RequestParam int display,
            @RequestParam int pageIndex,
            @RequestParam(required = false) String srchPolicyId,
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String bizTycdSel,
            @RequestParam(required = false) String srchPolyBizSecd,
            @RequestParam(required = false) String keyword) {
        // Open API 호출
        String url = "https://www.youthcenter.go.kr/opi/youthPlcyList.do?openApiVlak=" + openApiVlak
                + "&display=" + display + "&pageIndex=" + pageIndex;

        if (srchPolicyId != null) url += "&srchPolicyId=" + srchPolicyId;
        if (query != null) url += "&query=" + query;
        if (bizTycdSel != null) url += "&bizTycdSel=" + bizTycdSel;
        if (srchPolyBizSecd != null) url += "&srchPolyBizSecd=" + srchPolyBizSecd;
        if (keyword != null) url += "&keyword=" + keyword;

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        return restTemplate.getForObject(url, Map.class);
    }
}
