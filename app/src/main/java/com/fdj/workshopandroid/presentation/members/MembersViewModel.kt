package com.fdj.workshopandroid.presentation.members

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fdj.workshopandroid.data.repository.MembersRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MembersViewModel(
    private val repository: MembersRepository = MembersRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<MembersUiState>(MembersUiState.Loading)
    val uiState: StateFlow<MembersUiState> = _uiState

    init {
        fetchMembers()
    }

    fun shuffleMembers() = fetchMembers()

    private fun fetchMembers() {
        _uiState.value = MembersUiState.Loading
        viewModelScope.launch {
            try {
                delay(1500)
                val members = repository.fetchAllMembers().shuffled()
                _uiState.value = MembersUiState.Success(
                    members = members
                )
            } catch (ex: Exception) {
                _uiState.value = MembersUiState.Error("Dommage")
            }
        }
    }
}



