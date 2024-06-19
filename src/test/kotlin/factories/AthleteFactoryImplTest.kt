package factories

import org.example.enums.Sport
import org.example.factories.AthleteFactory
import org.example.factories.AthleteFactoryImpl
import org.example.models.Batter
import org.example.models.PointGuard
import org.example.models.Quarterback
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AthleteFactoryImplTest {

    private lateinit var athleteFactory: AthleteFactory

    @BeforeEach
    fun setUp() {
        athleteFactory = AthleteFactoryImpl()
    }

    @Test
    fun `createAthlete should create a Batter`() {
        val athlete = athleteFactory.createAthlete(Sport.BASEBALL)

        assertTrue(athlete is Batter)
        assertEquals(AthleteFactoryImpl.BASEBALL_NAME, (athlete as Batter).name)
    }

    @Test
    fun `createAthlete should create a Point Guard`() {
        val athlete = athleteFactory.createAthlete(Sport.BASKETBALL)

        assertTrue(athlete is PointGuard)
        assertEquals(AthleteFactoryImpl.BASKETBALL_NAME, (athlete as PointGuard).name)
    }

    @Test
    fun `createAthlete should create a Quarterback`() {
        val athlete = athleteFactory.createAthlete(Sport.FOOTBALL)

        assertTrue(athlete is Quarterback)
        assertEquals(AthleteFactoryImpl.FOOTBALL_NAME, (athlete as Quarterback).name)
    }
}
