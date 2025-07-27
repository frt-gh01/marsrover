import dev.frtgh01.Heading
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import dev.frtgh01.MarsRover;
import dev.frtgh01.Point2D

class MarsRoverTest {
    @Test
    @DisplayName("Should start at given position")
    fun testMarsRoverStartsAtGivenPosition() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
        marsRover.process("")

        assert(marsRover.isAt(Point2D(1, 2), Heading.NORTH))
    }

    @Test
    @DisplayName("Should move forward when processing `f`")
    fun testMarsRoverMovesForwardWhenCommandF() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
        marsRover.process("f")

        assert(marsRover.isAt(Point2D(1, 3), Heading.NORTH))
    }
}