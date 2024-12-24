package com.kkk.service;

import com.kkk.domain.dto.UserDto;
import com.kkk.domain.vo.UserLoginVo;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/22 20:18
 * @Version V1.0
 */
public interface UserService {
    void addUser(UserDto userDto);

    UserLoginVo login(UserDto userDto);
}
