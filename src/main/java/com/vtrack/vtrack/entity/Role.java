package com.vtrack.vtrack.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name="role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    @NotNull(message = "Role name should not be blank")
    @NotBlank(message = "Role name should not be blank")
    private String roleName;
    @CreationTimestamp
    private Timestamp created;
    @CreationTimestamp
    private Timestamp lastModified;
    private String lastModifiedUser;
}
