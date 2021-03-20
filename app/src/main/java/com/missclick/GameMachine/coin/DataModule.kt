package com.missclick.GameMachine.coin

import android.content.Context
import androidx.room.Room
import com.missclick.GameMachine.data.database.ILocale
import com.missclick.GameMachine.data.database.Locale
import com.missclick.GameMachine.data.database.StatkaDB
import com.missclick.GameMachine.data.database.repository.IStatkaRepository
import com.missclick.GameMachine.data.database.repository.StatkaRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        provideRepository(get())
    }
    single {
        provideRoomDb(get())
    }
    single {
        provideLocale(get())
    }


}


fun provideRepository(locale: ILocale): IStatkaRepository {
    return StatkaRepository(locale)
}

fun provideLocale(statkaDB: StatkaDB) : ILocale{
    return Locale(statkaDB)
}

fun provideRoomDb(context: Context) : StatkaDB {
    return Room.databaseBuilder(context, StatkaDB::class.java, "roomdb")
            .fallbackToDestructiveMigration()
            .build()
}