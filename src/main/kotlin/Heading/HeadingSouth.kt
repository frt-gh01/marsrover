package dev.frtgh01.Heading

import dev.frtgh01.Point2D

class HeadingSouth {
    fun forwardPoint() = Point2D(0, -1)
    fun backwardPoint() = Point2D(0, 1)
    fun rightHeading() = Heading.WEST
    fun leftHeading() = Heading.EAST
}