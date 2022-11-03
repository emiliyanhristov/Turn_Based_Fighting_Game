
public class EEStudent extends Student{//Electrical Engineer Student

	public EEStudent(String name) {
		super(name, 7, 6, 5, 8, 7);
	}
	
	/*
	 * This special attack allows the student to attack up to 2 enemies
	 */
	public void electricalStrike(Team enemyTeam) throws Exception{
		if(hasMaxKP() && isAlive()) {
			EEStudent.this.increaseEP(4);
			EEStudent.this.currentKP = 0;
			int counter = 0;
			for(Character i :  enemyTeam.getMembers()) {
				if(counter >= 2) {
					break;
				}
				if(i.isAlive()) {
					i.decreaseHP((100 * EEStudent.this.getAttack()) / (100 + i.getDefence()));
					counter++;
					if(i.getHP() == 0) {
						EEStudent.this.increaseEP(4);
					}
				}
			}
		} else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
