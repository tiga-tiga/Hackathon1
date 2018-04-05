package fr.wc.superheroesfighters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class SelectEnemyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_enemy);

        final GridView gridViewEnemy = findViewById(R.id.grid_view_enemy);
        ArrayList<SelectEnemyModel> enemy = new ArrayList<>();


        SelectEnemyAdapter adapter = new SelectEnemyAdapter(this, enemy);
        gridViewEnemy.setAdapter(adapter);
    }
}
