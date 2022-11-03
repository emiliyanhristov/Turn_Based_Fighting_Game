
public class TowerOfMonsters {
	
	GameReader game;
	Guild myGuild;
	String line;
	Team studentTeam;
	
	/*Tower of Monsters game that takes 8 students 2 from each class and reads
	 * a text file with the monsters on each level of the tower. The students
	 * and the monsters form a team and fight and if the students win they go 
	 * onto the next level, but if the monsters win and there are no more alive students
	 * left the game ends.
	 */
	
	public TowerOfMonsters(String file) throws Exception {
		game = new GameReader(file);
		myGuild = new Guild();
		myGuild.addMember(new AIStudent("Student1"));
		myGuild.addMember(new AIStudent("Student2"));
		myGuild.addMember(new CSStudent("Student3"));
		myGuild.addMember(new CSStudent("Student4"));
		myGuild.addMember(new CyberStudent("Student5"));
		myGuild.addMember(new CyberStudent("Student6"));
		myGuild.addMember(new SEStudent("Student7"));
		myGuild.addMember(new SEStudent("Student8"));
		String line;
		if(game.fileIsReady()) {
			while((line = game.getLine()) != null) {
				studentTeam = myGuild.getTeam(game.addToTeam(line));
				Battle battle = new Battle(studentTeam , game.addToTeam(line));
				System.out.println();
				if(battle.fight() == studentTeam) {
					continue;
				} else {
					if(myGuild.hasAliveMembers()) {
						studentTeam = myGuild.getTeam(game.addToTeam(line));
					} else {
						System.out.println();
						System.out.println("The game has finished!");
						break;
					}	
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		TowerOfMonsters game = new TowerOfMonsters(args[0]);//the program reads the text file with the game from the command prompt
	}

}
