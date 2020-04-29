package com.example.carcontroller

import android.app.Activity
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.devices_list.view.*

class DevicesAdapter(val context: Context, val devices: MutableList<BluetoothDevice>) : RecyclerView.Adapter<DevicesAdapter.DeviceHolder>() {

    override fun getItemCount(): Int {
        return devices.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.devices_list, parent, false)
        return DeviceHolder(itemView)
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {
        val device = devices.get(position)
        holder!!.deviceName.text = "${device.name} : ${device.address}"

        holder.itemView.setOnClickListener {
            if(BluetoothHelper.setConnession(device.address)){
                (context as Activity).finish()
                val toast = Toast.makeText(context, "Connesso!", Toast.LENGTH_LONG)
                toast.show()
            } else {
                val toast = Toast.makeText(context, "Impossibile connettere", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }

    class DeviceHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val deviceName = itemView.deviceName
    }
}