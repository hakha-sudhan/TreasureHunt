//denotes a joined part of the map
public class Section {
	private boolean[][] section;
	private int size;
	private int halfSize;
	public Section(int s){
		section = new boolean[s][s];
		size = s;
		halfSize = s/2;
	}
	
	public void setValue(int x, int y, boolean b){
		section[x+halfSize][y+halfSize] = b;
	}
	public boolean getValue(int x, int y){
		return section[x+halfSize][y+halfSize];
	}
	
	//returns equality
	public boolean isEqual(Section s){
		return false;
	}
	
	//returns whether s is a subset of this
	public boolean isSubset(Section s){
		return false;
	}
	
	//adds section into this
	public void add(Section s){
		
	}
	
	//checks whether square is next to section
	public boolean isNextTo(int x, int y){
		return false;
	}
}
