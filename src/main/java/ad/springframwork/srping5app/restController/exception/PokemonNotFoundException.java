package ad.springframwork.srping5app.restController.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PokemonNotFoundException extends RuntimeException{
    public PokemonNotFoundException(Long id) {
        super("Could not find pokemon " + id);
    }
}
