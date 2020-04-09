package com.poetry.repository;

import com.poetry.entity.Poetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @program: poetry-admin->PoetryRepository
 * @description: 数据层处理
 * @author: yangyi
 * @create: 2020-01-13
 **/
public interface PoetryRepository extends JpaRepository<Poetry,Integer> {

    //@Query(value ="select count(poetry.id)  from Poetry poetry where poetry.type =?1 ",nativeQuery = true)
    //Integer queryTotal(String type);

    @Query(value ="select *  from  poetry where type =?1 order by num asc limit 1 ",nativeQuery = true)
    Poetry queryLessOne(String type);


    @Transactional
    @Modifying
    @Query(value ="update poetry set num=num+1 where id=:id ",nativeQuery = true)
    void updateLessOne(@Param("id") Long id);
}