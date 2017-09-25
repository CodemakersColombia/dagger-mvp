package codemakers.daggermvp.di

import codemakers.daggermvp.ui.main.MainActivity
import codemakers.daggermvp.di.modules.MainModule
import codemakers.daggermvp.ui.add.AddActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun bindAddActivity(): AddActivity

}
