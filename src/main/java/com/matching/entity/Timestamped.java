package com.matching.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public interface Timestamped {

    @CreatedDate //생성시간 저장
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정시간 저장
    private LocalDateTime modifiedAt;

}
