import dev.frtgh01.Heading
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import dev.frtgh01.MarsRover;
import dev.frtgh01.Position2D

class MarsRoverTest {
    @Test
    @DisplayName("Should start at given position")
    fun testMarsRoverStartsAtGivenPosition() {
        val marsRover = MarsRover.at(Position2D(1, 2), Heading.NORTH)
        marsRover.process("")

        assert(marsRover.isAt(Position2D(1, 2), Heading.NORTH))
    }
}