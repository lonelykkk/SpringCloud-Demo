package com.kkk.domain.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 14:17
 * @Version V1.0
 */
@Data
public class UserAvatarVo {

    private Long id;

    private MultipartFile img;
}
