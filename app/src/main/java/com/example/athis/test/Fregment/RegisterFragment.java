package com.example.athis.test.Fregment;

import android.support.v4.app.Fragment;

import com.dspot.declex.Action;
import com.dspot.declex.annotation.Event;
import com.dspot.declex.annotation.Model;
import com.dspot.declex.annotation.Recollect;
import com.example.athis.test.Model.User_;
import com.example.athis.test.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import static com.dspot.declex.Action.$LoginFragment;
import static com.dspot.declex.actions.Action.$AlertDialog;
import static com.dspot.declex.actions.Action.$PutModel;
import static com.dspot.declex.actions.Action.$Recollect;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_register)
public class RegisterFragment extends Fragment {

    @Model
    @Recollect
    User_ user;

    @Click
    $LoginFragment logIn;

    @Click
    void btnRegister(){
        $Recollect(user);
        $PutModel(user);
        if ($PutModel.Failed) {
            $AlertDialog().title("Error").message("Has occurred a error.");
        }else {
            $AlertDialog().title("Good").message("Account created");
            $LoginFragment();
        }

    }

    @Event
    void  onBackPressedEvent() {
        $LoginFragment();
    }

}
