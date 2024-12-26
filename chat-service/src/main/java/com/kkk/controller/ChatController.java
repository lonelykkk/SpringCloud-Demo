package com.kkk.controller;

import com.kkk.client.RemoteClient;
import com.kkk.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/26 10:09
 * @Version V1.0
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @PostMapping("/getChat")
    public String getChat(String msg) {
        return chatService.getChat(msg);
    }
}
