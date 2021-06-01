package via.sep4.Viewspecimen;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import via.sep4.Model.Mushroom;

import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import via.sep4.Model.SensorDataList;
import via.sep4.R;

import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewSpecimen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewSpecimen extends Fragment {

    Button diaryButton;
    CardView temperature;
    TextView actualTemp;
    

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewSpecimenViewModel viewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Mushroom mushroom;
    private View v;

    public ViewSpecimen() {
        // Required empty public constructor
    }

    public ViewSpecimen(Mushroom mushroom){
        this.mushroom = mushroom;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewSpecimen.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewSpecimen newInstance(String param1, String param2) {
        ViewSpecimen fragment = new ViewSpecimen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewSpecimenViewModel();
        final Observer<SensorDataList> sensorDataObserver = new Observer<SensorDataList>()
        {
            @Override
            public void onChanged(@Nullable final SensorDataList sensorDataList)
            {
                //Sensor Data binding
            }
        };
        viewModel.getSensorLiveData().observe(this, sensorDataObserver);
        viewModel.getSensorData();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_view_specimen, container, false);
        diaryButton = root.findViewById(R.id.diaryButton);
        temperature = root.findViewById(R.id.temperature);
        actualTemp = root.findViewById(R.id.actualTemp);
        temperature.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mushroom = (Mushroom) getArguments().getSerializable("mushroom");
                Bundle bundle = new Bundle();
                bundle.putString("Type","Temperature");
                bundle.putString("Range","12C - 19C");
                bundle.putString("Name",mushroom.getName());
                NavController nav = Navigation.findNavController(root);
                nav.navigate(R.id.action_viewSpecimen_to_visualisation,bundle);
            }
        });
        diaryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NavController nav = Navigation.findNavController(root);
                nav.navigate(R.id.action_viewSpecimen_to_diary);
            }
        });
        actualTemp.setText("");
        return root;
    }
}