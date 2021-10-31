package com.example.dropdownmenus;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class AlarmReceiver: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        val intent2 = Intent(context, MainActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0, intent2, 0)


        val builder = NotificationCompat.Builder(context!!, "foxandroid")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Food Waste Notification")
            .setContentText("Add today's food wasted")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManagerCompat = NotificationManagerCompat.from(
            context
        )
        notificationManagerCompat.notify(123, builder.build())
    }
}
