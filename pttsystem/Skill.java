package pttsystem;

public class Skill {
	private String name;
	public Skill( String name ) {
		this.name = name;
	}
	@Override
	public boolean equals( Object st ) {
		if( !( st instanceof Skill ) ) return false;
		if( this.name.equals( ((Skill)st).name ) )
			return true;
		return false;
	}
}
