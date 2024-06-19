package org.example.factories

import org.example.enums.Sport
import org.example.models.Athlete
import org.example.models.Batter
import org.example.models.PointGuard
import org.example.models.Quarterback

class AthleteFactoryImpl : AthleteFactory {
    override fun createAthlete(sport: Sport): Athlete {
        return when (sport) {
            Sport.BASEBALL -> Batter(BASEBALL_NAME)
            Sport.BASKETBALL -> PointGuard(BASKETBALL_NAME)
            Sport.FOOTBALL -> Quarterback(FOOTBALL_NAME)
        }
    }

    companion object {
        const val BASEBALL_NAME = "Barry Bonds"
        const val BASKETBALL_NAME = "Stephen Curry"
        const val FOOTBALL_NAME = "Tom Brady"
    }
}
