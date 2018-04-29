package com.example.athis.test.Fregment;

import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.Toast;

import com.dspot.declex.actions.Action;
import com.dspot.declex.annotation.Model;
import com.dspot.declex.annotation.Recollect;
import com.dspot.declex.annotation.RunWith;
import com.example.athis.test.Model.User_;
import com.example.athis.test.R;
import com.dspot.declex.Action.$RegisterFragment;
import com.example.athis.test.Repository.UserRepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.dspot.declex.Action.$MainActivity;
import static com.dspot.declex.actions.Action.$AlertDialog;
import static com.dspot.declex.actions.Action.$Recollect;
import static com.dspot.declex.actions.Action.$Toast;


@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {
    @Bean
    UserRepository userRepository;

    @ViewById
    EditText userName;

    @ViewById
    EditText password;

    @Click
    $RegisterFragment btnCreateAccount;

    @Click
    void login(){
        /* Check credential */
        User_ user = userRepository.checkUserPass(userName.getText().toString(),password.getText().toString());
        if(user != null) {
            /* if credential is ok */
            $MainActivity().intent().extra("user_id",user.getId());
        }else {
            /* if credential is not ok */
            $AlertDialog().title("Error").message("Invalid credential.").positiveButton("Ok");
        }
    }


}
