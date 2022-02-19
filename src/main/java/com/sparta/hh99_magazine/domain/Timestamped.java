package com.sparta.hh99_magazine.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우
// createAt, updatedAt을 컬럼으로 인식
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {
    // 추상 클래스: 미완성 설계도, 미완성 메서드를 갖고 있는 클래스
    // 목적 1: 다른 클래스 작성에 도움을 주기 위한 것, 인스턴스 생성 불가
    // 목적 2: 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우
    // 완성: 상속을 통해 추상 메서드를 완성해야 인스턴스 생성 가능
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
