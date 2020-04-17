package com.zbj.crud.service;

import com.zbj.crud.pojo.BaseDict;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseDictDaoService {
    public List<BaseDict> selectBaseDictListByCode(String code);
}
