package com.zawmyohtet.lothone.utility;

import android.content.Context;

import com.zawmyohtet.lothone.dao.UserStore;
import com.zawmyohtet.lothone.model.User;

/**
 * @author zawmyohtet
 * @since 8/5/16
*/
public class Credential {

    private static final String TAG = "Credential";

    private static Credential ourInstance;

    private User activeUser;

    public Object clone() throws CloneNotSupportedException{
        super.clone();
        throw new CloneNotSupportedException();
    }

    public static synchronized Credential getInstance(Context context) {

        if (ourInstance == null){
            ourInstance = new Credential(context);
        }
        return ourInstance;
    }

    private Credential(Context context) {
        if (activeUser == null){
            UserStore userStore = new UserStore(context);
            activeUser = userStore.pull();
        }
    }

    public void reset(){
        ourInstance = null;
    }

    public User getActiveUser(){
        return activeUser;
    }
}
