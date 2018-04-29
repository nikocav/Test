package com.example.athis.test.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.dspot.declex.annotation.LocalDBModel;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

@LocalDBModel
public class User extends Model{

    @Column
    @NotEmpty
    String name;

    @Column
    @NotEmpty
    String userName;

    @Column
    @NotEmpty
    @Password
    String password;


    public List<Post> posts() {
        return getMany(Post.class, "user");
    }
}
