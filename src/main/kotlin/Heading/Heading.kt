package dev.frtgh01.Heading

import dev.frtgh01.Point2D

interface Heading {
    fun forwardPoint(): Point2D
    fun backwardPoint(): Point2D
    fun rightHeading(): CardinalPoint
    fun leftHeading(): CardinalPoint
}