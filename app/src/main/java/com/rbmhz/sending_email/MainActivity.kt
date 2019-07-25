package com.rbmhz.sending_email

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rbmhz.library.LibaryStoreData
import com.rbmhz.library.SendingErrorLog.SendingErrorLog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var libaryStoreData =  LibaryStoreData(this)
        libaryStoreData?.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail")
        btn_send.setOnClickListener {
            try {
                throw RuntimeException("RuntimeException Error")
            } catch (e: Exception) {
                SendingErrorLog(e,this,false,false)
            }
        }
    }
}
