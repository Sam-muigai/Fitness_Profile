package com.example.hnf_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

@OptIn(FlowPreview::class)
class SearchBarViewModel: ViewModel() {

    private val _searchText= MutableStateFlow("")

    val searchText=_searchText.asStateFlow()

    private val _isSearching= MutableStateFlow(false)
    val isSearching= _isSearching.asStateFlow()

    private val _topics= MutableStateFlow(allExercises)
    val topics=searchText
        .onEach { _isSearching.update { true } }
        .debounce(1000L)
        .combine(_topics){text, allExercises->
            if(text.isBlank()){
                allExercises
            }else{
                allExercises.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _topics.value
        )

    fun onSearchTextChange(text:String){
        _searchText.value=text
    }
}

data class Exercise(
    val name:String,
    val imageResoucreId: Int
){
    fun doesMatchSearchQuery(query:String):Boolean{
        return name.contains(query,ignoreCase = true)
    }
}

private val allExercises = listOf(
    Exercise(name = "Running", imageResoucreId = R.drawable.running),
    Exercise(name = "Jogging", imageResoucreId = R.drawable.running),
    Exercise(name = "Walking", imageResoucreId = R.drawable.running),
    Exercise(name = "Cycling", imageResoucreId = R.drawable.running),
    Exercise(name = "Swimming", imageResoucreId = R.drawable.running),
    Exercise(name = "Jump rope", imageResoucreId = R.drawable.running),
    Exercise(name = "High-Intensity Interval Training (HIIT)", imageResoucreId = R.drawable.running),
    Exercise(name = "Dancing", imageResoucreId = R.drawable.running),
    Exercise(name = "Rowing", imageResoucreId = R.drawable.running),
    Exercise(name = "Elliptical training", imageResoucreId = R.drawable.running),
    Exercise(name = "Squats", imageResoucreId = R.drawable.running),
    Exercise(name = "Lunges", imageResoucreId = R.drawable.running),
    Exercise(name = "Deadlifts", imageResoucreId = R.drawable.running),
    Exercise(name = "Bench press", imageResoucreId = R.drawable.running),
    Exercise(name = "Push-ups", imageResoucreId = R.drawable.running),
    Exercise(name = "Pull-ups", imageResoucreId = R.drawable.running),
    Exercise(name = "Dumbbell curls", imageResoucreId = R.drawable.running),
    Exercise(name = "Tricep dips", imageResoucreId = R.drawable.running),
    Exercise(name = "Leg press", imageResoucreId = R.drawable.running),
    Exercise(name = "Planks", imageResoucreId = R.drawable.running),
    Exercise(name = "Crunches", imageResoucreId = R.drawable.running),
    Exercise(name = "Bicycle crunches", imageResoucreId = R.drawable.running),
    Exercise(name = "Russian twists", imageResoucreId = R.drawable.running),
    Exercise(name = "Leg raises", imageResoucreId = R.drawable.running),
    Exercise(name = "Mountain climbers", imageResoucreId = R.drawable.running),
    Exercise(name = "Flutter kicks", imageResoucreId = R.drawable.running),
    Exercise(name = "Side planks", imageResoucreId = R.drawable.running),
    Exercise(name = "Woodchoppers", imageResoucreId = R.drawable.running),
    Exercise(name = "Superman", imageResoucreId = R.drawable.running),
    Exercise(name = "Hanging leg raises", imageResoucreId = R.drawable.running),
    Exercise(name = "Yoga", imageResoucreId = R.drawable.running),
    Exercise(name = "Pilates", imageResoucreId = R.drawable.running),
    Exercise(name = "Static stretching", imageResoucreId = R.drawable.running),
    Exercise(name = "Dynamic stretching", imageResoucreId = R.drawable.running),
    Exercise(name = "Tai Chi", imageResoucreId = R.drawable.running),
    Exercise(name = "Foam rolling", imageResoucreId = R.drawable.running),
    Exercise(name = "Resistance band stretches", imageResoucreId = R.drawable.running),
    Exercise(name = "Calf stretches", imageResoucreId = R.drawable.running),
    Exercise(name = "Hip flexor stretches", imageResoucreId = R.drawable.running),
    Exercise(name = "Shoulder stretches", imageResoucreId = R.drawable.running),
    Exercise(name = "Bosu ball exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Stability ball exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Single-leg balance exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Yoga balance poses", imageResoucreId = R.drawable.running),
    Exercise(name = "Stability exercises on a balance board", imageResoucreId = R.drawable.running),
    Exercise(name = "Bird-dog exercise", imageResoucreId = R.drawable.running),
    Exercise(name = "Stability ball rollouts", imageResoucreId = R.drawable.running),
    Exercise(name = "Medicine ball twists", imageResoucreId = R.drawable.running),
    Exercise(name = "Farmer's walk", imageResoucreId = R.drawable.running),
    Exercise(name = "Standing on one leg with eyes closed", imageResoucreId = R.drawable.running),
    Exercise(name = "Box jumps", imageResoucreId = R.drawable.running),
    Exercise(name = "Burpees", imageResoucreId = R.drawable.running),
    Exercise(name = "Jump squats", imageResoucreId = R.drawable.running),
    Exercise(name = "Plyometric push-ups", imageResoucreId = R.drawable.running),
    Exercise(name = "Medicine ball slams", imageResoucreId = R.drawable.running),
    Exercise(name = "Tuck jumps", imageResoucreId = R.drawable.running),
    Exercise(name = "Lateral jumps", imageResoucreId = R.drawable.running),
    Exercise(name = "Depth jumps", imageResoucreId = R.drawable.running),
    Exercise(name = "Skater jumps", imageResoucreId = R.drawable.running),
    Exercise(name = "Jumping lunges", imageResoucreId = R.drawable.running),
    Exercise(name = "Kettlebell swings", imageResoucreId = R.drawable.running),
    Exercise(name = "TRX exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Battle ropes", imageResoucreId = R.drawable.running),
    Exercise(name = "Sled pushes", imageResoucreId = R.drawable.running),
    Exercise(name = "Sandbag training", imageResoucreId = R.drawable.running),
    Exercise(name = "Tire flips", imageResoucreId = R.drawable.running),
    Exercise(name = "Farmer's carry", imageResoucreId = R.drawable.running),
    Exercise(name = "Bear crawls", imageResoucreId = R.drawable.running),
    Exercise(name = "Agility ladder drills", imageResoucreId = R.drawable.running),
    Exercise(name = "Tai Chi", imageResoucreId = R.drawable.running),
    Exercise(name = "Qigong", imageResoucreId = R.drawable.running),
    Exercise(name = "Mindful walking", imageResoucreId = R.drawable.running),
    Exercise(name = "Body scan meditation", imageResoucreId = R.drawable.running),
    Exercise(name = "Progressive muscle relaxation", imageResoucreId = R.drawable.running),
    Exercise(name = "Deep breathing exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Visualization exercises", imageResoucreId = R.drawable.running),
    Exercise(name = "Tai Chi", imageResoucreId = R.drawable.running),
    Exercise(name = "Mindful yoga", imageResoucreId = R.drawable.running),
    Exercise(name = "Pilates", imageResoucreId = R.drawable.running)
)