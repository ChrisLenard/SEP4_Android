package via.sep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void applyData(String mushroomName) {
        Dashboard dashboard = (Dashboard)
                getSupportFragmentManager().findFragmentById(R.id.fragmentbox);
        dashboard.AddMushroom(mushroomName);
    }

    //Bottom Navigation Bar Listener
    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = item -> {
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
                .replace(R.id.fragmentbox,selectedFragment).commit();
        return true;
    };
}