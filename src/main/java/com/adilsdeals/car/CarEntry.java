package com.adilsdeals.car;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "carEntry")
public class CarEntry {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "available", nullable = false)
    private boolean available;

    @JoinColumn(name = "car", nullable = false, unique = true)
    @OneToOne()
    private Car car;
}
