package com.example.demo.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Api(tags = "文心一言")
@CrossOrigin
@RestController
public class AIController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "AI问答")
    @PostMapping("/wxchat")
    public Result appapi(@RequestBody Map<String, String> que){
        String bid = que.get("bid");
        String ans = que.get("que");

        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";
        String accessToken = "24.72f8da8f2fa955c9f8920e01eff63534.2592000.1723010334.282335-42552253";

        HashMap<String, String> msg = new HashMap<>();
        msg.put("role", "user");
        msg.put("content",ans);

        ArrayList<HashMap> messages = new ArrayList<>();
        messages.add(msg);

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);

        String res = HttpUtil.post(url + "?access_token=" + accessToken, JSONUtil.toJsonStr(requestBody));
        JSONObject result = JSONObject.parseObject(res);
        String s;
        s=result.getString("result");
        if(s!=null){
            userService.addarchives(bid,s);
            return Result.success(s);
        }else{
            return Result.error("获取失败");
        }
    }
}
