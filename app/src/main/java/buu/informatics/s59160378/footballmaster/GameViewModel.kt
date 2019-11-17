package buu.informatics.s59160378.footballmaster

import android.provider.Settings.Global.getString
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel : ViewModel(){
    data class Question(
        val text: String,
        val answers: List<String>,
        val textFact: String

    )

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    val questions: MutableList<Question>

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    var questionIndex = 0
    var numQuestions = 0


    init {
       questions = mutableListOf(
            Question(text = "You'll Never Walk Alone.Is a song of praise of any football club?",
                answers = listOf("Manchester United", "Manchester City", "Liverpool", "Chelsea"),
                textFact = "Testttttttttttt111t"),
            Question(text = "World Cup 2018. Who is hosting?",
                answers = listOf("Russia", "Brazil", "France", "Thailand"),
                textFact = "Testtttttttttttt111"),
            Question(text = "What team is the 2018 World Cup champion?",
                answers = listOf("France", "Brazil", "Russia", "Argentina"),
                textFact = "Testtttttttttttt111"),
            Question(text = "The most expensive player in the world?",
               answers = listOf("Kylian Mbappe", "Mohamed Salah", "Raheem Sterling", "Lionel Messi"),
                textFact = "Testtttttttttttt1111"),
            Question(text = "What team is the uefa champions league?",
               answers = listOf("Liverpool", "Barcelona", "Juventus", "Manchester United"),
                textFact = "Testtttttttttttt1111555")


        )

        numQuestions = Math.min((questions.size + 1) / 2, 3)
        randomizeQuestions()
    }


    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
    }

    fun answerCheck(answerId:Int) : String{
        return currentQuestion.textFact
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.

}