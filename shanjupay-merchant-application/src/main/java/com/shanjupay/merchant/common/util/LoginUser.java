package com.shanjupay.merchant.common.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: sqx
 * @Date: 2022/8/21
 */
@Data
public class LoginUser {
    private String mobile;
    private Map<String, Object> payload = new HashMap<>();
    private String clientId;
    private String username;

}
