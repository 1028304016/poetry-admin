package com.poetry.controller;

import com.alibaba.fastjson.JSONObject;
import com.poetry.entity.Poetry;
import com.poetry.entity.WxUser;
import com.poetry.service.PoetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @program: poetry-admin->PoetryController
 * @description: 诗词后台控制
 * @author: yangyi
 * @create: 2020-01-13
 **/
@Slf4j
@RestController
public class PoetryController {

    @Autowired
    private PoetryService poetryService;

    /*
     *授权登录
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public WxUser login(@RequestBody JSONObject user){
        WxUser wxUserresult=null;
        try {
            JSONObject task_json = user.getJSONObject("user_info");
            WxUser wxUser = (WxUser)JSONObject.toJavaObject(task_json,WxUser.class);
            wxUserresult=poetryService.login(wxUser);
        } catch (Exception e) {
            log.error(e.toString());
            return  wxUserresult;
        }
        return  wxUserresult;
    }

    /*
     *查询一条数据
     */
    @GetMapping(value = "/findone")
    public Poetry findOne(String type){

        return  poetryService.findOne(type);
    }

    /*
     *新增一个问题
     */
    @PostMapping(value = "/addone")
    @ResponseBody
    public String addone(@RequestBody JSONObject poetry){

        try {
            JSONObject task_json = poetry.getJSONObject("poetry");
            Poetry poetryOne = (Poetry)JSONObject.toJavaObject(task_json,Poetry.class);
            Integer result=poetryService.addone(poetryOne);
        } catch (Exception e) {
            log.error(e.toString());
            return  "操作有误";
        }
        return  "操作成功";
    }
}