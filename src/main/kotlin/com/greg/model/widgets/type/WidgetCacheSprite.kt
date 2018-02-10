package com.greg.model.widgets.type

import com.greg.model.settings.Settings
import com.greg.model.widgets.WidgetBuilder
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

class WidgetCacheSprite(builder: WidgetBuilder, id: Int) : WidgetSprite(builder, id) {

    private var archive: SimpleStringProperty? = null

    fun getArchive(): String {
        return archiveProperty().get()
    }

    fun setArchive(value: String) {
        archiveProperty().set(value)
    }

    fun archiveProperty(): StringProperty {
        if (archive == null)
            archive = SimpleStringProperty(this, "archive", Settings.get(Settings.DEFAULT_SPRITE_ARCHIVE_NAME))

        return archive!!
    }

    init {
        properties.add(archiveProperty())
    }
}