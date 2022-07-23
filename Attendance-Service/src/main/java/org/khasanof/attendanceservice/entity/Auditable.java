package org.khasanof.attendanceservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auditable implements BaseEntity {
    @Id
    private String id;

    @Field(name = "is_deleted")
    private boolean isDeleted;

    @CreatedDate
    @Field(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreatedBy
    @Field(name = "created_by")
    private Integer createdBy = -1;

    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDateTime updatedAt = null;

    @LastModifiedBy
    @Field(name = "updated_by")
    private Integer updatedBy = null;
}
