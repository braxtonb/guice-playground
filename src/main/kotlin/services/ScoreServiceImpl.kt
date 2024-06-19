package org.example.services

import com.google.inject.Inject
import com.google.inject.Singleton
import org.example.enums.Sport
import org.example.factories.AthleteFactory

@Singleton
class ScoreServiceImpl @Inject constructor(private val athleteFactory: AthleteFactory) : ScoreService {
    override fun score(sport: Sport) {
        val athlete = athleteFactory.createAthlete(sport)

        athlete.score()
    }

    override fun celebrate(sport: Sport) {
        val athlete = athleteFactory.createAthlete(sport)

        athlete.celebrate()
    }
}
