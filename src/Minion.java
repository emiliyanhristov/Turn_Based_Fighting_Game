
public class Minion extends Character implements Monster{

	public Minion(String name) {//constructor for the minion
		super(name, 5, 5, 5, 5);
	}
	
	public Minion(String name, int level) {//constructor for the minion in the Tower Of Monsters game
		super(name, 5, 5, 5, 5);
		this.setLevel(level);
		this.increaseHP(getMaxHP());
	}
	
	public void SyntaxError(Character enemy) {//one of the moves of the minion
		Minion.this.increaseEP(3);
		enemy.decreaseHP((100 * Minion.this.getAttack()) / (100 + enemy.getDefence()));
		enemy.increaseEP(3);
		if(enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}
		if(enemy.getHP() == 0) {
			Minion.this.increaseEP(4);
		}
	}
	
	public void NullPointerException() {//one of the moves of the minion
		Minion.this.increaseEP(3);
		Minion.this.increaseHP(getDefence());
	}
	
	public void ArrayIndexOutOfBoundException(Character enemy) {//one of the moves of the minion
		Minion.this.increaseEP(3);
		enemy.decreaseHP(2 * ((100 * Minion.this.getAttack()) / (100 + enemy.getDefence())));
		enemy.increaseEP(3);
		if(enemy instanceof Student) {
			((Student) enemy).increaseKP(3);
		}
		if(enemy.getHP() == 0) {
			Minion.this.increaseEP(4);
		}
	}
	
	/*Method strike that makes the minion to use his moves depending on the random
	 * number that is representing the percentage of the moves.
	 */
	
	public void strike(Character enemy) throws Exception {
		if(this.isAlive()) {
			int number;
			number = tb.getRandomInteger(100);
			if(number <= 75) {
				System.out.println(this.getName() + " used Syntax Error on " + enemy.getName());
				Minion.this.SyntaxError(enemy);
			} else if(number > 75 && number <= 90) {
				System.out.println(this.getName() + " used Null Pointer Exception");
				Minion.this.NullPointerException();
			} else if(number > 90 && number <= 100) {
				System.out.println(this.getName() + " used Array Index Out Of Bound Exception on " + enemy.getName());
				Minion.this.ArrayIndexOutOfBoundException(enemy);
			}
		} else {
			throw new Exception(this.getName() + " is dead!");
		}
	}
}
