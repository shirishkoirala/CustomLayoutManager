package com.shirishkoirala.layoutmanager


import android.view.View
import kotlin.math.abs

/**
 * The default view picker used when one is not provided.
 * @return A view with the given adapter index.
 */
public fun defaultPicker(
    targetAdapterIndex: Int,
    layoutManager: CustomLayoutManager
): View? {
    return childClosestToMiddle(targetAdapterIndex, layoutManager)
}

/**
 * Returns a view with the given [targetAdapterIndex]. If there are multiple views associated with the
 * given index, this returns the view closest to the anchor edge.
 *
 * The anchor edge is the edge the view associated with index 0 would be initially laid out
 * against. For example: In a RTL horizontal layout, the anchor edge would be the right edge.
 */
public fun childClosestToAnchorEdge(
    targetAdapterIndex: Int,
    layoutManager: CustomLayoutManager
): View? {
    val movementDir = layoutManager.convertAdapterDirToMovementDir(
        CustomLayoutManager.TOWARDS_HIGHER_INDICES)
    val range = if (movementDir == CustomLayoutManager.TOWARDS_HIGHER_INDICES) {
        0 until layoutManager.childCount
    } else {
        layoutManager.childCount-1 downTo 0
    }

    for (i in range) {
        val view = layoutManager.getChildAt(i) ?: break
        if (layoutManager.getPosition(view) == targetAdapterIndex) {
            return view
        }
    }
    return null
}

/**
 * Returns a view with the given [targetAdapterIndex]. If there are multiple views associated with the
 * given index, this returns the view whose middle is closest to the middle of the layout.
 */
public fun childClosestToMiddle(
    targetAdapterIndex: Int,
    layoutManager: CustomLayoutManager
): View? {
    var minDistance = Int.MAX_VALUE
    var closestView: View? = null
    val layoutMiddle = if (layoutManager.orientation == CustomLayoutManager.HORIZONTAL) {
        layoutManager.paddingLeft + (layoutManager.layoutWidth / 2)
    } else {
        layoutManager.paddingTop + (layoutManager.layoutHeight / 2)
    }
    for (i in 0 until layoutManager.childCount) {
        val view = layoutManager.getChildAt(i) ?: return null
        if (layoutManager.getPosition(view) != targetAdapterIndex) {
            continue
        }
        val childMiddle = if (layoutManager.orientation == CustomLayoutManager.HORIZONTAL) {
            layoutManager.getDecoratedLeft(view) +
                    (layoutManager.getDecoratedMeasuredWidth(view) / 2)
        } else {
            layoutManager.getDecoratedTop(view) +
                    (layoutManager.getDecoratedMeasuredHeight(view) / 2)
        }
        val distance = abs(childMiddle - layoutMiddle)
        if (distance < minDistance) {
            minDistance = distance
            closestView = view
        }
    }
    return closestView
}