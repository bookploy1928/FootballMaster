package buu.informatics.s59160378.footballmaster

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel(var questionsArr: Array<Question>,var yourName:String) : ViewModel(){

    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 10000L

    }
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val timer: CountDownTimer

    private val _onGameFinish = MutableLiveData<Boolean>()
    val onGameFinish: LiveData<Boolean>
        get() = _onGameFinish

    private val _onQuestionEmpty = MutableLiveData<Boolean>()
    val onQuestionEmpty: LiveData<Boolean>
        get() = _onQuestionEmpty

    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    var questionIndex = 0
    var questions = questionsArr.toMutableList()

    init {
        _onQuestionEmpty.value = questionsArr.isEmpty()
        if (questionsArr.isEmpty()) {
            currentQuestion = Question("", listOf(),"")
            answers = mutableListOf()
        } else {
            randomizeQuestions()
        }
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ONE_SECOND
            }
            override fun onFinish() {
                _currentTime.value = DONE
                _onGameFinish.value = true
            }
        }
        timer.start()
        _onGameFinish.value = false
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
        var checkString = "none"
        if(answerId == -1){
            checkString = "timeUp"
        }
        else if(answers[answerId] == questions[questionIndex].answers[0]){
            checkString = "correct"
        }else{
            checkString = "inCorrect"
        }
        questions.removeAt(questionIndex)
//        Timber.i(questions.size.toString())
        questionsArr = questions.toTypedArray()
        return  checkString
    }

    fun getCurrentQuestionFact() : String {
        return questions[questionIndex].textFact
    }

    fun onFinishNavigate(){
        _onGameFinish.value = false
        _onQuestionEmpty.value = false
    }

    override fun onCleared() {
        super.onCleared()
        // Cancel the timer
        timer.cancel()
    }



    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.

}