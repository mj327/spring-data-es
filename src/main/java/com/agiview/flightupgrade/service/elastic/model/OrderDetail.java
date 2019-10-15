package com.agiview.flightupgrade.service.elastic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

@Document(indexName = "order_detail", type = "docs", shards = 1, replicas = 0)
public class OrderDetail {

    /**
     * 订单id
     */
    @Id
    private int orderId;
    /**
     * 航班号
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String flightNo;
     /**
     * 起飞机场三字码
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String depAirportCode;
    /**
     * 降落机场三字码
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String arrAirportCode;
    /**
     * 活动开始时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    /**
     * 活动结束时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date resultTime;
    /**
     * 起飞时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date depTime;
    /**
     * 降落时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date arrTime;
    /**
     * 持票人姓名
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String bearerName;
    /**
     * 持票人证件号
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String bearerIdentifier;
    /**
     * 竞拍出价
     */
    @Field(type = FieldType.Float)
    private BigDecimal bid;
    /**
     * 实际总支付额
     */
    @Field(type = FieldType.Float)
    private BigDecimal actualPayment;
    /**
     * 实际总退款额
     */
    @Field(type = FieldType.Float)
    private BigDecimal actualRefund;
    /**
     * 实际总幸运球/扑克牌数量
     */
    @Field(type = FieldType.Integer)
    private int actualQuantity;
    /**
     * 订单状态
     */
    @Field(type = FieldType.Keyword)
    private String orderStatus;
    /**
     * 升舱状态
     */
    @Field(type = FieldType.Keyword)
    private String upgradeStatus;
    /**
     * 活动结果
     */
    @Field(type = FieldType.Keyword)
    private String activityResult;
}
