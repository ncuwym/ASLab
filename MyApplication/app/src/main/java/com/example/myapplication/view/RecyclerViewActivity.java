package com.example.myapplication.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.RecyclerAdapter;
import com.example.myapplication.model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;
import java.util.List;

//RecyclerView活动
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Movie> movieList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        movieList.add(new Movie(R.drawable.img1, "少年的你 ", "青春高考片"));
        movieList.add(new Movie(R.drawable.img2, "海上钢琴师", "一个钢琴天才传奇的一生"));
        movieList.add(new Movie(R.drawable.img3, "盗梦特攻队", "美国大片"));
        movieList.add(new Movie(R.drawable.img1, "少年的你 ", "青春高考片"));
        movieList.add(new Movie(R.drawable.img2, "海上钢琴师", "一个钢琴天才传奇的一生"));
        movieList.add(new Movie(R.drawable.img3, "盗梦特攻队", "美国大片"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter = new RecyclerAdapter(movieList, this));
        FloatingActionButton floatingActionButton =
                findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(view -> {
            recyclerView.smoothScrollToPosition(0);
        });
    }

    //    //
//    @Override
//    public void addContentView(View view, ViewGroup.LayoutParams params) {
//        super.addContentView(view, params);
//    }
    //创建菜单按钮
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
                adapter.notifyDataSetChanged();
                break;
            case R.id.add:
                movieList.add(movieList.get((int) (Math.random() * movieList.size())));
                adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
