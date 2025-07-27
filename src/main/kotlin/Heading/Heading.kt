package dev.frtgh01.Heading

import dev.frtgh01.Point2D

interface Heading {
    fun forwardPoint(): Point2D
    fun backwardPoint(): Point2D
    fun rightHeading(): Heading
    fun leftHeading(): Heading

    fun cardinalPoint(): CardinalPoint
}