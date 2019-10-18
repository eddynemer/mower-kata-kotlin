package com.olbati.models.mower

import com.olbati.enums.Orientation
import com.olbati.models.Surface

class Mower(position: String, commands: String, surface: Surface) {
    internal var direction: Orientation = Orientation.N
    internal var location: Pair<Int, Int> = Pair(0, 0)
    private var driver: MowerDriver = MowerDriver(this)
    internal val horizontalLimit: Int = surface.horizontalLimit
    internal val verticalLimit: Int = surface.verticalLimit

    init {
        setupMower(position, commands)
    }

    private fun setupMower(position: String, commandChars: String) {

        require(
            position.matches("[0-9]* [0-9]* [NEWS]".toRegex())
        ) {
            "mower position must be of the form X Y Direction"
        }

        require(commandChars.matches("[GDA]*".toRegex())) { "Commands must be one of G, D, A" }

        val pos = position.split(" ")
        if (pos.size >= 2) {
            try {
                val tempLocation = Pair(pos[0].toInt(), pos[1].toInt())
                location = tempLocation
            } catch (e: NumberFormatException) {
                println("Given location is in wrong format")
            }

            direction = if (pos[2].isBlank()) Orientation.N else Orientation.valueOf(pos[2])

            driver.takeCommands(commandChars)
        }
    }

    fun getPosition(): String {
        return "${location.first} ${location.second} ${direction.name}"
    }

    fun mow() {
        driver.handleInstructions()
        println(getPosition())
    }

}