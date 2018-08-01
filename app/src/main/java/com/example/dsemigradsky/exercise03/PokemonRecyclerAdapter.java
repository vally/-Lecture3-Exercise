package com.example.dsemigradsky.exercise03;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

public class PokemonRecyclerAdapter extends RecyclerView.Adapter<PokemonRecyclerAdapter.ViewHolder> {

    private final List<Pokemon> pokemons;
    private final Context context;
    private final LayoutInflater inflater;
    private final int avatarSize;
    private View.OnClickListener onClickListener;

    PokemonRecyclerAdapter(Context context, List<Pokemon> pokemons, int avatarSize, View.OnClickListener onClickListener) {
        this.context = context;
        this.pokemons = pokemons;
        this.avatarSize = avatarSize;
        this.inflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewHolder, int i) {
        View view = inflater.inflate(R.layout.list_item_pokemon, viewHolder, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view, this.avatarSize);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Pokemon pokemon = pokemons.get(i);

        viewHolder.name.setText(pokemon.getName());
        SvgLoader.pluck().with((Activity)context).load(pokemon.getAvatar(), viewHolder.avatar);
    }

    @Override
    public int getItemCount() {
        return this.pokemons.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView avatar;
        public final TextView name;

        ViewHolder(@NonNull View itemView, int avatarSize) {
            super(itemView);

            this.avatar = itemView.findViewById(R.id.avatar);
            this.avatar.setLayoutParams(new ConstraintLayout.LayoutParams(avatarSize, avatarSize));

            this.name = itemView.findViewById(R.id.name);
        }
    }
}
