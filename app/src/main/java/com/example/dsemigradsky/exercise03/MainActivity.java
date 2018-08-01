package com.example.dsemigradsky.exercise03;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView list = findViewById(R.id.pokemonList);
            int itemPosition = list.getChildLayoutPosition(view);

            Intent intent = new Intent(MainActivity.this, PokemonInfoActivity.class);
            intent.putExtra(PokemonInfoActivity.ID, itemPosition + 1);

            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.pokemonList);
        list.setAdapter(new PokemonRecyclerAdapter(this, DataUtil.generatePokemons(), getPokemonAvatarSize(), onClickListener));
    }

    private int getPokemonAvatarSize() {
        Resources resources = this.getResources();
        int pxDeviceWidth = resources.getDisplayMetrics().widthPixels;
        float ptPadding = resources.getDimension(R.dimen.list_item_padding) * 2;
        int pxPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ptPadding, resources.getDisplayMetrics());
        return pxDeviceWidth / resources.getInteger(R.integer.span_count) - pxPadding;
    }
}
