package com.rbmhz.library;

import android.content.Context;
import android.content.SharedPreferences;

public class LibaryStoreData {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    Context con;

    public static final String PREFS_NAME = "RBMhz_SHARED_PREFS";
    public static final String FROMEMAIL = "FROM_EMAIL";
    public static final String TOEMAIL = "TO_EMAIL";
    public static final String FROMPASSWORD = "FROM_PASSWORD";

    public LibaryStoreData(Context context) {
        this.con = context;
        pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        edit = pref.edit();
    }

    public void saveLibaryRequiredData(String fromEmail, String fromPassword, String toEmail) {
        pref.edit().putString(FROMEMAIL,fromEmail).apply();
        pref.edit().putString(FROMPASSWORD, fromPassword).apply();
        pref.edit().putString(TOEMAIL, toEmail).apply();
        edit.commit();
    }

    public String getEmailAndPassword(String getEmailPassword) {
        SharedPreferences sharedPreferences = con.getSharedPreferences(PREFS_NAME, Context.MODE_MULTI_PROCESS);
       String data = "";
        if(getEmailPassword.equals(FROMEMAIL)){
            data = sharedPreferences.getString(FROMEMAIL, "");
        }else if(getEmailPassword.equals(FROMPASSWORD)){
            data = sharedPreferences.getString(FROMPASSWORD, "");
        }else if(getEmailPassword.equals(TOEMAIL)){
            data = sharedPreferences.getString(TOEMAIL, "");
        }
        return data;
    }
}
