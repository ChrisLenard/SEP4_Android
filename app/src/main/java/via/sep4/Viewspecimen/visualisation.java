package via.sep4.Viewspecimen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;

import java.util.ArrayList;
import java.util.List;

import via.sep4.R;

public class visualisation extends Fragment
{
	View v;
	TextView name;
	TextView range;
	TextView type;
	
	public visualisation()
	{
		// Required empty public constructor
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		v = inflater.inflate(R.layout.fragment_visualisation, container, false);
		name = v.findViewById(R.id.name);
		range = v.findViewById(R.id.range);
		type = v.findViewById(R.id.type);
		name.setText(getArguments().getString("Name"));
		range.setText(getArguments().getString("Range"));
		type.setText(getArguments().getString("Type"));
		setupCharts();
		
		return v;
	}
	
	private void setupCharts(){
		
		AnyChartView anyChartView1;
		 anyChartView1 = v.findViewById(R.id.anychart_temp_graph);
		
		
		Cartesian cartesian = AnyChart.line();
		
		cartesian.animation(true);
		
		cartesian.padding(10d, 20d, 5d, 20d);
		
		cartesian.crosshair().enabled(true);
		cartesian.crosshair()
				.yLabel(true)
				// TODO ystroke
				.yStroke((Stroke) null, null, null, (String) null, (String) null);
		
		cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
		
		cartesian.title("Temperature Monitor");
		
		cartesian.yAxis(0).title("Number Of Degrees C");
		cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);
		
		List<DataEntry> seriesData = new ArrayList<>();
		seriesData.add(new CustomDataEntry("14May-21:10", 100));
		seriesData.add(new CustomDataEntry("14May-21:20", 80));
		seriesData.add(new CustomDataEntry("14May-21:30", 70));
		seriesData.add(new CustomDataEntry("14May-21:40", 60));
		seriesData.add(new CustomDataEntry("14May-21:50", 50));
		seriesData.add(new CustomDataEntry("14May-22:00", 40));
		seriesData.add(new CustomDataEntry("14May-22:10", 30));
		seriesData.add(new CustomDataEntry("14May-22:20", 30));
		seriesData.add(new CustomDataEntry("14May-22:30", 20));
		seriesData.add(new CustomDataEntry("14May-22:40", 10));
		seriesData.add(new CustomDataEntry("14May-22:50", 9));
		
		Set set = Set.instantiate();
		set.data(seriesData);
		Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
		
		Line series1 = cartesian.line(series1Mapping);
		series1.name("Mushroom");
		series1.hovered().markers().enabled(true);
		series1.hovered().markers()
				.type(MarkerType.CIRCLE)
				.size(4d);
		series1.tooltip()
				.position("right")
				.anchor(Anchor.LEFT_CENTER)
				.offsetX(5d)
				.offsetY(5d);
		cartesian.legend().enabled(true);
		cartesian.legend().fontSize(13d);
		cartesian.legend().padding(0d, 0d, 10d, 0d);
		
		anyChartView1.setChart(cartesian);
	}
}

class CustomDataEntry extends ValueDataEntry
{
	
	public CustomDataEntry(String x, Number value) {
		super(x, value);
	}
	
}
