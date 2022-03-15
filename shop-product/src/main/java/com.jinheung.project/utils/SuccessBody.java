package com.jinheung.project.utils;

import java.util.HashMap;
import java.util.Map;

public class SuccessBody {
    public static HashMap<String, Object> body(Map<String, Object> addBody) {
        return new HashMap<>(){{
                    put("success", true);
                    put("data", addBody);
                }};
    }


}
