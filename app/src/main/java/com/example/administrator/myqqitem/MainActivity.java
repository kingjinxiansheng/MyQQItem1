package com.example.administrator.myqqitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SlideListView listview;
    List<String>listdata=new ArrayList<>();
    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setAdapter();
        setData();
        setOnListener();
    }

    private void setOnListener() {
        slideAdapter.setOnClickenListener(new SlideAdapter.Listener() {
            @Override
            public void setListener(View one, View two, View three, final int position) {
                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = listdata.get(position);
                        listdata.remove(position);
                        listdata.add(0,s);
                        slideAdapter.notifyDataSetChanged();
                    }
                });

                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "未读", Toast.LENGTH_SHORT).show();
                        slideAdapter.notifyDataSetChanged();
                    }
                });
                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listdata.remove(position);
                        slideAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "条目"+i, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setAdapter() {
         slideAdapter = new SlideAdapter(MainActivity.this,listdata);
        listview.setAdapter(slideAdapter);
    }

    private void setData() {
        for (int i = 0; i <30 ; i++) {
            listdata.add("数据"+i);
        }
    }

    private void initView() {
        listview = (SlideListView) findViewById(R.id.listview);
    }
}
