package com.greg.canvas.widget

import com.greg.canvas.DragModel
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.paint.Color

open class WidgetData: Group {

    var components = mutableListOf<WidgetInterface>()
    var drag: DragModel? = null

    constructor(builder: WidgetBuilder) {
        //Add widget it's self as an attribute component
        add(this.parent)

        //Add all the rest, default just rectangle
        for (component in builder.components)
            add(component)
    }

    protected fun add(component: Node) {
        if (component is WidgetInterface)
            components.add(component)
        children.add(component)
        setWidth(component.layoutBounds.width)
        setHeight(component.layoutBounds.height)
    }

    private fun setWidth(width: Double) {
        getRectangle()?.width = width
    }

    private fun setHeight(height: Double) {
        getRectangle()?.height = height
    }

    fun setSelection(colour: Color?) {
        getRectangle()?.stroke = colour
    }

    private fun getRectangle(): WidgetRectangle? {
        val component = components[1]
        if (component is WidgetRectangle)
            return component
        return null
    }

}