package com.example.formula1trackerapp.standing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.formula1trackerapp.MainActivity
import com.example.formula1trackerapp.ui.theme.Formula1TrackerAppTheme
import com.example.standings.domain.StandingsRepository
import com.example.standings.ui.screens.StandingsScreen
import com.example.standings.ui.screens.driver.DriverStandingsUiMapper
import com.example.standings.ui.screens.driver.DriverStandingsUiState
import com.example.standings.ui.screens.team.TeamStandingsUiMapper
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class StandingsInstrumentedTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var standingsRepository: StandingsRepository

    @Inject
    lateinit var driverStandingsUiMapper: DriverStandingsUiMapper

    @Inject
    lateinit var teamStandingsUiMapper: TeamStandingsUiMapper

    @Before
    fun setup() {
        hiltRule.inject()

        composeTestRule.setContent {
            Formula1TrackerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    ) {
                        StandingsScreen()
                    }
                }
            }
        }
    }

    @Test
    fun standing_is_displayed_successfully() = runTest(
        timeout = 30.seconds
    ) {
        composeTestRule.onNodeWithText("Drivers").assertIsDisplayed()
        composeTestRule.onNodeWithText("Teams").assertIsDisplayed()

        runBlocking {
            standingsRepository.loadDriverStandingsByYear(2024).collectLatest { result ->
                result.map(driverStandingsUiMapper).let { state ->
                    if (state is DriverStandingsUiState.Success) {
                        state.drivers.forEach {
                            composeTestRule.onNodeWithText(it.name).assertIsDisplayed()
                        }
                    }
                }
                delay(3000)

                composeTestRule.onNodeWithText("Teams").performClick()
                composeTestRule.awaitIdle()

                delay(3000)

                composeTestRule.onNodeWithText("Drivers").performClick()
                composeTestRule.awaitIdle()

                delay(3000)
            }
        }
    }
}