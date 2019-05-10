package assignment5;

public class Nbaplayer {
	private int id;
	private String name;
	private int point;
	private int rebound;
	/*Highest score and rebound
	 */
	
	public Nbaplayer() {
		
	}
	
	public Nbaplayer(int id, String name, int point, int rebound) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
		this.rebound = rebound;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;	
	}
	public int getRebound() {
		return rebound;
	}
	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	

}
