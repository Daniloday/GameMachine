package com.missclick.slotmachine.data.database

import com.missclick.slotmachine.data.database.entities.StatkaEntities

interface ILocale {

    suspend fun getById(id : Int)
    suspend fun insertAllStats(stats : List<StatkaEntities>)
    suspend fun addStat(statka : StatkaEntities) : Long
    suspend fun getStats(): List<StatkaEntities>
    suspend fun removeStatka(statka : StatkaEntities)

}