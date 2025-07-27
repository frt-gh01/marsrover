package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class HeadingEast : Heading {
    override fun forwardPoint() = Point2D(1, 0)
    override fun backwardPoint() = Point2D(-1, 0)
    override fun rightHeading() = HeadingSouth()
    override fun leftHeading() = HeadingNorth()

    override fun cardinalPoint() = CardinalPoint.EAST
}