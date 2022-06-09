package com.fdj.workshopandroid.presentation.members

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fdj.workshopandroid.R
import com.fdj.workshopandroid.domain.model.Member
import com.fdj.workshopandroid.sample.SampleMemberProvider
import com.fdj.workshopandroid.ui.theme.WorkShopAndroidTheme
import com.skydoves.landscapist.glide.GlideImage

class MembersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkShopAndroidTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MembersScreen()
                }
            }
        }
    }
}

@Composable
fun MembersScreen(viewModel: MembersViewModel = viewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MembersList(viewModel)
        Spacer(modifier = Modifier.size(50.dp))
        Button(onClick = { viewModel.shuffleMembers() }) {
            Text(text = "Try")
        }
    }
}

@Composable
fun MembersList(viewModel: MembersViewModel) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is MembersUiState.Error -> Error(state.error)
        is MembersUiState.Success -> MembersLoaded(state.members)
        MembersUiState.Loading -> LoadingProgress()
    }
}

@Preview
@Composable
fun LoadingProgress() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(100.dp))
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.size(100.dp))
    }
}

@Composable
fun Error(error: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = error)
    }
}

@Composable
fun MembersLoaded(members: List<Member>) {
    LazyColumn() {
        items(items = members) {
            MembersListItem(member = it)
        }
    }
}

@Preview(name = "MemberItem", showBackground = true)
@Composable
fun MembersListItem(@PreviewParameter(SampleMemberProvider::class, 2) member: Member) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            MemberImage(member.pictureUrl)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                with(member) {
                    Text(text = this.name, style = MaterialTheme.typography.h6)
                    Text(text = this.team.name, style = MaterialTheme.typography.body1, color = this.team.color)
                }
            }
        }
    }
}

@Composable
fun MemberImage(pictureUrl: String) {
    GlideImage(
        imageModel = pictureUrl,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(CircleShape),
        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
        error = ImageBitmap.imageResource(R.drawable.placeholder)
    )
}

@Preview(name = "Screen", showBackground = true)
@Composable
fun DefaultPreview() {
    WorkShopAndroidTheme {
        MembersLoaded(
            members = listOf(
                Member(name = "David", team = Member.Team.PDV, pictureUrl = "error"),
                Member(name = "Vincent", team = Member.Team.PDV, pictureUrl = "error"),
                Member(name = "Olivier", team = Member.Team.PDV, pictureUrl = "error")
            )
        )
    }
}