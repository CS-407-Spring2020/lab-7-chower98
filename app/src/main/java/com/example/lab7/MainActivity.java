package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.lab7.App.CHANNEL_1_ID;
import static com.example.lab7.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.textTitle);
        editTextMessage = findViewById(R.id.textMessage);
    }

    public void sendOnChannel1(View view) {
        String textTitle = editTextTitle.getText().toString();
        String textContent = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_hot_tub_black_24dp).setContentTitle(textTitle)
                .setContentText(textContent).setPriority(NotificationCompat.PRIORITY_HIGH).build();

        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View view) {
        String textTitle = editTextTitle.getText().toString();
        String textContent = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_hot_tub_black_24dp).setContentTitle(textTitle)
                .setContentText(textContent).setPriority(NotificationCompat.PRIORITY_LOW).build();

        notificationManager.notify(2, notification);
    }
}
