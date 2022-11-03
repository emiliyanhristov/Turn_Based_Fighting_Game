import java.util.ArrayList;

public abstract class Team {//creating a Team class that groups the characters into a classes

	private String name;
	private ArrayList<Character> members;
	
	public Team(String name) {//the Team constructor has a name and consist of an ArrayList with it's members
		this.name = name;
		members = new ArrayList<Character>();
	}
	
	public String getName() {//method to print the name of the team
		return name;
	}
	
	public ArrayList<Character> getMembersList(){//method to return the ArrayList with guild members(useful for sorting)
		return members;
	}
	
	public void remove(Character member) {//method to remove character from the team
		members.remove(member);
		member.setTeam(null);
	}
	
	public Character[] getMembers() {//method to print the members of the team as an array and get that array size
		Character[] member = members.toArray(new Character[members.size()]);
		return member;
	}
	
	public int addMember(Character member) {//method to add a member to the team
		Character[] tempMem = getMembers();
		for(Character i : tempMem) {
			if(member.getName().equals(i.getName())) {//if to check whether that member is already in the team
				return -1;
			}
		}
		if(members.size() >= 5) {//if to check whether the team has reached it's limit of 5
			return -2;
		}
		else {//if the team isn't full and the member is not already in this team, the member is added to the team
			members.add(member);
			member.setTeam(this);
			return members.size();
		}
	}
	
	public int teamSize() {//method to return the size of the team
		return members.size();
	}
	
	public void getStats() {//method to print the statistics of the people in the team
		Character[] tempMem = getMembers();
		for(Character mem : tempMem) {
			System.out.println(mem.getName() + " has " + mem.getHP() + "HP has " + mem.getSpeed() +" Speed and is level " + mem.getLevel());
		}
	}
	
	public Character getRandomMember(Character mem) throws Exception{//method to get random member of the team
		Character[] member = getMembers();
		for(int i = 0; i < teamSize(); i++) {
			if(member[i].isAlive() && member[i].coinToss() && !member[i].equals(mem)) {
				return member[i];
			}
		}
		for(int i = 0; i <teamSize(); i++) {
			if(member[i].isAlive()) {
				if(!member[i].equals(mem)) {
					return member[i];
				}
			}
		}
		throw new Exception("All members in the team are dead!");
	}
	
	public boolean hasAliveTeamMates(Character mem) {//checks whether the character has alive team mates
		Character[] member = getMembers();
		for(Character i : member) {
			if(i.isAlive() && !i.equals(mem)) {
				return true;
			}
		}
		return false;
	}
	
	public Character lowestHP(Team team) throws Exception{//method to find the character with the lowest HP
		Character[] member = team.getMembers();
		for(int i = 1; i < member.length; i ++) {//bubble sorting the team so the first character after the sorting is the one with the lowest HP
			for(int j = 0; j < member.length - 1; j++) {
				if(member[j].getHP() > member[j+1].getHP()) {
					Character temp = member[j];
					member[j] = member[j+1];
					member[j+1] = temp;
				}
			}
		}
		for(int i = 0; i < member.length; i++) {//checking if there exist a character who is alive
			if(member[i].getHP() != 0) {
				return member[i];
			}
		}
		throw new Exception("All characters are dead!");
	}
	
	public boolean isDead() {//method to check whether the whole team is dead
		for(Character i : Team.this.getMembersList()) {
			if(i.isAlive()) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
	
	public abstract void move(Character member, Team enemyTeam) throws Exception;//abstract method move to decide the team's moves
}
