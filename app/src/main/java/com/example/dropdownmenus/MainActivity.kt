package com.example.dropdownmenus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var viewWastedFoodButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<View>(R.id.btn_add_waste) as Button
        button!!.setOnClickListener { openActivity2() }

        viewWastedFoodButton = findViewById<View>(R.id.btn_view_waste) as Button
        viewWastedFoodButton!!.setOnClickListener { openActivity3() }

//        val alarmManager = getSystemService (Context.ALARM_SERVICE) as AlarmManager
//        val pendingIntent: PendingIntent
//        val intent = Intent(this, MainActivity::class.java)
//        pendingIntent = PendingIntent.getService (this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        val calendar: Calendar = Calendar.getInstance()
//        // set the triggered time to currentHour:08:00 for testing
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MINUTE, 11);
//
//        alarmManager.setInexactRepeating(
//            AlarmManager.RTC_WAKEUP,
//            calendar.getTimeInMillis(), 0, pendingIntent
//        );
    }

    fun openActivity2() {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }

    fun openActivity3() {
        val intent = Intent(this, WastedFoodPage::class.java)
        startActivity(intent)
    }

    protected fun onHandleIntent(intent: Intent?) {
//        showNotification()
    }

//    private fun showNotification() {
//        val soundUri: Uri = RingtoneManager
//            .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//        val notification: Notification = NotificationCompat.Builder(this)
//            .setContentTitle("Alarm title")
//            .setContentText("Alarm text")
//            .setContentIntent(
//                PendingIntent.getActivity(
//                    this, 0, Intent(
//                        this,
//                        MainActivity::class.java
//                    ),
//                    PendingIntent.FLAG_UPDATE_CURRENT
//                )
//            )
//            .setSound(soundUri).setSmallIcon(R.drawable.ic_launcher)
//            .build()
//        NotificationManagerCompat.from(this).notify(0, notification)
//    }


}