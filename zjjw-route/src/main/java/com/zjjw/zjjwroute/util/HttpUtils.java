package com.zjjw.zjjwroute.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjjw.common.res.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Auther: frozen
 * @Date: 2019/9/22 12:32
 * @Description:
 */
@Service
@Slf4j
public class HttpUtils {

    @Autowired
    private OkHttpClient okHttpClient;

    private MediaType mediaType = MediaType.parse("application/json");
    public BaseResponse sendMsg(String url, JSONObject param) {
        try {
            RequestBody requestBody = RequestBody.create(mediaType, param.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            ResponseBody body = response.body();
            try {
                if (!response.isSuccessful()) {
                    log.error("url={},param={},response",url,param,response);
                    return null;
                }
                String json = body.string() ;
                return JSON.parseObject(json, BaseResponse.class);
            }finally {
                body.close();
            }
        }catch (Exception e){
            log.error("url={},param={}",url,param,e);
        }
        return null;
    }

}
