package com.kkk.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
* 标签
* @TableName tag
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {

    /**
    * 
    */
    private Long id;
    /**
    * 标签名
    */
    private String name;
    /**
    * 
    */
    private Long createBy;
    /**
    * 
    */
    private Date createTime;
    /**
    * 
    */
    private Long updateBy;
    /**
    * 
    */
    private Date updateTime;
    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    private Integer delFlag;
    /**
    * 备注
    */
    private String remark;

}
