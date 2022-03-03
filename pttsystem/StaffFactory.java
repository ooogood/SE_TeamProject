package pttsystem;

public class StaffFactory implements ElemFactory<Staff> {
	public Staff create( String name ) {
		return new Staff( name );
	}
}
 