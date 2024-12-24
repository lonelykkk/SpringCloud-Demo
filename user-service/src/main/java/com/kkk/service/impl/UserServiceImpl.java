package com.kkk.service.impl;

import com.kkk.domain.dto.UserDto;
import com.kkk.domain.entity.User;
import com.kkk.domain.enums.ResponseCodeEnum;
import com.kkk.domain.vo.UserLoginVo;
import com.kkk.exception.BusinessException;
import com.kkk.mapper.UserMapper;
import com.kkk.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/22 20:18
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 新增用户/注册
     * @param userDto
     */
    public void addUser(UserDto userDto) {
        User user = userMapper.selectByUserName(userDto.getUsername());
        if (user != null) {
            throw new BusinessException(ResponseCodeEnum.CODE_601);
        }
        user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        userMapper.insert(user);
    }

    @Override
    public UserLoginVo login(UserDto userDto) {
        User user = userMapper.selectByUserNameAndPassword(userDto.getUsername(),userDto.getPassword());
        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("loginDemo:user:token:" + token, user.getId().toString());
        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setUser(user);
        userLoginVo.setToken(token);
        return userLoginVo;
    }
}
