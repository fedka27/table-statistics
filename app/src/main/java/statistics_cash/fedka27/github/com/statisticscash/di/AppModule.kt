package statistics_cash.fedka27.github.com.statisticscash.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application){

    @AppScope
    @Provides
    fun provideApplication(): Context {
        return application
    }

}