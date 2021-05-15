package com.example.rajuscoreboard;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import pl.droidsonroids.gif.GifImageView;

public class ScoreBoard extends AppCompatActivity {

    GifImageView rungif;
    ConnectionClass connectionClass;
    TextView scr;
    TextView plrname;
    TextView plrscr;
    int score=0;
    int plrscore=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        rungif = (GifImageView) findViewById(R.id.rungif);
        scr =(TextView)findViewById(R.id.scr);
        plrname =(TextView)findViewById(R.id.plrtxt);
        plrscr =(TextView)findViewById(R.id.plrscr);

        plrname.setText(DB_Support.getPlrName());
        plrscr.setText("0");

        connectionClass = new ConnectionClass();
        score = DB_Support.getScore();
        scr.setText(Integer.toString(score));
    }

    public void hitme(View v)
    {
        int run = ((int) (Math.random()*(5 - 0))) + 0;
        if(run==0) {
            rungif.setImageResource(R.drawable.scr0);
            score= score+0;
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                } else {
                    String scrupd = "UPDATE matches SET Score=? WHERE Name=?";
                    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(scrupd);
                    pstmt.setInt(1, score);
                    pstmt.setString(2, DB_Support.getMtchName());
                    pstmt.executeUpdate();

                    DB_Support.delplayers(DB_Support.getPlrName());
                    DB_Support.setScore(score);
                    Thread.sleep(3000);

                    AlertDialog.Builder builder = new AlertDialog.Builder(ScoreBoard.this);
                    builder.setTitle("Player "+DB_Support.getPlrName()+" is out!");
                    builder.setMessage("Pick the next batsman");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(ScoreBoard.this,PlayerList.class));
                        }
                    });
                    builder.show();

                }
            }
            catch (Exception ex)
            {
            }
        }
        else
        {
            if(run==1) {
                rungif.setImageResource(R.drawable.scr1);
                score= score+1;
                plrscore = plrscore + 1;
            }
            else if(run==2) {
                rungif.setImageResource(R.drawable.scr2);
                score= score+2;
                plrscore = plrscore + 2;
            }
            else if(run==3) {
                rungif.setImageResource(R.drawable.scr3);
                score= score+3;
                plrscore = plrscore + 3;
            }
            else if(run==4) {
                rungif.setImageResource(R.drawable.scr4);
                score= score+4;
                plrscore = plrscore + 4;
            }
            else {
                rungif.setImageResource(R.drawable.scr5);
                score= score+6;
                plrscore = plrscore + 6;
            }
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                } else {
                    String scrupd = "update matches set Score=? where Name=?";
                    PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(scrupd);
                    pstmt.setInt(1, score);
                    pstmt.setString(2, DB_Support.getMtchName());
                    int i = pstmt.executeUpdate();
                    DB_Support.setScore(score);
                }
            }
            catch (Exception ex)
            {
            }
        }

        scr.setText(Integer.toString(score));
        plrscr.setText(Integer.toString(plrscore));
    }
}