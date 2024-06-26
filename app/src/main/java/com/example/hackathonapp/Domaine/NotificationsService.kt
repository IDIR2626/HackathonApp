package com.example.hackathonapp.Domaine

import android.app.Activity
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.hackathonapp.MainActivity
import com.example.hackathonapp.R


class NotificationsService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(
        notificationText: String,
        channelId: String,
        id: Int,
        notificationTitle: String,

    ) {
        val activityIntent = Intent(context,MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            2,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(notificationTitle)
            .setContentText(notificationText)
            .setSmallIcon(R.drawable.notif)
            .setContentIntent(activityPendingIntent)
            .build()

        notificationManager.notify(id, notification)
    }

    companion object {

        const val NOTIFICATIONS_CHANNEL_ID = "notifications_channel_id"
    }
}