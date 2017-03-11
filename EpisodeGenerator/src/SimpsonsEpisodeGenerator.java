//Generates a Random Season and Episode of the Simpsons
import java.util.Random;
import java.util.LinkedList;
import java.io.*;

public class SimpsonsEpisodeGenerator{
	public static LinkedList<EpisodeObject> episodeBios[] = (LinkedList<EpisodeObject>[]) new LinkedList<?>[28];;
	
	public static void main(String[] args){
		
		for(int i = 0; i < episodeBios.length; i++){
			if(episodeBios[i] == null){
				episodeBios[i] = new LinkedList<EpisodeObject>();
			}
		}
		
		try{
			readInFile();
		}catch(Exception e){
			System.err.println(e);
		}
		
		Random randomGenerator = new Random();
		int season = randomGenerator.nextInt(27) + 1;
		int episode = generateEpisode(randomGenerator, season);
		
		printEpisodeDetails(season, episode);
	}
	
	public static int generateEpisode(Random randomGenerator, int season){
		if(season == 1){
			return randomGenerator.nextInt(13) + 1;
		}else if(season == 2 || season == 4 || season == 5 || season == 11 || season == 13 || season == 14 || season == 15 || season == 17 || season == 18 || season == 22 || season == 23 || season == 24 || season == 25 || season == 26 || season == 27){
			return randomGenerator.nextInt(22) + 1;
		}else if(season == 3){
			return randomGenerator.nextInt(24) + 1;
		}else if(season == 6 || season == 7 || season == 8 || season == 9){
			return randomGenerator.nextInt(25) + 1;
		}else if(season == 10 || season == 21){
			return randomGenerator.nextInt(23) + 1;
		}else if(season == 12 || season == 16 || season == 20){
			return randomGenerator.nextInt(21) + 1;
		}else if(season == 19){
			return randomGenerator.nextInt(20) + 1;
		}else{
			return 0;
		}
	}
	
	
	public static void readInFile() throws IOException{
		FileReader reader  = new FileReader("episodeNumbersandNames.txt");
		BufferedReader input = new BufferedReader(reader);
		String currentLine;
		
		//The first string array will be used to split current line into 3 seperate arrays based on the location of quotation marks which are only ever around the title of an episode
		String [] nameQuoteSplit = new String[3];
		String [] currentLineSplit = new String[20];
		
		int currentSeasonNumber = 1;
		int episodeAiringNumber;
		int episodeSeasonNumber;
		String episodeName;
		
		while((currentLine = input.readLine()) != null){
			nameQuoteSplit = currentLine.split("\"");
			currentLineSplit = nameQuoteSplit[0].split("\\s+");
			
			if(currentLineSplit[0].equals("Season")){
				currentSeasonNumber = Integer.parseInt(currentLineSplit[1]);
			}
			else{
				episodeAiringNumber = Integer.parseInt(currentLineSplit[0]);
				episodeSeasonNumber = Integer.parseInt(currentLineSplit[1]);
				episodeName = nameQuoteSplit[1];
				
				episodeBios[currentSeasonNumber - 1].add(new EpisodeObject(episodeAiringNumber, episodeSeasonNumber, currentSeasonNumber, episodeName));
				
			}
		}input.close();
	}
	
	public static void printEpisodeDetails(int season, int episode){
		System.out.println(episodeBios[season - 1].get(episode - 1).getEpisodeName());
		System.out.printf("Season: %s Episode: %s",season,episode);
		
	}
	
	

}
