package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class HeadingWest : Heading {
    override fun forwardPoint() = Point2D(-1, 0)
    override fun backwardPoint() = Point2D(1, 0)
    override fun rightHeading() = CardinalPoint.NORTH
    override fun leftHeading() = CardinalPoint.SOUTH
}