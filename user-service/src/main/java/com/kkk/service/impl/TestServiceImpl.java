package com.kkk.service.impl;

import com.kkk.chat.client.ChatFeignClient;
import com.kkk.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/26 10:21
 * @Version V1.0
 */
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
@Slf4j
public class TestServiceImpl implements TestService {

    @Resource
    private ChatFeignClient chatFeignClient;
    @Override
    public String ChatClient(String msg) {
        String answer = chatFeignClient.getChat(msg);
        log.info("GPT：{}", answer);
        return answer;
    }
}
