
public class CyberStudent extends Student{

	public CyberStudent(String name) {
		super(name, 7, 7, 5, 6, 6);
	}
	
	public void cyberAttack(Team enemyteam) throws Exception {//method that contains one of the CyberStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			CyberStudent.this.increaseEP(4);
			CyberStudent.this.currentKP = 0;
			Character[] tempEnemy = enemyteam.getMembers();
			for(Character i : tempEnemy) {//loop to o through the whole enemy team
				if(i.getHP() != 0) {
					i.decreaseHP((100 * CyberStudent.this.getAttack()) / (100 + i.getDefence()));
					if(i.getHP() == 0) {
						CyberStudent.this.increaseEP(4);
					}
				}
			}
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
