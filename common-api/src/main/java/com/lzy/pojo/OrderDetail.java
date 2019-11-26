package com.lzy.pojo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_orderdetail")
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "order")
    @GenericGenerator(name = "order",strategy = "com.lzy.utils.UserIdentityGenerator")
    private String detail_id;

    private String product_name;

    private BigDecimal product_price;

    private Integer product_num;

    private String start_Address;
    private String stop_Address;

    private Integer day_start;
    private Integer day_stop;
    private String descs;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private OrderMaster master;


}
