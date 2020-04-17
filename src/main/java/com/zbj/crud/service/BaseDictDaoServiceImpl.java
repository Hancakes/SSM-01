package com.zbj.crud.service;

import com.zbj.crud.mapper.BaseDictDao;
import com.zbj.crud.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictDaoServiceImpl implements BaseDictDaoService{

    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> selectBaseDictListByCode(String code) {
        List<BaseDict> list = this.baseDictDao.selectBaseDictListByCode(code);
        return list;
    }
}
