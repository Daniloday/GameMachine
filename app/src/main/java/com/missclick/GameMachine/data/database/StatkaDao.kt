package com.missclick.GameMachine.data.database

import androidx.room.*
import com.missclick.GameMachine.data.database.entities.StatkaEntities

@Dao
interface StatkaDao{

    @Query("SELECT * FROM roomdb")
    fun getAll() : List<StatkaEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStat(statka: StatkaEntities) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllStats(stats : List<StatkaEntities>)

    @Delete
    fun removeStat(statka: StatkaEntities)

    @Query("SELECT * FROM roomdb WHERE id = :id")
    fun getById(id : Int) : StatkaEntities

}