package com.olbati

import com.olbati.models.Surface
import kotlin.random.Random

fun getRandomSurface(): Surface {
    return Surface(getRandomNumber(), getRandomNumber())
}

fun getRandomNumber(): Int {
    return Random.nextInt(2, 15)
}