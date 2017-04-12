
public enum PieceType {
	Rook (1),
	Bishop (5),
	Knight (10),
	Merged (20);
	private final int reference;
	
	PieceType(int reference){
		this.reference = reference;
	}
	public int getRef(){
		return reference;
	}
}
