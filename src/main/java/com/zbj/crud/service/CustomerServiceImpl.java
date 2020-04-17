package com.zbj.crud.service;

import com.zbj.common.utils.Page;
import com.zbj.crud.mapper.CustomerDao;
import com.zbj.crud.pojo.Customer;
import com.zbj.crud.pojo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService{


    @Autowired
    private CustomerDao customerDao;

    //通过4个条件 查询分页对象
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {
        Page<Customer> page = new Page<Customer>();

        page.setSize(5);
        //每页列表行数
        vo.setSize(5);

        if (null != vo) {
            if (null != vo.getPage()) {
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customerDao.customerCountByQueryVo(vo));
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));
        }

            return  page;
    }

    @Override
    public Customer selectCustomerById(Integer id) {
        return customerDao.selectCustomerById(id);
    }

    //修改
    public void UpdateCustomerById(Customer customer){
         customerDao.UpdateCustomerById(customer);
    }

    //删除
    public void DeteleCustomerByID(Integer id){
        customerDao.DeteleCustomerByID(id);
    }
}
