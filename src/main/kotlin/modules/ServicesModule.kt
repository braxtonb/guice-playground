package org.example.modules

import com.google.inject.AbstractModule
import com.google.inject.Inject
import com.google.inject.Provides
import org.example.factories.AthleteFactory
import org.example.factories.AthleteFactoryImpl
import org.example.services.ScoreService
import org.example.services.ScoreServiceImpl

class ServicesModule : AbstractModule() {
    @Provides
    fun provideAthleteFactory(): AthleteFactory = AthleteFactoryImpl()

    @Provides
    @Inject
    fun provideScoreService(athleteFactory: AthleteFactory): ScoreService = ScoreServiceImpl(athleteFactory)
}
