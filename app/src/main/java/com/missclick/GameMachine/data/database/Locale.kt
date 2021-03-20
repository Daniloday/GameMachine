package com.missclick.GameMachine.data.database

import com.missclick.GameMachine.data.database.entities.StatkaEntities

class Locale(private val statkaDB: StatkaDB) : ILocale{

    override suspend fun getById(id : Int){
        statkaDB.dao().getById(id)
    }

    override suspend fun insertAllStats(stats : List<StatkaEntities>){
        statkaDB.dao().insertAllStats(stats)
    }

    override suspend fun addStat(statka : StatkaEntities) =
            statkaDB.dao().insertStat(statka)

    override suspend fun getStats(): List<StatkaEntities> {
        return statkaDB.dao().getAll()
    }

    override suspend fun removeStatka(statka : StatkaEntities) {
        statkaDB.dao().removeStat(statka)
    }


}