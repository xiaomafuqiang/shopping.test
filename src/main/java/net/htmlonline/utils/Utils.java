package net.htmlonline.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Utils {
    public static String parseRequestJson(HttpServletRequest req) {

        try {
            BufferedReader reader = req.getReader();
            StringBuilder jsonRequest = new StringBuilder();

            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
                jsonRequest.append(s);
            }
            System.out.println("request data::: " + jsonRequest);
            return jsonRequest.toString();
        } catch (IOException e) {
            System.out.println("error int utils parseRequestJson... " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }



    public static String result(String result, Integer status) {
        if (status == null) {
            status = 200;
        }
        JSONObject jsonObject = JSON.parseObject(result);
        HashMap<String, Object> map = new HashMap<>();
        map.put("ok", true);
        map.put("status", status);
        map.put("data", jsonObject);

        return JSON.toJSONString(map);
    }

}
