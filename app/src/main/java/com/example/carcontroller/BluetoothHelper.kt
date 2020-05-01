package com.example.carcontroller

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.util.Log
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

object BluetoothHelper {

    val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothSocket : BluetoothSocket? = null
    private var bluetoothDevice : BluetoothDevice? = null
    private var inputStream : InputStream? = null
    private var outputStream : OutputStream? = null
    private var bondedDevices = bluetoothAdapter.bondedDevices


    fun getDevicesList() : MutableList<BluetoothDevice> {
        bluetoothAdapter.enable()
        val devicesList = mutableListOf<BluetoothDevice>()
        devicesList.addAll(bondedDevices)
        return devicesList
    }

    fun setConnession(address: String) : Boolean {

        bluetoothDevice = bluetoothAdapter.getRemoteDevice(address)
        bluetoothSocket = bluetoothDevice!!.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"))

        try {
            bluetoothSocket!!.connect()
            inputStream = bluetoothSocket!!.inputStream
            outputStream = bluetoothSocket!!.outputStream
        }catch (ex : IOException){
            Log.d("Errore", "Impossibile connettersi")
        }

        return bluetoothSocket!!.isConnected
    }

    fun disconnession(){
        bluetoothSocket?.let {
            it.close()
        }
    }

    fun write(message: String) {
        if (bluetoothSocket!!.isConnected){
            outputStream!!.write(message.toByteArray())
        }
    }

}