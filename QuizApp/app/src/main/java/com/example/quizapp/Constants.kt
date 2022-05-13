package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val qList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina, // images are represented as Ints
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        qList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )

        qList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )

        qList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )

        qList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "None of these",
            1
        )

        qList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )

        qList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Russia",
            3
        )

        qList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "Iran",
            "Hungary",
            "India",
            4
        )

        qList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Philippines",
            "United Kingdom",
            "South Africa",
            1
        )

        qList.add(que9)

        val que10 = Question(
            10,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Sudan",
            "Saudi Arabia",
            "Israel",
            "Kuwait",
            4
        )

        qList.add(que10)

        return qList
    }
}