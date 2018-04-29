package com.example.athis.test.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.dspot.declex.annotation.LocalDBModel;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

@LocalDBModel
public class Post extends Model{

    @Column
    User_ user;

    @Column
    @NotEmpty
    String title;

    @Column
    @NotEmpty
    String body;
}
