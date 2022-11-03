
public interface Monster {//monster interface that specifies the special moves of the monsters

	Toolbox tb = new Toolbox();
	public void strike(Character enemy) throws Exception;
	public void SyntaxError(Character enemy);
	public void NullPointerException();
	public void ArrayIndexOutOfBoundException(Character enemy);
}
