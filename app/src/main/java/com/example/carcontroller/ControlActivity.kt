package com.example.carcontroller

import android.annotation.SuppressLint
import android.bluetooth.BluetoothSocket
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.OutputStream


class ControlActivity : AppCompatActivity() {

    private lateinit var bluetoothHelper : BluetoothHelper
    private lateinit var forward : ImageView
    private lateinit var backward : ImageView
    private lateinit var left : ImageView
    private lateinit var right : ImageView
    private var outputStreamControl : OutputStream? = null
    private var bluetoothSocketControl : BluetoothSocket? = null
    private lateinit var event: MotionEvent


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        bluetoothHelper = BluetoothHelper

        forward = findViewById(R.id.button_up)
        forward.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                    bluetoothHelper.write("F")
                return@OnTouchListener true
            } else if (event.action == MotionEvent.ACTION_UP) {
               bluetoothHelper.write("S")
                return@OnTouchListener true
            }
            false
        })
    }
}
