package dev.enigmatic.enigma;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Rushabh on 19-03-2016.
 */
public class SMSActivity extends AppCompatActivity {

    SmsManager sm;
    Notification n;
    EditText e1,e2;
    ImageView b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b=(ImageView)findViewById(R.id.imageView);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String num = e1.getText().toString();
                final String mess = e2.getText().toString();

                AlertDialog.Builder ab=new AlertDialog.Builder(SMSActivity.this);
                ab.setMessage("Do you really want to send this SMS?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendSMSMessage();
                        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

                        /* For Notification */
                        final NotificationManager ng = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                        Notification.Builder builder = new Notification.Builder(SMSActivity.this);
                        builder.setAutoCancel(true);
                        builder.setTicker("Message has been sent to " + num);
                        builder.setContentTitle("Message sent to " + num);

                        builder.setSmallIcon(R.mipmap.ic_launcher);
                        builder.setOngoing(false);
                        builder.setSubText(mess);
                        builder.setNumber(1);
                        builder.build();

                        n = builder.getNotification();
                        ng.notify(11, n);
                        ///////////////////

                        finish();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert=ab.create();
                alert.setTitle("Alert!!!");
                alert.show();
            }
        });
    }
    protected void sendSMSMessage() {

        String phoneNo = e1.getText().toString();
        String message = e2.getText().toString();

        sm = SmsManager.getDefault();
        sm.sendTextMessage(phoneNo, null, message, null, null);


    }
}
