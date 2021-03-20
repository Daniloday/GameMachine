package com.missclick.slotmachine.data.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "roomdb")
data class StatkaEntities(

        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "id")
        var id : Int? = null,

        @ColumnInfo(name = "score")
        var score : Int,

        @ColumnInfo(name = "category")
        var lvl : Int
)
