package com.adilsdeals.car;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity(name = "carEntry")

public class CarEntry {
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "car", nullable = false, unique = true)
    private Car car;
}
