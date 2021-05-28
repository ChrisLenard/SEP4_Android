package via.sep4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {
private ArrayList<DiaryEntry> mEntries;
final private OnListItemClickListener mOnListItemClickListener;

DiaryAdapter(ArrayList<DiaryEntry> entries, OnListItemClickListener listItemClickListener)
{
	mEntries = entries;
	mOnListItemClickListener = listItemClickListener;
}
@NonNull
@Override

public DiaryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	LayoutInflater inflater = LayoutInflater.from(parent.getContext());
	View view = inflater.inflate(R.layout.diary_entry_list_item, parent, false);
	return new ViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull DiaryAdapter.ViewHolder holder, int position) {
	holder.word.setText(mEntries.get(position).getEntry());
	holder.diaryDate.setText(mEntries.get(position).getDateAdded().toString());
}

@Override
public int getItemCount() {
	return mEntries.size();
}

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
	
	TextView word;
	TextView diaryDate;
	public ViewHolder(@NonNull View itemView) {
		super(itemView);
		word = itemView.findViewById(R.id.word);
		diaryDate = itemView.findViewById(R.id.diaryDate);
		itemView.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		mOnListItemClickListener.onListItemClick(getAdapterPosition());
	}
}

public interface OnListItemClickListener {
	void onListItemClick(int clickedItemIndex);
}
}
