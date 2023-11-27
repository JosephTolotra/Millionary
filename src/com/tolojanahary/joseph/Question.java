package com.tolojanahary.joseph;

public class Question
{
    public String mQuestions [] = {
		"Iza no filoham-pirenena amin'izao fotoana izao?",
		"Aiza no toerana betsaka mpizaha tany eto Madagasikara?",
		
		"Iza no Piraiminisitra tamin'ny 2019?",
		"Repoblika faha-firy isika izao?",
		"Firy ny faritra misy eto Fianaratsoa?",
		"Iza no Renirano farany lava eto madagascar?",
		"Lalam-pirenena faha-firy no mampitohy ny tana-fianara-tulear?",
		"Iza no mahay baolina indrindra maneratany??",
		"Iza no mpanazatra ny barea nandritran'ny CAN 2019 ?",
		"Tamin'ny taona firy no sambany mba nandray anjara amin'izany CAN izany ny Barea?",
		"Iza no Renivohitry MADAGASIKARA?",
		"Iza no kapiteny vaovao ni BAREA?","Iza no olona farany manakarena eto Madagasikara?",
		"Taiza no klioba nilalaovan'i Jeremy Morel tany amin'ny Ligue 1 tamin'ny taom-pilalaovana 2019?",
		"T@ny taona firy no nahazo ni fahaleovan-tena i Madagasikara?",
		"Iza no renivohitra ara-toekaren'i Madagasikara?",
		"Iza no mpanjaka farany nanjaka teto Madagasikara?",
		"Inona no anarany anime(manga) misy an'ny Madagasikara?"
   
	};
	private String mChoices [][]= {
		{"Rajoelina Andry","Tsiranana Philbert","Rajaonarimampianina Hery","Ravalomanana Marc"},
	    {"Isalo","Nosy be","St marie","Ranomafana"},
		{"Ntsay Christian","Camy Vital","Jean Omer Belijik","Christine Razanamahasoa"},
		{"faha-3","faha-4","faha-5","faha-2"},
		{"22","2","4","10"},
		{"Onilahy","Matsiatra","Ikopa","Mangoky"},
		{"RN2","RN34","RN7","RN4"},
		{"Faneva Ima","C.Ronaldo","Messi","Neymar"},
        {"Nicolas Dupuis","Zinedine Zidane","Voavy Paulin","Valverde"},
		{"1960","2014","2021","2019"},
		 {"Fianarantsoa","Toamasina","Antananarivo","Atsiranana"},
		{"Marco Ilaimaharitra","Jérome Mombris","Anicet","Faneva Ima"},
		{"Ravalomanana Marc","Akbaraly","Andry Rajoelina","Mbola Rajaona"},
		{"Olympic lyonnais","Marseille","OGC Nice","stade rennais"},  
		{"1960","2014","1947","2019"},
		{"Antananarivo","Fianarantsoa","Atsiranana","Toamasina"},
		{"Radama II","Andrianamponimerina","Rasoherina","Ranavalona III"},
		{"One piece","the king of prisme","peguin de madagascar","Madagascar"}}
;
	private String mCorrectAnsewrs [] = {
		"Rajoelina Andry",
		"Nosy be",
		"Ntsay Christian",
		"faha-4",
		"4",
		"Mangoky",
		"RN7",
		"C.Ronaldo",
		"Nicolas Dupuis",
		"2019",
		"Antananarivo",
		"Anicet",
		"Akbaraly",
		"Stade Rennais",
		"1960",
		"Toamasina",
		"Ranavalona III",
		"The king of prisme"
	};
	
	public String getQuestion (int a){
		String question= mQuestions[a];
		return question;
	}
	
	public String getChoice1 (int a) {
		String choice = mChoices[a][0];
		return choice;
	}
	public String getChoice2 (int a) {
		String choice1 = mChoices[a][1];
		return choice1;
	}
	public String getChoice3 (int a) {
		String choice2 = mChoices[a][2];
		return choice2;
	}
	public String getChoice4 (int a) {
		String choice3 = mChoices[a][3];
		return choice3;
	}
	public String getCorrectAnsewrs (int a) {
		String answer = mCorrectAnsewrs[a];
		return answer;
	}
}