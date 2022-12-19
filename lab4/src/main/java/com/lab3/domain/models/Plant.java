package com.lab3.domain.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "plants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
    name = "fetch all plants",
    query = "SELECT p FROM Plant p"
)
@NamedQuery(
    name = "find plant by name",
    query = "SELECT p FROM Plant p WHERE p.name = :name"
)
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
	private String name;

    @Column(name = "temperature", nullable = false)
	private double temperature;

    @Column(name = "light", nullable = false, length = 255)
	private String light;

    @Column(name = "is_poisonous", nullable = false)
	private boolean isPoisonous;

    @Column(name = "size", nullable = false)
	private double size;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_family_id")
	private PlantFamily family;
    
    public boolean getIsPoisonous() {
        return isPoisonous;
    }
    
    public void setIsPoisonous(boolean isPoisonous) {
        this.isPoisonous = isPoisonous;
    }
}
