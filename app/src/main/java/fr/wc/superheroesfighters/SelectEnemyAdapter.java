package fr.wc.superheroesfighters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by wilder on 05/04/18.
 */

public class SelectEnemyAdapter extends ArrayAdapter<SelectEnemyModel> {
    public SelectEnemyAdapter (Context context, ArrayList<SelectEnemyModel> enemyGrid) {
        super(context,0,enemyGrid);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        SelectEnemyModel enemy = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grid_enemy, parent, false);
        }

        ImageView imgEnemy = (ImageView) convertView.findViewById(R.id.image_enemy);
        TextView nameEnemy = (TextView) convertView.findViewById(R.id.name_enemy);


        Glide.with(getContext()).load(enemy.getImageHero()) .into(imgEnemy);
        nameEnemy.setText(enemy.getNameEnemy());

        return convertView;
    }
}
