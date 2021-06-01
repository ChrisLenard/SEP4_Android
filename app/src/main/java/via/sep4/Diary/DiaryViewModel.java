package via.sep4.Diary;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DiaryViewModel extends AndroidViewModel
{
	
	private final DiaryEntryRepository repository;
	
	public DiaryViewModel(Application application)
	{
		super(application);
		repository = DiaryEntryRepository.getInstance(application);
	}
	
	public LiveData<List<DiaryEntry>> getAllEntries()
	{
		return repository.getAllEntries();
	}
	
	public void insert(final DiaryEntry entry)
	{
		repository.insert(entry);
	}
	
}
