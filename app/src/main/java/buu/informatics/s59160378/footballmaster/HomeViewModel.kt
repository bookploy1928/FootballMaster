package buu.informatics.s59160378.footballmaster

import androidx.lifecycle.ViewModel

class HomeViewModel (): ViewModel() {

    var questions: Array<Question>
    var yourName:String

    init {
        yourName = ""
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
                textFact = "Liverpool is a UEFA Champion League")
        )
    }

    fun setName(name:String){
        yourName = name
    }

}