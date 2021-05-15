package com.example.vroomcarshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QandA extends AppCompatActivity {

    int idcount=0;
    int finalscore = 0;
    ConnectionClass connectionClass;
    TextView question;
    TextView qno;
    TextView score;
    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    int atmpt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qanda);
        connectionClass = new ConnectionClass();
        question = (TextView) findViewById(R.id.quest);
        qno = (TextView) findViewById(R.id.qno);
        score = (TextView) findViewById(R.id.score);
        opt1 = (Button) findViewById(R.id.ans1);
        opt2 = (Button) findViewById(R.id.ans2);
        opt3 = (Button) findViewById(R.id.ans3);
        opt4 = (Button) findViewById(R.id.ans4);

        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
            } else {
                String qfetch ="select *from questions";
                ResultSet rsmtch=null;
                Statement stmtmtch = con.createStatement();
                rsmtch = stmtmtch.executeQuery(qfetch);
                int qid = 0;
                while(rsmtch.next()) {
                    //int qid = rsmtch.getInt("qid");
                    String questText = rsmtch.getString("qtext");
                    DB_Support.questions[qid] = questText;
                    qid++;
                }

                String ansfetch="select *from answers";
                ResultSet ansres=null;
                Statement ansmatch = con.createStatement();
                ansres = ansmatch.executeQuery(ansfetch);
                qid = 0;
                while(ansres.next()) {
                    //int qid = ansres.getInt("qid");
                    ArrayList<String> answers = new ArrayList<String>();
                    String opt1 = ansres.getString("opt1"); answers.add(opt1);
                    String opt2 = ansres.getString("opt2"); answers.add(opt2);
                    String opt3 = ansres.getString("opt3"); answers.add(opt3);
                    String opt4 = ansres.getString("opt4"); answers.add(opt4);
                    String ans = ansres.getString("ans"); answers.add(ans);
                    DB_Support.answers.put(qid,answers);
                    qid++;
                }
            }
        }
        catch (Exception ex)
        {
        }
        question.setText(DB_Support.questions[0]);
        opt1.setText(DB_Support.answers.get(0).get(0));
        opt2.setText(DB_Support.answers.get(0).get(1));
        opt3.setText(DB_Support.answers.get(0).get(2));
        opt4.setText(DB_Support.answers.get(0).get(3));

    }

    public void addnotify()
    {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setContentTitle("Online Exam System") //set title of notification
                        .setContentText("Exam Started. Good Luck!")//this is notification message
                        .setAutoCancel(true) // makes auto cancel of notification
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


        Intent notificationIntent = new Intent(this, Notification.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public void opt1btn(View v)
    {
        atmpt=1;
        if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 1)
        {
            finalscore = finalscore+1;
            score.setText("Score-"+finalscore+"/10");
            opt1.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
            opt1.setTextColor(getResources().getColor(R.color.white));
        }
        else
        {
            opt1.setBackground(getResources().getDrawable(R.drawable.redroundcorner));
            opt1.setTextColor(getResources().getColor(R.color.white));
            if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 2)
            {
                opt2.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt2.setTextColor(getResources().getColor(R.color.white));
            }
            else if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 3)
            {
                opt3.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt3.setTextColor(getResources().getColor(R.color.white));
            }
            else
            {
                opt4.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt4.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    public void opt2btn(View v)
    {
        atmpt=1;
        if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 2)
        {
            finalscore = finalscore+1;
            score.setText("Score-"+finalscore+"/10");
            opt2.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
            opt2.setTextColor(getResources().getColor(R.color.white));
        }
        else
        {
            opt2.setBackground(getResources().getDrawable(R.drawable.redroundcorner));
            opt2.setTextColor(getResources().getColor(R.color.white));
            if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 1)
            {
                opt1.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt1.setTextColor(getResources().getColor(R.color.white));
            }
            else if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 3)
            {
                opt3.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt3.setTextColor(getResources().getColor(R.color.white));
            }
            else
            {
                opt4.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt4.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    public void opt3btn(View v)
    {
        atmpt=1;
        if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 3)
        {
            finalscore = finalscore+1;
            score.setText("Score-"+finalscore+"/10");
            opt3.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
            opt3.setTextColor(getResources().getColor(R.color.white));
        }
        else
        {
            opt3.setBackground(getResources().getDrawable(R.drawable.redroundcorner));
            opt3.setTextColor(getResources().getColor(R.color.white));
            if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 2)
            {
                opt2.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt2.setTextColor(getResources().getColor(R.color.white));
            }
            else if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 1)
            {
                opt1.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt1.setTextColor(getResources().getColor(R.color.white));
            }
            else
            {
                opt4.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt4.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    public void opt4btn(View v)
    {
        atmpt=1;
        if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 4)
        {
            finalscore = finalscore+1;
            score.setText("Score-"+finalscore+"/10");
            opt4.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
            opt4.setTextColor(getResources().getColor(R.color.white));
        }
        else
        {
            opt4.setBackground(getResources().getDrawable(R.drawable.redroundcorner));
            opt4.setTextColor(getResources().getColor(R.color.white));
            if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 2)
            {
                opt2.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt2.setTextColor(getResources().getColor(R.color.white));
            }
            else if(Integer.parseInt(DB_Support.answers.get(idcount).get(4)) == 3)
            {
                opt3.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt3.setTextColor(getResources().getColor(R.color.white));
            }
            else
            {
                opt1.setBackground(getResources().getDrawable(R.drawable.greenroundcorner));
                opt1.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    public void nexxtbtn (View v)
    {
        if (atmpt>0)
        {
            opt1.setBackground(getResources().getDrawable(R.drawable.customroundcorner2));
            opt1.setTextColor(getResources().getColor(R.color.black));
            opt2.setBackground(getResources().getDrawable(R.drawable.customroundcorner2));
            opt2.setTextColor(getResources().getColor(R.color.black));
            opt3.setBackground(getResources().getDrawable(R.drawable.customroundcorner2));
            opt3.setTextColor(getResources().getColor(R.color.black));
            opt4.setBackground(getResources().getDrawable(R.drawable.customroundcorner2));
            opt4.setTextColor(getResources().getColor(R.color.black));

            idcount++;
            if(idcount<10) {
                qno.setText("Question " + (idcount + 1));
                question.setText(DB_Support.questions[idcount]);
                opt1.setText(DB_Support.answers.get(idcount).get(0));
                opt2.setText(DB_Support.answers.get(idcount).get(1));
                opt3.setText(DB_Support.answers.get(idcount).get(2));
                opt4.setText(DB_Support.answers.get(idcount).get(3));
            }
            else
            {
                Intent intent=new Intent(QandA.this, Report.class);
                startActivity(intent);
            }
            atmpt=0;
        }
        else
        {
            Toast toast = Toast.makeText(this, "Please Select an Option!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}