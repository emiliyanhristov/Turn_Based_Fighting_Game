
public class Boss extends Character implements Monster{

	public Boss(String name) {//boss constructor with the base boss statistics
		super(name, 8, 7, 8, 7);
	}
	
	public Boss(String name, int level) {//boss constructor for the Tower of Monsters file
		super(name, 8, 7, 8, 7);
		this.setLevel(level);
		this.increaseHP(getMaxHP());
	}
	
	public void SyntaxError(Character enemy) {//one of the moves of the boss
		Boss.this.increaseEP(3);
		enemy.decreaseHP((100 * Boss.this.getAttack()) / (100 + enemy.getDefence()));
		enemy.increaseEP(3);
		if(enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}
		if(enemy.getHP() == 0) {
			Boss.this.increaseEP(4);
		}
	}
	
	public void NullPointerException() {//one of the moves of the boss
		Boss.this.increaseEP(3);
		Boss.this.increaseHP(getDefence());
	}
	
	public void ArrayIndexOutOfBoundException(Character enemy) {//one of the moves of the boss
		Boss.this.increaseEP(3);
		enemy.decreaseHP(2 * ((100 * Boss.this.getAttack()) / (100 + enemy.getDefence())));
		enemy.increaseEP(3);
		if(enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}
		if(enemy.getHP() == 0) {
			Boss.this.increaseEP(4);
		}
	}
	
	public void NoneTermination() {//one of the moves of the boss
		Boss.this.increaseEP(3);
		Character[] tempTeam = Boss.this.getTeam().getMembers();
		for(Character i : tempTeam) {
			if(!i.isAlive()) {
				i.increaseHP(i.getMaxHP());
			}
		}
	}
	
	public void ConcurrentModificationException(Character enemy) {//one of the moves of the boss
		Boss.this.increaseEP(3);
		Character[] tempTeam = enemy.getTeam().getMembers();
		for(Character i : tempTeam) {
			if(i.isAlive()) {
				i.decreaseHP((100 * Boss.this.getAttack()) / (100 + i.getDefence()));
				i.increaseEP(3);
				if(i instanceof Student) {
					((Student) i).increaseKP(4);
				}
				if(i.getHP() == 0) {
					Boss.this.increaseEP(4);
				}
			}
		}
	}
	
	/*Method strike that makes the boss to use his moves depending on the random
	 * number that is representing the percentage of the moves.
	 */
	
	public void strike(Character enemy) throws Exception{
		if(this.isAlive()) {
			int number;
			number = tb.getRandomInteger(100);
			if(number <= 50) {
				System.out.println(this.getName() + " used Syntax Error on " + enemy.getName());
				Boss.this.SyntaxError(enemy);
			} else if(number > 50 && number <= 65) {
				System.out.println(this.getName() + " used Null Pointer Exception");
				Boss.this.NullPointerException();
			} else if(number > 65 && number <= 80) {
				System.out.println(this.getName() + " used Array Index Out Of Bound Exception on " + enemy.getName());
				Boss.this.ArrayIndexOutOfBoundException(enemy);
			} else if(number > 80 && number <= 90) {
				System.out.println(this.getName() + " used None Termination");
				Boss.this.NoneTermination();
			} else if(number > 90 && number <= 100) {
				System.out.println(this.getName() + " used Concurrent Modification Exception on " + enemy.getTeam().getName());
				Boss.this.ConcurrentModificationException(enemy);
			}
		} else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}