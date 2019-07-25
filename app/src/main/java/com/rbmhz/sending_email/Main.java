package com.rbmhz.sending_email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.rbmhz.library.LibaryStoreData;

import static com.rbmhz.library.SendingErrorLog.SendingErrorLog;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LibaryStoreData libaryStoreData = new LibaryStoreData(this);
        libaryStoreData.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail");
        Button btn = findViewById(R.id.btn_send);
        btn.setOnClickListener(v -> {
                    try {
                        throw new RuntimeException("RuntimeException Error");
                    } catch (Exception e) {
                        SendingErrorLog(e, this, true,false);
                    }
                }
        );
    }
}
