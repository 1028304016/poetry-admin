package com.poetry.service;

import com.poetry.entity.Poetry;
import com.poetry.entity.WxUser;

import java.util.Optional;

/**
 * @program: poetry-admin->PoetryService
 * @description: 诗词业务层处理
 * @author: yangyi
 * @create: 2020-01-13
 **/
public interface PoetryService {

    /**
     * 随机查询一条数据
     */
    Poetry findOne(String type);

    /**
     * 新增一个问题
     */
    Integer addone(Poetry poetry);
    /**
     * 授权登录
     */
    WxUser login(WxUser wxUser);
}