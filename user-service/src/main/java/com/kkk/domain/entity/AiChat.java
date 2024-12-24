package com.kkk.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 
* @TableName ai_chat
*/
@Data
public class AiChat implements Serializable {

    /**
    * 主键id
    */
    private Long id;
    /**
    * 问题
    */
    private String question;
    /**
    * 回答
    */
    private String answer;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 创建时间
    */
    private Date createTime;

    private Long listId;

}
