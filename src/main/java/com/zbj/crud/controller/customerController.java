package com.zbj.crud.controller;

import com.zbj.common.utils.Page;
import com.zbj.crud.pojo.BaseDict;
import com.zbj.crud.pojo.Customer;
import com.zbj.crud.pojo.QueryVo;
import com.zbj.crud.service.BaseDictDaoService;
import com.zbj.crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class customerController {

    @Autowired
    private BaseDictDaoService baseDictDaoService;
    @Autowired
    private CustomerService customerService;

    //注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;
    @Value("${industryType.Code}")
    private String industryTypeCode;
    @Value("${levelType.Code}")
    private String levelTypeCode;

    @RequestMapping(value = "/customer/list")
    public String list(QueryVo vo , Model model){
        List<BaseDict> fromType = baseDictDaoService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictDaoService.selectBaseDictListByCode(industryTypeCode);
        List<BaseDict> levelType = baseDictDaoService.selectBaseDictListByCode(levelTypeCode);

        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        //通过4个条件 查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page",page);
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custSource",vo.getCustSource());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        model.addAttribute("custLevel",vo.getCustLevel());
        return "customer";
    }
    //去修改页面
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){

        return customerService.selectCustomerById(id);
    }
    //修改
    @RequestMapping(value = "/customer/update.action")
    public @ResponseBody
    String Uptate(Customer customer){
        customerService.UpdateCustomerById(customer);
        return "ok";
    }

    //删除
    @RequestMapping(value = "/customer/delete.action")
    public @ResponseBody
    String Delete(Integer id){
        customerService.DeteleCustomerByID(id);
        return "ok";
    }
}
