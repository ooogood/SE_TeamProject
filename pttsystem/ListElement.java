package pttsystem;
/**
 * This is an abstract class that all the data in the Lox should extends
 */

abstract public class ListElement {
	protected String name;
	public ListElement( String name ) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public boolean equals( Object o ) {
		if( !( o instanceof ListElement ) ) return false;
		if( this.name.equals( ((ListElement)o).name ) )
			return true;
		return false;
	}
}
