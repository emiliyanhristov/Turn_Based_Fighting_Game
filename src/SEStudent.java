
public class SEStudent extends Student{

	public SEStudent(String name) {
		super(name, 8, 5, 8, 4, 10);
	}
	
	public void groupWork(Character enemy) throws Exception {//method that contains one of the SEStudent's special attacks
		if(this.hasMaxKP() && this.isAlive()) {
			SEStudent.this.increaseEP(4);
			SEStudent.this.currentKP = 0;
			Character[] tempTeam = SEStudent.this.getTeam().getMembers();
			for(Character i : tempTeam) {
				enemy.decreaseHP((100 * i.getAttack()) / (100 + enemy.getDefence()));//every member of the team attacks the enemy
				}
			if(enemy.getHP() == 0) {
				SEStudent.this.increaseEP(4);
			}
		}
		else if(!hasMaxKP() && isAlive()) {
			throw new Exception(this.getName() + "'s special ability is not charged!");
		}
		else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
	
	public void groupDiscussion() throws Exception {//method that contains one of the SEStudent's special attacks
		if(hasMaxKP() && isAlive()) {
			SEStudent.this.increaseEP(4);
			SEStudent.this.currentKP = 0;
			Character[] tempTeam = SEStudent.this.getTeam().getMembers();
			for(Character i : tempTeam) {
				if(i.getHP() != 0) {
					i.increaseHP((SEStudent.this.getDefence())/2);//every member of the team is healed
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
