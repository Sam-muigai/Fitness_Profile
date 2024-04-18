@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.hnf_profile.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.hnf_profile.SearchBarViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar_n_ContentCards(
    navController: NavController
){

    val viewModel= viewModel<SearchBarViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val topics by viewModel.topics.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top=16.dp, start = 16.dp, end=16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                ,placeholder = { Text(text = "Search") },
                leadingIcon = { Icon(Icons.Default.Search,
                    contentDescription = "search")},
                colors = TextFieldDefaults.textFieldColors( // Set text color
                    cursorColor = Color(0xFF008ACC),
                    containerColor = Color.Transparent,
                    focusedTextColor = Color(0xFF00CED1),
                    unfocusedTextColor =Color(0xFF008ACC),
                    focusedIndicatorColor = Color(0xFF00CED1),
                    unfocusedIndicatorColor =Color(0xFF008ACC),
                    unfocusedLeadingIconColor = Color(0xFF008ACC),
                    focusedLeadingIconColor = Color(0xFF00CED1),
                    unfocusedPlaceholderColor = Color(0xFF008ACC),
                    focusedPlaceholderColor = Color(0xFF00CED1),
                ),
                shape = RoundedCornerShape(12.dp)

            )
            if(isSearching){
                Box(modifier = Modifier.fillMaxSize()){
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFF00CED1)
                    )
                }
            }else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        //.padding(top = 16.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(topics) { topic ->
                        ContentCards2(exerciseName = topic.name, navController)
//                        ContentCards(image = painterResource(id = topic.imageResourceId),
//                            exerciseName = topic.name)
                    }
                }
            }
        }
    }
}