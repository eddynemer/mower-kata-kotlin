package com.olbati.models.mower

import com.olbati.enums.DriverInstructions
import com.olbati.enums.DriverInstructions.*

class MowerDriver(private val mower: Mower) {

    private var commands = ""

    fun handleInstructions() {
        commands.forEach {
            when (it) {
                LEFT.instruction -> changeDirection(LEFT)
                RIGHT.instruction -> changeDirection(RIGHT)
                FORWARD.instruction -> moveForward()
            }
        }
    }

    private fun moveForward() {
        val decal = mower.direction.decalation
        val oldLocation = mower.location
        var newLocation = Pair(oldLocation.first + decal.first, oldLocation.second + decal.second)

        newLocation = restrictMowerToLimits(newLocation)

        mower.location = newLocation
    }

    private fun restrictMowerToLimits(newLocation: Pair<Int, Int>): Pair<Int, Int> {
        var restrictedLocation = newLocation
        if (restrictedLocation.first < 0) restrictedLocation = restrictedLocation.copy(first = 0)
        if (restrictedLocation.first > mower.horizontalLimit) restrictedLocation =
            restrictedLocation.copy(first = mower.horizontalLimit)
        if (restrictedLocation.second < 0) restrictedLocation = restrictedLocation.copy(second = 0)
        if (restrictedLocation.second > mower.verticalLimit) restrictedLocation =
            restrictedLocation.copy(second = mower.verticalLimit)
        return restrictedLocation
    }

    private fun changeDirection(direction: DriverInstructions) {
        mower.direction = mower.direction.changeDirection(mower.direction, direction)
    }

    fun takeCommands(commandChars: String) {
        commands = commandChars
    }
}