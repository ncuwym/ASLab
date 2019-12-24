package com.example.myapplication.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ListViewAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

//ListView活动
public class ListViewActivity extends AppCompatActivity {
    List<Movie> movieList = new LinkedList<>();
    ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listViewAdapter = new ListViewAdapter(movieList, getApplicationContext());
        movieList.add(new Movie(R.drawable.img1, "少年的你 ", "青春高考片"));
        movieList.add(new Movie(R.drawable.img2, "海上钢琴师", "一个钢琴天才传奇的一生"));
        movieList.add(new Movie(R.drawable.img3, "盗梦特攻队", "美国大片"));
        movieList.add(new Movie(R.drawable.img1, "少年的你 ", "青春高考片"));
        movieList.add(new Movie(R.drawable.img2, "海上钢琴师", "一个钢琴天才传奇的一生"));
        movieList.add(new Movie(R.drawable.img3, "盗梦特攻队", "美国大片"));
        ListView listView = findViewById(R.id.list_View);
        //设置适配器
        listView.setAdapter(listViewAdapter);
        //悬浮按钮，回到顶部
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(view -> {
            listView.smoothScrollToPosition(0);
        });
    }

    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.del:
                movieList.remove((int) (Math.random() * movieList.size()));
                listViewAdapter.notifyDataSetChanged();
                break;
            case R.id.add:
                movieList.add(movieList.get((int) (Math.random() * movieList.size())));
                listViewAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
