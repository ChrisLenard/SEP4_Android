package via.sep4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class DashboardActivity extends AppCompatActivity {
    ImageButton buttonInfo;
    ImageButton buttonDashboard;
    ImageButton buttonSettings;
    ImageButton buttonAddMushroom;
    TableLayout tableLayout;
    TableRow row1;

    ArrayList<String> mushrooms = new ArrayList();
    ArrayList<Integer> tableRowIds = new ArrayList();

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

    public void AddMushroom(View view) {
        TableRow row1 = (TableRow)findViewById(R.id.dashboardRow1);
        String mushroomName = "Mushroom"+(mushrooms.size()+1);
        //ImageButton for new shroom
        ImageButton newShroomButton = new ImageButton(this);
        ImageButton shroomButton = (ImageButton)findViewById(R.id.imageButton8);
        ViewGroup.LayoutParams layoutShroomButton = shroomButton.getLayoutParams();
        newShroomButton.setLayoutParams(layoutShroomButton);
        newShroomButton.setMinimumWidth(toDensity(this,97));
        newShroomButton.setMinimumHeight(toDensity(this,92));
        newShroomButton.setBackgroundResource(R.drawable.shroom);
        newShroomButton.setBackground(getDrawable(R.drawable.shroom));
        newShroomButton.setClickable(true);
        newShroomButton.setScaleType(ImageView.ScaleType.FIT_XY);


        //TextView for new shroom
        TextView newShroomText = new TextView(this);
        TextView shroomText = (TextView) findViewById(R.id.editTextTextPersonName4);
        ViewGroup.LayoutParams layoutShroomText = shroomText.getLayoutParams();
        newShroomText.setLayoutParams(layoutShroomText);
        newShroomText.setMinEms(10);
        newShroomText.setText(mushroomName);
        newShroomText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        newShroomText.setTranslationZ(3);
        newShroomText.setTextColor(Color.BLACK);
        newShroomText.setId(ViewCompat.generateViewId());
        newShroomText.setTextAppearance(R.style.TextAppearance_AppCompat_Medium);

        //LinearLayout
        LinearLayout newShroomContainer = new LinearLayout(this);
        newShroomContainer.setTag("mushroom"+mushrooms.size());
        LinearLayout linLayout = (LinearLayout)findViewById(R.id.containerMushroom1);
        ViewGroup.LayoutParams lp = linLayout.getLayoutParams();
        newShroomContainer.setLayoutParams(lp);
        newShroomContainer.setOrientation(LinearLayout.VERTICAL);
        newShroomContainer.setId(ViewCompat.generateViewId());
        newShroomContainer.addView(newShroomButton);
        newShroomContainer.addView(newShroomText);
        if(mushrooms.size() % 3 == 0){
            TableRow newRow = new TableRow(this);
            newRow.setId(ViewCompat.generateViewId());
            ViewGroup.LayoutParams tableRowLayout = row1.getLayoutParams();
            newRow.setLayoutParams(tableRowLayout);
            tableRowIds.add(newRow.getId());
            newRow.addView(newShroomContainer);
            tableLayout.addView(newRow);
        }else{
            TableRow rowToAdd = (TableRow)findViewById(tableRowIds.get((int)mushrooms.size()/3));
            rowToAdd.addView(newShroomContainer);
        }
        mushrooms.add(mushroomName);
        newShroomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void RemoveMushroom(){
        //int removalInThisRow = ((View)newShroomContainer.getParent()).getId();
        //((ViewManager)newShroomContainer.getParent()).removeView(newShroomContainer);
    }
    public static int toDensity(final Context context, final float px) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, context.getResources().getDisplayMetrics());
    }
}