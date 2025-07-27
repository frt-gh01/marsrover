package dev.frtgh01

import dev.frtgh01.Heading.Heading
import dev.frtgh01.Heading.HeadingEast
import dev.frtgh01.Heading.HeadingNorth

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        fun at(position: Point2D, heading: Heading): MarsRover = MarsRover(position, heading)
        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    private fun processCommand(command: Char) {
        when (this.heading) {
            Heading.NORTH -> {
                when (command) {
                    'f' -> this.position += HeadingNorth().forwardPoint()
                    'b' -> this.position += HeadingNorth().backwardPoint()
                    'r' -> this.heading = HeadingNorth().rightHeading()
                    'l' -> this.heading = HeadingNorth().leftHeading()
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.EAST -> {
                when (command) {
                    'f' -> this.position += HeadingEast().forwardPoint()
                    'b' -> this.position += HeadingEast().backwardPoint()
                    'r' -> this.heading = HeadingEast().rightHeading()
                    'l' -> this.heading = HeadingEast().leftHeading()
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.SOUTH -> {
                when (command) {
                    'f' -> this.position += Point2D(0, -1)
                    'b' -> this.position += Point2D(0, 1)
                    'r' -> this.heading = Heading.WEST
                    'l' -> this.heading = Heading.EAST
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
            Heading.WEST -> {
                when (command) {
                    'f' -> this.position += Point2D(-1, 0)
                    'b' -> this.position += Point2D(1, 0)
                    'r' -> this.heading = Heading.NORTH
                    'l' -> this.heading = Heading.SOUTH
                    else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
                }
            }
        }
    }

    fun isAt(position: Point2D, heading: Heading): Boolean {
        return this.position == position && this.heading == heading
    }
}