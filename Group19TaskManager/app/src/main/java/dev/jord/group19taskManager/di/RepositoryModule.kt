package dev.jord.group19taskManager.di

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jord.group19taskManager.data.repository.AuthRepository
import dev.jord.group19taskManager.data.repository.AuthRepositoryImplementation
import dev.jord.group19taskManager.data.repository.TaskRepository
import dev.jord.group19taskManager.data.repository.TaskRepositoryImplementation
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(
        database: FirebaseFirestore,
        auth: FirebaseAuth,
        appPreferences: SharedPreferences,
        gson: Gson
    ): AuthRepository {
        return AuthRepositoryImplementation(auth,database,appPreferences,gson)
    }

    @Provides
    @Singleton
    fun ProvidesTaskRepository(
        database: FirebaseFirestore,
        auth: FirebaseAuth,
    ): TaskRepository {
        return TaskRepositoryImplementation(auth,database)
    }
}