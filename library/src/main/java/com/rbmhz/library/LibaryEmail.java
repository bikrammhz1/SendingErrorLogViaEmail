package com.rbmhz.library;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LibaryEmail {
    private static String toEmail;
    private static Session session = null;
    private static ProgressDialog progress;
    private static String senderEmail = "";
    private static String senderPassword = "";
    private static LibaryStoreData libaryStoreData;
    private static Model model;

    public static void sendEmail(Context c, String subject, String message, boolean showProgressBar,boolean showSuccessToast) {
        //Getting content for toEmail
        progress = new ProgressDialog(c);
        libaryStoreData = new LibaryStoreData(c);
        model = new Model(subject,message,c,showProgressBar,showSuccessToast);

        if (libaryStoreData.getEmailAndPassword(LibaryStoreData.TOEMAIL).equals("") ||
                libaryStoreData.getEmailAndPassword(LibaryStoreData.FROMPASSWORD).equals("") ||
                libaryStoreData.getEmailAndPassword(LibaryStoreData.FROMEMAIL).equals("")) {
            Toast.makeText(c, "Please Set LibaryEmail and Password", Toast.LENGTH_SHORT).show();
        } else {
            toEmail = libaryStoreData.getEmailAndPassword(LibaryStoreData.TOEMAIL);
            senderEmail = libaryStoreData.getEmailAndPassword(LibaryStoreData.FROMEMAIL);
            senderPassword = libaryStoreData.getEmailAndPassword(LibaryStoreData.FROMPASSWORD);

            progress.setMessage("Sending.....");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            if(showProgressBar){
                progress.show();
            }

            /*https://myaccount.google.com/lesssecureapps*/
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        //Authenticating the password
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(senderEmail, senderPassword);
                        }
                    });

            RetriveFeedTask retriveFeedTask = new RetriveFeedTask();
            retriveFeedTask.execute(model);
        }
    }

    static class RetriveFeedTask extends AsyncTask<Model, Void, Void> {
        Context c;
        boolean showProgress = true;
        boolean showToast = true;

        @Override
        protected Void doInBackground(Model... strings) {
            try {
                showProgress = strings[0].getProgressBar();
                showToast = strings[0].isShowToast();
                c = strings[0].getContext();
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                message.setSubject(strings[0].getTitle());
                message.setText(strings[0].getBody());
                Transport.send(message);
            } catch (Exception e) {
                if(showProgress){
                    progress.dismiss();
                }
                Log.d("Ex==>", e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void a) {
            if(showProgress){
                progress.dismiss();
            }
            if(showToast){
                Toast.makeText(c, "Email Sent", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
