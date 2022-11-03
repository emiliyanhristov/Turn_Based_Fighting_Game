import java.util.ArrayList;
import java.util.Collections;

public class Battle {

	Team team1;
	Team team2;
	ArrayList<Character> battlePart;//list with the participants in the battle
	
	public Battle(Team team1, Team team2) {//constructor with the two teams that engage into battle
		this.team1 = team1;
		this.team2 = team2;
		battlePart = new ArrayList<Character>();
	}
	
	/* Method to specify how the fight goes. It prints what round it is. It puts the
	 * remaining alive members of the teams into an array list and sorts it by speed
	 * then checks from which team an element of the sorted speed array is and fights
	 * it with the other team. At the end of a move or round it checks whether one of the
	 * teams has lost and if so it returns the other team as a winner. If after 30 rounds
	 * there is no winner the battle is a draw and null is returned.
	 */
	
	public Team fight() throws Exception{
		for(int i = 1; i <= 30; i++) {
			System.out.println("ROUND " + i);
			System.out.println();
			//two checks to remove the dead members from the fight
			for(Character mem : team1.getMembersList()) {
				if(mem.isAlive()) {
					battlePart.add(mem);
				}
			}
			
			for(Character mem : team2.getMembersList()) {
				if(mem.isAlive()) {
					battlePart.add(mem);
				}
			}
			//sorting the turns in the fight
			Collections.sort(battlePart);
			for(Character mem : battlePart) {
				if(mem.getTeam().equals(team1)) {
					mem.getTeam().move(mem, team2);
					if(team1.isDead()) {
						System.out.println();
						System.out.println("WE HAVE A WINNER!");
						System.out.println(team2.getName());
						System.out.println();
						team2.getStats();
						return team2;
					} else if(team2.isDead()) {
						System.out.println();
						System.out.println("WE HAVE A WINNER!");
						System.out.println(team1.getName());
						System.out.println();
						team1.getStats();
						return team1;
					}
				} else if(mem.getTeam().equals(team2)) {
					mem.getTeam().move(mem, team1);
					if(team1.isDead()) {
						System.out.println();
						System.out.println("WE HAVE A WINNER!");
						System.out.println(team2.getName());
						System.out.println();
						team2.getStats();
						return team2;
					} else if(team2.isDead()) {
						System.out.println();
						System.out.println("WE HAVE A WINNER!");
						System.out.println(team1.getName());
						System.out.println();
						team1.getStats();
						return team1;
					}
				}
			}
			if(team1.isDead()) {
				System.out.println();
				System.out.println("WE HAVE A WINNER!");
				System.out.println(team2.getName());
				System.out.println();
				team2.getStats();
				return team2;
			} else if(team2.isDead()) {
				System.out.println();
				System.out.println("WE HAVE A WINNER!");
				System.out.println(team1.getName());
				System.out.println();
				team1.getStats();
				return team1;
			} else {
				System.out.println();
				System.out.println("AFTER ROUND " + i + " THESE ARE THE STATISTICS FOR THE TWO TEAMS!");
				System.out.println();
				System.out.println("TEAM " + team1.getName());
				team1.getStats();
				System.out.println();
				System.out.println("TEAM " + team2.getName());
				team2.getStats();
				System.out.println();
			}
			battlePart.clear();
		}
		System.out.println();
		System.out.println("THE BATTLE ENDS AND THE RESULT IS... DRAW!");
		System.out.println();
		System.out.println(team1.getName());
		System.out.println();
		team1.getStats();
		System.out.println();
		System.out.println(team2.getName());
		System.out.println();
		team2.getStats();
		return null;
	}
}
