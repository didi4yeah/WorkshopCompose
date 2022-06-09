package com.fdj.workshopandroid.presentation.members

import com.fdj.workshopandroid.domain.model.Member

sealed class MembersUiState {
    object Loading: MembersUiState()
    class Success(val members: List<Member>) : MembersUiState()
    class Error(val error: String): MembersUiState()
}