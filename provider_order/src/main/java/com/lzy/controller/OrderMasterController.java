package com.lzy.controller;

import com.lzy.pojo.OrderMaster;
import com.lzy.service.OrderMasterService;
import com.lzy.vo.OrderMasterVO;
import com.lzy.vo.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderMasterController {
    @Autowired
    private OrderMasterService orderMasterService;


    @RequestMapping("list")
    public PageResponse<OrderMaster> list(OrderMasterVO orderMasterVO){

        Page<OrderMaster> page = orderMasterService.list(orderMasterVO);

        return  new PageResponse<>(page.getTotalPages(),page.getTotalElements(),page.getContent());
    }
}
