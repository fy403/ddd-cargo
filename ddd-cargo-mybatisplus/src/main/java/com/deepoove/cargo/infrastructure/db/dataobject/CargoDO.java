package com.deepoove.cargo.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

@TableName(value = "ddd_cargo")
public class CargoDO {
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @TableField("sender_phone")
    private String senderPhone;

    @TableField("description")
    private String description;

    @TableField("originLocation_code")
    private String originLocationCode;

    @TableField("destinationLocation_code")
    private String destinationLocationCode;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updated_at", fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

}
