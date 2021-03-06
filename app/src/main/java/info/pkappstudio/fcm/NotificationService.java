package info.pkappstudio.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static info.pkappstudio.fcm.App.CHANNEL_ID;

public class NotificationService extends FirebaseMessagingService {

    private NotificationManager notificationManager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();

        notificationManager = this.getSystemService(NotificationManager.class);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getData().get("title");
        String messageBody = remoteMessage.getData().get("body");

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(Notification.PRIORITY_HIGH)
                .build();

        notificationManager.notify(1, notification);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Log.e( "FCM TOKEN: ", task.getResult());
                    }
                });
    }
}
