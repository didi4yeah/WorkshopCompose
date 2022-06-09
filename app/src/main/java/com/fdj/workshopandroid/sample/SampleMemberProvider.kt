package com.fdj.workshopandroid.sample

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.fdj.workshopandroid.domain.model.Member

class SampleMemberProvider : PreviewParameterProvider<Member> {
    override val values = sequenceOf(
        Member(
            name = "didi",
            team = Member.Team.PDV,
            pictureUrl = "https://images.app.goo.gl/HZA9sBKuhRgnFGro8",
        ), Member(
            name = "Olivier",
            team = Member.Team.PDV,
            pictureUrl = "https://images.app.goo.gl/St9CjHw1cE22S9eT7",
        )
    )
}