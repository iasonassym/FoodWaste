package com.example.dropdownmenus

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.timepicker.MaterialTimePicker
import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import com.example.dropdownmenus.R
import android.content.Intent
import com.example.dropdownmenus.AlarmReceiver
import android.widget.Toast
import com.google.android.material.timepicker.TimeFormat
import android.os.Build
import android.app.NotificationManager
import android.app.NotificationChannel
import android.content.Context
import android.content.SharedPreferences
import com.example.dropdownmenus.databinding.ActivitySettingsBinding
import java.util.*

internal class SettingsPage : AppCompatActivity() {
    private var binding: ActivitySettingsBinding? = null
    private var picker: MaterialTimePicker? = null
    private var calendar: Calendar? = null
    private var alarmManager: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null
    var sp: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("NotificationTime", Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        binding = ActivitySettingsBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)
        createNotificationChannel()
        binding!!.selectTimeBtn.setOnClickListener { showTimePicker() }
        binding!!.setAlarmBtn.setOnClickListener { setAlarm() }
        binding!!.cancelAlarmBtn.setOnClickListener { cancelAlarm() }
        var time: String
        time = sp?.getString("time", "").toString()
        binding!!.selectedTime.text = time
    }

    private fun cancelAlarm() {
        val intent = Intent(this, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        if (alarmManager == null) {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        }
        alarmManager!!.cancel(pendingIntent)
        Toast.makeText(this, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
    }

    private fun setAlarm() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager!!.setInexactRepeating(
            AlarmManager.RTC_WAKEUP, calendar!!.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
        val editor = sp?.edit()
        editor?.putString("time", binding!!.selectedTime.text.toString())
        editor?.commit()
        Toast.makeText(this, "Alarm set Successfully", Toast.LENGTH_SHORT).show()
    }

    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()
        picker!!.show(supportFragmentManager, "foxandroid")
        picker!!.addOnPositiveButtonClickListener {
            if (picker!!.hour > 12) {
                binding!!.selectedTime.text =
                    String.format("%02d", picker!!.hour - 12) + " : " + String.format(
                        "%02d",
                        picker!!.minute
                    ) + " PM"
            } else {
                binding!!.selectedTime.text =
                    picker!!.hour.toString() + " : " + picker!!.minute + " AM"
            }
            calendar = Calendar.getInstance()
            calendar?.set(Calendar.HOUR_OF_DAY, picker!!.hour)
            calendar?.set(Calendar.MINUTE, picker!!.minute)
            calendar?.set(Calendar.SECOND, 0)
            calendar?.set(Calendar.MILLISECOND, 0)


        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "foxAndroidReminderChannel"
            val description = "Channel for Notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("foxandroid", name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}