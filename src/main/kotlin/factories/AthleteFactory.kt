package org.example.factories

import org.example.enums.Sport
import org.example.models.Athlete

interface AthleteFactory {
    fun createAthlete(sport: Sport): Athlete
}
