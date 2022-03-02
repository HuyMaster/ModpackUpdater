package root.utilities;

public class java {
	private transient String temp;
	
	public String checkVer() {
		temp = System.getProperty("java.version");
		return temp;
	}
	
	public String checkHome() {
		temp = System.getProperty("java.home");
		return temp;
	}
}
