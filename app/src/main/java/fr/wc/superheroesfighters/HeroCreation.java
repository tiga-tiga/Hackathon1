package fr.wc.superheroesfighters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HeroCreation extends AppCompatActivity {

    int forceF = 0;
    int intellF = 0;
    int durabilityF = 0;
    int combatF = 0;
    int speedF = 0;
    int powerF = 0;
    int capitalF = 300;
    ImageView avatar;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_creation);

        Button forceMoins = findViewById(R.id.force_moins);
        final TextView force = findViewById(R.id.force);
        Button forcePlus = findViewById(R.id.force_plus);

        Button intellMoins = findViewById(R.id.intell_moins);
        final TextView intell = findViewById(R.id.intell);
        Button intellPlus = findViewById(R.id.intell_plus);

        Button  durabilityPlus = findViewById(R.id.durability_plus);
        final TextView durability = findViewById(R.id.durability);
        Button durabilityMoins = findViewById(R.id.durability_moins);

        Button combatMoins = findViewById(R.id.combat_moins);
        final TextView combat = findViewById(R.id.combat);
        Button combatPlus = findViewById(R.id.combat_plus);

        Button speedMoins = findViewById(R.id.speed_moins);
        final TextView speed = findViewById(R.id.speed);
        Button speedPlus = findViewById(R.id.speed_plus);

        Button powerMoins = findViewById(R.id.power_moins);
        final TextView power = findViewById(R.id.power);
        Button powerPlus = findViewById(R.id.power_plus);

        final TextView capital = findViewById(R.id.pts_left);

        Button goSelectEnemy = findViewById(R.id.go_fight);

        final EditText yourName = findViewById(R.id.name_hero);



        forceMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    forceF -= 10;
                    capitalF += 10;

                    if (forceF < 0){
                        forceF = 0;
                    }

                    if (capitalF > 300){
                        capitalF = 300;
                    }

                    force.setText(String.valueOf(forceF));
                    capital.setText(String.valueOf(capitalF));
            }
        });

        forcePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    forceF += 10;
                    capitalF -= 10;

                    if (capitalF<0){
                        capitalF = 0;
                    }

                    force.setText(String.valueOf(forceF));
                    capital.setText(String.valueOf(capitalF));
                }
            }
        });

        durabilityMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                durabilityF -= 10;
                capitalF += 10;

                if (durabilityF < 0){
                    durabilityF = 0;
                }

                if (capitalF > 300){
                    capitalF = 300;
                }

                durability.setText(String.valueOf(durabilityF));
                capital.setText(String.valueOf(capitalF));
            }
        });

        durabilityPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    durabilityF += 10;
                    capitalF -= 10;


                    if (capitalF<0){
                        capitalF = 0;
                    }

                    durability.setText(String.valueOf(durabilityF));
                    capital.setText(String.valueOf(capitalF));
                }
            }
        });

        intellMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intellF -= 10;
                capitalF += 10;

                if (intellF < 0){
                    intellF = 0;
                }

                if (capitalF > 300){
                    capitalF = 300;
                }

                intell.setText(String.valueOf(intellF));
                capital.setText(String.valueOf(capitalF));
            }
        });

        intellPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    intellF += 10;
                    capitalF -= 10;

                    if (capitalF<0){
                        capitalF = 0;
                    }

                    intell.setText(String.valueOf(intellF));
                    capital.setText(String.valueOf(capitalF));
                }
            }
        });

        combatMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combatF -= 10;
                capitalF += 10;

                if (combatF < 0){
                    combatF = 0;
                }

                if (capitalF > 300){
                    capitalF = 300;
                }

                combat.setText(String.valueOf(combatF));
                capital.setText(String.valueOf(capitalF));

            }
        });

        combatPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    combatF += 10;
                    capitalF -= 10;

                    if (capitalF<0){
                        capitalF = 0;
                    }

                    combat.setText(String.valueOf(combatF));
                    capital.setText(String.valueOf(capitalF));
                }

            }
        });

        speedMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                speedF -= 10;
                capitalF += 10;

                if (speedF < 0){
                    speedF = 0;
                }

                if (capitalF > 300){
                    capitalF = 300;
                }

                speed.setText(String.valueOf(speedF));
                capital.setText(String.valueOf(capitalF));

            }
        });

        speedPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    speedF += 10;
                    capitalF -= 10;

                    if (capitalF<0){
                        capitalF = 0;
                    }

                    speed.setText(String.valueOf(speedF));
                    capital.setText(String.valueOf(capitalF));
                }

            }
        });

        powerMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                powerF -= 10;
                capitalF += 10;

                if (powerF < 0){
                    powerF = 0;
                }

                if (capitalF > 300){
                    capitalF = 300;
                }

                power.setText(String.valueOf(powerF));
                capital.setText(String.valueOf(capitalF));
            }
        });

        powerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( (forceF + intellF + durabilityF + combatF + speedF + powerF) > 290 ) {

                    Toast.makeText(HeroCreation.this, "You used all yours points", Toast.LENGTH_SHORT).show();
                } else {

                    powerF += 10;
                    capitalF -= 10;

                    if (capitalF<0){
                        capitalF = 0;
                    }

                    power.setText(String.valueOf(powerF));
                    capital.setText(String.valueOf(capitalF));
                }

            }
        });

        avatar = findViewById(R.id.avatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 0);
            }
        });

        goSelectEnemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String heroName = yourName.getText().toString();

                Intent goListEnemy = new Intent(HeroCreation.this, SelectEnemyActivity.class);
                HeroStats stats = new HeroStats(heroName, forceF, intellF, durabilityF, combatF, speedF, powerF,bitmap);
                goListEnemy.putExtra("GUERRE", stats);
                startActivity(goListEnemy);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         bitmap = (Bitmap) data.getExtras().get("data");

         RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                HeroCreation.this.getResources(), bitmap);

        roundedBitmapDrawable.setCircular(true);
        avatar.setImageDrawable(roundedBitmapDrawable);
    }


    }
