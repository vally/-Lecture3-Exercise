package com.example.dsemigradsky.exercise03;

import android.annotation.SuppressLint;

public class Pokemon {

    @SuppressLint("DefaultLocale")
    Pokemon(String name, int position) {
        this.name = name;
        this.avatar = String.format("https://raw.githubusercontent.com/jnovack/pokemon-svg/master/svg/%d.svg", position);
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    private String name;
    private String avatar;
}
