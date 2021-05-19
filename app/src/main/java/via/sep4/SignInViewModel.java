package via.sep4;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Objects;

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
        User userInLiveData = new User();
        user.setValue(userInLiveData);
    }

    public MutableLiveData<User> getUser() {
        return user;
    }

    //TODO: ensure that login only happens if connection successful
    public boolean SignIn()
    {
        return webHandler.token(user.getValue());
    }
}
