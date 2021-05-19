package via.sep4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * @deprecated Superseded by Dashboard.
 */

public class DashboardActivity extends AppCompatActivity implements AddMushroomDialogFragment.AddMushroomDialogListener {

    ImageButton buttonInfo;
    ImageButton buttonDashboard;
    ImageButton buttonSettings;
    ImageButton buttonAddMushroom;
    TableLayout tableLayout;
    TableRow row1;

    ArrayList<String> mushrooms = new ArrayList();
    ArrayList<Integer> tableRowIds = new ArrayList();

    DashboardActivityViewModel dashboardActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        buttonInfo = (ImageButton)findViewById(R.id.buttonInfo);
        buttonDashboard = (ImageButton)findViewById(R.id.buttonDashboard);
        buttonSettings = (ImageButton)findViewById(R.id.buttonSettings);
        buttonAddMushroom = (ImageButton)findViewById(R.id.buttonAddMushroom);
        row1 = (TableRow)findViewById(R.id.dashboardRow1);
        tableLayout = (TableLayout)findViewById(R.id.table);

        dashboardActivityViewModel = new ViewModelProvider(this).get(DashboardActivityViewModel.class);
        dashboardActivityViewModel.setData(this,row1,(ImageButton)findViewById(R.id.imageButton8),getDrawable(R.drawable.shroom),(TextView) findViewById(R.id.editTextTextPersonName4),(LinearLayout)findViewById(R.id.containerMushroom1));
        dashboardActivityViewModel.addMushroom(new Mushroom("Latticed Stinkhorn"));
        dashboardActivityViewModel.addMushroom(new Mushroom("Treehugger"));
        dashboardActivityViewModel.addMushroom(new Mushroom("Puffball"));
        dashboardActivityViewModel.addMushroom(new Mushroom("Indigo Milkcap"));
        //dashboardActivityViewModel.reSetUpGrid() //Only for testing;
        UpdateGrid();
    }



    public void UpdateGrid(){
        tableLayout.removeAllViews();
        for (TableRow row: dashboardActivityViewModel.getGrid()) {
            tableLayout.addView(row);
        }
    }

    public void NavigateDashboard(View view) {
        Intent intentActivityAddMushroom = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intentActivityAddMushroom);
    }
    public void NavigateGeneralInfo(View view) {
        Intent intentActivityAddMushroom = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intentActivityAddMushroom);
    }
    public void NavigateSettings(View view) {
        Intent intentActivityAddMushroom = new Intent(DashboardActivity.this,MainActivity.class);
        startActivity(intentActivityAddMushroom);
    }


    //On clicking + this brings a dialog with input
    public void AddMushroom(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mushroom Name");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        builder.setView(input);

        builder.setPositiveButton("Add Mushroom", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dashboardActivityViewModel.addMushroom(new Mushroom(input.getText().toString()));
                UpdateGrid();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void RemoveMushroom(LinearLayout containerToRemove){
        int removalInThisRow = ((View)containerToRemove.getParent()).getId();
        int rowsToUpdate = tableRowIds.size()-tableRowIds.indexOf(removalInThisRow);

        for(int i =rowsToUpdate;i<tableRowIds.size();i++){
            TableRow rowToUpdate = (TableRow)findViewById(tableRowIds.get(i));
        }
        ((ViewManager)containerToRemove.getParent()).removeView(containerToRemove);

    }

    public void clickHandlerCell(View view) {
        view.getTag();
        NavController nav = Navigation.findNavController(view);
        nav.navigate(R.id.action_dashboard_to_viewSpecimen);
    }
}