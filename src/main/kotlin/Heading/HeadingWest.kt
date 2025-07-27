package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class HeadingWest {
    fun forwardPoint() = Point2D(-1, 0)
    fun backwardPoint() = Point2D(1, 0)
    fun rightHeading() = Heading.NORTH
    fun leftHeading() = Heading.SOUTH
}