package ad.springframwork.srping5app.repository;

import ad.springframwork.srping5app.domain.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository <Pokemon,Long> {
}

