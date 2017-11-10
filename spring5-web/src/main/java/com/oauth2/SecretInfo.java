/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oauth2;

import lombok.Data;

/**
 *
 * @author Yang
 */
@Data
public class SecretInfo {

    //客户端Id,配置得到
    private String clientId;
    //客户端密钥,配置得到
    private String clientSecret;
    //重定向code.
    //  QQ --> String url = "https://graph.qq.com/oauth2.0/authorize?client_id="+ clientId + "&redirect_uri="+ redirectURI+ "&response_type=code&state=test&scope=get_user_info,add_topic,add_one_blog,add_album,upload_pic,list_album,add_share,check_page_fans,add_t,add_pic_t,del_t,get_repost_list,get_info,get_other_info,get_fanslist,get_idollist,add_idol,del_ido,get_tenpay_addr";
    //sina --> String url = "https://api.weibo.com/oauth2/authorize?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectURI;
    //通过重定向得到
    private String code;
    // QQ POST --> String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=" + clientId + "&client_secret=" + clientSecret + "&redirect_uri=" + redirectURI+ "&code=" + code;
    // sina POST --> String url = "https://api.weibo.com/oauth2/access_token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&redirect_uri=" + redirectURI+ "&code=" + code;
    private String accessToken;
    // POST --> String url1 = "https://graph.qq.com/oauth2.0/me?access_token=" + accessToken;
    // 新浪在获取accessToken这一步就可以获取uid
    //qq称为openId，新浪叫做uid
    private String openId;
    //获取用户信息
    //String url = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=" + clientId + "&access_token=" + accessToken + "&openid=" + openid + "&format=json";
    //String url = "https://api.weibo.com/2/users/show.json?access_token=" + accessToken + "&uid=" + uid;
}
