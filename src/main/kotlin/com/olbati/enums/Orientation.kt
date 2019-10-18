package com.olbati.enums

enum class Orientation(var decalation: Pair<Int, Int>) {
    N(Pair(0, 1)),
    E(Pair(1, 0)),
    W(Pair(-1, 0)),
    S(Pair(0, -1));

    fun changeDirection(orientation: Orientation, direction: DriverInstructions): Orientation {
        return when (direction) {
            DriverInstructions.LEFT -> turnLeft(orientation)
            DriverInstructions.RIGHT -> turnRight(orientation)
            else -> orientation
        }
    }

    private fun turnRight(orientation: Orientation): Orientation {
        return when (orientation) {
            N -> E
            E -> S
            W -> N
            S -> W
        }
    }

    private fun turnLeft(orientation: Orientation): Orientation {
        return when (orientation) {
            N -> W
            E -> N
            W -> S
            S -> E
        }
    }
}
