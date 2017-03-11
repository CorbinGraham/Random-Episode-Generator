
public class EpisodeObject {
	private int episodeAiringNumber;
	private int episodeSeasonNumber;
	private int	seasonNumber;
	private String episodeName;
	public EpisodeObject(int a, int b, int c, String d){
		episodeAiringNumber = a;
		episodeSeasonNumber = b;
		seasonNumber = c;
		episodeName = d;
	}
	public int getAiringNumber(){return episodeAiringNumber;}
	
	public int getEpisodeSeasonNumber(){return episodeSeasonNumber;}
	
	public int getSeasonNumber(){return seasonNumber;}
	
	public String getEpisodeName(){return episodeName;}
}
