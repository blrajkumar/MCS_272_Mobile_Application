package com.quintus.labs.addremovelist;


import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private Switch wifiSwitch;
    private Switch blthSwitch;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiSwitch = (Switch) findViewById(R.id.wifi);
        blthSwitch = (Switch) findViewById(R.id.blth);

        wifiManager.setWifiEnabled(false);
        wifiSwitch.setChecked(false);
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                } else {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

        final BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        adapter.disable();
        blthSwitch.setChecked(false);
        blthSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    adapter.enable();
                } else {
                    adapter.disable();
                }
            }
        });
    }

    public void back(View view)
    {
        Intent main = new Intent(Settings.this, Welcome.class);
        startActivity(main);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(mBluetoothStatusChangedReceiver, filter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
        unregisterReceiver(mBluetoothStatusChangedReceiver);
    }
    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiStateExtra) {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    Toast.makeText(getApplicationContext(),"Wifi is enabled",Toast.LENGTH_LONG).show();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    Toast.makeText(getApplicationContext(),"Wifi is disabled",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private BroadcastReceiver mBluetoothStatusChangedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                switch (state) {
                    case BluetoothAdapter.STATE_ON:
                        blthSwitch.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Bluetooth is enabled", Toast.LENGTH_LONG).show();
                        break;
                    case BluetoothAdapter.STATE_OFF:
                        blthSwitch.setChecked(false);
                        Toast.makeText(getApplicationContext(), "Bluetooth is disabled", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        }
    };
}