package com.rbmhz.library;

import android.content.Context;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SendingErrorLog {
    public static void SendingErrorLog(Exception e, Context c,boolean showProgressBar,boolean showSuccessToast){
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String exceptionAsString = stringWriter.toString();
        Log.d("Error==>", exceptionAsString);
        LibaryEmail.sendEmail(c, "Error", exceptionAsString,showProgressBar,showSuccessToast);
    }
}
