package ad.springframwork.srping5app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tipo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany
    @JoinColumn(name = "id_type")
    private Set<Pokemon> pokemons = new HashSet<>();

    public Tipo() {
    }

    public Tipo( String name, Set<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
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

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    /*
    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }

     */
}
