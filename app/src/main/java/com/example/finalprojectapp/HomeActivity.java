package com.example.finalprojectapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    Switch switch_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch_id = findViewById(R.id.switch_id);

        switch_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switch_id.isChecked())
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dlayout;
    private NavigationView nav;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private SharedPreferences sp;
    private  MediMartDbHelper db;
    private TextView tv;

    protected  void OnCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        drawerToggle=new ActionBarDrawerToggle(this.getParent(),dlayout, toolbar, "On","Off");
        dlayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        nav.setNavigationItemSelectedListener(this);
        permissions();
        MediMartUtils.loadFragment(this,new CategoryFragment());
        loadmenu();
    }

   public void init(){
        dlayout=findViewById(R.id.dlayout);
        nav=findViewById(R.id.toolbar);
        tv=nav.getHeaderView(0).findViewById(R.id.tvusername);
        sp=getPreferences("users",MODE_PRIVATE);
        db=new MediMartDbHelper(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mega Mart");
   }

   public  boolean onCreateOptionsMenu(Menu,menu){
        getMenuInflater().inflate(R.menu.search_menu);
        return  super.onCreateOptionsMenu(menu);
   }

   public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId()==R.id.mcart){
            String user = sp.getString("userid", "guest");
            if (user.equals("guest")){
                MediMartUtils.loadFragment(this, new LoginFragment());
                Snackbar.make(getCurrentFocus(), "Please Login First,BaseTransientBottomBar.LENGTH_LONG").show();
            }
            else {
                MediMartUtils.loadFragment(this, new CartFragment());
            }
        }
        return super.onOptionsItemSelected(item);
   }


   public void login(View view){
        MediMartUtils.loadFragment(this, new LoginFragment());
   }

    public void register(View view){
        MediMartUtils.loadFragment(this, new RegisterFragment());
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
