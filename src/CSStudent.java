
public class CSStudent extends Student{

	public CSStudent(String name) {
		super(name, 7, 6, 6, 6, 4);
	}
	
	public void pairWorking(Character friend, Character enemy) throws Exception {//method that contains one of the CSStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			CSStudent.this.increaseEP(4);
			CSStudent.this.currentKP = 0;
			enemy.decreaseHP(((100 * CSStudent.this.getAttack()) / (100 + enemy.getDefence())) + ((100 * friend.getAttack()) / (100 + enemy.getDefence())));
			if(enemy.getHP() == 0) {
				CSStudent.this.increaseEP(4);
			}
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
	
	public void support(Character friend) throws Exception {//method that contains one of the CSStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			CSStudent.this.increaseEP(4);
			CSStudent.this.currentKP = 0;
			friend.increaseHP(CSStudent.this.getDefence());
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
