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
        Ability fire = new Ability("FIRE", "QUEMA");
        Pokemon squirtle = new Pokemon("squirtle", 200);
        Ability water = new Ability("water", "moja");

        charmander.getAbilities().add(fire);
        fire.getPokemons().add(charmander);
        squirtle.getAbilities().add(water);
        water.getPokemons().add(squirtle);

        pokemonRepository.save(charmander);
        abilityRepository.save(fire);
        pokemonRepository.save(squirtle);
        abilityRepository.save(water);

        System.out.println("numero de pokemons: " + pokemonRepository.count());
        System.out.println("Habilidades totales: " + abilityRepository.count());

    }
}
