package via.sep4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import via.sep4.Model.Mushroom;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dashboard extends Fragment implements AddMushroomDialogFragment.AddMushroomDialogListener {

    ImageButton buttonAddMushroom;
    TableLayout tableLayout;
    TableRow row1;
    View v;

    ArrayList<Integer> tableRowIds = new ArrayList();

    DashboardViewModel dashboardViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Dashboard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dashboard.
     */
    // TODO: Rename and change types and number of parameters
    public static Dashboard newInstance(String param1, String param2) {
        Dashboard fragment = new Dashboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dashboard,container,false);
        buttonAddMushroom = (ImageButton)v.findViewById(R.id.btnAddMushroom);
        row1 = (TableRow)v.findViewById(R.id.dashboardTableRow1);
        tableLayout = (TableLayout)v.findViewById(R.id.dashboardTable);
        buttonAddMushroom = (ImageButton)v.findViewById(R.id.btnAddMushroom);

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        dashboardViewModel.setData(getContext(),row1,(ImageButton)v.findViewById(R.id.mushroomButton),getActivity().getDrawable(R.drawable.shroom),(TextView)v.findViewById(R.id.mushroomText),(LinearLayout)v.findViewById(R.id.containerMushroom));
        dashboardViewModel.addMushroom(new Mushroom("Latticed Stinkhorn"));
        dashboardViewModel.addMushroom(new Mushroom("Treehugger"));
        dashboardViewModel.addMushroom(new Mushroom("Puffball"));
        dashboardViewModel.addMushroom(new Mushroom("Indigo Milkcap"));
        buttonAddMushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddMushroomDialog(v);
            }
        });
        //dashboardActivityViewModel.reSetUpGrid() //Only for testing;
        UpdateGrid();
        Log.d("DASH","Dashboard View Created");
        return v;
    }

    // Re-draws grid
    public void UpdateGrid(){
        Log.d("DASH","Grid Update Called");
        tableLayout.removeAllViews();
        for (TableRow row: dashboardViewModel.getGrid()) {
            tableLayout.addView(row);
        }
    }
    // Remove mushroom ussing its display container
    public void RemoveMushroom(LinearLayout containerToRemove, View view){
        int removalInThisRow = ((View)containerToRemove.getParent()).getId();
        int rowsToUpdate = tableRowIds.size()-tableRowIds.indexOf(removalInThisRow);

        for(int i =rowsToUpdate;i<tableRowIds.size();i++){
            TableRow rowToUpdate = (TableRow)view.findViewById(tableRowIds.get(i));
        }
        ((ViewManager)containerToRemove.getParent()).removeView(containerToRemove);
        UpdateGrid();

    }
    //Pops up AddMushroom Dialog
    public void openAddMushroomDialog(View v){
        AddMushroomDialogFragment dialogFragment = new AddMushroomDialogFragment();
        dialogFragment.show(getParentFragmentManager(),"AddMushroomDialogFragment");
        Log.d("DASH","OPENED ADDMUSHROOMDIALOG");
    }
    //Adds new mushroom using mushroom name
    public void AddMushroom(String mushroomName){
        Log.d("DASH","Adding "+mushroomName);
        dashboardViewModel.addMushroom(new Mushroom(mushroomName));
        Log.d("DASH","Updating Grid");
        UpdateGrid();

    }
    @Override
    public void applyData(String mushroomName) {
        AddMushroom(mushroomName);
    }
}