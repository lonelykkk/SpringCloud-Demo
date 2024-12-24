package com.kkk.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 18/7/2024 上午 10:23
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo {

    /**
     * 文章id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章摘要
     */
    private String summary;
    /**
     * 所属分类id
     */
    private String categoryName;

    private List<String> tagName;
    /**
     * 缩略图
     */
    private String thumbnail;
    /**
     * 访问量
     */
    private Long viewCount;
    /**
     * 是否允许评论 1是，0否
     */
    private Long createBy;
    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     *
     */
    private Long updateBy;
    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
