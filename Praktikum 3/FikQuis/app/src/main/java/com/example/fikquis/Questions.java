package com.example.fikquis;

public class Questions {

    private static String textQuestions[] = {
            "1. Jumlah Planet Dalam Tata Surya?",
            "2. Planet Terdekat Dari Matahari?",
            "3. Planet Terbesar Dalam Tata Surya?",
            "4. Planet Yang Memiliki Cincin? ",
            "5. Planet Terkecil Dalam Tata Surya?"
    };

    private static String multipleChoice[][]={
            {"6", "8", "10", "12"},
            {"Merkurius", "Bumi", "Neptunus", "Uranus"},
            {"Pluto","Bumi","Jupiter","Mars"},
            {"Venus","Saturnus","Bumi","Mars"},
            {"Merkurius","Mars","Neptunus","Bumi"}

    };
    private static String mCorrectAnswers[] = {"8","Merkurius","Jupiter","Saturnus","Merkurius"};

    public int getLength(){return textQuestions.length;}


    public String getQuestion(int a){
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num){
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}