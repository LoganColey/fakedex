package com.example.fakedex.pokemon;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemon(){
        return pokemonRepository.findAll();
    }

    public void addnewPokemon(Pokemon pokemon){
        Optional<Pokemon> pokemonOptional = pokemonRepository
                .findPokemonByName(pokemon.getName());
        if (pokemonOptional.isPresent()) {
            throw new IllegalStateException("This Pokemon already exists");
        }
        pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long pokemonId){
        boolean exists = pokemonRepository.existsById(pokemonId);
        if (!exists){
            throw new IllegalStateException("The pokemon with the id " + pokemonId + " does not exists");
        }
        pokemonRepository.deleteById(pokemonId);
    }

    @Transactional
    public void updatePokemon(Long pokemonId,
                              String name,
                              String description){
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new IllegalStateException(
                "pokemon with id "+ pokemonId +" does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(pokemon.getName(), name)) {
            pokemon.setName(name);
        }

        if (description != null && description.length() > 0 && !Objects.equals(pokemon.getDescription(), description)){
            Optional<Pokemon> studentOptional = pokemonRepository
                    .findPokemonByName(description);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("name taken");
            }
            pokemon.setDescription(description);
        }
    }



}
