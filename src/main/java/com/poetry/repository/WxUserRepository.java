package com.poetry.repository;

import com.poetry.entity.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @program: poetry-admin->WxUserRepository
 * @description: 数据层处理
 * @author: yangyi
 * @create: 2020-01-13
 **/
public interface WxUserRepository extends JpaRepository<WxUser,Integer> {

    @Query(value ="select *  from wx_user where avatar_url =?1 ",nativeQuery = true)
    WxUser queryUserByUrl(String avatarUrl);
}