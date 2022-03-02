package pttsystem;

public class Training {
	private String name;
	public Training( String name ) {
		this.name = name;
	}
	@Override
	public boolean equals( Object st ) {
		if( !( st instanceof Training ) ) return false;
		if( this.name.equals( ((Training)st).name ) )
			return true;
		return false;
	}
}
