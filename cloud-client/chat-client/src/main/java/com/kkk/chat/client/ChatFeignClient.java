package com.kkk.chat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/12/26 10:18
 * @Version V1.0
 */
@FeignClient("chat-service")
public interface ChatFeignClient {

    @PostMapping("/chat/getChat")
    public String getChat(String msg);
}
