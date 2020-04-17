package com.zbj.crud.service;

import com.zbj.common.utils.Page;
import com.zbj.crud.pojo.Customer;
import com.zbj.crud.pojo.QueryVo;

public interface CustomerService {

    public Page<Customer> selectPageByQueryVo(QueryVo vo);

    //通过cust_id返回数据集
    public Customer selectCustomerById(Integer id);

    //修改
    public void UpdateCustomerById(Customer customer);

    //通过id删除
    public void DeteleCustomerByID(Integer id);
}
