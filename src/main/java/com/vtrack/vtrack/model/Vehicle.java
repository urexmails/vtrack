package com.vtrack.vtrack.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer vehicleId;

    @NotBlank(message = "Name is Mandatory")
    private String vehicleName;
    @NotBlank(message = "Vehicle Number is Mandatory")
    @Column(unique = true)
    private String vehicleNumber;
    @NotNull(message = "Seats Count is Mandatory")
    private Integer seatsCount;
    private Timestamp created;
    private Timestamp lastModified;
    private String lastModifiedUser;
}
