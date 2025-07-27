package dev.frtgh01

import dev.frtgh01.Heading.CardinalPoint
import dev.frtgh01.Heading.Heading
import dev.frtgh01.Heading.HeadingEast
import dev.frtgh01.Heading.HeadingNorth
import dev.frtgh01.Heading.HeadingSouth
import dev.frtgh01.Heading.HeadingWest

class MarsRover(var position: Point2D, var heading: CardinalPoint) {
    companion object MarsRoverClass {
        fun at(position: Point2D, heading: CardinalPoint): MarsRover = MarsRover(position, heading)
        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    private fun processCommand(command: Char) {
        val currentHeading : Heading = when (this.heading) {
            CardinalPoint.NORTH -> HeadingNorth()
            CardinalPoint.EAST -> HeadingEast()
            CardinalPoint.SOUTH -> HeadingSouth()
            CardinalPoint.WEST -> HeadingWest()
        }

        when (command) {
            'f' -> this.position += currentHeading.forwardPoint()
            'b' -> this.position += currentHeading.backwardPoint()
            'r' -> this.heading = currentHeading.rightHeading()
            'l' -> this.heading = currentHeading.leftHeading()
            else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
        }
    }

    fun isAt(position: Point2D, heading: CardinalPoint): Boolean {
        return this.position == position && this.heading == heading
    }
}