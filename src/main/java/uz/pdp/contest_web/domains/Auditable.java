package uz.pdp.contest_web.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Auditable {
    @Column(columnDefinition = "boolean default 'f'")
    private boolean deleted;

    @Column(columnDefinition = "timestamp default now()", updatable = false)
    private LocalDateTime createdAt;

    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Tashkent"));
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Tashkent"));
    }
}
