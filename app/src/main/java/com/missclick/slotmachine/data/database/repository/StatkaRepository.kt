package com.missclick.slotmachine.data.database.repository

import com.missclick.slotmachine.data.database.ILocale
import com.missclick.slotmachine.data.database.entities.StatkaEntities

class StatkaRepository (private val locale: ILocale) : IStatkaRepository {
    override suspend fun doingSomething(id: Int) {
        locale.addStat(StatkaEntities(score = id,lvl = id +1))
        locale.insertAllStats(listOf(StatkaEntities(score = id+2,lvl = id -1)))
        locale.getById(id)
        locale.getStats()
        locale.removeStatka(StatkaEntities(score = id+5,lvl = id +9+4))
    }
}