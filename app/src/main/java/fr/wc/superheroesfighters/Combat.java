package fr.wc.superheroesfighters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Combat extends AppCompatActivity {

    int heroLife = 100;
    int lifeEnemy= 10;

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
        TextView heroLifeBar = findViewById(R.id.heo_life_bar);
        final TextView enemyLifeBar = findViewById(R.id.enemy_life_bar);

        final SelectEnemyModel monstre = getIntent().getExtras().getParcelable("TIMBRE");
        final HeroStats courier = getIntent().getExtras().getParcelable("GUERE");

        //photo joueur
        heroPortrait.setImageBitmap(courier.getImage());

        Glide.with(Combat.this).load(monstre.getImageEnemy()) .into(enemyPortrait);

        lifeEnemy = ( 10 + monstre.getDur() + monstre.getPowr());
        heroLife = (50 + courier.getDurability() + courier.getPower());

        enemyLifeBar.setText(String.valueOf(lifeEnemy));
        heroLifeBar.setText(String.valueOf(heroLife));

        heroPhyAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int calculHp = 1;
                calculHp = (((courier.getPower())+(courier.getForce())-(monstre.getDur())));

                if (calculHp<0) {
                    calculHp=0;
                }

                lifeEnemy = lifeEnemy - (calculHp);

                if (lifeEnemy<0){
                    lifeEnemy = 0;
                }

                enemyLifeBar.setText(String.valueOf(lifeEnemy));
            }
        });

        heroMentAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int calculHe = 1;
                calculHe = (((courier.getIntelligence())+(courier.getCombat())-(monstre.getIntell())));

                if (calculHe<0) {
                    calculHe=0;
                }

                lifeEnemy = lifeEnemy - (calculHe);

                if (lifeEnemy<0){
                    lifeEnemy = 0;
                }

                enemyLifeBar.setText(String.valueOf(lifeEnemy));

            }
        });

        heroSpecialAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int calculHs = 1;
                calculHs = (((courier.getCombat())+(courier.getForce())-(monstre.getDur())));

                if (calculHs<0) {
                    calculHs=0;
                }

                lifeEnemy = lifeEnemy - (calculHs);

                if (lifeEnemy<0){
                    lifeEnemy = 0;
                }

                enemyLifeBar.setText(String.valueOf(lifeEnemy));

            }
        });



    }
}
