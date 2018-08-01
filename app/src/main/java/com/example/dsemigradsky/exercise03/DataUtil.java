package com.example.dsemigradsky.exercise03;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class DataUtil {
    public static void getPokemonInfo(Context context, int id, final GettingPokemonInfoFunction callback) {
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        final RequestQueue requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        @SuppressLint("DefaultLocale") String url = String.format("https://pokeapi.co/api/v2/pokemon/%d/", id);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name = response.getString("name");

                    List<String> types = new ArrayList<>();
                    JSONArray jsonTypes = response.getJSONArray("types");
                    for (int i = 0; i < jsonTypes.length(); i++) {
                        types.add(
                                jsonTypes.getJSONObject(i).getJSONObject("type").getString("name")
                        );
                    }

                    callback.gettingPokemonInfo(new PokemonInfo(name, types));
                } catch (JSONException e) {
                    callback.gettingPokemonInfo(null);
                }

                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.gettingPokemonInfo(null);
            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    public static List<Pokemon> generatePokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Bulbasaur", 1));
        pokemons.add(new Pokemon("Ivysaur", 2));
        pokemons.add(new Pokemon("Venusaur", 3));
        pokemons.add(new Pokemon("Charmander", 4));
        pokemons.add(new Pokemon("Charmeleon", 5));
        pokemons.add(new Pokemon("Charizard", 6));
        pokemons.add(new Pokemon("Squirtle", 7));
        pokemons.add(new Pokemon("Wartortle", 8));
        pokemons.add(new Pokemon("Blastoise", 9));
        pokemons.add(new Pokemon("Caterpie", 10));
        pokemons.add(new Pokemon("Metapod", 11));
        pokemons.add(new Pokemon("Butterfree", 12));
        pokemons.add(new Pokemon("Weedle", 13));
        pokemons.add(new Pokemon("Kakuna", 14));
        pokemons.add(new Pokemon("Beedrill", 15));
        pokemons.add(new Pokemon("Pidgey", 16));
        pokemons.add(new Pokemon("Pidgeotto", 17));
        pokemons.add(new Pokemon("Pidgeot", 18));
        pokemons.add(new Pokemon("Rattata", 19));
        pokemons.add(new Pokemon("Raticate", 20));
        pokemons.add(new Pokemon("Spearow", 21));
        pokemons.add(new Pokemon("Fearow", 22));
        pokemons.add(new Pokemon("Ekans", 23));
        pokemons.add(new Pokemon("Arbok", 24));
        pokemons.add(new Pokemon("Pikachu", 25));
        pokemons.add(new Pokemon("Raichu", 26));
        pokemons.add(new Pokemon("Sandshrew", 27));
        pokemons.add(new Pokemon("Sandslash", 28));
        pokemons.add(new Pokemon("Nidoran ♀", 29));
        pokemons.add(new Pokemon("Nidorina", 30));
        pokemons.add(new Pokemon("Nidoqueen", 31));
        pokemons.add(new Pokemon("Nidoran ♂", 32));
        pokemons.add(new Pokemon("Nidorino", 33));
        pokemons.add(new Pokemon("Nidoking", 34));
        pokemons.add(new Pokemon("Clefairy", 35));
        pokemons.add(new Pokemon("Clefable", 36));
        pokemons.add(new Pokemon("Vulpix", 37));
        pokemons.add(new Pokemon("Ninetales", 38));
        pokemons.add(new Pokemon("Jigglypuff", 39));
        pokemons.add(new Pokemon("Wigglytuff", 40));
        pokemons.add(new Pokemon("Zubat", 41));
        pokemons.add(new Pokemon("Golbat", 42));
        pokemons.add(new Pokemon("Oddish", 43));
        pokemons.add(new Pokemon("Gloom", 44));
        pokemons.add(new Pokemon("Vileplume", 45));
        pokemons.add(new Pokemon("Paras", 46));
        pokemons.add(new Pokemon("Parasect", 47));
        pokemons.add(new Pokemon("Venonat", 48));
        pokemons.add(new Pokemon("Venomoth", 49));
        pokemons.add(new Pokemon("Diglett", 50));
        pokemons.add(new Pokemon("Dugtrio", 51));
        pokemons.add(new Pokemon("Meowth", 52));
        pokemons.add(new Pokemon("Persian", 53));
        pokemons.add(new Pokemon("Psyduck", 54));
        pokemons.add(new Pokemon("Golduck", 55));
        pokemons.add(new Pokemon("Mankey", 56));
        pokemons.add(new Pokemon("Primeape", 57));
        pokemons.add(new Pokemon("Growlithe", 58));
        pokemons.add(new Pokemon("Arcanine", 59));
        pokemons.add(new Pokemon("Poliwag", 60));
        pokemons.add(new Pokemon("Poliwhirl", 61));
        pokemons.add(new Pokemon("Poliwrath", 62));
        pokemons.add(new Pokemon("Abra", 63));
        pokemons.add(new Pokemon("Kadabra", 64));
        pokemons.add(new Pokemon("Alakazam", 65));
        pokemons.add(new Pokemon("Machop", 66));
        pokemons.add(new Pokemon("Machoke", 67));
        pokemons.add(new Pokemon("Machamp", 68));
        pokemons.add(new Pokemon("Bellsprout", 69));
        pokemons.add(new Pokemon("Weepinbell", 70));
        pokemons.add(new Pokemon("Victreebel", 71));
        pokemons.add(new Pokemon("Tentacool", 72));
        pokemons.add(new Pokemon("Tentacruel", 73));
        pokemons.add(new Pokemon("Geodude", 74));
        pokemons.add(new Pokemon("Graveler", 75));
        pokemons.add(new Pokemon("Golem", 76));
        pokemons.add(new Pokemon("Ponyta", 77));
        pokemons.add(new Pokemon("Rapidash", 78));
        pokemons.add(new Pokemon("Slowpoke", 79));
        pokemons.add(new Pokemon("Slowbro", 80));
        pokemons.add(new Pokemon("Magnemite", 81));
        pokemons.add(new Pokemon("Magneton", 82));
        pokemons.add(new Pokemon("Farfetch'd", 83));
        pokemons.add(new Pokemon("Doduo", 84));
        pokemons.add(new Pokemon("Dodrio", 85));
        pokemons.add(new Pokemon("Seel", 86));
        pokemons.add(new Pokemon("Dewgong", 87));
        pokemons.add(new Pokemon("Grimer", 88));
        pokemons.add(new Pokemon("Muk", 89));
        pokemons.add(new Pokemon("Shellder", 90));
        pokemons.add(new Pokemon("Cloyster", 91));
        pokemons.add(new Pokemon("Gastly", 92));
        pokemons.add(new Pokemon("Haunter", 93));
        pokemons.add(new Pokemon("Gengar", 94));
        pokemons.add(new Pokemon("Onix", 95));
        pokemons.add(new Pokemon("Drowzee", 96));
        pokemons.add(new Pokemon("Hypno", 97));
        pokemons.add(new Pokemon("Krabby", 98));
        pokemons.add(new Pokemon("Kingler", 99));
        pokemons.add(new Pokemon("Voltorb", 100));
        pokemons.add(new Pokemon("Electrode", 101));
        pokemons.add(new Pokemon("Exeggcute", 102));
        pokemons.add(new Pokemon("Exeggutor", 103));
        pokemons.add(new Pokemon("Cubone", 104));
        pokemons.add(new Pokemon("Marowak", 105));
        pokemons.add(new Pokemon("Hitmonlee", 106));
        pokemons.add(new Pokemon("Hitmonchan", 107));
        pokemons.add(new Pokemon("Lickitung", 108));
        pokemons.add(new Pokemon("Koffing", 109));
        pokemons.add(new Pokemon("Weezing", 110));
        pokemons.add(new Pokemon("Rhyhorn", 111));
        pokemons.add(new Pokemon("Rhydon", 112));
        pokemons.add(new Pokemon("Chansey", 113));
        pokemons.add(new Pokemon("Tangela", 114));
        pokemons.add(new Pokemon("Kangaskhan", 115));
        pokemons.add(new Pokemon("Horsea", 116));
        pokemons.add(new Pokemon("Seadra", 117));
        pokemons.add(new Pokemon("Goldeen", 118));
        pokemons.add(new Pokemon("Seaking", 119));
        pokemons.add(new Pokemon("Staryu", 120));
        pokemons.add(new Pokemon("Starmie", 121));
        pokemons.add(new Pokemon("Mr. Mime", 122));
        pokemons.add(new Pokemon("Scyther", 123));
        pokemons.add(new Pokemon("Jynx", 124));
        pokemons.add(new Pokemon("Electabuzz", 125));
        pokemons.add(new Pokemon("Magmar", 126));
        pokemons.add(new Pokemon("Pinsir", 127));
        pokemons.add(new Pokemon("Tauros", 128));
        pokemons.add(new Pokemon("Magikarp", 129));
        pokemons.add(new Pokemon("Gyarados", 130));
        pokemons.add(new Pokemon("Lapras", 131));
        pokemons.add(new Pokemon("Ditto", 132));
        pokemons.add(new Pokemon("Eevee", 133));
        pokemons.add(new Pokemon("Vaporeon", 134));
        pokemons.add(new Pokemon("Jolteon", 135));
        pokemons.add(new Pokemon("Flareon", 136));
        pokemons.add(new Pokemon("Porygon", 137));
        pokemons.add(new Pokemon("Omanyte", 138));
        pokemons.add(new Pokemon("Omastar", 139));
        pokemons.add(new Pokemon("Kabuto", 140));
        pokemons.add(new Pokemon("Kabutops", 141));
        pokemons.add(new Pokemon("Aerodactyl", 142));
        pokemons.add(new Pokemon("Snorlax", 143));
        pokemons.add(new Pokemon("Articuno", 144));
        pokemons.add(new Pokemon("Zapdos", 145));
        pokemons.add(new Pokemon("Moltres", 146));
        pokemons.add(new Pokemon("Dratini", 147));
        pokemons.add(new Pokemon("Dragonair", 148));
        pokemons.add(new Pokemon("Dragonite", 149));
        pokemons.add(new Pokemon("Mewtwo", 150));
        pokemons.add(new Pokemon("Mew", 151));
        pokemons.add(new Pokemon("Chikorita", 152));
        pokemons.add(new Pokemon("Bayleef", 153));
        pokemons.add(new Pokemon("Meganium", 154));
        pokemons.add(new Pokemon("Cyndaquil", 155));
        pokemons.add(new Pokemon("Quilava", 156));
        pokemons.add(new Pokemon("Typhlosion", 157));
        pokemons.add(new Pokemon("Totodile", 158));
        pokemons.add(new Pokemon("Croconaw", 159));
        pokemons.add(new Pokemon("Feraligatr", 160));
        pokemons.add(new Pokemon("Sentret", 161));
        pokemons.add(new Pokemon("Furret", 162));
        pokemons.add(new Pokemon("Hoothoot", 163));
        pokemons.add(new Pokemon("Noctowl", 164));
        pokemons.add(new Pokemon("Ledyba", 165));
        pokemons.add(new Pokemon("Ledian", 166));
        pokemons.add(new Pokemon("Spinarak", 167));
        pokemons.add(new Pokemon("Ariados", 168));
        pokemons.add(new Pokemon("Crobat", 169));
        pokemons.add(new Pokemon("Chinchou", 170));
        pokemons.add(new Pokemon("Lanturn", 171));
        pokemons.add(new Pokemon("Pichu", 172));
        pokemons.add(new Pokemon("Cleffa", 173));
        pokemons.add(new Pokemon("Igglybuff", 174));
        pokemons.add(new Pokemon("Togepi", 175));
        pokemons.add(new Pokemon("Togetic", 176));
        pokemons.add(new Pokemon("Natu", 177));
        pokemons.add(new Pokemon("Xatu", 178));
        pokemons.add(new Pokemon("Mareep", 179));
        pokemons.add(new Pokemon("Flaaffy", 180));
        pokemons.add(new Pokemon("Ampharos", 181));
        pokemons.add(new Pokemon("Bellossom", 182));
        pokemons.add(new Pokemon("Marill", 183));
        pokemons.add(new Pokemon("Azumarill", 184));
        pokemons.add(new Pokemon("Sudowoodo", 185));
        pokemons.add(new Pokemon("Politoed", 186));
        pokemons.add(new Pokemon("Hoppip", 187));
        pokemons.add(new Pokemon("Skiploom", 188));
        pokemons.add(new Pokemon("Jumpluff", 189));
        pokemons.add(new Pokemon("Aipom", 190));
        pokemons.add(new Pokemon("Sunkern", 191));
        pokemons.add(new Pokemon("Sunflora", 192));
        pokemons.add(new Pokemon("Yanma", 193));
        pokemons.add(new Pokemon("Wooper", 194));
        pokemons.add(new Pokemon("Quagsire", 195));
        pokemons.add(new Pokemon("Espeon", 196));
        pokemons.add(new Pokemon("Umbreon", 197));
        pokemons.add(new Pokemon("Murkrow", 198));
        pokemons.add(new Pokemon("Slowking", 199));
        pokemons.add(new Pokemon("Misdreavus", 200));
        pokemons.add(new Pokemon("Unown", 201));
        pokemons.add(new Pokemon("Wobbuffet", 202));
        pokemons.add(new Pokemon("Girafarig", 203));
        pokemons.add(new Pokemon("Pineco", 204));
        pokemons.add(new Pokemon("Forretress", 205));
        pokemons.add(new Pokemon("Dunsparce", 206));
        pokemons.add(new Pokemon("Gligar", 207));
        pokemons.add(new Pokemon("Steelix", 208));
        pokemons.add(new Pokemon("Snubbull", 209));
        pokemons.add(new Pokemon("Granbull", 210));
        pokemons.add(new Pokemon("Qwilfish", 211));
        pokemons.add(new Pokemon("Scizor", 212));
        pokemons.add(new Pokemon("Shuckle", 213));
        pokemons.add(new Pokemon("Heracross", 214));
        pokemons.add(new Pokemon("Sneasel", 215));
        pokemons.add(new Pokemon("Teddiursa", 216));
        pokemons.add(new Pokemon("Ursaring", 217));
        pokemons.add(new Pokemon("Slugma", 218));
        pokemons.add(new Pokemon("Magcargo", 219));
        pokemons.add(new Pokemon("Swinub", 220));
        pokemons.add(new Pokemon("Piloswine", 221));
        pokemons.add(new Pokemon("Corsola", 222));
        pokemons.add(new Pokemon("Remoraid", 223));
        pokemons.add(new Pokemon("Octillery", 224));
        pokemons.add(new Pokemon("Delibird", 225));
        pokemons.add(new Pokemon("Mantine", 226));
        pokemons.add(new Pokemon("Skarmory", 227));
        pokemons.add(new Pokemon("Houndour", 228));
        pokemons.add(new Pokemon("Houndoom", 229));
        pokemons.add(new Pokemon("Kingdra", 230));
        pokemons.add(new Pokemon("Phanpy", 231));
        pokemons.add(new Pokemon("Donphan", 232));
        pokemons.add(new Pokemon("Porygon2", 233));
        pokemons.add(new Pokemon("Stantler", 234));
        pokemons.add(new Pokemon("Smeargle", 235));
        pokemons.add(new Pokemon("Tyrogue", 236));
        pokemons.add(new Pokemon("Hitmontop", 237));
        pokemons.add(new Pokemon("Smoochum", 238));
        pokemons.add(new Pokemon("Elekid", 239));
        pokemons.add(new Pokemon("Magby", 240));
        pokemons.add(new Pokemon("Miltank", 241));
        pokemons.add(new Pokemon("Blissey", 242));
        pokemons.add(new Pokemon("Raikou", 243));
        pokemons.add(new Pokemon("Entei", 244));
        pokemons.add(new Pokemon("Suicune", 245));
        pokemons.add(new Pokemon("Larvitar", 246));
        pokemons.add(new Pokemon("Pupitar", 247));
        pokemons.add(new Pokemon("Tyranitar", 248));
        pokemons.add(new Pokemon("Lugia", 249));
        pokemons.add(new Pokemon("Ho-oh", 250));
        pokemons.add(new Pokemon("Celebi", 251));
        pokemons.add(new Pokemon("Treecko", 252));
        pokemons.add(new Pokemon("Grovyle", 253));
        pokemons.add(new Pokemon("Sceptile", 254));
        pokemons.add(new Pokemon("Torchic", 255));
        pokemons.add(new Pokemon("Combusken", 256));
        pokemons.add(new Pokemon("Blaziken", 257));
        pokemons.add(new Pokemon("Mudkip", 258));
        pokemons.add(new Pokemon("Marshtomp", 259));
        pokemons.add(new Pokemon("Swampert", 260));
        pokemons.add(new Pokemon("Poochyena", 261));
        pokemons.add(new Pokemon("Mightyena", 262));
        pokemons.add(new Pokemon("Zigzagoon", 263));
        pokemons.add(new Pokemon("Linoone", 264));
        pokemons.add(new Pokemon("Wurmple", 265));
        pokemons.add(new Pokemon("Silcoon", 266));
        pokemons.add(new Pokemon("Beautifly", 267));
        pokemons.add(new Pokemon("Cascoon", 268));
        pokemons.add(new Pokemon("Dustox", 269));
        pokemons.add(new Pokemon("Lotad", 270));
        pokemons.add(new Pokemon("Lombre", 271));
        pokemons.add(new Pokemon("Ludicolo", 272));
        pokemons.add(new Pokemon("Seedot", 273));
        pokemons.add(new Pokemon("Nuzleaf", 274));
        pokemons.add(new Pokemon("Shiftry", 275));
        pokemons.add(new Pokemon("Taillow", 276));
        pokemons.add(new Pokemon("Swellow", 277));
        pokemons.add(new Pokemon("Wingull", 278));
        pokemons.add(new Pokemon("Pelipper", 279));
        pokemons.add(new Pokemon("Ralts", 280));
        pokemons.add(new Pokemon("Kirlia", 281));
        pokemons.add(new Pokemon("Gardevoir", 282));
        pokemons.add(new Pokemon("Surskit", 283));
        pokemons.add(new Pokemon("Masquerain", 284));
        pokemons.add(new Pokemon("Shroomish", 285));
        pokemons.add(new Pokemon("Breloom", 286));
        pokemons.add(new Pokemon("Slakoth", 287));
        pokemons.add(new Pokemon("Vigoroth", 288));
        pokemons.add(new Pokemon("Slaking", 289));
        pokemons.add(new Pokemon("Nincada", 290));
        pokemons.add(new Pokemon("Ninjask", 291));
        pokemons.add(new Pokemon("Shedinja", 292));
        pokemons.add(new Pokemon("Whismur", 293));
        pokemons.add(new Pokemon("Loudred", 294));
        pokemons.add(new Pokemon("Exploud", 295));
        pokemons.add(new Pokemon("Makuhita", 296));
        pokemons.add(new Pokemon("Hariyama", 297));
        pokemons.add(new Pokemon("Azurill", 298));
        pokemons.add(new Pokemon("Nosepass", 299));
        pokemons.add(new Pokemon("Skitty", 300));
        pokemons.add(new Pokemon("Delcatty", 301));
        pokemons.add(new Pokemon("Sableye", 302));
        pokemons.add(new Pokemon("Mawile", 303));
        pokemons.add(new Pokemon("Aron", 304));
        pokemons.add(new Pokemon("Lairon", 305));
        pokemons.add(new Pokemon("Aggron", 306));
        pokemons.add(new Pokemon("Meditite", 307));
        pokemons.add(new Pokemon("Medicham", 308));
        pokemons.add(new Pokemon("Electrike", 309));
        pokemons.add(new Pokemon("Manectric", 310));
        pokemons.add(new Pokemon("Plusle", 311));
        pokemons.add(new Pokemon("Minun", 312));
        pokemons.add(new Pokemon("Volbeat", 313));
        pokemons.add(new Pokemon("Illumise", 314));
        pokemons.add(new Pokemon("Roselia", 315));
        pokemons.add(new Pokemon("Gulpin", 316));
        pokemons.add(new Pokemon("Swalot", 317));
        pokemons.add(new Pokemon("Carvanha", 318));
        pokemons.add(new Pokemon("Sharpedo", 319));
        pokemons.add(new Pokemon("Wailmer", 320));
        pokemons.add(new Pokemon("Wailord", 321));
        pokemons.add(new Pokemon("Numel", 322));
        pokemons.add(new Pokemon("Camerupt", 323));
        pokemons.add(new Pokemon("Torkoal", 324));
        pokemons.add(new Pokemon("Spoink", 325));
        pokemons.add(new Pokemon("Grumpig", 326));
        pokemons.add(new Pokemon("Spinda", 327));
        pokemons.add(new Pokemon("Trapinch", 328));
        pokemons.add(new Pokemon("Vibrava", 329));
        pokemons.add(new Pokemon("Flygon", 330));
        pokemons.add(new Pokemon("Cacnea", 331));
        pokemons.add(new Pokemon("Cacturne", 332));
        pokemons.add(new Pokemon("Swablu", 333));
        pokemons.add(new Pokemon("Altaria", 334));
        pokemons.add(new Pokemon("Zangoose", 335));
        pokemons.add(new Pokemon("Seviper", 336));
        pokemons.add(new Pokemon("Lunatone", 337));
        pokemons.add(new Pokemon("Solrock", 338));
        pokemons.add(new Pokemon("Barboach", 339));
        pokemons.add(new Pokemon("Whiscash", 340));
        pokemons.add(new Pokemon("Corphish", 341));
        pokemons.add(new Pokemon("Crawdaunt", 342));
        pokemons.add(new Pokemon("Baltoy", 343));
        pokemons.add(new Pokemon("Claydol", 344));
        pokemons.add(new Pokemon("Lileep", 345));
        pokemons.add(new Pokemon("Cradily", 346));
        pokemons.add(new Pokemon("Anorith", 347));
        pokemons.add(new Pokemon("Armaldo", 348));
        pokemons.add(new Pokemon("Feebas", 349));
        pokemons.add(new Pokemon("Milotic", 350));
        pokemons.add(new Pokemon("Castform", 351));
        pokemons.add(new Pokemon("Kecleon", 352));
        pokemons.add(new Pokemon("Shuppet", 353));
        pokemons.add(new Pokemon("Banette", 354));
        pokemons.add(new Pokemon("Duskull", 355));
        pokemons.add(new Pokemon("Dusclops", 356));
        pokemons.add(new Pokemon("Tropius", 357));
        pokemons.add(new Pokemon("Chimecho", 358));
        pokemons.add(new Pokemon("Absol", 359));
        pokemons.add(new Pokemon("Wynaut", 360));
        pokemons.add(new Pokemon("Snorunt", 361));
        pokemons.add(new Pokemon("Glalie", 362));
        pokemons.add(new Pokemon("Spheal", 363));
        pokemons.add(new Pokemon("Sealeo", 364));
        pokemons.add(new Pokemon("Walrein", 365));
        pokemons.add(new Pokemon("Clamperl", 366));
        pokemons.add(new Pokemon("Huntail", 367));
        pokemons.add(new Pokemon("Gorebyss", 368));
        pokemons.add(new Pokemon("Relicanth", 369));
        pokemons.add(new Pokemon("Luvdisc", 370));
        pokemons.add(new Pokemon("Bagon", 371));
        pokemons.add(new Pokemon("Shelgon", 372));
        pokemons.add(new Pokemon("Salamence", 373));
        pokemons.add(new Pokemon("Beldum", 374));
        pokemons.add(new Pokemon("Metang", 375));
        pokemons.add(new Pokemon("Metagross", 376));
        pokemons.add(new Pokemon("Regirock", 377));
        pokemons.add(new Pokemon("Regice", 378));
        pokemons.add(new Pokemon("Registeel", 379));
        pokemons.add(new Pokemon("Latias", 380));
        pokemons.add(new Pokemon("Latios", 381));
        pokemons.add(new Pokemon("Kyogre", 382));
        pokemons.add(new Pokemon("Groudon", 383));
        pokemons.add(new Pokemon("Rayquaza", 384));
        pokemons.add(new Pokemon("Jirachi", 385));
        pokemons.add(new Pokemon("Deoxys", 386));
        pokemons.add(new Pokemon("Turtwig", 387));
        pokemons.add(new Pokemon("Grotle", 388));
        pokemons.add(new Pokemon("Torterra", 389));
        pokemons.add(new Pokemon("Chimchar", 390));
        pokemons.add(new Pokemon("Monferno", 391));
        pokemons.add(new Pokemon("Infernape", 392));
        pokemons.add(new Pokemon("Piplup", 393));
        pokemons.add(new Pokemon("Prinplup", 394));
        pokemons.add(new Pokemon("Empoleon", 395));
        pokemons.add(new Pokemon("Starly", 396));
        pokemons.add(new Pokemon("Staravia", 397));
        pokemons.add(new Pokemon("Staraptor", 398));
        pokemons.add(new Pokemon("Bidoof", 399));
        pokemons.add(new Pokemon("Bibarel", 400));
        pokemons.add(new Pokemon("Kricketot", 401));
        pokemons.add(new Pokemon("Kricketune", 402));
        pokemons.add(new Pokemon("Shinx", 403));
        pokemons.add(new Pokemon("Luxio", 404));
        pokemons.add(new Pokemon("Luxray", 405));
        pokemons.add(new Pokemon("Budew", 406));
        pokemons.add(new Pokemon("Roserade", 407));
        pokemons.add(new Pokemon("Cranidos", 408));
        pokemons.add(new Pokemon("Rampardos", 409));
        pokemons.add(new Pokemon("Shieldon", 410));
        pokemons.add(new Pokemon("Bastiodon", 411));
        pokemons.add(new Pokemon("Burmy", 412));
        pokemons.add(new Pokemon("Wormadam", 413));
        pokemons.add(new Pokemon("Mothim", 414));
        pokemons.add(new Pokemon("Combee", 415));
        pokemons.add(new Pokemon("Vespiquen", 416));
        pokemons.add(new Pokemon("Pachirisu", 417));
        pokemons.add(new Pokemon("Buizel", 418));
        pokemons.add(new Pokemon("Floatzel", 419));
        pokemons.add(new Pokemon("Cherubi", 420));
        pokemons.add(new Pokemon("Cherrim", 421));
        pokemons.add(new Pokemon("Shellos", 422));
        pokemons.add(new Pokemon("Gastrodon", 423));
        pokemons.add(new Pokemon("Ambipom", 424));
        pokemons.add(new Pokemon("Drifloon", 425));
        pokemons.add(new Pokemon("Drifblim", 426));
        pokemons.add(new Pokemon("Buneary", 427));
        pokemons.add(new Pokemon("Lopunny", 428));
        pokemons.add(new Pokemon("Mismagius", 429));
        pokemons.add(new Pokemon("Honchkrow", 430));
        pokemons.add(new Pokemon("Glameow", 431));
        pokemons.add(new Pokemon("Purugly", 432));
        pokemons.add(new Pokemon("Chingling", 433));
        pokemons.add(new Pokemon("Stunky", 434));
        pokemons.add(new Pokemon("Skuntank", 435));
        pokemons.add(new Pokemon("Bronzor", 436));
        pokemons.add(new Pokemon("Bronzong", 437));
        pokemons.add(new Pokemon("Bonsly", 438));
        pokemons.add(new Pokemon("Mime Jr.", 439));
        pokemons.add(new Pokemon("Happiny", 440));
        pokemons.add(new Pokemon("Chatot", 441));
        pokemons.add(new Pokemon("Spiritomb", 442));
        pokemons.add(new Pokemon("Gible", 443));
        pokemons.add(new Pokemon("Gabite", 444));
        pokemons.add(new Pokemon("Garchomp", 445));
        pokemons.add(new Pokemon("Munchlax", 446));
        pokemons.add(new Pokemon("Riolu", 447));
        pokemons.add(new Pokemon("Lucario", 448));
        pokemons.add(new Pokemon("Hippopotas", 449));
        pokemons.add(new Pokemon("Hippowdon", 450));
        pokemons.add(new Pokemon("Skorupi", 451));
        pokemons.add(new Pokemon("Drapion", 452));
        pokemons.add(new Pokemon("Croagunk", 453));
        pokemons.add(new Pokemon("Toxicroak", 454));
        pokemons.add(new Pokemon("Carnivine", 455));
        pokemons.add(new Pokemon("Finneon", 456));
        pokemons.add(new Pokemon("Lumineon", 457));
        pokemons.add(new Pokemon("Mantyke", 458));
        pokemons.add(new Pokemon("Snover", 459));
        pokemons.add(new Pokemon("Abomasnow", 460));
        pokemons.add(new Pokemon("Weavile", 461));
        pokemons.add(new Pokemon("Magnezone", 462));
        pokemons.add(new Pokemon("Lickilicky", 463));
        pokemons.add(new Pokemon("Rhyperior", 464));
        pokemons.add(new Pokemon("Tangrowth", 465));
        pokemons.add(new Pokemon("Electivire", 466));
        pokemons.add(new Pokemon("Magmortar", 467));
        pokemons.add(new Pokemon("Togekiss", 468));
        pokemons.add(new Pokemon("Yanmega", 469));
        pokemons.add(new Pokemon("Leafeon", 470));
        pokemons.add(new Pokemon("Glaceon", 471));
        pokemons.add(new Pokemon("Gliscor", 472));
        pokemons.add(new Pokemon("Mamoswine", 473));
        pokemons.add(new Pokemon("Porygon-z", 474));
        pokemons.add(new Pokemon("Gallade", 475));
        pokemons.add(new Pokemon("Probopass", 476));
        pokemons.add(new Pokemon("Dusknoir", 477));
        pokemons.add(new Pokemon("Froslass", 478));
        pokemons.add(new Pokemon("Rotom", 479));
        pokemons.add(new Pokemon("Uxie", 480));
        pokemons.add(new Pokemon("Mesprit", 481));
        pokemons.add(new Pokemon("Azelf", 482));
        pokemons.add(new Pokemon("Dialga", 483));
        pokemons.add(new Pokemon("Palkia", 484));
        pokemons.add(new Pokemon("Heatran", 485));
        pokemons.add(new Pokemon("Regigigas", 486));
        pokemons.add(new Pokemon("Giratina", 487));
        pokemons.add(new Pokemon("Cresselia", 488));
        pokemons.add(new Pokemon("Phione", 489));
        pokemons.add(new Pokemon("Manaphy", 490));
        pokemons.add(new Pokemon("Darkrai", 491));
        pokemons.add(new Pokemon("Shaymin", 492));
        pokemons.add(new Pokemon("Arceus", 493));
        pokemons.add(new Pokemon("Victini", 494));
        pokemons.add(new Pokemon("Snivy", 495));
        pokemons.add(new Pokemon("Servine", 496));
        pokemons.add(new Pokemon("Serperior", 497));
        pokemons.add(new Pokemon("Tepig", 498));
        pokemons.add(new Pokemon("Pignite", 499));
        pokemons.add(new Pokemon("Emboar", 500));
        pokemons.add(new Pokemon("Oshawott", 501));
        pokemons.add(new Pokemon("Dewott", 502));
        pokemons.add(new Pokemon("Samurott", 503));
        pokemons.add(new Pokemon("Patrat", 504));
        pokemons.add(new Pokemon("Watchog", 505));
        pokemons.add(new Pokemon("Lillipup", 506));
        pokemons.add(new Pokemon("Herdier", 507));
        pokemons.add(new Pokemon("Stoutland", 508));
        pokemons.add(new Pokemon("Purrloin", 509));
        pokemons.add(new Pokemon("Liepard", 510));
        pokemons.add(new Pokemon("Pansage", 511));
        pokemons.add(new Pokemon("Simisage", 512));
        pokemons.add(new Pokemon("Pansear", 513));
        pokemons.add(new Pokemon("Simisear", 514));
        pokemons.add(new Pokemon("Panpour", 515));
        pokemons.add(new Pokemon("Simipour", 516));
        pokemons.add(new Pokemon("Munna", 517));
        pokemons.add(new Pokemon("Musharna", 518));
        pokemons.add(new Pokemon("Pidove", 519));
        pokemons.add(new Pokemon("Tranquill", 520));
        pokemons.add(new Pokemon("Unfezant", 521));
        pokemons.add(new Pokemon("Blitzle", 522));
        pokemons.add(new Pokemon("Zebstrika", 523));
        pokemons.add(new Pokemon("Roggenrola", 524));
        pokemons.add(new Pokemon("Boldore", 525));
        pokemons.add(new Pokemon("Gigalith", 526));
        pokemons.add(new Pokemon("Woobat", 527));
        pokemons.add(new Pokemon("Swoobat", 528));
        pokemons.add(new Pokemon("Drilbur", 529));
        pokemons.add(new Pokemon("Excadrill", 530));
        pokemons.add(new Pokemon("Audino", 531));
        pokemons.add(new Pokemon("Timburr", 532));
        pokemons.add(new Pokemon("Gurdurr", 533));
        pokemons.add(new Pokemon("Conkeldurr", 534));
        pokemons.add(new Pokemon("Tympole", 535));
        pokemons.add(new Pokemon("Palpitoad", 536));
        pokemons.add(new Pokemon("Seismitoad", 537));
        pokemons.add(new Pokemon("Throh", 538));
        pokemons.add(new Pokemon("Sawk", 539));
        pokemons.add(new Pokemon("Sewaddle", 540));
        pokemons.add(new Pokemon("Swadloon", 541));
        pokemons.add(new Pokemon("Leavanny", 542));
        pokemons.add(new Pokemon("Venipede", 543));
        pokemons.add(new Pokemon("Whirlipede", 544));
        pokemons.add(new Pokemon("Scolipede", 545));
        pokemons.add(new Pokemon("Cottonee", 546));
        pokemons.add(new Pokemon("Whimsicott", 547));
        pokemons.add(new Pokemon("Petilil", 548));
        pokemons.add(new Pokemon("Lilligant", 549));
        pokemons.add(new Pokemon("Basculin", 550));
        pokemons.add(new Pokemon("Sandile", 551));
        pokemons.add(new Pokemon("Krokorok", 552));
        pokemons.add(new Pokemon("Krookodile", 553));
        pokemons.add(new Pokemon("Darumaka", 554));
        pokemons.add(new Pokemon("Darmanitan-standard", 555));
        pokemons.add(new Pokemon("Maractus", 556));
        pokemons.add(new Pokemon("Dwebble", 557));
        pokemons.add(new Pokemon("Crustle", 558));
        pokemons.add(new Pokemon("Scraggy", 559));
        pokemons.add(new Pokemon("Scrafty", 560));
        pokemons.add(new Pokemon("Sigilyph", 561));
        pokemons.add(new Pokemon("Yamask", 562));
        pokemons.add(new Pokemon("Cofagrigus", 563));
        pokemons.add(new Pokemon("Tirtouga", 564));
        pokemons.add(new Pokemon("Carracosta", 565));
        pokemons.add(new Pokemon("Archen", 566));
        pokemons.add(new Pokemon("Archeops", 567));
        pokemons.add(new Pokemon("Trubbish", 568));
        pokemons.add(new Pokemon("Garbodor", 569));
        pokemons.add(new Pokemon("Zorua", 570));
        pokemons.add(new Pokemon("Zoroark", 571));
        pokemons.add(new Pokemon("Minccino", 572));
        pokemons.add(new Pokemon("Cinccino", 573));
        pokemons.add(new Pokemon("Gothita", 574));
        pokemons.add(new Pokemon("Gothorita", 575));
        pokemons.add(new Pokemon("Gothitelle", 576));
        pokemons.add(new Pokemon("Solosis", 577));
        pokemons.add(new Pokemon("Duosion", 578));
        pokemons.add(new Pokemon("Reuniclus", 579));
        pokemons.add(new Pokemon("Ducklett", 580));
        pokemons.add(new Pokemon("Swanna", 581));
        pokemons.add(new Pokemon("Vanillite", 582));
        pokemons.add(new Pokemon("Vanillish", 583));
        pokemons.add(new Pokemon("Vanilluxe", 584));
        pokemons.add(new Pokemon("Deerling", 585));
        pokemons.add(new Pokemon("Sawsbuck", 586));
        pokemons.add(new Pokemon("Emolga", 587));
        pokemons.add(new Pokemon("Karrablast", 588));
        pokemons.add(new Pokemon("Escavalier", 589));
        pokemons.add(new Pokemon("Foongus", 590));
        pokemons.add(new Pokemon("Amoonguss", 591));
        pokemons.add(new Pokemon("Frillish", 592));
        pokemons.add(new Pokemon("Jellicent", 593));
        pokemons.add(new Pokemon("Alomomola", 594));
        pokemons.add(new Pokemon("Joltik", 595));
        pokemons.add(new Pokemon("Galvantula", 596));
        pokemons.add(new Pokemon("Ferroseed", 597));
        pokemons.add(new Pokemon("Ferrothorn", 598));
        pokemons.add(new Pokemon("Klink", 599));
        pokemons.add(new Pokemon("Klang", 600));
        pokemons.add(new Pokemon("Klinklang", 601));
        pokemons.add(new Pokemon("Tynamo", 602));
        pokemons.add(new Pokemon("Eelektrik", 603));
        pokemons.add(new Pokemon("Eelektross", 604));
        pokemons.add(new Pokemon("Elgyem", 605));
        pokemons.add(new Pokemon("Beheeyem", 606));
        pokemons.add(new Pokemon("Litwick", 607));
        pokemons.add(new Pokemon("Lampent", 608));
        pokemons.add(new Pokemon("Chandelure", 609));
        pokemons.add(new Pokemon("Axew", 610));
        pokemons.add(new Pokemon("Fraxure", 611));
        pokemons.add(new Pokemon("Haxorus", 612));
        pokemons.add(new Pokemon("Cubchoo", 613));
        pokemons.add(new Pokemon("Beartic", 614));
        pokemons.add(new Pokemon("Cryogonal", 615));
        pokemons.add(new Pokemon("Shelmet", 616));
        pokemons.add(new Pokemon("Accelgor", 617));
        pokemons.add(new Pokemon("Stunfisk", 618));
        pokemons.add(new Pokemon("Mienfoo", 619));
        pokemons.add(new Pokemon("Mienshao", 620));
        pokemons.add(new Pokemon("Druddigon", 621));
        pokemons.add(new Pokemon("Golett", 622));
        pokemons.add(new Pokemon("Golurk", 623));
        pokemons.add(new Pokemon("Pawniard", 624));
        pokemons.add(new Pokemon("Bisharp", 625));
        pokemons.add(new Pokemon("Bouffalant", 626));
        pokemons.add(new Pokemon("Rufflet", 627));
        pokemons.add(new Pokemon("Braviary", 628));
        pokemons.add(new Pokemon("Vullaby", 629));
        pokemons.add(new Pokemon("Mandibuzz", 630));
        pokemons.add(new Pokemon("Heatmor", 631));
        pokemons.add(new Pokemon("Durant", 632));
        pokemons.add(new Pokemon("Deino", 633));
        pokemons.add(new Pokemon("Zweilous", 634));
        pokemons.add(new Pokemon("Hydreigon", 635));
        pokemons.add(new Pokemon("Larvesta", 636));
        pokemons.add(new Pokemon("Volcarona", 637));
        pokemons.add(new Pokemon("Cobalion", 638));
        pokemons.add(new Pokemon("Terrakion", 639));
        pokemons.add(new Pokemon("Virizion", 640));
        pokemons.add(new Pokemon("Tornadus", 641));
        pokemons.add(new Pokemon("Thundurus", 642));
        pokemons.add(new Pokemon("Reshiram", 643));
        pokemons.add(new Pokemon("Zekrom", 644));
        pokemons.add(new Pokemon("Landorus", 645));
        pokemons.add(new Pokemon("Kyurem", 646));
        pokemons.add(new Pokemon("Keldeo", 647));
        pokemons.add(new Pokemon("Meloetta", 648));
        pokemons.add(new Pokemon("Genesect", 649));

        return pokemons;
    }
}