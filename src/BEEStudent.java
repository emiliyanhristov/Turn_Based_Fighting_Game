
public class BEEStudent extends Student {//Biomedical Electronic Engineering Student

	public BEEStudent(String name) {
		super(name, 7, 8, 4, 5, 9);
	}
	
	/*The special attack of the student is to deal damage to an enemy and heal his
	 * friend at the same time.
	 */
	public void biomedicalEngineering(Character friend, Character enemy) throws Exception{
		if(hasMaxKP() && isAlive()) {
			BEEStudent.this.increaseEP(4);
			BEEStudent.this.currentKP = 0;
			enemy.decreaseHP((100 * BEEStudent.this.getAttack()) / (100 + enemy.getDefence()));
			friend.increaseHP((100 * BEEStudent.this.getAttack()) / (100 + enemy.getDefence()));
			if(enemy.getHP() == 0) {
				BEEStudent.this.increaseEP(4);
			}
		} else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
	
}
