package com.lzy.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_ordermaster")
@Getter
@Setter
public class OrderMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "order")
    @GenericGenerator(name = "order",strategy = "com.lzy.utils.UserIdentityGenerator")
    private String order_id;

    private String people_name;

    private  String People_phone;

    private Date start_time;

    private Date stop_time;

    @OneToMany(mappedBy = "master")
    private List<OrderDetail> details;


}
