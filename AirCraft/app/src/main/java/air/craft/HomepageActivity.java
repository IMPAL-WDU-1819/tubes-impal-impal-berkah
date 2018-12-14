package air.craft;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView nav = findViewById(R.id.menu_bottom);

        nav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag, new Home()).commit();
        getSupportActionBar().setTitle("Home");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selected = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selected = new Home();
                            getSupportActionBar().setTitle("Home");
                            break;
                        case R.id.nav_help:
                            selected = new Payment();
                            getSupportActionBar().setTitle("Payment Info");
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag,selected).commit();

                    return true;
                }
            };
}
