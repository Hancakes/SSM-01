package com.zbj.crud.mapper;

import com.zbj.crud.pojo.BaseDict;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseDictDao {

    //查询
    public List<BaseDict> selectBaseDictListByCode(String code);
}
