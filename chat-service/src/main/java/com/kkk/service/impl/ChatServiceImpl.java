package com.kkk.service.impl;

import com.kkk.client.RemoteClient;
import com.kkk.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/26 11:07
 * @Version V1.0
 */
@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Autowired
    private RemoteClient remoteClient;


    @Override
    public String getChat(String msg) {
        String chat = remoteClient.getPowerAiChat(msg, 1);
        log.info("gpt接口调用： {}", chat);
        return chat;
    }
}
