import java.util.ArrayList;
import java.util.Collection;

public class Guild {

	ArrayList<Character> myGuild;
	private Toolbox tb = new Toolbox();
	
	public Guild() {
		myGuild = new ArrayList<Character>();
	}
	
	public void addMember(Character member) {//method that adds members to the guild
		myGuild.add(member);
	}
	
	public Collection<Character> getMembers() {//method that returns the guild members as a collection array list
		return myGuild;
	}
	
	public boolean hasAliveMembers() {//method that checks whether the guild has alive members
		for(Character i : myGuild) {
			if(i.isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	public Team getTeam(Team enemyTeam) {//method that groups five people from the guild into a team
		Team tempTeam = new StudentTeam("Guild Team");//creating the team
		int coin;
		if(myGuild.size() > 5) {//if the guild has more than 5 members
			for(int i = 0; i < myGuild.size(); i++) {//looping and tossing coin to choose randomly which member should be in the team
				coin = tb.getRandomInteger(2);
				if(coin == 1 && tempTeam.teamSize() < 5 && myGuild.get(i).isAlive()) {
					tempTeam.addMember(myGuild.get(i));
				} else {
					continue;
				}
			}
		} else {//if the guild has less than or 5 members everyone is in the team
			for(int i = 0; i < myGuild.size(); i++) {
				if(myGuild.get(i).isAlive()) {
					tempTeam.addMember(myGuild.get(i));
				}
			}
		}
		if(myGuild.size() > 5 && tempTeam.teamSize() < 5) {//if the guild has more than 5 members and after the random choosing the team is not full, the first 5 get in the team
			for(int i = 0; i < myGuild.size(); i++) {
				if(tempTeam.teamSize() < 5 && myGuild.get(i).isAlive()) {
					tempTeam.addMember(myGuild.get(i));
				}
			}
		}
		return tempTeam;
	}
}
