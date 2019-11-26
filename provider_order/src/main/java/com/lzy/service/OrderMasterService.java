package com.lzy.service;


import com.lzy.pojo.OrderMaster;
import com.lzy.vo.OrderMasterVO;
import org.springframework.data.domain.Page;

public interface OrderMasterService {

    Page<OrderMaster> list(OrderMasterVO orderMasterVO);
}
