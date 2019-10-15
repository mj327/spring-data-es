package com.agiview.flightupgrade.service.elastic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author MaJun
 * Created at 5:00 PM, 2019-09-18
 * 操作日志索引模型类
 */
@Document(indexName = "operation_log", type = "docs", shards = 1, replicas = 0)
public class OperationLog {

    /**
     * 主键
     * 若想使用ES自动生成主键的方式则必须使用String类型
     */
    @Id
    private String operationLogId;

    /**
     * 操作者姓名
     */
    @Field(type = FieldType.Keyword)
    private String operatorName;

    /**
     * 操作描述
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String operationDesc;

    /**
     * 操作对象id
     */
    @Field(type = FieldType.Integer)
    private int operatingObjectId;

    /**
     * 本条记录创建时间
     */
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public String getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(String operationLogId) {
        this.operationLogId = operationLogId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public int getOperatingObjectId() {
        return operatingObjectId;
    }

    public void setOperatingObjectId(int operatingObjectId) {
        this.operatingObjectId = operatingObjectId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "operationLogId='" + operationLogId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operationDesc='" + operationDesc + '\'' +
                ", operatingObjectId=" + operatingObjectId +
                ", createTime=" + createTime +
                '}';
    }
}
