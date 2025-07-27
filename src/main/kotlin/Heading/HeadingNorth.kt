package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class HeadingNorth : Heading {
    override fun forwardPoint() = Point2D(0, 1)
    override fun backwardPoint() = Point2D(0, -1)
    override fun rightHeading() = CardinalPoint.EAST
    override fun leftHeading() = CardinalPoint.WEST
}