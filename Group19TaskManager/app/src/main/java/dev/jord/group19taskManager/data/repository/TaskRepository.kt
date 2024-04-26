package dev.jord.group19taskManager.data.repository

import dev.jord.group19taskManager.data.model.Task
import dev.jord.group19taskManager.data.model.User
import dev.jord.group19taskManager.util.UiState

interface TaskRepository {
    fun addTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit)
    fun updateTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit)
    fun deleteTask(task: Task, result: (UiState<Pair<Task,String>>) -> Unit)
    fun getTask(id: String, result: (UiState<Pair<Task,String>>) -> Unit)
    fun getTasks(user: User?, result: (UiState<List<Task>>) -> Unit)
    fun storeTasks(tasks: List<Task>, result: (UiState<String>) -> Unit)
}