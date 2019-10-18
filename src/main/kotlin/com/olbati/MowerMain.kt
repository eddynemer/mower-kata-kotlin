package com.olbati

import com.olbati.models.Lawn


fun main() {

    val lawn = Lawn.readConfig("5 5\n" +
            "1 2 N\n" +
            "GAGAGAGAA\n" +
            "3 3 E\n" +
            "AADAADADDA")

    lawn.mow()
}