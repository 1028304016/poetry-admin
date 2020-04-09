package com.poetry.service.impl;

import com.poetry.entity.Dict;
import com.poetry.entity.Poetry;
import com.poetry.entity.WxUser;
import com.poetry.repository.DictRepository;
import com.poetry.repository.PoetryRepository;
import com.poetry.repository.WxUserRepository;
import com.poetry.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: poetry-admin->PoetryServiceImpl
 * @description: 诗词业务层处理
 * @author: yangyi
 * @create: 2020-01-13
 **/
@Component
public class PoetryServiceImpl  implements PoetryService {

    @Autowired
    private PoetryRepository poetryRepository;

    @Autowired
    private DictRepository dictRepository;

    @Autowired
    private WxUserRepository wxUserRepository;

    @Override
    public Poetry findOne(String type) {

        //取出访问量最少的一道题
        Poetry poetry=poetryRepository.queryLessOne(type);
        List<Dict> dicts=dictRepository.findDictByPoetryId(poetry.getId().toString());
        poetry.setDicts(dicts);
        //取出问题后计数+1
        poetryRepository.updateLessOne(poetry.getId());

        /*//随机选择一个问题
        //取出库中问题总数
        Integer problowTotal=poetryRepository.queryTotal(type);
        if(problowTotal==0){
            return null;
        }
        for (int i = 0; i <100 ; i++) {
            Integer poetryId=((int) (Math.random()*problowTotal)+1);
            Optional<Poetry> poetry=poetryRepository.findById(poetryId);
            List<Dict> dicts=dictRepository.findDictByPoetryId(poetryId.toString());
            if(null!=dicts && dicts.size()>0){
                Poetry result=poetry.get();
                result.setDicts(dicts);
                return result;
            }
        }*/
        return poetry;
    }

    @Transactional
    @Override
    public Integer addone(Poetry poetry) {

        Poetry poetryReturn=poetryRepository.save(poetry);

        //问题选项
        for(Dict dict : poetry.getDicts()){
            Dict dictInsert = new Dict();
            dictInsert.setPoetryId(poetryReturn.getId().toString());
            dictInsert.setSelectKey(dict.getSelectKey());
            dictInsert.setSelectValue(dict.getSelectValue());
            dictRepository.save(dictInsert);
        }
        return 1;
    }

    @Override
    public WxUser login(WxUser wxUser) {
        WxUser poetryReturn=null;
        //判断是否存在用户
        poetryReturn=wxUserRepository.queryUserByUrl(wxUser.getAvatarUrl());
        if(poetryReturn==null){
            poetryReturn=wxUserRepository.save(wxUser);
        }
        return poetryReturn;
    }
}