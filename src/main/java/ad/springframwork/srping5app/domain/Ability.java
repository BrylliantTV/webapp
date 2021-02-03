package ad.springframwork.srping5app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String effect;

    @ManyToMany(mappedBy = "abilities")
    @JoinTable(name = "pokemon_ability",
            joinColumns = @JoinColumn (name = "id_ability"),
            inverseJoinColumns = @JoinColumn (name = "id_pokemon")
    )
    private Set<Pokemon> pokemons = new HashSet<>();

    public Ability() {
    }

    public Ability(String name, String effect) {
        this.name = name;
        this.effect = effect;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
