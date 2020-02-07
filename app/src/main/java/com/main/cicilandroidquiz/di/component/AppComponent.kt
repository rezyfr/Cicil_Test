package com.main.cicilandroidquiz.di.component

import android.app.Application
import com.main.cicilandroidquiz.App
import com.main.cicilandroidquiz.di.builder.ActivityBuilder
import com.main.cicilandroidquiz.di.module.AppModule
import com.main.cicilandroidquiz.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityBuilder::class,
        AppModule::class, NetworkModule::class]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}