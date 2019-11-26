package com.lzy.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderMasterVO {
    private  Integer pageNo;
    private  Integer pageSize;

    private String order_id;

    private String people_name;

    private  String People_phone;

    private Date start_time_start;
    private Date start_time_stop;

    private Date stop_time_start;
    private Date stop_time_stop;


}
