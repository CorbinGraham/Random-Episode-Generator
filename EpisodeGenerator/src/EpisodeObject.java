
public class EpisodeObject {
	private int episodeAiringNumber;
	private int episodeSeasonNumber;
	private int	seasonNumber;
	private String episodeName;
	private String episodeBio;
	
	public EpisodeObject(int a, int b, int c, String d, String e){
		episodeAiringNumber = a;
		episodeSeasonNumber = b;
		seasonNumber = c;
		episodeName = d;
		episodeBio = e;
	}
	
	public int getAiringNumber(){return episodeAiringNumber;}
	
	public int getEpisodeSeasonNumber(){return episodeSeasonNumber;}
	
	public int getSeasonNumber(){return seasonNumber;}
	
	public String getEpisodeName(){return episodeName;}
	
	public String getEpisodeBio(){return episodeBio;}
}
