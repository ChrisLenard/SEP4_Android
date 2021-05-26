package via.sep4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anychart.core.stock.indicators.AO;

import java.util.Objects;

import via.sep4.Model.Data.AppData;
import via.sep4.Model.Data.User;
import via.sep4.Model.PersistenceHandler;
import via.sep4.Model.WebHandler;

public class SignInViewModel extends ViewModel
{
    private PersistenceHandler persistenceHandler;
    private WebHandler webHandler;
    private MutableLiveData<User> user;
    private MutableLiveData<Boolean> success;

    public SignInViewModel() {
        persistenceHandler = new PersistenceHandler();
        webHandler = new WebHandler();
        User userInLiveData = new User();
        user = new MutableLiveData<>();
        user.setValue(userInLiveData);
        success = new MutableLiveData<>();
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public MutableLiveData<Boolean> getSuccess() {return success;}

    //TODO: ensure that login only happens if connection successful
    public void SignIn()
    {
        boolean b = webHandler.token(user.getValue());
        AppData appData = AppData.getInstance();
        if (!b) {
            String[] arr = appData.retrieveSavedUser();
            if(arr[0].equals("") || arr[1].equals(""))
            {
                success.setValue(false);
            }
        }
        else {
            appData.saveUser(user.getValue());
            success.setValue(true);
        }
    }
}
