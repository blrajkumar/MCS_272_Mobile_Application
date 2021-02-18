package com.example.raj2047120;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private String prof;
    private ImageView prof_image;
    private TextView name;
    private TextView reg;
    private TextView email;
    private TextView course;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mConstraintLayout = (ConstraintLayout)findViewById(R.id.layout);
        prof_image = (ImageView) findViewById(R.id.prof_image);
        name = (TextView) findViewById(R.id.prof_name);
        reg = (TextView) findViewById(R.id.prof_reg);
        email = (TextView) findViewById(R.id.prof_email);
        course  = (TextView) findViewById(R.id.course);

        prof = getIntent().getExtras().getString("Value");
        switch (prof)
        {
            case "chan":
                prof_image.setImageResource(R.drawable.chan);
                name.setText("Name : Chanchal");
                reg.setText("Reg.No : 2047130");
                email.setText("chan@cs.chrstuni.in");
                break;
            case "chui":
                prof_image.setImageResource(R.drawable.chui);
                name.setText("Name : Gaichuiliu");
                reg.setText("Reg.No : 2047133");
                email.setText("chui@cs.chrstuni.in");
                break;
            case "hari":
                prof_image.setImageResource(R.drawable.hari);
                name.setText("Name : Hari Prasath");
                reg.setText("Reg.No : 2047114");
                email.setText("hari@cs.chrstuni.in");
                break;
            case "raj":
                prof_image.setImageResource(R.drawable.raj);
                name.setText("Name : Rajkumar");
                reg.setText("Reg.No : 2047120");
                email.setText("raj@cs.chrstuni.in");
                break;
            case "shivam":
                prof_image.setImageResource(R.drawable.shivam);
                name.setText("Name : Shivam");
                reg.setText("Reg.No : 2047122");
                email.setText("shivam@cs.chrstuni.in");
                break;
            case "sonali":
                prof_image.setImageResource(R.drawable.sonali);
                name.setText("Name : Sonali");
                reg.setText("Reg.No : 2047143");
                email.setText("sonali@cs.chrstuni.in");
                break;
            default:
                break;
        }
    }


    public void previous(View v)
    {
        Intent j1 = new Intent(getBaseContext(),MainActivity2.class);
        startActivity(j1);
        finish();
    }

    public void endprg(View v)
    {
        finish();
        System.exit(0);
    }

    public void phone_call(View v)
    {
        Intent k1 = new Intent(Intent.ACTION_DIAL);
        switch (prof)
        {
            case "chan":
                k1.setData(Uri.parse("tel:+9197086885151"));
                startActivity(k1);
                break;
            case "chui":
                k1.setData(Uri.parse("tel:+919597324912"));
                startActivity(k1);
                break;
            case "hari":
                k1.setData(Uri.parse("tel:+919524320021"));
                startActivity(k1);
                break;
            case "raj":
                k1.setData(Uri.parse("tel:+919361048881"));
                startActivity(k1);
                break;
            case "shivam":
                k1.setData(Uri.parse("tel:+918126519330"));
                startActivity(k1);
                break;
            case "sonali":
                k1.setData(Uri.parse("tel:+919904075875"));
                startActivity(k1);
                break;
            default:
                break;
        }
    }

    public void linkedin(View v)
    {
        Intent k1 = new Intent(Intent.ACTION_VIEW);
        String[] linkacc={"https://www.linkedin.com/","https://www.linkedin.com/in/chanchal-sharma-9292391b2/","https://www.linkedin.com/in/harishwaran-sakthivel-557a23193/","https://www.linkedin.com/in/rajkumar-balakrishnan-lakshmi-9a894981/","https://www.linkedin.com/in/shivam-tyagi-b1b040165/"};
        switch (prof)
        {
            case "chan":
                k1.setData(Uri.parse(linkacc[1]));
                startActivity(k1);
                break;
            case "chui":
                k1.setData(Uri.parse(linkacc[0]));
                startActivity(k1);
                break;
            case "hari":
                k1.setData(Uri.parse(linkacc[2]));
                startActivity(k1);
                break;
            case "raj":
                k1.setData(Uri.parse(linkacc[3]));
                startActivity(k1);
                break;
            case "shivam":
                k1.setData(Uri.parse(linkacc[0]));
                startActivity(k1);
                break;
            case "sonali":
                k1.setData(Uri.parse(linkacc[4]));
                startActivity(k1);
                break;
            default:
                break;
        }
    }

    public void whatsapp(View v)
    {
        PackageManager pm=getPackageManager();
        switch (prof)
        {
            case "chan":
                try {
                        String toNumber = "9197086885151";
                        Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                        sendIntent.setPackage("com.whatsapp");
                        startActivity(sendIntent);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                     }
                break;
            case "chui":
                try {
                    String toNumber = "919597324912";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                }
                break;
            case "hari":
                try {
                    String toNumber = "919524320021";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                }
                break;
            case "raj":
                try {
                    String toNumber = "919361048881";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                }
                break;
            case "shivam":
                try {
                    String toNumber = "918126519330";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                }
                break;
            case "sonali":
                try {
                    String toNumber = "919904075875";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + "" + toNumber + "?body=" + "Hello"));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Toast.makeText(MainActivity3.this,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                }
                break;
            default:
                break;
        }
    }

    public void insta(View v)
    {
        Intent k1 = new Intent(Intent.ACTION_VIEW);
        String[] instaacc={"https://www.instagram.com/chanchal_sharma21/","https://www.instagram.com/gaichuiliu_gonmei/","https://www.instagram.com/hariprassath_hp/","https://www.instagram.com/rajkumarbl/","https://www.instagram.com/chandler_beeing/","https://www.instagram.com"};
        switch (prof)
        {
            case "chan":
                k1.setData(Uri.parse(instaacc[0]));
                startActivity(k1);
                break;
            case "chui":
                k1.setData(Uri.parse(instaacc[1]));
                startActivity(k1);
                break;
            case "hari":
                k1.setData(Uri.parse(instaacc[2]));
                startActivity(k1);
                break;
            case "raj":
                k1.setData(Uri.parse(instaacc[3]));
                startActivity(k1);
                break;
            case "shivam":
                k1.setData(Uri.parse(instaacc[4]));
                startActivity(k1);
                break;
            case "sonali":
                k1.setData(Uri.parse(instaacc[5]));
                startActivity(k1);
                break;
            default:
                break;
        }
    }
}