package org.example

import com.google.inject.Guice
import org.example.enums.Sport
import org.example.modules.ServicesModule
import org.example.services.ScoreService

fun main() {
    val injector = Guice.createInjector(ServicesModule())
    val scoreService = injector.getInstance(ScoreService::class.java)
    val sport = Sport.fromString(System.getenv("SPORT") ?: Sport.FOOTBALL.name)

    scoreService.score(sport)
    scoreService.celebrate(sport)
}
