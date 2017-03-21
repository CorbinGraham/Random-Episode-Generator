//Generates a Random Season and Episode of the Simpsons
import java.util.Random;
import java.util.LinkedList;
import java.io.*;

public class SimpsonsEpisodeGenerator{
	public static LinkedList<EpisodeObject> episodeNameAndNumber[] = (LinkedList<EpisodeObject>[]) new LinkedList<?>[28];;
	
	public static void main(String[] args){
		
		for(int i = 0; i < episodeNameAndNumber.length; i++){
			if(episodeNameAndNumber[i] == null){
				episodeNameAndNumber[i] = new LinkedList<EpisodeObject>();
			}
		}
		
		try{
			readInEpisodesFile();
		}catch(Exception e){
			System.err.println(e);
		}
		
		Random randomGenerator = new Random();
		int season = randomGenerator.nextInt(27) + 1;
		int episode = generateEpisode(randomGenerator, season);
		
		printEpisodeDetails(season, episode);
	}
	
	public static int generateEpisode(Random randomGenerator, int season){
		
		switch(season){
			case 1:
				return randomGenerator.nextInt(13) + 1;
			case 19:
				return randomGenerator.nextInt(20) + 1;
			case 12:
			case 16:
			case 20:
				return randomGenerator.nextInt(21) + 1;
			case 2:
			case 4:
			case 5:
			case 11:
			case 13:
			case 14:
			case 15:
			case 17:
			case 18:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
				return randomGenerator.nextInt(22) + 1;
			case 10:
			case 21:
				return randomGenerator.nextInt(23) + 1;
			case 3:
				return randomGenerator.nextInt(24) + 1;
			case 6:
			case 7:
			case 8:
			case 9:
				return randomGenerator.nextInt(25) + 1;
			default:
				return 0;
		}

	}
	
	
	public static void readInEpisodesFile() throws IOException{
		FileReader reader  = new FileReader("episodeNumbersandNames.txt");
		BufferedReader input = new BufferedReader(reader);
		String currentLine;
		
		FileReader bioReader  = new FileReader("episodeBiosFinal.txt");
		BufferedReader bioInput = new BufferedReader(bioReader);
		String bioCurrentLine;
		
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
				if((bioCurrentLine = bioInput.readLine()) != null){
					while(bioCurrentLine.isEmpty()){
						bioCurrentLine = bioInput.readLine();
					}
					episodeAiringNumber = Integer.parseInt(currentLineSplit[0]);
					episodeSeasonNumber = Integer.parseInt(currentLineSplit[1]);
					episodeName = nameQuoteSplit[1];
				
					episodeNameAndNumber[currentSeasonNumber - 1].add(new EpisodeObject(episodeAiringNumber, episodeSeasonNumber, currentSeasonNumber, episodeName, bioCurrentLine));
				}
			}
		}input.close();
		bioInput.close();
	}
	
	
	public static void printEpisodeDetails(int season, int episode){
		System.out.println(episodeNameAndNumber[season - 1].get(episode - 1).getEpisodeName());
		System.out.printf("Season: %s Episode: %s\n",season,episode);
		System.out.println("Episode Bio: " + episodeNameAndNumber[season - 1].get(episode - 1).getEpisodeBio());
		
	}
	
	

}
