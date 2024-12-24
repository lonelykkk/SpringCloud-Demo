package com.kkk.domain.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/26 16:26
 * @Version V1.0
 */
@Data
public class AiChatVo {
    private String question;
    private String answer;
    private Date createTime;
}
