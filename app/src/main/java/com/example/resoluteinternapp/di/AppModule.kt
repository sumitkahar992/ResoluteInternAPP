package com.example.resoluteinternapp.di

import android.app.Application
import androidx.room.Room
import com.example.resoluteinternapp.data.database.TeaDatabase
import com.example.resoluteinternapp.data.repository.TeaRepositoryImpl
import com.example.resoluteinternapp.domain.repository.TeaRepository
import com.example.resoluteinternapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): TeaDatabase {
        return Room.databaseBuilder(application, TeaDatabase::class.java, "tea").build()
    }


    @Provides
    @Singleton
    fun provideRepository(
        teaDatabase: TeaDatabase
    ): TeaRepository {
        return TeaRepositoryImpl(teaDatabase.taskDAO())
    }


    @Provides
    @Singleton
    fun provideGetAllTaskUseCase(repository: TeaRepository): GetAllTaskUseCase {
        return GetAllTaskUseCaseImpl(repository)
    }


    @Provides
    @Singleton
    fun provideSaveTaskUseCase(repository: TeaRepository): SaveTaskUseCase {
        return SaveTaskUseCaseImpl(repository)
    }


    @Provides
    @Singleton
    fun provideGetTaskByIdUseCase(repository: TeaRepository): GetTaskByIdUseCase {
        return GetTaskByIdUseCaseImpl(repository)
    }


    @Provides
    @Singleton
    fun provideDeleteTaskUseCase(repository: TeaRepository): DeleteTaskUseCase {
        return DeleteTaskUseCaseImpl(repository)
    }


}