package com.lzy.service.impl;

import com.lzy.dao.OrderMasterMapper;
import com.lzy.pojo.OrderMaster;
import com.lzy.service.OrderMasterService;
import com.lzy.vo.OrderMasterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Override
    public Page<OrderMaster> list(OrderMasterVO orderMasterVO) {
        Specification<OrderMaster> specification = new Specification<OrderMaster>() {
            @Override
            public Predicate toPredicate(Root<OrderMaster> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                List<Predicate> list = new ArrayList<>();
                if(orderMasterVO.getOrder_id() != null){
                    Predicate p1 = cb.like(root.get("order_id"), "%" + orderMasterVO.getOrder_id() + "%");
                    list.add(p1);
                }
                if(orderMasterVO.getPeople_name() != null){
                    Predicate p2 = cb.like(root.get("people_name"), "%" + orderMasterVO.getPeople_name() + "%");
                    list.add(p2);
                }
                if(orderMasterVO.getPeople_phone() != null){
                    Predicate p3 = cb.like(root.get("people_phone"), "%" + orderMasterVO.getPeople_phone() + "%");
                    list.add(p3);
                }
                if(orderMasterVO.getStart_time_start() != null){
                    Predicate p4 = cb.greaterThanOrEqualTo(root.get("start_time"), orderMasterVO.getStart_time_start());
                    list.add(p4);
                }
                if(orderMasterVO.getStart_time_stop() != null){
                    Predicate p5 = cb.lessThanOrEqualTo(root.get("start_time"), orderMasterVO.getStart_time_stop());
                    list.add(p5);
                }
                if(orderMasterVO.getStop_time_start() != null){
                    Predicate p4 = cb.greaterThanOrEqualTo(root.get("stop_time"), orderMasterVO.getStop_time_start());
                    list.add(p4);
                }
                if(orderMasterVO.getStop_time_stop() != null){
                    Predicate p5 = cb.lessThanOrEqualTo(root.get("stop_time"), orderMasterVO.getStop_time_stop());
                    list.add(p5);
                }

                Predicate[] Predicate = list.toArray(new Predicate[list.size()]);
                return cb.and(Predicate);
            }
        };

        return  orderMasterMapper.findAll(specification, PageRequest.of(orderMasterVO.getPageNo() - 1, orderMasterVO.getPageSize()));



    }
}
