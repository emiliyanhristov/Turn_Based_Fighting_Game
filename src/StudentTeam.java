
public class StudentTeam extends Team{

	public StudentTeam(String name) {
		super(name);
	}
	
	/*Method for the student team that checks what kind of a student is the
	 * member of the team and decides what move to use depending on the situation.
	 */
	
	public void move(Character member, Team enemyTeam) throws Exception {
		//AIStudent
		if(member instanceof AIStudent) {
			if(((AIStudent) member).hasMaxKP() && member.isAlive()) {//checks whether the student has max KP and is alive
				if(member.has40HP()) {//checks  whether the student is above 40% of his health
					try {
						System.out.println(member.getName() + " used Machine Learning on " + lowestHP(enemyTeam).getName());
						((AIStudent) member).machineLearning(lowestHP(enemyTeam));
					} catch (Exception e) {
						System.out.println(e);
					}
				} else {
					try {
						System.out.println(member.getName() + " used Natural Language Processing");
						((AIStudent) member).naturalLanguageProcessing();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}else if(member.has40HP() && member.isAlive()){//if the student hasn't got max KP if checks whether he has more than 40% of his HP
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((AIStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.isAlive()){
				try {
					System.out.println(member.getName() + " used Self Study");
					((AIStudent) member).selfStudy();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} 
		//CSStudnet
		else if(member instanceof CSStudent) {
			if(((CSStudent) member).hasMaxKP() && member.isAlive()) {//checks whether the student has max KP and is alive
				for(Character i : member.getTeam().getMembers()) {//loop that goes through the Student Team
					if(!i.has40HP() && i.isAlive() && !i.equals(member)) {//selects a member of the team with less than 40% of his health and supports him
						try {
							System.out.println(member.getName() + " used Support on " + i.getName());
							((CSStudent) member).support(i);
							break;
						} catch (Exception e){
							System.out.println(e);
						}
					}
				}
			}
			if(((CSStudent) member).hasMaxKP() && member.isAlive() && member.getTeam().hasAliveTeamMates((CSStudent) member)) {
				//checks whether there are any other alive members of the team
				try {
					System.out.println(member.getName() + " used Pair Working on " + lowestHP(enemyTeam).getName());
					((CSStudent) member).pairWorking(member.getTeam().getRandomMember((CSStudent) member), lowestHP(enemyTeam));//gets random alive member of the team
				} catch (Exception e){
					System.out.println(e);
				}
			}else if(member.has40HP() && member.isAlive()){
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((CSStudent) member).javaProgramming(lowestHP(enemyTeam));
				}catch (Exception e){
					System.out.println(e);
				}
			} else if(member.isAlive()){
				try {
					System.out.println(member.getName() + " used Self Study");
					((CSStudent) member).selfStudy();
				} catch (Exception e){
					System.out.println(e);
				}
			}
		}
		//CyberStudent
		else if(member instanceof CyberStudent) {
			if(((CyberStudent) member).hasMaxKP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Cyber Attack on " + enemyTeam.getName());
					((CyberStudent) member).cyberAttack(enemyTeam);
				} catch (Exception e){
					System.out.println(e);
				}
			}else if(member.has40HP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((CyberStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e){
					System.out.println(e);
				}
			}else if(member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Self Study");
					((CyberStudent) member).selfStudy();
				} catch (Exception e){
					System.out.println(e);
				}
			}
		}
		//SEStudent
		else if(member instanceof SEStudent) {
			if(((SEStudent) member).hasMaxKP() && member.isAlive() && member.getTeam().hasAliveTeamMates((SEStudent) member)) {
				int counter = 0;//counter to check how many people in the team are alive and below 40% of their HP
				for(Character i : member.getTeam().getMembers()) {
					if(!i.has40HP() && i.isAlive()) {
						counter ++;
					}
				}
				if(counter >= (member.getTeam().teamSize() / 2)) {//if half of the team is below 40% of their HP the student uses Group Discussion
					try {
						System.out.println(member.getName() + " used Group Discussion");
						((SEStudent) member).groupDiscussion();
					} catch (Exception e){
						System.out.println(e);
					}
				} else {
					try {
						System.out.println(member.getName() + " used Group Work on " + enemyTeam.getName());
						((SEStudent) member).groupWork(lowestHP(enemyTeam));
					} catch (Exception e){
						System.out.println(e);
					}	
				}
			} else if(member.has40HP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((SEStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e){
					System.out.println(e);
				}
			} else if(member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Self Study");
					((SEStudent) member).selfStudy();
				} catch (Exception e){
					System.out.println(e);
				}
			}
		}
		//BEEStudent
		else if(member instanceof BEEStudent) {
			if(((BEEStudent) member).hasMaxKP() && member.isAlive() && member.getTeam().hasAliveTeamMates(member)) {
				try {
					System.out.println(member.getName() + " used Biomedical Engineering on " + lowestHP(enemyTeam).getName());
					((BEEStudent) member).biomedicalEngineering(member.getTeam().getRandomMember(member), lowestHP(enemyTeam));
				}catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.has40HP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((BEEStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Self Study");
					((BEEStudent) member).selfStudy();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		//EEStudent
		else if(member instanceof EEStudent) {
			if(((EEStudent) member).hasMaxKP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Electrical Strike on " + enemyTeam.getName());
					((EEStudent) member).electricalStrike(enemyTeam);
				}catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.has40HP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((EEStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Self Study");
					((EEStudent) member).selfStudy();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		//AEEStudent
		else if(member instanceof AEEStudent) {
			if(((AEEStudent) member).hasMaxKP() && member.isAlive()) {
				for(Character i : enemyTeam.getMembers()) {
					if(i.isAlive()) {
						if(i instanceof Boss) {
							try {
								System.out.println(member.getName() + " used Rocket Strike on " + i.getName());
								((AEEStudent) member).rocketStrike(i);
							} catch (Exception e) {
								System.out.println(e);
							}
							break;
						}
					}
				}
			}
			if(((AEEStudent) member).hasMaxKP() && member.isAlive()) {
				for(Character i : enemyTeam.getMembers()) {
					if(i.isAlive()) {
						try {
							System.out.println(member.getName() + " used Rocket Strike on " + i.getName());
							((AEEStudent) member).rocketStrike(i);
						} catch (Exception e) {
							System.out.println(e);
						}
						break;
					}
				}
			} else if(member.has40HP() && member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Java Programming on " + lowestHP(enemyTeam).getName());
					((AEEStudent) member).javaProgramming(lowestHP(enemyTeam));
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if(member.isAlive()) {
				try {
					System.out.println(member.getName() + " used Self Study");
					((AEEStudent) member).selfStudy();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
