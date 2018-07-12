package statistics_cash.fedka27.github.com.statisticscash.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import statistics_cash.fedka27.github.com.statisticscash.data.database.AppDatabase

@Module
class AppModule(private val application: Application){

    @AppScope
    @Provides
    fun provideApplication(): Context {
        return application
    }

    @AppScope
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {

        return Room.databaseBuilder(context,
                AppDatabase::class.java,
                "db-table-statistics").build()
    }
}