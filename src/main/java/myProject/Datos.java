package myProject;

public class Datos {
	public int time;
	public String url;
	
	Datos() {
		
	}
	
	public void setData (int time, String url) {
		this.time = time;
		this.url = url;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getUrl() {
		return url;
	}
}