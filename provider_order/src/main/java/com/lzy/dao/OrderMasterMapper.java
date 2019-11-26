package com.lzy.dao;


import com.lzy.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderMasterMapper extends JpaRepository<OrderMaster,String>, JpaSpecificationExecutor<OrderMaster> {
}
