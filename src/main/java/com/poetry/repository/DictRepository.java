package com.poetry.repository;

import com.poetry.entity.Dict;
import com.poetry.entity.Poetry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: poetry-admin->DictRepository
 * @description: 选项数据层处理
 * @author: yangyi
 * @create: 2020-01-13
 **/
public interface DictRepository extends JpaRepository<Dict,Integer> {

    List<Dict> findDictByPoetryId(String poetryId);
}