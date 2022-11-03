
public class AIStudent extends Student{

	public AIStudent(String name) {
		super(name, 6, 7, 7, 5, 3);
	}
	
	public void machineLearning(Character enemy) throws Exception {//method that contains one of the AIStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			AIStudent.this.increaseEP(4);
			AIStudent.this.currentKP = 0;
			enemy.decreaseHP(2 * (100 * AIStudent.this.getAttack()) / (100 + enemy.getDefence()));
			if(enemy.getHP() == 0) {
				AIStudent.this.increaseEP(4);
			}
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
	
	public void naturalLanguageProcessing() throws Exception {//method that contains one of the AIStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			AIStudent.this.increaseEP(4);
			AIStudent.this.currentKP = 0;
			AIStudent.this.increaseHP(AIStudent.this.getDefence());
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
