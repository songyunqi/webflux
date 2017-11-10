/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oauth2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

/**
 *
 * @author Yang
 */
public class OAuth2Service {

    /**
     *
     * @param accessTokenURL
     * @return
     * @throws IOException
     */
    public String getAccessToken(String accessTokenURL) throws IOException {

        //String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=" + clientId + "&client_secret=" + clientSecret + "&redirect_uri=" + loginSuccessURL + "&code=" + code;
        HttpGet request = new HttpGet(accessTokenURL);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        String result = "";
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        return result;
    }

    /**
     *
     * @param userInfoURL
     * @return
     * @throws java.io.IOException
     */
    public String getUserInfo(String userInfoURL) throws IOException {
        //String userInfoURL = "https://graph.qq.com/oauth2.0/me?access_token=" + accessToken;
        HttpGet request = new HttpGet(userInfoURL);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        String result = "";
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        return result;
    }

    public static Map<String, String> WrapResult(String result) {
        if (StringUtils.isEmpty(result)) {
            return new HashMap<>();
        }
        Map<String, String> paramMap = new HashMap<>();
        if (result != null && !"".equals(result)) {
            String[] temp = result.split("&");
            for (String temp1 : temp) {
                String[] obj = temp1.split("=");
                paramMap.put(obj[0], obj[1]);
            }
        }
        return paramMap;

    }
}
