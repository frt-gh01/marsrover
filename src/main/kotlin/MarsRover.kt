package dev.frtgh01

import dev.frtgh01.Heading.CardinalPoint
import dev.frtgh01.Heading.Heading
import dev.frtgh01.Heading.HeadingEast
import dev.frtgh01.Heading.HeadingNorth
import dev.frtgh01.Heading.HeadingSouth
import dev.frtgh01.Heading.HeadingWest

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        fun at(position: Point2D, heading: CardinalPoint): MarsRover {
            val currentHeading : Heading = when (heading) {
                CardinalPoint.NORTH -> HeadingNorth()
                CardinalPoint.EAST -> HeadingEast()
                CardinalPoint.SOUTH -> HeadingSouth()
                CardinalPoint.WEST -> HeadingWest()
            }

            return MarsRover(position, currentHeading)
        }
        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    private fun processCommand(command: Char) {
        when (command) {
            'f' -> this.position += this.heading.forwardPoint()
            'b' -> this.position += this.heading.backwardPoint()
            'r' -> this.heading = this.heading.rightHeading()
            'l' -> this.heading = this.heading.leftHeading()
            else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
        }
    }

    fun isAt(position: Point2D, heading: CardinalPoint): Boolean {
        return this.position == position && this.heading.cardinalPoint() == heading
    }
}