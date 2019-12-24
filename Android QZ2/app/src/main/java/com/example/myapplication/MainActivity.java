package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

//主活动
public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            //抽屉菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this, "打开抽屉",
                        Toast.LENGTH_LONG).show();
                super.onDrawerOpened(drawerView);
            }

            //抽屉菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MainActivity.this, "关闭抽屉",
                        Toast.LENGTH_LONG).show();
                super.onDrawerClosed(drawerView);
            }
        };
        //NavigationView设置点击监听
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Toast.makeText(MainActivity.this, menuItem.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return false;
                    }
                });
        drawerToggle.syncState();
        //DrawerLayout监听抽屉
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*控件初始化*/
    private void initView() {
        floatingActionButton = findViewById(R.id.floating_Button);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.drawer_navigation);
    }
}
