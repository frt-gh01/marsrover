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

    @Test
    @DisplayName("Should move backwards when processing `b`")
    fun testMarsRoverMovesBackwardsWhenCommandB() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
        marsRover.process("b")

        assert(marsRover.isAt(Point2D(1, 1), Heading.NORTH))
    }

    @Test
    @DisplayName("Should rotate right when processing `r`")
    fun testMarsRoverRotatesRightWhenCommandR() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
        marsRover.process("r")

        assert(marsRover.isAt(Point2D(1, 2), Heading.EAST))
    }

    @Test
    @DisplayName("Should rotate left when processing `l`")
    fun testMarsRoverRotatesLeftWhenCommandL() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
        marsRover.process("l")

        assert(marsRover.isAt(Point2D(1, 2), Heading.WEST))
    }
}