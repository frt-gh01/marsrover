import dev.frtgh01.Heading
import dev.frtgh01.InvalidCommandException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested

import dev.frtgh01.MarsRover;
import dev.frtgh01.Point2D
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.assertEquals

class MarsRoverTest {
    @Nested
    @DisplayName("Heading North")
    inner class HeadingNorth {
        @Test
        @DisplayName("Should start at given position")
        fun testMarsRoverStartsAtGivenPosition() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("")

            assert(marsRover.isAt(Point2D(1, 2), Heading.NORTH))
        }

        @Test
        @DisplayName("Should move forward when processing `f`")
        fun testMarsRoverMovesForwardWhenCommandFHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("f")

            assert(marsRover.isAt(Point2D(1, 3), Heading.NORTH))
        }

        @Test
        @DisplayName("Should move backwards when processing `b`")
        fun testMarsRoverMovesBackwardsWhenCommandBHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("b")

            assert(marsRover.isAt(Point2D(1, 1), Heading.NORTH))
        }

        @Test
        @DisplayName("Should rotate right when processing `r`")
        fun testMarsRoverRotatesRightWhenCommandRHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("r")

            assert(marsRover.isAt(Point2D(1, 2), Heading.EAST))
        }

        @Test
        @DisplayName("Should rotate left when processing `l`")
        fun testMarsRoverRotatesLeftWhenCommandLHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("l")

            assert(marsRover.isAt(Point2D(1, 2), Heading.WEST))
        }

        @Test
        @DisplayName("Should not process invalid command")
        fun testMarsRoverDoNotProcessInvalidCommandHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)

            val exception = assertThrows(InvalidCommandException::class.java) {
                marsRover.process("i")
            }

            assertEquals(MarsRover.invalidCommandErrorDescription(), exception.message)
            assert(marsRover.isAt(Point2D(1, 2), Heading.NORTH))
        }

        @Test
        @DisplayName("Should move forward many times")
        fun testMarsRoverMovesForwardManyTimesHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.NORTH)
            marsRover.process("ff")

            assert(marsRover.isAt(Point2D(1, 4), Heading.NORTH))
        }
    }

    @Nested
    @DisplayName("Heading East")
    inner class HeadingEast {
        @Test
        @DisplayName("Should move forward when processing `f`")
        fun testMarsRoverMovesForwardWhenCommandFHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.EAST)
            marsRover.process("f")

            assert(marsRover.isAt(Point2D(2, 2), Heading.EAST))
        }

        @Test
        @DisplayName("Should move backwards when processing `b`")
        fun testMarsRoverMovesBackwardsWhenCommandBHeadingEast() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.EAST)
            marsRover.process("b")

            assert(marsRover.isAt(Point2D(0, 2), Heading.EAST))
        }
    }
}