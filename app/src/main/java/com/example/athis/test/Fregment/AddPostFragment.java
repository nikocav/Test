package com.example.athis.test.Fregment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dspot.declex.actions.Action;
import com.dspot.declex.annotation.Model;
import com.dspot.declex.annotation.Populate;
import com.dspot.declex.annotation.Recollect;
import com.dspot.declex.annotation.RunWith;
import com.dspot.declex.annotation.UseModel;
import com.example.athis.test.Model.Post;
import com.example.athis.test.Model.Post_;
import com.example.athis.test.Model.User_;
import com.example.athis.test.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import static com.dspot.declex.Action.$ListPostFragment;
import static com.dspot.declex.actions.Action.$AlertDialog;
import static com.dspot.declex.actions.Action.$PutModel;
import static com.dspot.declex.actions.Action.$Recollect;
import static com.dspot.declex.actions.Action.$Toast;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_add_post)
public class AddPostFragment extends Fragment {

    @FragmentArg
    Long user_id;

    @UseModel
    @Recollect(validate = true)
    Post_ post;

    @Click
    void btnSave(){
        post = new Post_();
        $Recollect(post);
        User_ user = User_.load(User_.class,user_id);
        post.setUser(user);
        post.save();
        $ListPostFragment().user_id(user_id);
    }

    @Click
    void btnCancel(){
        $ListPostFragment().user_id(user_id);
    }


}
