package com.poetry.entity;

import javax.persistence.*;

/**
 * @program: poetry-admin->Dict
 * @description: 诗词选项实体
 * @author: yangyi
 * @create: 2020-01-13
 **/
@Entity
@Table(name = "dict")
public class Dict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键
    private String poetryId;//关联id
    private String selectKey;//选项key
    private String selectValue;//选项value

    public Dict() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(String poetryId) {
        this.poetryId = poetryId;
    }

    public String getSelectKey() {
        return selectKey;
    }

    public void setSelectKey(String selectKey) {
        this.selectKey = selectKey;
    }

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }
}