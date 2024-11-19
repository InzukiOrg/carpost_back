package org.sark.carpost.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import java.util.List;

@Getter
@Data
@Entity
@Table(name = "car_brand")
public class CarBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "carBrand", cascade = CascadeType.ALL)
    private List<CarModelEntity> carModel;

}
