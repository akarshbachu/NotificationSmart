package mgit.notificationsmart;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button notification_btn,bigTxtNotify,bigImageNotify,inboxNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification_btn=(Button)findViewById(R.id.notify);
        bigTxtNotify=(Button)findViewById(R.id.BigTextNotify);
        bigImageNotify=(Button)findViewById(R.id.BigImageNotify);
        inboxNotify=(Button)findViewById(R.id.InboxStyleNotify);
        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //step 1:
                //creating the contents of notification
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle("Normal notification");
                builder.setContentText("It is Normal there are three styles 1.regular 2.BigText 3.BigImage");//it will be displayed just below Title
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
                manager.notify(1234,notification);//takes 2 objs 1.id 2.notification obj
            }
        });
        bigTxtNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Assigning style in our case it is BigText
                NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
                style.setBigContentTitle("This is BigText Style");
                style.bigText("It is big there are three styles 1.regular 2.BigText 3.BigImage" );



                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                builder.setContentTitle("Big Text notification");
                builder.setContentText("Its my second notification");//it will be displayed just below Title
                builder.setSmallIcon(R.drawable.icon);//icon will be shown left side in notification
                builder.setTicker("its ticker");//this will appear at the top of the screen
                builder.setAutoCancel(true);

                builder.setStyle(style);

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
                //passing notification through notificantion manager
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                manager.notify(12345,notification);//takes 2 objs 1.id 2.notification obj
            }
        });

        bigImageNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assigning style as Big Image notification
                Bitmap bmp= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bigpic);
                NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle();
                style.setBigContentTitle("This is BigImage Style");
                style.bigPicture(bmp);

                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                builder.setContentTitle("Big Image notification");
                builder.setContentText("Its my Third notification");//it will be displayed just below Title
                builder.setSmallIcon(R.drawable.icon);//icon will be shown left side in notification
                builder.setTicker("its ticker");//this will appear at the top of the screen
                builder.setAutoCancel(true);

                builder.setStyle(style);

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

                //passing notification through notificantion manager
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                manager.notify(123456,notification);//takes 2 objs 1.id 2.notification obj
            }
        });

        inboxNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //assigning style
                NotificationCompat.InboxStyle style=new NotificationCompat.InboxStyle();
                style.setBigContentTitle("Inbox style");
                style.addLine("hello");
                style.addLine("how r u");
                style.addLine("wr r u");

                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext());
                builder.setContentTitle("Big Image notification");
                builder.setContentText("Its my Third notification");//it will be displayed just below Title
                builder.setSmallIcon(R.drawable.icon);//icon will be shown left side in notification
                builder.setTicker("its ticker");//this will appear at the top of the screen
                builder.setAutoCancel(true);

                builder.setStyle(style);

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

                //passing notification through notificantion manager
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                manager.notify(123457,notification);//takes 2 objs 1.id 2.notification obj
            }
        });
    }
}

            /*
            Step1: select atyle and assign it.
            there are 4 styles
            1.regular 2.bigtext 3.bigimage 4.inboxstyle

            Step2:Set the content of notification

            Step 3:Set intents and actions of button

            Step 4:Pass notification through Notification manager
             */
