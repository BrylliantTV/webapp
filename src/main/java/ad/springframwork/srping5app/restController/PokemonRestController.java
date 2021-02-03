package ad.springframwork.srping5app.restController;

import ad.springframwork.srping5app.domain.Pokemon;
import ad.springframwork.srping5app.repository.PokemonRepository;
import ad.springframwork.srping5app.restController.exception.PokemonNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonRestController {

//    private final Log log = LogFactory.getLog(PokemonRestController.class);

    private final PokemonRepository pokemonRepository;

    public PokemonRestController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/pokemons")
    public List<Pokemon> getAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @GetMapping ("/pokemons/{id}")
    public Pokemon one(@PathVariable Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
    }
    @PostMapping("/pokemons")
    public Pokemon newPokemon (@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
    @PutMapping("/pokemons/{id}")
    public Pokemon update (@RequestBody Pokemon editPokemon, @PathVariable Long id) {
        return pokemonRepository.findById(id).map(pokemon -> {
            pokemon.setName(editPokemon.getName());
            pokemon.setPower(editPokemon.getPower());
            return pokemonRepository.save(pokemon);
        }).orElseGet(() -> {
            editPokemon.setId(id);
            return pokemonRepository.save(editPokemon);
        });
    }
    @DeleteMapping ("/pokemons/{id}")
    public void delete (@PathVariable Long id) {
        pokemonRepository.deleteById(id);
    }
}
