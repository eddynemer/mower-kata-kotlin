package com.olbati.models

import com.olbati.models.mower.Mower
import java.lang.Integer.parseInt

class Lawn(width: Int, height: Int, private val mowers: List<Mower>) {

    companion object {
        fun readConfig(config: String): Lawn {
            val lines = config.split("\n")
            require(
                lines.size % 2 == 1
            ) { "lawn configuration must one line for lawn dimensions plus 2 lines per mower" }
            require(
                lines[0].matches("[0-9]* [0-9]*".toRegex())
            ) {
                "lawn dimension must contain only width and height values"
            }

            val xy = lines[0].split(" ")
            val width = parseInt(xy[0])
            val height = parseInt(xy[1])
            val nbMower = (lines.size - 1) / 2
            val mowers = arrayListOf<Mower>()
            for (i in 0 until nbMower) {
                mowers.add(Mower(lines[(2 * i) + 1], lines[2 * i + 2], Surface(width, height)))
            }
            return Lawn(width, height, mowers)
        }
    }

    fun mow() {
        for (mower in mowers) {
            mower.mow()
        }
    }
}