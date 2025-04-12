package com.alfajar.myapp12.db.model

import android.media.midi.MidiSender

data class Order (
    val id: String = "",
    val itemName: String = "",
    val sender: String = "",
    val destination: String = "",
    val date: String = "",
)