package com.example.fakedex.pokemon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PokemonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PokemonRepository repository){
        return args -> {
            Pokemon PepeChu = new Pokemon(
                    "Pepechu",
                    "Electric",
                    "Normal",
                    1.25,
                    12.86,
                    "Lil fella"
            );
            Pokemon Chadlup = new Pokemon(
                    "Chadlup",
                    "Fighting",
                    "Fire",
                    6.6,
                    240.0,
                    "Big Lad"
            );
            repository.saveAll(List.of(PepeChu,Chadlup));
        };
    }
}
