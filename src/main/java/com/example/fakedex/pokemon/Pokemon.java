package com.example.fakedex.pokemon;
import javax.persistence.*;

@Entity
@Table
public class Pokemon {
    @Id
    @SequenceGenerator(
            name="pokemon_sequence",
            sequenceName = "pokemon_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pokemon_sequence"

    )
    private Long id;
    private String name;
    private String type1;
    private String type2;
    private Double height;
    private Double weight;
    private String description;



    public Pokemon(){

    }

    public Pokemon(Long id,String name, String type1, String type2, Double height, Double weight, String description) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }
    public Pokemon(String name,String type1, String type2, Double height, Double weight, String description) {
            this.name = name;
            this.type1 = type1;
            this.type2 = type2;
            this.height = height;
            this.weight = weight;
            this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                '}';
    }
}
