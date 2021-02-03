package ad.springframwork.srping5app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double power;

    @ManyToMany (mappedBy = "pokemons")
    private Set<Ability> abilities = new HashSet<>();

    @ManyToOne
    private Tipo tipo;

    public Pokemon() {
    }

    public Pokemon(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Set<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<Ability> abilities) {
        this.abilities = abilities;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", abilities=" + abilities +
                ", tipo=" + tipo +
                '}';
    }
}
