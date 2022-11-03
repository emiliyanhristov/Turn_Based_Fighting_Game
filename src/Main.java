
public class Main {

	public static void main(String args[]) throws Exception{
		AIStudent ivan = new AIStudent("petkan");
        AIStudent mom = new AIStudent("MMM");
        CSStudent trakan = new CSStudent("traki");
        CSStudent traqn = new CSStudent("track");
        CyberStudent petko = new CyberStudent("petyu");
        CyberStudent pavel = new CyberStudent("pufi");
        SEStudent ivo = new SEStudent("ivko");
        SEStudent emo = new SEStudent("bigI");
        AIStudent val = new AIStudent("viki");
        CSStudent bog = new CSStudent("god");

        StudentTeam team1 = new StudentTeam("veliki");
        StudentTeam team2 = new StudentTeam("slabi");

        team1.addMember(ivan);
        team1.addMember(mom);
        team1.addMember(pavel);
        team1.addMember(bog);
        team1.addMember(emo);

        team2.addMember(ivo);
        team2.addMember(trakan);
        team2.addMember(val);
        team2.addMember(traqn);
        team2.addMember(petko);

        //petko.getTeam().move(petko, team1);
        System.out.println(ivan.getTeam().getName());
        Battle battle = new Battle(team1, team2);
        battle.fight();
	}
}
