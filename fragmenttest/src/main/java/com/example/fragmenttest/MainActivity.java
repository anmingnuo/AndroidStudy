package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.btn1);
        Button button2=findViewById(R.id.btn2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Bundle bundle=new Bundle();
                bundle.putString("message","whanamn");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);
                bf.setFragmentCallback(new IFragmentCallback() {
                    @Override
                    public void senMessageToActivity(String s) {
//                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();;
                    }

                    @Override
                    public String getMessageFromActivity(String msg) {
                        return "hello i am from Activity";
                    }
                });
                replaceFragment(bf);
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
        }
    }
    //动态切换
    private void replaceFragment(Fragment blankFragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,blankFragment);
//        transaction.addToBackStack(null);点击返回 ，返回上一个Fragment
        transaction.commit();
    }
}