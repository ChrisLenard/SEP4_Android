package via.sep4;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;
import via.sep4.Model.Mushroom;
import androidx.lifecycle.Observer;
import via.sep4.Model.Data.SensorDataList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewSpecimen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewSpecimen extends Fragment {
    
    Button diaryButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewSpecimen() {
        // Required empty public constructor
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Mushroom mushroom = (Mushroom) getArguments().getSerializable("mushroom");

        View v = inflater.inflate(R.layout.fragment_view_specimen, container, false);
        diaryButton = v.findViewById(R.id.diaryButton);
        diaryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v2)
            {
                NavController nav = new NavController(getContext());
                nav.navigate(R.id.action_viewSpecimen_to_diary4);
            }
        });
        TextView mushroomName = v.findViewById(R.id.MushroomName);
        mushroomName.setText(mushroom.getName());
        CardView cardView1 = v.findViewById(R.id.temperature);
        CardView cardView2 = v.findViewById(R.id.humidity);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                ((AppCompatActivity) v3.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentbox,new TemperatureFragment()).commit();
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                ((AppCompatActivity) v4.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentbox,new HumidityFragment()).commit();
            }
        });
        return v;
    }
}