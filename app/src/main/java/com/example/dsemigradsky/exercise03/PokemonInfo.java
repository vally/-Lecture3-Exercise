package com.example.dsemigradsky.exercise03;

import java.util.List;

class PokemonInfo {
    public String getName() {
        return name;
    }

    public List<String> getTypes() {
        return types;
    }

    private String name;
    private List<String> types;

    PokemonInfo(String name, List<String> types) {
        this.name = name;
        this.types = types;
    }
}
