
public class Character implements Comparable<Character>{//class that creates a character

	protected String name;
	protected int baseHP;
	protected int baseAtk;
	protected int baseDef;
	protected int baseSpd;
	protected int level = 1;
	protected int currentHP;
	protected int currentEP = 0;
	protected Team team;
	private Toolbox tb = new Toolbox();
	
	public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {//constructor that contains the character characteristics
		this.name = name;
		this.baseHP = baseHP;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpd = baseSpd;
		currentHP = getMaxHP();
	}
	
	public Character(String name) {//a constructor containing only the Character name for the sub-classes
		this.name = name;
	}
	
	public String getName() {//method that prints the name of the character
		return name;
	}
	
	/*
	 * Methods that calculate the character characteristics
	 */
	public int getMaxHP() {
		return (int) Math.round(baseHP * Math.pow(level, 1.2));
	}
	
	public int getAttack() {
		return (int) Math.round(baseAtk * Math.pow(level, 1.2));
	}
	
	public int getDefence() {
		return (int) Math.round(baseDef * Math.pow(level, 1.2));
	}
	
	public int getSpeed() {
		return (int) Math.round(baseSpd * Math.pow(level, 1.2));
	}
	
	public int getTargetEP() {
		return (int) Math.round(10 * Math.pow(level, 1.5));
	}
	public int getHP() {
		return currentHP;
	}
	
	public int getEP() {
		return currentEP;
	}
	
	public void increaseHP(int amount) {//method that increases the character's HP
		currentHP += amount;
		if(currentHP > this.getMaxHP()) {//checks whether the character's HP has reached it's limit
			currentHP = getMaxHP();
		}
	}
	
	public void decreaseHP(int amount) {//method that decreases the character's HP
		currentHP = currentHP - amount;
		if(this.getHP() < 0){//checks whether the character's HP is under 0 a.k.a. the character is dead
			currentHP = 0;
		}
	}
	
	public void increaseEP(int amount) {//method that increases the character's EP
		currentEP = currentEP + amount;
		if(currentEP >= this.getTargetEP()) {//checks whether the character has reached the needed EP to level up
			currentEP = 0;
			level = level + 1;
			if(currentHP == 0) {//checks the character's HP when they are leveling up
				currentHP = 0;//if the character is dead the HP stays at 0
			}
			else {
				currentHP = this.getMaxHP();//if the character is alive the HP is set  to max 
			}
		}
	}
	
	public void setLevel(int level) {//setter for the level
		this.level = level;
	}
	
	public int getLevel() {//prints the character's level
		return level;
	}
	
	public void setTeam(Team team) {//method that sets the character's team
		this.team = team;
	}
	
	public Team getTeam() {//method that prints the character's team
		return team;
	}
	
	public boolean has40HP() {//method to check whether the character has at least 40% of his HP
		if(currentHP >= getMaxHP() - (getMaxHP() * (60 / 100))) {
			return true;
		} else return false;
	}
	
	public boolean isAlive() {//checks whether the character is alive
		if(currentHP != 0) {
			return true;
		} else return false;
	}
	
	public boolean coinToss() {//method that throws a coin and returns either true or false
		int a;
		a = tb.getRandomInteger(2);
		if(a == 1) {
			return true;
		} else return false;
	}
	
	public int compareTo(Character a) {//method to compare the speed of the characters in a team
		if(this.getSpeed() < a.getSpeed()) {
			return 1;
		} else if(this.getSpeed() > a.getSpeed()) {
			return -1;
		} else return 0;
	}
}
