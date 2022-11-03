
public class MonsterTeam extends Team{

	public MonsterTeam(String name) {
		super(name);
	}
	
	/*Monster team method that specifies the move of the monsters during the battle
	 * it checks whether the monster is a minion or boss and uses the needed
	 * strike method.
	 */
	
	public void move(Character member, Team enemyTeam) throws Exception{
		
		if(member instanceof Minion) {
			if(member.isAlive()) {
				try {
					((Minion) member).strike(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
		else if(member instanceof Boss) {
			if(member.isAlive()) {
				try {
					((Boss) member).strike(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
