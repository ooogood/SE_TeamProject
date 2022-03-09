import pttsystem.PTTSystem;

public class Main {
	public static void main( String args[] ) {

		PTTSystem ptt = PTTSystem.inst();

		View view = new View( ptt );
		Controller controller = new Controller( view, ptt );
		controller.systemStart();
	}
}