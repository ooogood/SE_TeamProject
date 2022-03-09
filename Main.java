import pttsystem.PTT2TxtKit;
import pttsystem.PTTSystem;

public class Main {
	public static void main( String args[] ) {

		PTTSystem ptt = PTTSystem.inst();
		ptt.setSLFactory( new PTT2TxtKit() );
		ptt.loadSystem();

		View view = new View( ptt );
		Controller controller = new Controller( view, ptt );
		controller.systemStart();
	}
}