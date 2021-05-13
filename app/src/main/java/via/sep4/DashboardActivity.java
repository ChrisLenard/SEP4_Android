package via.sep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import via.sep4.Model.Mushroom;

/**
 * @deprecated Superseded by Dashboard.
 */

public class DashboardActivity extends AppCompatActivity implements AddMushroomDialogFragment.AddMushroomDialogListener {
    ImageButton buttonAddMushroom;
    TableLayout tableLayout;
    TableRow row1;

    ArrayList<String> mushrooms = new ArrayList();
    ArrayList<Integer> tableRowIds = new ArrayList();

    DashboardViewModel dashboardViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        buttonAddMushroom = (ImageButton)findViewById(R.id.btnAddMushroom);
        row1 = (TableRow)findViewById(R.id.dashboardTableRow1);
        tableLayout = (TableLayout)findViewById(R.id.dashboardTable);

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        dashboardViewModel.setData(this,row1,(ImageButton)findViewById(R.id.mushroomButton),getDrawable(R.drawable.shroom),(TextView) findViewById(R.id.mushroomText),(LinearLayout)findViewById(R.id.containerMushroom));
        dashboardViewModel.addMushroom(new Mushroom("Latticed Stinkhorn"));
        dashboardViewModel.addMushroom(new Mushroom("Treehugger"));
        dashboardViewModel.addMushroom(new Mushroom("Puffball"));
        dashboardViewModel.addMushroom(new Mushroom("Indigo Milkcap"));
        buttonAddMushroom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAddMushroomDialog(v);
            }
        });
		
        //dashboardActivityViewModel.reSetUpGrid() //Only for testing;
        UpdateGrid();
    }



    public void UpdateGrid(){
        tableLayout.removeAllViews();
        for (TableRow row: dashboardViewModel.getGrid()) {
            tableLayout.addView(row);
        }
    }


    //On clicking + this brings a dialog with input
    public void AddMushroom(String mushroomName) {
        dashboardViewModel.addMushroom(new Mushroom(mushroomName));
        UpdateGrid();
    }

    public void RemoveMushroom(LinearLayout containerToRemove){
        int removalInThisRow = ((View)containerToRemove.getParent()).getId();
        int rowsToUpdate = tableRowIds.size()-tableRowIds.indexOf(removalInThisRow);

        for(int i =rowsToUpdate;i<tableRowIds.size();i++){
            TableRow rowToUpdate = (TableRow)findViewById(tableRowIds.get(i));
        }
        ((ViewManager)containerToRemove.getParent()).removeView(containerToRemove);

    }

    public void openAddMushroomDialog(View v){
        AddMushroomDialogFragment dialogFragment = new AddMushroomDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"AddMushroomDialogFragment");
    }

    @Override
    public void applyData(String mushroomName) {
        AddMushroom(mushroomName);
    }
}