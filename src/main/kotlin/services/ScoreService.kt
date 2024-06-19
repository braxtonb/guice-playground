package org.example.services

import org.example.enums.Sport

interface ScoreService {
    fun score(sport: Sport)
    fun celebrate(sport: Sport)
}
