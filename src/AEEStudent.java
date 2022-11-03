
public class AEEStudent extends Student{//Aerospace Electronic Student

	public AEEStudent(String name) {
		super(name, 5, 4, 10, 5, 15);
	}
	/*
	 * Very powerful attack that kills the enemy instantly
	 */
	public void rocketStrike(Character enemy) throws Exception{
		if(hasMaxKP() && isAlive()) {
			AEEStudent.this.increaseEP(4);
			AEEStudent.this.currentKP = 0;
			enemy.decreaseHP(1000000000);
			if(enemy.getHP() == 0) {
				AEEStudent.this.increaseEP(4);
			}
		} else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
