package fr.wc.superheroesfighters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

public class Combat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        Intent board = getIntent();

        final MonsterModel fighters = board.getParcelableExtra("fighters");



        fighter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monster.takeHit1();
                boom2.setVisibility(View.VISIBLE);
                boom1.setVisibility(View.GONE);
                monster2Life.setText(String.valueOf(monster.getLife2()));
                if(monster.isKO2()){
                    winner.setImageResource(R.drawable.firesaur);
                    winner.setVisibility(View.VISIBLE);
                    fighter1.setClickable(false);
                    fighter2.setClickable(false);
                    button.setVisibility(View.VISIBLE);
                    tvBlink2.setVisibility(View.VISIBLE);

                    tvBlink2.setText(monster.getNameMonster1() + "WIN'S!!!");
                    //on paramètre l'animation
                    Animation anim = new AlphaAnimation(0.0f, 1.0f);
                    anim.setDuration(1000); //c'est le paramètre qui permet de paramètrer la fréquence du clignot
                    anim.setStartOffset(10);//temps qu'il reste invisible
                    anim.setRepeatMode(Animation.REVERSE);
                    anim.setRepeatCount(Animation.INFINITE);
                    tvBlink2.startAnimation(anim);
                    Toast.makeText(BattleActivity.this, monster.getNameMonster2() + " is KO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
