package com.olbati

import com.olbati.enums.Orientation
import com.olbati.models.Surface
import com.olbati.models.mower.Mower
import org.junit.Assert
import org.junit.Test

class MowerTest {

    //Mower init test
    @Test
    fun given_limit_5_5_position_0_3_N_direction_N_should_set_initial_values() {
        val mower = Mower("0 3 N", "", Surface(5, 7))
        Assert.assertEquals(5, mower.horizontalLimit)
        Assert.assertEquals(7, mower.verticalLimit)
        Assert.assertEquals(Orientation.N, mower.direction)
        Assert.assertEquals(Pair(0, 3), mower.location)
    }

    //Mower init test with wrong input
    @Test(expected = IllegalArgumentException::class)
    fun given_limit_e5_5_position_0_3_N_direction_N_should_set_initial_values() {
        val mower = Mower("0 3N", "", Surface(5, 7))
    }

    //Mower position
    @Test
    fun given_position_0_3_N_should_return_String_03N() {
        val mower = Mower("0 3 N", "", getRandomSurface())
        Assert.assertEquals("0 3 N", mower.getPosition())
    }


}