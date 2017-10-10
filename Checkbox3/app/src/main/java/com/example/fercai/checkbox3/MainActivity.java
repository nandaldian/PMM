package com.example.fercai.checkbox3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHoby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
    }

    public void initialUISetup()
    {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        TextView txtHobby = (TextView)findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new MyCheckBoxChangeClicker());
    }

    class MyCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener
    { @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if(isChecked)
        {
            if(buttonView==chkBoxCycling)
            {
                showTextNotification("Cycling");
            }
            if(buttonView==chkBoxTeaching)
            {
                showTextNotification("Teaching");
            }
            if(buttonView==chkBoxBlogging)
            {
                showTextNotification("BlackBlogging");
            }
        }
    }
    }// clase interna
    public void showTextNotification(String msgToDisplay)
    { Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }


}
