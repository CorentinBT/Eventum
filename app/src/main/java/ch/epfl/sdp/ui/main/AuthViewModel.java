package ch.epfl.sdp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ch.epfl.sdp.auth.User;

public class AuthViewModel extends ViewModel {

    private MutableLiveData<User> mUser = new MutableLiveData<>();

    public void setUser(User user) {
        mUser.setValue(user);
    }

    public LiveData<User> getUser() {
        return mUser;
    }
}