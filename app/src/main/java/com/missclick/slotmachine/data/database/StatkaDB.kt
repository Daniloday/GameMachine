package com.missclick.slotmachine.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.missclick.slotmachine.data.database.entities.StatkaEntities

@Database(entities = [StatkaEntities::class], version = 5)
abstract class StatkaDB : RoomDatabase(){
    abstract fun dao() : StatkaDao
}