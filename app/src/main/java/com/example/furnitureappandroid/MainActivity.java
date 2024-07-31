package com.example.furnitureappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<DataModel> data;
    private Context mContext;
    private static RecyclerView.Adapter adapter2;
    private static RecyclerView recyclerView2;
    private RecyclerView.LayoutManager layoutManager2;
    private static ArrayList<DataModel> data2;
    private Context mContext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitiateMainCards();
        InitiateSecondaryCards();
    }

    private void InitiateSecondaryCards() {
        recyclerView2 = findViewById(R.id.recyclerViewSecondary);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        data2 = new ArrayList<DataModel>();

        for(int i = 0 ; i < MyData2.nameArray.length ; i++){
            data2.add(
                    new DataModel(
                            MyData2.nameArray[i],
                            MyData2.versionArray[i],
                            MyData2.id_[i],
                            MyData2.drawableArray[i]
                    )
            );
        }
        adapter2 = new CustomerAdapter2(this
                , data2);
        recyclerView2.setAdapter(adapter2);

    }

    private void InitiateMainCards() {
        recyclerView = findViewById(R.id.recyclerViewPrimary);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();

        for(int i = 0 ; i < MyData.nameArray.length ; i++){
            data.add(
                    new DataModel(
                            MyData.nameArray[i],
                            MyData.versionArray[i],
                            MyData.id_[i],
                            MyData.drawableArray[i]
                    )
            );
        }
        adapter = new CustomAdapter(data , this);
        recyclerView.setAdapter(adapter);
    }
}