package via.sep4;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements AddMushroomDialogFragment.AddMushroomDialogListener {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bottom Navigation Bar
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
        bottomNavigationView.setVisibility(View.INVISIBLE); //To not see navigation bar on Sign In menu
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentbox,new SignIn()).commit();
    }

    @Override
    public void applyData(String mushroomName) {
        Dashboard dashboard = (Dashboard)
                getSupportFragmentManager().findFragmentById(R.id.fragmentbox);
        dashboard.AddMushroom(mushroomName);
    }

    //Bottom Navigation Bar Listener
    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch(item.getItemId()){
                case R.id.item_home:
                    selectedFragment = new InfoFragment();
                    break;
                case R.id.item_dashboard:
                    selectedFragment = new Dashboard();
                    break;
                case R.id.item_settings:
                    selectedFragment = new SettingsFragment();
                    break;
            }
            //Begin Transaction
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentbox,selectedFragment).commit();
            return true;
        }
    };
}