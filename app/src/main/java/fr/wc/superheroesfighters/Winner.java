package fr.wc.superheroesfighters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
         ImageView winnner = findViewById(R.id.image_winner);

         ImageView looserImg = findViewById(R.id.image_loser);




        SelectEnemyModel looser = getIntent().getExtras().getParcelable("LOOSER");
        HeroStats winner = getIntent().getExtras().getParcelable("WINNER");
        Glide.with(Winner.this).load(looser.getImageEnemy()) .into(looserImg);

        winnner.setImageBitmap(winner.getImage());

        ImageView replay = findViewById(R.id.image_restartw);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Winner.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
