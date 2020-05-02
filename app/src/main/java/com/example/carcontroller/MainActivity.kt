package com.example.carcontroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   lateinit var devicesButton : Button
   lateinit var bluetoothDisconnect : ImageView
   lateinit var playButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        devicesButton = findViewById(R.id.bluetoothBtn)
        devicesButton.setOnClickListener {
            val intent = Intent(this, Devices::class.java)
            startActivity(intent)
        }

        bluetoothDisconnect = findViewById(R.id.bluetooth_disconnect)
        bluetoothDisconnect.setOnClickListener {
            BluetoothHelper.disconnection()
            val toast = Toast.makeText(this, "Disconnesso", Toast.LENGTH_LONG)
            toast.show()
        }

        playButton = findViewById(R.id.playBtn)
        playButton.setOnClickListener {
            val intent = Intent(this,ControlActivity::class.java)
            startActivity(intent)
        }
    }
}
