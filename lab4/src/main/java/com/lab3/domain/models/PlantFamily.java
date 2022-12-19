package com.lab3.domain.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "plant_families")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
    name = "find plant family by name",
    query = "SELECT pf FROM PlantFamily pf WHERE pf.name = :name"
)
@NamedQuery(
    name = "fetch all plant families",
    query = "SELECT pf FROM PlantFamily pf"
)
public class PlantFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(name = "name", nullable = false, unique = true, length = 255)
	private String name;
    
    @OneToMany(mappedBy = "family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plant> plants;
}
