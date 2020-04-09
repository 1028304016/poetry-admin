package com.poetry.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @program: poetry-admin->Poetry
 * @description: 诗词实体
 * @author: yangyi
 * @create: 2020-01-13
 **/
@Entity
@Table(name = "poetry")
public class Poetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键
    private String content;//内容
    private String answer;//答案
    private Long num;//计数
    private String type;//问题类型
    private String detail;//描述
    /**
     * 选择列表
     */
    @Transient
    private List<Dict> dicts;

    public Poetry() {
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Dict> getDicts() {
        return dicts;
    }

    public void setDicts(List<Dict> dicts) {
        this.dicts = dicts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}