package com.zbj.crud.mapper;

import com.zbj.crud.pojo.Customer;
import com.zbj.crud.pojo.QueryVo;

import java.util.List;

public interface CustomerDao {
    //总条数
    public  Integer customerCountByQueryVo(QueryVo vo);

    //结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);

    //通过cust_id返回数据集
    public Customer selectCustomerById(Integer id);

    //修改
    public void UpdateCustomerById(Customer customer);

    //删除
    public void DeteleCustomerByID(Integer id);
}
