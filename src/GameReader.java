import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class GameReader {
	
	protected BufferedReader reader;
	Team levelTeam;

	public GameReader(String file) {//game reader constructor that reads from the file
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getLine() {//method to read every line in the file
		String line = null;
			try {
				line = reader.readLine();
				return line;
			} catch (IOException e) {
				e.printStackTrace();
				return line;
			}
	}
	
	public boolean fileIsReady() {//method to check whether the file is ready
		try {
			if(reader != null) {
				return reader.ready();
			}
			else return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Team addToTeam(String line) throws Exception {//method that adds the monster to the team
		Team temp = new MonsterTeam("Monsters Team");
		int i = 0;
		String[] part = line.split("\\(|\\,|\\);|\\)");
		do {
			Class<?> c = Class.forName(part[i+1]);//searches for class with the same name as element i+1
			Constructor<?> constructor = c.getDeclaredConstructor(String.class, int.class);//declares a constructor with those specifications
			temp.addMember((Character) constructor.newInstance(part[i].toString(), Integer.parseInt(part[i+2])));//adds the monster with this constructor to the team
			i +=3;
		} while((i < part.length));
		return temp;
	}
	
}
