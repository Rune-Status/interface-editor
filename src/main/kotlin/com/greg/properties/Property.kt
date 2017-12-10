package com.greg.properties

import com.greg.canvas.widget.Widget
import com.greg.canvas.widget.WidgetInterface
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

class Property {

    val title: String
    val type: PropertyType
    val widgetClass: KClass<out WidgetInterface>
    val reflection: KFunction<out WidgetInterface>

    constructor(title: String, name: String, type: PropertyType, widget: KClass<out WidgetInterface>) {
        this.title = title
        this.type = type
        this.widgetClass = widget
        reflection = Widget.get(name, widget)
    }

    override fun toString(): String {
        return "$title $type $widgetClass"
    }
}