package com.example.athis.test.Fregment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dspot.declex.annotation.Model;
import com.dspot.declex.annotation.Populate;
import com.dspot.declex.annotation.UpdateOnEvent;
import com.example.athis.test.Model.Post;
import com.example.athis.test.Model.Post_;
import com.example.athis.test.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemSelect;


import java.util.List;

import static com.dspot.declex.Action.$AddPostFragment;
import static com.dspot.declex.actions.Action.$AlertDialog;
import static com.dspot.declex.actions.Action.$LoadModel;
import static com.dspot.declex.actions.Action.$Populate;
import static com.dspot.declex.actions.Action.$PutModel;
import static com.dspot.declex.actions.Action.$Toast;


/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_list_post)
public class ListPostFragment extends Fragment {

    @FragmentArg
    Long user_id;

    @Model(query = "user = {getUserId()}")
    @Populate
    List<Post_> posts;

    @AfterViews
    void initRecyclerView(RecyclerView posts) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        posts.setLayoutManager(layoutManager);
    }

    Long getUserId(){
        return user_id;
    }

    @Click
    void btnDel(Post_ model){
        $AlertDialog().title("Confimation").message("Do you want delete this item?").positiveButton("Yes").negativeButton("No");

        if($AlertDialog.PositiveButtonPressed) {
            posts.remove(model);
            $Populate(posts);
            model.delete();
        }
    }

    @Click
    void btnEdit(Post_ model){
        $AddPostFragment().user_id(user_id);
    }


}
