package via.sep4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AddMushroomDialogFragment.AddMushroomDialogListener {
    private Dashboard dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dashboard = new Dashboard();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, dashboard).commit();
    }

    @Override
    public void applyData(String mushroomName) {
        dashboard.AddMushroom(mushroomName);
    }
}