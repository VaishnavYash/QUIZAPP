package yash.com.example.quiza

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*


class QuizQuestion : AppCompatActivity(), View.OnClickListener {





    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList <Question>?= null
    private var mSelectedOptionPosition : Int = 0

    private var mUserName: String?=null
    private var mCorrectAnswers: Int = 0

    private var progressBar : ProgressBar?=null
    private var tvProgress: TextView?=null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var butSum : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.proBar)
        ivImage = findViewById(R.id.tvImage)
        tvQuestion = findViewById(R.id.questionsText)
        tvProgress = findViewById(R.id.questionProgress)

        tvOptionOne = findViewById(R.id.optionOne)
        tvOptionTwo = findViewById(R.id.optionTwo)
        tvOptionThree = findViewById(R.id.optionThree)
        tvOptionFour = findViewById(R.id.optionFour)
        butSum = findViewById(R.id.buttonSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        butSum?.setOnClickListener(this)


        mQuestionList = Constants.getQuestion()

        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition==mQuestionList!!.size){
            butSum?.text="FINISH"
        }else{
            butSum?.text="NEXT"
        }

    }

    private fun defaultOptionView(){

        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }


    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.correct_option_bg
        )

    }

    private var p: Boolean = false

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                tvOptionOne?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.optionTwo -> {
                tvOptionTwo?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.optionThree -> {
                tvOptionThree?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.optionFour -> {
                tvOptionFour?.let{
                    selectedOptionView(it, 4)
                }
            }

            R.id.buttonSubmit -> {

                   if(mSelectedOptionPosition==0){
                       Toast.makeText(this, "Please select one Option", Toast.LENGTH_LONG).show()
                   }else {

                       val question = mQuestionList?.get(mCurrentPosition-1)

                       if(question!!.correctOpt !=mSelectedOptionPosition){
                           answerView(mSelectedOptionPosition, R.drawable.wrong_correct_option_border_bg)
                       }else{
                           mCorrectAnswers++
                       }
                       answerView(question.correctOpt, R.drawable.right_correct_option_border_bg)

                       butSum?.isEnabled = false
                       butSum?.postDelayed(Runnable {
                           butSum?.isEnabled = true

                           mCurrentPosition++
                           when {
                               mCurrentPosition <= mQuestionList!!.size -> {
                                   setQuestion()
                               }
                               else -> {
                                   val intent = Intent(this, LastPage::class.java)
                                   intent.putExtra(Constants.USER_NAME, mUserName)
                                   intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                                   intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                                   startActivity(intent)
                                   finish()
                               }
                           }
                       }, 1000)

                       mSelectedOptionPosition =0

                   }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
         when(answer) {
             1 -> {
                 tvOptionOne?.background = ContextCompat.getDrawable(
                     this,
                     drawableView
                 )
             }
             2 -> {
                 tvOptionTwo?.background = ContextCompat.getDrawable(
                     this,
                     drawableView
                 )
             }
             3 -> {
                 tvOptionThree?.background = ContextCompat.getDrawable(
                     this,
                     drawableView
                 )
             }
             4 -> {
                 tvOptionFour?.background = ContextCompat.getDrawable(
                     this,
                     drawableView
                 )
             }
        }
    }
}

private fun <E> ArrayList<E>.add(index: E, element: TextView) {

}
