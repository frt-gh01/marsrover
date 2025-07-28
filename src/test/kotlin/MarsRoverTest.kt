import dev.frtgh01.heading.Heading
import dev.frtgh01.InvalidCommandException
import dev.frtgh01.MarsRover
import dev.frtgh01.Point2D
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MarsRoverTest {
    @Test
    @DisplayName("Should start at given position")
    fun testMarsRoverStartsAtGivenPosition() {
        val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
        marsRover.process("")

        assert(marsRover.isAt(Point2D(1, 2), Heading.north()))
    }

    @Nested
    @DisplayName("Heading North")
    inner class HeadingNorth {
        @Test
        @DisplayName("Should move forward when processing `f`")
        fun testMarsRoverMovesForwardWhenCommandFHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
            marsRover.process("f")

            assert(marsRover.isAt(Point2D(1, 3), Heading.north()))
        }

        @Test
        @DisplayName("Should move backwards when processing `b`")
        fun testMarsRoverMovesBackwardsWhenCommandBHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
            marsRover.process("b")

            assert(marsRover.isAt(Point2D(1, 1), Heading.north()))
        }

        @Test
        @DisplayName("Should rotate right when processing `r`")
        fun testMarsRoverRotatesRightWhenCommandRHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
            marsRover.process("r")

            assert(marsRover.isAt(Point2D(1, 2), Heading.east()))
        }

        @Test
        @DisplayName("Should rotate left when processing `l`")
        fun testMarsRoverRotatesLeftWhenCommandLHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
            marsRover.process("l")

            assert(marsRover.isAt(Point2D(1, 2), Heading.west()))
        }

        @Test
        @DisplayName("Should not process invalid command")
        fun testMarsRoverDoNotProcessInvalidCommandHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())

            val exception = assertThrows(InvalidCommandException::class.java) {
                marsRover.process("i")
            }

            assertEquals(MarsRover.invalidCommandErrorDescription(), exception.message)
            assert(marsRover.isAt(Point2D(1, 2), Heading.north()))
        }

        @Test
        @DisplayName("Should move forward many times")
        fun testMarsRoverMovesForwardManyTimesHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.north())
            marsRover.process("ff")

            assert(marsRover.isAt(Point2D(1, 4), Heading.north()))
        }
    }

    @Nested
    @DisplayName("Heading East")
    inner class HeadingEast {
        @Test
        @DisplayName("Should move forward when processing `f`")
        fun testMarsRoverMovesForwardWhenCommandFHeadingNorth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.east())
            marsRover.process("f")

            assert(marsRover.isAt(Point2D(2, 2), Heading.east()))
        }

        @Test
        @DisplayName("Should move backwards when processing `b`")
        fun testMarsRoverMovesBackwardsWhenCommandBHeadingEast() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.east())
            marsRover.process("b")

            assert(marsRover.isAt(Point2D(0, 2), Heading.east()))
        }

        @Test
        @DisplayName("Should rotate right when processing `r`")
        fun testMarsRoverRotatesRightWhenCommandRHeadingEast() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.east())
            marsRover.process("r")

            assert(marsRover.isAt(Point2D(1, 2), Heading.south()))
        }

        @Test
        @DisplayName("Should rotate left when processing `l`")
        fun testMarsRoverRotatesLeftWhenCommandLHeadingEast() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.east())
            marsRover.process("l")

            assert(marsRover.isAt(Point2D(1, 2), Heading.north()))
        }
    }

    @Nested
    @DisplayName("Heading South")
    inner class HeadingSouth {
        @Test
        @DisplayName("Should move forward, backwards and rotate when processing `ffbr`")
        fun testMarsRoverMovesForwardBackwardsRotateRightWhenCommandFFBRHeadingSouth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.south())
            marsRover.process("ffbr")

            assert(marsRover.isAt(Point2D(1, 1), Heading.west()))
        }

        @Test
        @DisplayName("Should rotate left when processing `l`")
        fun testMarsRoverRotatesLeftWhenCommandLHeadingSouth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.south())
            marsRover.process("l")

            assert(marsRover.isAt(Point2D(1, 2), Heading.east()))
        }
    }

    @Nested
    @DisplayName("Heading West")
    inner class HeadingWest {
        @Test
        @DisplayName("Should move forward, backwards and rotate when processing `ffbr`")
        fun testMarsRoverMovesForwardBackwardsRotateRightWhenCommandFFBRHeadingSouth() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.west())
            marsRover.process("ffbr")

            assert(marsRover.isAt(Point2D(0, 2), Heading.north()))
        }

        @Test
        @DisplayName("Should rotate left when processing `l`")
        fun testMarsRoverRotatesLeftWhenCommandLHeadingWest() {
            val marsRover = MarsRover.at(Point2D(1, 2), Heading.west())
            marsRover.process("l")

            assert(marsRover.isAt(Point2D(1, 2), Heading.south()))
        }
    }
}