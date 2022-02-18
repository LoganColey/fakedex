package com.example.fakedex.pokemon;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonService.getPokemon();
    }

    @PostMapping
    public void addnewStudent(@RequestBody Pokemon pokemon){
        pokemonService.addnewPokemon(pokemon);
    }

    @DeleteMapping(path = "{pokemonId}")
    public void deletePokemon(
            @PathVariable("pokemonId") Long id){
        pokemonService.deletePokemon(id);
    }

    @PutMapping(path = "{pokemonId}")
    public void updatePokemon(@PathVariable("pokemonId") Long pokemonId, @RequestParam(required = false) String name, @RequestParam(required = false) String description){
        pokemonService.updatePokemon(pokemonId,name, description);
    }

}
