package fr.wc.superheroesfighters;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class SelectEnemyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_enemy);

        final GridView gridViewEnemy = findViewById(R.id.grid_view_enemy);
        final ArrayList<SelectEnemyModel> enemy = new ArrayList<>();

        // Crée une file d'attente pour les requêtes vers l'API
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/all.json";

        // Création de la requête vers l'API, ajout des écouteurs pour les réponses et erreurs possibles
        final JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for ( int i = 0; i < response.length(); i++ ) {
                                JSONObject heroPage = response.getJSONObject(i);
                                JSONObject powerStat = heroPage.getJSONObject("powerstats");
                                JSONObject imgHero = heroPage.getJSONObject("images");

                                String imageHero = imgHero.getString("sm");

                                String nom = heroPage.getString("name");
                                int intell = powerStat.getInt("intelligence");
                                int force = powerStat.getInt("strength");
                                int speed = powerStat.getInt("speed");
                                int dur = powerStat.getInt("durability");
                                int powr = powerStat.getInt("power");
                                int cmbt = powerStat.getInt("combat");

                                enemy.add(new SelectEnemyModel(imageHero, nom));
                            }

                            SelectEnemyAdapter adapter = new SelectEnemyAdapter(SelectEnemyActivity.this, enemy);
                            gridViewEnemy.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Afficher l'erreur
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }
        );

        // On ajoute la requête à la file d'attente
        requestQueue.add(jsonObjectRequest);

        gridViewEnemy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent goCombat = new Intent(SelectEnemyActivity.this, Combat.class);
                startActivity(goCombat);
            }
        });


    }
}
