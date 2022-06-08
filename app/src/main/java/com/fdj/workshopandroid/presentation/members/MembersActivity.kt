package com.fdj.workshopandroid.presentation.members

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fdj.workshopandroid.ui.theme.WorkShopAndroidTheme

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
fun MembersScreen() {

}

@Preview(name = "Screen", showBackground = true)
@Composable
fun DefaultPreview() {
    WorkShopAndroidTheme {

    }
}