package com.olbati

import com.olbati.enums.Orientation
import com.olbati.models.mower.Mower
import org.junit.Assert
import org.junit.Test

class MowerDriverDirectionTest {

    @Test
    fun given_direction_N_instruction_D_should_return_direction_E() {
        val mower = Mower("0 0 N", "D", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.E, mower.direction)
    }

    @Test
    fun given_direction_E_instruction_D_should_return_direction_S() {
        val mower = Mower("0 0 E", "D", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.S, mower.direction)
    }

    @Test
    fun given_direction_W_instruction_D_should_return_direction_N() {
        val mower = Mower("0 0 W", "D", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.N, mower.direction)
    }

    @Test
    fun given_direction_S_instruction_D_should_return_direction_W() {
        val mower = Mower("0 0 S", "D", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.W, mower.direction)
    }

    @Test
    fun given_direction_N_instruction_G_should_return_direction_W() {
        val mower = Mower("0 0 N", "G", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.W, mower.direction)
    }

    @Test
    fun given_direction_E_instruction_G_should_return_direction_N() {
        val mower = Mower("0 0 E", "G", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.N, mower.direction)
    }

    @Test
    fun given_direction_W_instruction_G_should_return_direction_S() {
        val mower = Mower("0 0 W", "G", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.S, mower.direction)
    }

    @Test
    fun given_direction_W_instruction_S_should_return_direction_E() {
        val mower = Mower("0 0 S", "G", getRandomSurface())
        mower.mow()
        Assert.assertEquals(Orientation.E, mower.direction)
    }
}