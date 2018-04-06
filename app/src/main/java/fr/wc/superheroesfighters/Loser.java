package fr.wc.superheroesfighters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Loser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);

        ImageView ivWinner = findViewById(R.id.image_winner);
        ImageView ivLoser = findViewById(R.id.image_loser);
        TextView tvWin = findViewById(R.id.text_winner);
        TextView tvLose = findViewById(R.id.text_loser);
        TextView tvWinnerName = findViewById(R.id.text_name);
    }
}
