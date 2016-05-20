package mgit.notificationsmart;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button notification_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification_btn=(Button)findViewById(R.id.notify);
        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step 1:
                //creating the contents of notification
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle("Normal notification");
                builder.setContentText("Its my first notification");//it will be displayed just below Title
                builder.setSmallIcon(R.drawable.icon);//icon will be shown left side in notification
                builder.setTicker("its ticker");//this will appear at the top of the screen
                builder.setAutoCancel(true);

                //Step:3
                //Providing the intents
                Intent i=new Intent(MainActivity.this,Notify_screen.class);
                //Adding the backstack as it is regular activity, this is done using task builder and set the intent to pending intent
                TaskStackBuilder stackBuilder=TaskStackBuilder.create(getApplicationContext());
                stackBuilder.addParentStack(Notify_screen.class);
                stackBuilder.addNextIntent(i);
                PendingIntent pi_main=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                //builder.setContentIntent(pi_main);

                //Step:4
                //adding intents, and backstack for buttons
                Intent j=new Intent(MainActivity.this,Notify_action.class);
                TaskStackBuilder stackBuilder_action=TaskStackBuilder.create(getApplicationContext());
                stackBuilder_action.addParentStack(Notify_action.class);
                stackBuilder_action.addNextIntent(j);
                PendingIntent pi_action=stackBuilder_action.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

                builder.setContentIntent(pi_main);
                builder.addAction(R.drawable.loc,"Location",pi_action);
                //this below code should be added in Manifest.xml file.
                /*
        <activity android:name=".Notify_screen"
            android:parentActivityName=".MainActivity"
            >
            <meta-data android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity" />
        </activity>*/
                //when back button is pressed we get the mainactivity

                //Step:2
                //passing notification through notificantion manager
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1234,notification);
            }
        });
    }
}
