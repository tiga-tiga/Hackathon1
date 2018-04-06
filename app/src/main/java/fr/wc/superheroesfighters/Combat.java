package fr.wc.superheroesfighters;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

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
        ImageView heroMentAttack = findViewById(R.id.hero_mental_attack);
        ImageView heroSpecialAttack = findViewById(R.id.hero_special_attack);
        final TextView heroLifeBar = findViewById(R.id.heo_life_bar);
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


        final Intent victoire = new Intent(Combat.this, Winner.class);
        final Intent loser = new Intent(Combat.this, Loser.class);
        final HeroStats stats = new HeroStats(courier.getName(), courier.getForce(), courier.getIntelligence(), courier.getDurability(), courier.getCombat(), courier.getSpeed(), courier.getPower(), courier.getImage());
        final SelectEnemyModel enemyF = new SelectEnemyModel(monstre.getImageEnemy(), monstre.getNameEnemy(),monstre.getIntell(),monstre.getForce(),monstre.getSpeed(),monstre.getDur(),monstre.getPowr(),monstre.getCmbt());
        victoire.putExtra("FIN", stats);
        victoire.putExtra("FINE", enemyF);


        heroPhyAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int calculHp = 1;
                calculHp = (((courier.getPower())+(courier.getForce())-(monstre.getDur())));

                int calculEp = 1;
                calculEp = (((monstre.getPowr())+(monstre.getForce())-(courier.getDurability())));


                if (calculHp<0) {
                    calculHp=0;
                }

                if (calculEp<0) {
                    calculEp=0;
                }

                lifeEnemy = lifeEnemy - (calculHp);
                heroLife = heroLife - (calculEp);

                if (lifeEnemy < 0) {
                    lifeEnemy = 0;
                    startActivity(victoire);

                }

                if (heroLife < 0) {
                    heroLife = 0;
                     Intent loser = new Intent(Combat.this, Loser.class);
                    loser.putExtra("LOOSER", stats);
                    loser.putExtra("WINNER", enemyF);
                    startActivity(loser);
                }



                heroLifeBar.setText(String.valueOf(heroLife));
                enemyLifeBar.setText(String.valueOf(lifeEnemy));

                // toast de résultats
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView imageEnemy = (ImageView) layout.findViewById(R.id.image_enemy);
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                TextView text = (TextView) layout.findViewById(R.id.text);

                image.setImageBitmap(courier.getImage());
                Glide.with(Combat.this).load(monstre.getImageEnemy()) .into(imageEnemy);


                text.setText( "You deal " + calculHp + " damages for the enemy ! " + " \n " + "but you get " + calculEp + "damages");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

            }
        });

        heroMentAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int calculHp = 1;
                calculHp = (((courier.getIntelligence())+(courier.getSpeed())-(monstre.getDur())));

                int calculEp = 1;
                calculEp = ((monstre.getIntell())+(monstre.getSpeed())-(courier.getDurability()));


                if (calculHp<0) {
                    calculHp=0;
                }

                if (calculEp<0) {
                    calculEp=0;
                }

                lifeEnemy = lifeEnemy - (calculHp);
                heroLife = heroLife - (calculEp);

                if (lifeEnemy < 0) {
                    lifeEnemy = 0;
                    Intent victoire = new Intent(Combat.this, Winner.class);
                    HeroStats stats = new HeroStats(courier.getName(), courier.getForce(), courier.getIntelligence(), courier.getDurability(), courier.getCombat(), courier.getSpeed(), courier.getPower(), courier.getImage());
                    SelectEnemyModel enemyF = new SelectEnemyModel(monstre.getImageEnemy(), monstre.getNameEnemy(),monstre.getIntell(),monstre.getForce(),monstre.getSpeed(),monstre.getDur(),monstre.getPowr(),monstre.getCmbt());
                    victoire.putExtra("FIN", stats);
                    victoire.putExtra("FINE", enemyF);
                    startActivity(victoire);

                }

                if (heroLife < 0) {
                    heroLife = 0;
                    Intent loser = new Intent(Combat.this, Loser.class);
                    HeroStats stats = new HeroStats(courier.getName(), courier.getForce(), courier.getIntelligence(), courier.getDurability(), courier.getCombat(), courier.getSpeed(), courier.getPower(), courier.getImage());
                    SelectEnemyModel enemyF = new SelectEnemyModel(monstre.getImageEnemy(), monstre.getNameEnemy(),monstre.getIntell(),monstre.getForce(),monstre.getSpeed(),monstre.getDur(),monstre.getPowr(),monstre.getCmbt());
                    loser.putExtra("FIN", stats);
                    loser.putExtra("FINE", enemyF);
                    startActivity(loser);
                }


                heroLifeBar.setText(String.valueOf(heroLife));
                enemyLifeBar.setText(String.valueOf(lifeEnemy));

                // toast de résultats
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView imageEnemy = (ImageView) layout.findViewById(R.id.image_enemy);
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                TextView text = (TextView) layout.findViewById(R.id.text);

                image.setImageBitmap(courier.getImage());
                Glide.with(Combat.this).load(monstre.getImageEnemy()) .into(imageEnemy);


                text.setText( "You deal " + calculHp + " damages for the enemy ! " + " \n " + "but you get " + calculEp + "damages");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });

        heroSpecialAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int calculHp = 1;
                calculHp = ((((courier.getPower())+(courier.getIntelligence())+(courier.getForce())+20)-(monstre.getDur())));

                int calculEp = 1;
                calculEp = (((monstre.getPowr())+(monstre.getIntell())+(monstre.getForce()+20)-(courier.getDurability())));


                if (calculHp<0) {
                    calculHp=0;
                }

                if (calculEp<0) {
                    calculEp=0;
                }

                lifeEnemy = lifeEnemy - (calculHp);
                heroLife = heroLife - (calculEp);

                if (lifeEnemy < 0) {
                    lifeEnemy = 0;
                    Intent victoire = new Intent(Combat.this, Winner.class);
                    HeroStats stats = new HeroStats(courier.getName(), courier.getForce(), courier.getIntelligence(), courier.getDurability(), courier.getCombat(), courier.getSpeed(), courier.getPower(), courier.getImage());
                    SelectEnemyModel enemyF = new SelectEnemyModel(monstre.getImageEnemy(), monstre.getNameEnemy(),monstre.getIntell(),monstre.getForce(),monstre.getSpeed(),monstre.getDur(),monstre.getPowr(),monstre.getCmbt());
                    victoire.putExtra("FIN", stats);
                    victoire.putExtra("FINE", enemyF);
                    startActivity(victoire);

                }

                if (heroLife < 0) {
                    heroLife = 0;
                    Intent loser = new Intent(Combat.this, Loser.class);
                    HeroStats stats = new HeroStats(courier.getName(), courier.getForce(), courier.getIntelligence(), courier.getDurability(), courier.getCombat(), courier.getSpeed(), courier.getPower(), courier.getImage());
                    SelectEnemyModel enemyF = new SelectEnemyModel(monstre.getImageEnemy(), monstre.getNameEnemy(),monstre.getIntell(),monstre.getForce(),monstre.getSpeed(),monstre.getDur(),monstre.getPowr(),monstre.getCmbt());
                    loser.putExtra("FIN", stats);
                    loser.putExtra("FINE", enemyF);
                    startActivity(loser);
                }

                heroLifeBar.setText(String.valueOf(heroLife));
                enemyLifeBar.setText(String.valueOf(lifeEnemy));


                // toast de résultats
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));

                ImageView imageEnemy = (ImageView) layout.findViewById(R.id.image_enemy);
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                TextView text = (TextView) layout.findViewById(R.id.text);

                image.setImageBitmap(courier.getImage());
                Glide.with(Combat.this).load(monstre.getImageEnemy()) .into(imageEnemy);

                text.setText( "You deal " + calculHp + " damages for the enemy ! " + " \n " + "but you get " + calculEp + "damages");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });
    }
}
