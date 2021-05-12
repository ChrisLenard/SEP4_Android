package via.sep4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import via.sep4.Model.Data.User;
import via.sep4.Model.PersistenceHandler;
import via.sep4.Model.WebHandler;

public class SignInViewModel extends ViewModel
{
    private PersistenceHandler persistenceHandler;
    private WebHandler webHandler;
    private MutableLiveData<User> user;

    public SignInViewModel() {
        persistenceHandler = new PersistenceHandler();
        webHandler = new WebHandler();
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    public void SignIn()
    {
        webHandler.token(user.getValue());
    }
}
