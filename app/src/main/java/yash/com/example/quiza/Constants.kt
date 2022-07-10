package yash.com.example.quiza

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_Question"
    const val CORRECT_ANSWER: String = "correct_answer"



    fun getQuestion(): ArrayList<Question>{
        val questionsList = ArrayList < Question> ()
        val que1 = Question(
            1, "What Country does this flag belongs to?", R.drawable.one, "Russia", "Germany",
            "Ukraine","France",3
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "Which Sports is this?", R.drawable.two,"F1 Racing", "Nas Car", "Moto GP",
            "Tour De France",1
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "Which Car Company is this?" , R.drawable.three, "Lexus", "Citroen", "Subaru",
            "Diahatsu", 2
        )
        questionsList.add(que3)


        val que4 = Question(
            4, "Who is the Current Governor of Maharashtra?", R.drawable.fourth,
            "Bhagat Singh Koshyari", "Uddhav Thackeray", "Satya Pal Malik", "Sanjay Raut", 1
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "What does BBC stand for?", R.drawable.fifth, "British Broadcasting Corporation",
            "😏😏😏😏", "Big Block Chevy", "Beautiful British Columbia", 1
        )
        questionsList.add(que5)

        val que6 = Question(
            6,"Who was the first prime minister of India?", R.drawable.sixth, "Gulzarilal Nanda", "Lal Bahadur Shastri",
            "Jawaharlal Nehru", "Morarji Desai", 3
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "Which country is called the land of rising sun?", R.drawable.seventh, "Japan", "China",
            "Taiwan", "South Korea", 1
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "What is the most popular sport throughout the world?", R.drawable.eigth, "Football", "Soccer",
            "Cricket","Volleyball",2
        )
        questionsList.add(que8)

        val que9 = Question(
            9,"Which of the following birds is known for its intelligence?",R.drawable.ninth,"Kingfisher",
            "Crow", "Sparrow", "Owl",4
        )
        questionsList.add(que9)

        val que10 = Question(
            10, "Which women WTA world number ONE retired recently at a age of 25", R.drawable.tenth,
            "Venus Williams", "Steffi Graf", "Martina Hingis","Ashleigh Barty",4
        )
        questionsList.add(que10)

        return questionsList
    }


}