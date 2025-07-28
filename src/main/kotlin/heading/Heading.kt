package dev.frtgh01.heading

import dev.frtgh01.Point2D

class Heading(val cardinalPoint: CardinalPoint, val forwardDelta: Point2D,
              val rightCardinalPoint: CardinalPoint, val leftCardinalPoint: CardinalPoint) {

    companion object HeadingClass {
        // Map with all the possible Headings
        // where the key is the CardinalPoint for that Heading.
        val headings: Map<CardinalPoint, Heading> = listOf(
            Heading(CardinalPoint.NORTH, Point2D(0, 1), CardinalPoint.EAST, CardinalPoint.WEST),
            Heading(CardinalPoint.EAST, Point2D(1, 0), CardinalPoint.SOUTH, CardinalPoint.NORTH),
            Heading(CardinalPoint.SOUTH, Point2D(0, -1), CardinalPoint.WEST,CardinalPoint.EAST),
            Heading(CardinalPoint.WEST, Point2D(-1, 0), CardinalPoint.NORTH, CardinalPoint.SOUTH)
        ).associateBy { heading -> heading.cardinalPoint() }

        fun headingFor(cardinalPoint: CardinalPoint): Heading = headings.getValue(cardinalPoint)

        fun north() = headingFor(CardinalPoint.NORTH)
        fun east() = headingFor(CardinalPoint.EAST)
        fun south() = headingFor(CardinalPoint.SOUTH)
        fun west() = headingFor(CardinalPoint.WEST)
    }

    fun cardinalPoint(): CardinalPoint = this.cardinalPoint
    fun forwardDelta(): Point2D = this.forwardDelta
    fun leftHeading(): Heading = headingFor(this.leftCardinalPoint)
    fun rightHeading(): Heading = headingFor(this.rightCardinalPoint)
}