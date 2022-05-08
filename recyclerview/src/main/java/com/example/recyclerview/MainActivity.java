package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<1000;i++){
            Bean bean=new Bean();
            bean.setName("安明诺"+i);
            data.add(bean);
        }
        RecyclerView  recyclerView=findViewById(R.id.rv);
//        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setLayoutManager( new GridLayoutManager(this,3));
        MyAdapter myAdapter = new MyAdapter(data, this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setRecyclerItemClickLister(new MyAdapter.OnRecyclerItemClickLister() {
            @Override
            public void onRecyclerItemClick(int position) {
                Log.e("amn", "onRecyclerItemClick: "+position );
            }
        });
    }

}