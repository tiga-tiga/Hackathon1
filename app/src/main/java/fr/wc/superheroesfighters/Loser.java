package fr.wc.superheroesfighters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Loser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);

        final ImageView winnner = findViewById(R.id.image_winnerl);

        final ImageView looserImg = findViewById(R.id.image_loserl);




        SelectEnemyModel winner = getIntent().getExtras().getParcelable("WINNER");
        HeroStats looser = getIntent().getExtras().getParcelable("LOOSER");

        Glide.with(Loser.this).load(winner.getImageEnemy()) .into(winnner);

        looserImg.setImageBitmap(looser.getImage());

        ImageView replay = findViewById(R.id.image_restartL);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loser.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
