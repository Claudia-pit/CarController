package com.example.carcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_devices.*

class Devices : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devices)

        val listOfDevices = BluetoothHelper.getDevicesList()

        recyclerView.adapter = DevicesAdapter(this, listOfDevices)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
