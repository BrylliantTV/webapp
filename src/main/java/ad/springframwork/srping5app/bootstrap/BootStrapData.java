package ad.springframwork.srping5app.bootstrap;

import ad.springframwork.srping5app.domain.Ability;
import ad.springframwork.srping5app.domain.Pokemon;
import ad.springframwork.srping5app.repository.AbilityRepository;
import ad.springframwork.srping5app.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final PokemonRepository pokemonRepository;
    private final AbilityRepository abilityRepository;

    public BootStrapData(PokemonRepository pokemonRepository, AbilityRepository abilityRepository) {
        this.pokemonRepository = pokemonRepository;
        this.abilityRepository = abilityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Pokemon charmander = new Pokemon("Charmander", 200);
        Pokemon squirtle = new Pokemon("squirtle", 200);
        Pokemon bulbasaur = new Pokemon("bulbasaur", 200);
        Ability fire = new Ability("FIRE", "QUEMA");
        Ability waterPistol = new Ability("waterPistol", "MOJA");
        Ability hojaAfilada = new Ability("hojaAfilada", "CORTA");

        charmander.getAbilities().add(fire);
        fire.getPokemons().add(charmander);
        squirtle.getAbilities().add(waterPistol);
        waterPistol.getPokemons().add(squirtle);
        bulbasaur.getAbilities().add(hojaAfilada);
        hojaAfilada.getPokemons().add(bulbasaur);

        System.out.println("numero de pokemons: " + pokemonRepository.count());
        System.out.println("Habilidades totales: " + abilityRepository.count());

    }
}
