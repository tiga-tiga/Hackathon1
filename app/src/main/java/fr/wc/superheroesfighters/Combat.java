package fr.wc.superheroesfighters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

public class Combat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        ImageView enemyPortrait = findViewById(R.id.enemy_view);
        ImageView heroPortrait = findViewById(R.id.hero_view);
        ImageView heroPhyAttack = findViewById(R.id.hero_physic_attack);
        ImageView enemyPhyAttack = findViewById(R.id.enemy_physic_attack);
        ImageView enemyMentAttack = findViewById(R.id.enemy_mental_attack);
        ImageView heroMentAttack = findViewById(R.id.hero_mental_attack);
        ImageView heroSpecialAttack = findViewById(R.id.hero_special_attack);
        ImageView enemySpecialAttack = findViewById(R.id.enemy_special_attack);

        heroPhyAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        heroMentAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        heroSpecialAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
