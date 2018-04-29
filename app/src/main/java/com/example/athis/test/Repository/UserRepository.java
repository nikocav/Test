package com.example.athis.test.Repository;

import com.activeandroid.query.Select;
import com.example.athis.test.Model.User;
import com.example.athis.test.Model.User_;

import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class UserRepository {

    public User_ checkUserPass(String userName,String password) {
        return new Select()
                .from(User_.class)
                .where("userName = ?", userName)
                .and("password = ?",password)
                .executeSingle();

    }
}
