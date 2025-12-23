package com.example.snapshottestingandroid

import app.cash.paparazzi.Paparazzi
import com.example.bankdashboard.BankDashboardSimpleScreen
import org.junit.Rule
import org.junit.Test

class DashboardScreenShotTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun compose() {
        paparazzi.snapshot { BankDashboardSimpleScreen() }
    }
}