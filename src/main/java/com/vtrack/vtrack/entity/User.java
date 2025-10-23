package com.vtrack.vtrack.entity;

import com.vtrack.vtrack.validation.MobileNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String userName;
    private Date dob;
    private String mobile;
    private String email;
    private Integer role;
    @CreationTimestamp
    private Timestamp created;
    @CreationTimestamp
    private Timestamp lastModified;
}
