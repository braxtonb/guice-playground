package services

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.example.enums.Sport
import org.example.factories.AthleteFactory
import org.example.models.Batter
import org.example.models.PointGuard
import org.example.models.Quarterback
import org.example.services.ScoreService
import org.example.services.ScoreServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class ScoreServiceImplTest {

    @MockK
    private lateinit var athleteFactory: AthleteFactory

    @MockK
    private lateinit var batter: Batter

    @MockK
    private lateinit var pointGuard: PointGuard

    @MockK
    private lateinit var quarterback: Quarterback

    private lateinit var scoreService: ScoreService

    @BeforeEach
    fun setUp() {
        scoreService = ScoreServiceImpl(athleteFactory)

        every { athleteFactory.createAthlete(Sport.BASEBALL) } returns batter
        every { athleteFactory.createAthlete(Sport.BASKETBALL) } returns pointGuard
        every { athleteFactory.createAthlete(Sport.FOOTBALL) } returns quarterback

        every { batter.score() } answers { println("Batter scores!") }
        every { pointGuard.score() } answers { println("Point guard scores!") }
        every { quarterback.score() } answers { println("Quarterback scores!") }

        every { batter.celebrate() } answers { println("Batter celebrates!") }
        every { pointGuard.celebrate() } answers { println("Point guard celebrates!") }
        every { quarterback.celebrate() } answers { println("Quarterback celebrates!") }
    }

    @Test
    fun `score should score as a batter`() {
        scoreService.score(Sport.BASEBALL)

        verify { athleteFactory.createAthlete(Sport.BASEBALL) }
        verify { batter.score() }
    }

    @Test
    fun `score should score as a point guard`() {
        scoreService.score(Sport.BASKETBALL)

        verify { athleteFactory.createAthlete(Sport.BASKETBALL) }
        verify { pointGuard.score() }
    }

    @Test
    fun `score should score as a quarterback`() {
        scoreService.score(Sport.FOOTBALL)

        verify { athleteFactory.createAthlete(Sport.FOOTBALL) }
        verify { quarterback.score() }
    }

    @Test
    fun `celebrate should celebrate as a batter`() {
        scoreService.celebrate(Sport.BASEBALL)

        verify { athleteFactory.createAthlete(Sport.BASEBALL) }
        verify { batter.celebrate() }
    }

    @Test
    fun `celebrate should celebrate as a point guard`() {
        scoreService.celebrate(Sport.BASKETBALL)

        verify { athleteFactory.createAthlete(Sport.BASKETBALL) }
        verify { pointGuard.celebrate() }
    }

    @Test
    fun `celebrate should celebrate as a quarterback`() {
        scoreService.celebrate(Sport.FOOTBALL)

        verify { athleteFactory.createAthlete(Sport.FOOTBALL) }
        verify { quarterback.celebrate() }
    }
}
