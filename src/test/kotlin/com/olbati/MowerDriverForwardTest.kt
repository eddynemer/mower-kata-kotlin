package com.olbati

import com.olbati.models.Surface
import com.olbati.models.mower.Mower
import org.junit.Assert
import org.junit.Test

class MowerDriverForwardTest {

    //Moves N once
    @Test
    fun given_0_0_N_instruction_A_should_return_position_01N() {
        val mower = Mower("0 0 N", "A", getRandomSurface())
        mower.mow()
        Assert.assertEquals("0 1 N", mower.getPosition())
    }

    //Moves N twice
    @Test
    fun given_0_0_N_instruction_AA_should_return_position_02N() {
        val mower = Mower("0 0 N", "AA", getRandomSurface())
        mower.mow()
        Assert.assertEquals("0 2 N", mower.getPosition())
    }

    //Moves N but not out of Zone
    @Test
    fun given_position_0_3_N_Zone_3_4_instruction_AA_should_return_position_04N() {
        val mower = Mower("0 3 N", "AA", Surface(3, 4))
        mower.mow()
        Assert.assertEquals("0 4 N", mower.getPosition())
    }

    //Moves S but not out of Zone
    @Test
    fun given_position_0_1_S_Zone_3_4_instruction_AA_should_return_position_00S() {
        val mower = Mower("0 1 S", "AA", getRandomSurface())
        mower.mow()
        Assert.assertEquals("0 0 S", mower.getPosition())
    }

    //Moves E but not out of Zone
    @Test
    fun given_position_2_1_E_Zone_3_4_instruction_AA_should_return_position_31E() {
        val mower = Mower("2 1 E", "AA", Surface(3, 4))
        mower.mow()
        Assert.assertEquals("3 1 E", mower.getPosition())
    }

    //Moves W but not out of Zone
    @Test
    fun given_position_1_1_W_Zone_3_4_instruction_AA_should_return_position_01W() {
        val mower = Mower("1 1 W", "AA", Surface(3, 4))
        mower.mow()
        Assert.assertEquals("0 1 W", mower.getPosition())
    }

    //Required Tests
    @Test
    fun given_position_1_2_N_Zone_5_5_instrutions_GAGAGAGAA_return_position_13N() {
        val mower = Mower("1 2 N", "GAGAGAGAA", Surface(5, 5))
        mower.mow()
        Assert.assertEquals("1 3 N", mower.getPosition())
    }

    @Test
    fun given_position_3_3_E_Zone_5_5_instrutions_AADAADADDA_return_position_51E() {
        val mower = Mower("3 3 E", "AADAADADDA", Surface(5, 5))
        mower.mow()
        Assert.assertEquals("5 1 E", mower.getPosition())
    }

}