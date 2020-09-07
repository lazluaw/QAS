package com.qas.web.domains;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
@Lazy
public class Comment {
    protected Integer commentIdx;
    protected String commentContent;
    protected Boolean commentLike;
    protected Integer commentLikeCount;
    protected Timestamp insertDate;
    protected Timestamp updateDate;
    protected String userId;
}
