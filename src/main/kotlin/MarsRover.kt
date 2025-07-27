package dev.frtgh01

import dev.frtgh01.Heading.CardinalPoint
import dev.frtgh01.Heading.Heading

class MarsRover(var position: Point2D, var heading: Heading) {
    companion object MarsRoverClass {
        // Map with all the possible Headings
        // where the key is the CardinalPoint for that Heading.
        val headings: Map<CardinalPoint, Heading> = listOf(
                Heading(CardinalPoint.NORTH, Point2D(0, 1), Point2D(0, -1), CardinalPoint.EAST, leftCardinalPoint = CardinalPoint.WEST),
                Heading(CardinalPoint.EAST, Point2D(1, 0), Point2D(-1, 0), CardinalPoint.SOUTH, leftCardinalPoint = CardinalPoint.NORTH),
                Heading(CardinalPoint.SOUTH, Point2D(0, -1), Point2D(0, 1), CardinalPoint.WEST, leftCardinalPoint = CardinalPoint.EAST),
                Heading(CardinalPoint.WEST, Point2D(-1, 0), Point2D(1, 0), CardinalPoint.NORTH, leftCardinalPoint = CardinalPoint.SOUTH),
            ).associateBy { heading -> heading.cardinalPoint() }

        fun at(position: Point2D, cardinalPoint: CardinalPoint): MarsRover = MarsRover(position, headingFor(cardinalPoint))

        fun headingFor(cardinalPoint: CardinalPoint): Heading = headings.getValue(cardinalPoint)

        fun invalidCommandErrorDescription(): String = "Invalid Command"
    }

    fun process(commands: String) {
        commands.forEach(::processCommand)
    }

    private fun processCommand(command: Char) {
        when (command) {
            'f' -> this.position += this.heading.forwardPoint()
            'b' -> this.position += this.heading.backwardPoint()
            'r' -> this.heading = headingFor(this.heading.rightCardinalPoint())
            'l' -> this.heading = headingFor(this.heading.leftCardinalPoint())
            else -> throw InvalidCommandException(MarsRover.invalidCommandErrorDescription())
        }
    }

    fun isAt(position: Point2D, heading: CardinalPoint): Boolean {
        return this.position == position && this.heading.cardinalPoint() == heading
    }
}