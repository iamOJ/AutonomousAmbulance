package com.example.jones.autonomousambulance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class TypeActivity extends AppCompatActivity {

    ArrayList<ImageButton> imageButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        RecyclerView rvButtons = (RecyclerView) findViewById(R.id.emergency);

        imageButtons = ImageButton.createImageList();

        ButtonAdapter adapter = new ButtonAdapter(this, imageButtons);

        rvButtons.setAdapter(adapter);
        /*
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        rvButtons.setLayoutManager(gridLayoutManager);*/
        rvButtons.setHasFixedSize(true);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvButtons.setLayoutManager(gridLayoutManager);



    }
}
