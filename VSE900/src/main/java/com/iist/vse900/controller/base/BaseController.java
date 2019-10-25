package com.iist.vse900.controller.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    protected ResponseEntity<?> buildResultJson(int statusCode, String statusMessage, Object body) {
        Map<String, Object> jsonObject = new HashMap();
        jsonObject.put("statusCode", statusCode);
        jsonObject.put("statusMessage", StringUtils.isNotBlank(statusMessage) ? statusMessage : "");
        jsonObject.put("body", body);
        return ResponseEntity.ok(jsonObject);
    }
}
