package com.example.bossthedevil.medicinereminder;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by BB-Sobuj on 7/3/2018.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref1";
    private static final String KEY_ADMIN = "admin";
    private static final String KEY_MAIL= "mail";
    private static final String KEY_MOBILE = "mobile ";


    private static final int KEY_MODE =1;
  //  private static final String SHARED_PREF_NAME = "mysharedpref1";


    private SharedPrefManager(Context context){
        mCtx=context;

    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if(mInstance == null){
            mInstance =new SharedPrefManager(context);
        }
        return mInstance;
    }

/*
public boolean userLogin(String fullname, String username , String email){

SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();

//editor.putString(KEY_FULL_NAME,fullname);
editor.putString(KEY_USER_NAME,username);
//editor.putString(KEY_EMAIL,email);

//editor.putString(FULL_NAME,fullname);
    editor.apply();
return true;
}
*/


public boolean isLoggedIn(){
    SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

    if(sharedPreferences.getString(KEY_MAIL,null) != null){
        return true;
    }
    return false;
}



    public boolean NewUser(String username,String pass){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

//editor.putString(KEY_FULL_NAME,fullname);
        editor.putString(KEY_MAIL,username);
        editor.putString(KEY_MOBILE,pass);
        editor.apply();
        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_MAIL,null);
    }
    public String getUserpass(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_MOBILE,null);
    }


    public boolean storeuserName(String mail){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_MAIL,mail);
        editor.apply();
        return true;
    }
    public boolean storeuserPass(String mobile){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_MOBILE,mobile);
        editor.apply();
        return true;
    }

   /* public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_USER_NAME).commit();

        editor.remove(KEY_USERPASS).commit();

        editor.commit();

        return true;
    }
*/



}
