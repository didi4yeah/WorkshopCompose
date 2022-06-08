package com.fdj.workshopandroid.domain.model

import androidx.compose.ui.graphics.Color

data class Member(
    val name: String,
    val team: Team,
    val pictureUrl: String = ""
) {
    enum class Team(val color: Color) {
        PDV(Color.Blue),
        PSEL(Color.Red),
        HASARD(Color.Magenta)
    }
}