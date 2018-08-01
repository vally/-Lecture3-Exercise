package com.example.dsemigradsky.exercise03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PokemonInfoActivity extends AppCompatActivity {

    public static String ID = "id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);

        Intent intent = getIntent();
        int id = intent.getIntExtra(ID, -1);

        DataUtil.getPokemonInfo(this, id, new GettingPokemonInfoFunction() {
            @Override
            public void gettingPokemonInfo(PokemonInfo pokemonInfo) {
                if (pokemonInfo == null) {
                    return;
                }

                ((TextView)findViewById(R.id.tv_pokemon_name)).setText(pokemonInfo.getName());
                ((TextView)findViewById(R.id.tv_pokemon_types)).setText(pokemonInfo.getTypes().toString());
            }
        });
    }
}
