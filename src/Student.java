
public class Student extends Character {//creating a Student sub-class to the Character superclass

	protected int maxKP;
	protected int currentKP = 0;
	protected Toolbox tb = new Toolbox();
	
	public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP){//the student constructor inherits the character characteristics and adds a KP
		super(name, baseHP, baseAtk, baseDef, baseSpd);
		this.maxKP = maxKP;
	}
	
	public Student(String name) {//a constructor with only name for the sub-classes
		super(name);
	}
	
	public void increaseKP(int amount) {//method to increase the currentKP
		currentKP = currentKP + amount;
		if(currentKP >= maxKP) {
			currentKP = maxKP;
		}
	}
	
	public int getKP() {//getter method to check the current KP
		return currentKP;
	}
	
	public boolean hasMaxKP() {//method to check whether the student has max KP
		if(currentKP == maxKP) {
			return true;
		} else return false;
	}
	
	public void javaProgramming(Character enemy) throws Exception{//method that is a skill of the student sub-class
		if(isAlive()) {
			Student.this.increaseEP(3);
			Student.this.increaseKP(1);
			enemy.decreaseHP((100 * Student.this.getAttack()) / (100 + enemy.getDefence()));//decreases the enemy HP by a special formula
			enemy.increaseEP(2);
			if(enemy instanceof Student) {//checks if the enemy is of sub-class student
				((Student)enemy).increaseKP(3);//if it is, it's KP is increased by 3
			}
			if(enemy.getHP() == 0) {//checks whether the enemy is dead
				Student.this.increaseEP(4);
			}
		} else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
	
	public void selfStudy() throws Exception{//method that is a skill of the student sub-class
		if(isAlive()) {
			Student.this.increaseHP(2);
			Student.this.increaseEP(6);
			Student.this.increaseKP(2);
		} else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
