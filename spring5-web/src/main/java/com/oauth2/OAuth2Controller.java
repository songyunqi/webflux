/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oauth2;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Yang
 */
@Controller
public class OAuth2Controller {

    @RequestMapping("triggerSNSLogin")
    public void trig(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String clientId = "";
        String redirectURL = "";
        String url = "https://graph.qq.com/oauth2.0/authorize?client_id="
                + clientId
                + "&redirect_uri="
                + redirectURL
                + "&response_type=code&state=test&scope=get_user_info,add_topic,add_one_blog,add_album,upload_pic,list_album,add_share,check_page_fans,add_t,add_pic_t,del_t,get_repost_list,get_info,get_other_info,get_fanslist,get_idollist,add_idol,del_ido,get_tenpay_addr";
        response.sendRedirect(url);
    }

    @RequestMapping("afterRedirect")
    public ModelAndView afterRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //重定向得到的code
        String code = request.getParameter("code");
        String clientId = "";
        String clientSecret = "";

        String loginSuccessURL = "";

        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=" + clientId + "&client_secret=" + clientSecret + "&redirect_uri=" + loginSuccessURL
                + "&code=" + code;
        //GetMethod getAccessToken = new GetMethod(url);
        HttpClient client = new HttpClient();
        
        HttpGet getAccessToken = new GetMethod(url);
        
        client.executeMethod(getAccessToken);
        String oauthResponseBody = getAccessToken.getResponseBodyAsString();
        //分割成为map
        Map<String, String> responseBodyMap = StringUtil.formatString(oauthResponseBody);

        String accessToken = responseBodyMap.get("access_token");

        String userInfoURL = "https://graph.qq.com/oauth2.0/me?access_token=" + accessToken;

        GetMethod getUserInfo = new GetMethod(userInfoURL);

        client.executeMethod(getUserInfo);

        String userInfoResponseBody = getUserInfo.getResponseBodyAsString();

        String openid = StringUtil.getOpenId(s);

        return null;
    }

}
