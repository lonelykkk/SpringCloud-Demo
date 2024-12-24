package com.kkk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 10:09
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    private String username;
    private String password;
    private String email;
}