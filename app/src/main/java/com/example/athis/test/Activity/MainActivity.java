package com.example.athis.test.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dspot.declex.Action;
import com.dspot.declex.annotation.Model;
import com.dspot.declex.annotation.Recollect;
import com.dspot.declex.annotation.RunWith;
import com.example.athis.test.Model.Post;
import com.example.athis.test.Model.User_;
import com.example.athis.test.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import static com.dspot.declex.Action.$AddPostFragment;
import static com.dspot.declex.Action.$ListPostFragment;
import static com.dspot.declex.actions.Action.$Recollect;
import static com.dspot.declex.actions.Action.$Toast;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Extra
    Long user_id;


    @RunWith
    void onCreate() {
        $ListPostFragment().user_id(user_id);

    }

    @Click
    void fab(){
        $AddPostFragment().user_id(user_id);
    }

}
