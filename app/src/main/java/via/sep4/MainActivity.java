package via.sep4;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import via.sep4.Dashboard.AddMushroomDialogFragment;
import via.sep4.Model.AppData;

public class MainActivity extends AppCompatActivity implements AddMushroomDialogFragment.AddMushroomDialogListener {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        AppData.setup(this);

        //Bottom Navigation Bar
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        //bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
        bottomNavigationView.setVisibility(View.INVISIBLE); //To not see navigation bar on Sign In menu

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.item_home, R.id.dashboard, R.id.item_settings).build();
        //avigation.setViewNavController(getCurrentFocus().findViewById(R.id.bottomNavigationView), new NavController(getApplicationContext()));
        NavController navController = Navigation.findNavController(this, R.id.fragmentbox);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportFragmentManager().beginTransaction()
                //.replace(R.id.fragmentbox, new SignIn()).commit();
    }

    /*@Override
    public void applyData(String mushroomName, Dashboard dash) {
        dash.AddMushroom(mushroomName);
    }*/

    //Bottom Navigation Bar Listener
    /*rivate BottomNavigationView.OnNavigationItemSelectedListener navigationListener = item -> {
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.item_home) {
            selectedFragment = new InfoFragment();
        } else if (itemId == R.id.item_dashboard) {
            selectedFragment = new Dashboard();
        } else if (itemId == R.id.item_settings) {
            selectedFragment = new SettingsFragment();
        }

        //Begin Transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentbox, selectedFragment).commit();
        return true;
    };*/
}