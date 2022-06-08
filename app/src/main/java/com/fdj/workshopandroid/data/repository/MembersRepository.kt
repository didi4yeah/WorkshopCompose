package com.fdj.workshopandroid.data.repository

import com.fdj.workshopandroid.domain.model.Member

class MembersRepository {

    private val members = listOf(
        Member(
            name = "Brieuc",
            team = Member.Teams.HASARD,
            pictureUrl = "https://media-exp2.licdn.com/dms/image/C5603AQGzWvMR642q2A/profile-displayphoto-shrink_400_400/0/1516983318263?e=1660176000&v=beta&t=zph7PIlmculLSyYJ5y5TGWhEwVwz-k4FnOO5jUogY5c",
        ), Member(
            name = "Vincent",
            team = Member.Teams.PDV,
            pictureUrl = "https://media-exp2.licdn.com/dms/image/C4D03AQE2T7gjXBc8qQ/profile-displayphoto-shrink_400_400/0/1603623198984?e=1660176000&v=beta&t=MtBOkWM5j93hTaRZUYbXZFiUDIRCfx1pbuYCE0xxNsU",
        ), Member(
            name = "Joris",
            team = Member.Teams.PSEL,
            pictureUrl = "https://media-exp2.licdn.com/dms/image/C4E03AQFkFy09eFaSsg/profile-displayphoto-shrink_400_400/0/1616615340025?e=1660176000&v=beta&t=Kmu8DAtGFrzGEcU6BX_PctBOFXuIIjBjDSC4r2IHaNc",
        )
    )

    fun fetchAllMembers() = members
}