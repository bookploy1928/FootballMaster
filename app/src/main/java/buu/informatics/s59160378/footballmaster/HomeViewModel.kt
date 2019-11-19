package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber

class HomeViewModel (): ViewModel() {

    var questions: Array<Question>
    var score:Int

    private val _yourName = MutableLiveData<String>()
    val yourName: LiveData<String>
        get() = _yourName

    val startButtonVisible = Transformations.map(yourName) {
        Timber.i("changed")
        it != ""
    }

    init {
        _yourName.value = ""
        score = 0
        questions = arrayOf(
            Question(text = "You'll Never Walk Alone.Is a song of praise of any football club?",
                answers = listOf("Liverpool","Manchester United", "Manchester City",  "Chelsea"),
                textFact = "You'll Never Walk Alone is the song of the Liverpool footbal club"),
            Question(text = "World Cup 2018. Who is hosting?",
                answers = listOf("Russia", "Brazil", "France", "Thailand"),
                textFact = "Russia is the country that hosts the World Cup 2018."),
            Question(text = "What team is the 2018 World Cup champion?",
                answers = listOf("France", "Brazil", "Russia", "Argentina"),
                textFact = "France is the country that won the World Cup 2018."),
            Question(text = "The most expensive player in the world?",
                answers = listOf("Kylian Mbappe", "Mohamed Salah", "Raheem Sterling", "Lionel Messi"),
                textFact = "The most expensive player in the world is Kylian Mbappe."),
            Question(text = "What team is the UEFA Champions league?",
                answers = listOf("Liverpool", "Barcelona", "Juventus", "Manchester United"),
                textFact = "Liverpool is a UEFA Champion League"),
            Question(text = "Test?",
                answers = listOf("test", "Barcelona", "Juventus", "Manchester United"),
                textFact = "Test")
        )
    }

    fun setName(name:String){
       _yourName.value = name
    }

}