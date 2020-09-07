package com.qas.web.domains;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
@Lazy
public class Board {
    private Integer postIdx;
    private String postTitle;
    private String postContent;
    private String imgFile;
    private Timestamp insertDate;
    private Timestamp updateDate;
    private String tagContent;
    private Boolean postLike;
    private Integer postLikeCount;
    private Integer commentCount;
}
