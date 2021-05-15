package com.codingwithsara.notificationapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final String CHANNEL_ID = "CHANNEL_SAMPLE";

    @Override
    public void onReceive(Context context, Intent intent) {

        // Get id & message
        int notificationId = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("message");

        // Call MainActivity when notification is tapped.
        Intent mainIntent = new Intent(context, MainActivity.class);
        Intent mainIntent2 = new Intent(Intent.ACTION_DIAL);
        mainIntent2.setData(Uri.parse("tel:9876543210"));
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent2, 0);

        // NotificationManager
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For API 26 and above
            CharSequence channelName = "My Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            notificationManager.createNotificationChannel(channel);
        }

        // Prepare Notification
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.grocery);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Grocery Delivery")
                .setContentText("Your grocery has arrived!")
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

                builder.setLargeIcon(bmp)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bmp).bigLargeIcon(null));
               // builder.setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.not_txt)));


        // Notify
        notificationManager.notify(notificationId, builder.build());
    }
}