package com.adilsdeals.car_owner;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity(name = "car_owner")
public class CarOwner {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "telephoneNumber", nullable = false)
    private String telephoneNumber;

    @Column(name = "email", nullable = false)
    private String email;
}
