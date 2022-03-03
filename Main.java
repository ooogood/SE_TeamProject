import pttsystem.PTTSystem;

public class Main {
	public static void main( String args[] ) {
		PTTSystem ptt = PTTSystem.inst();
		ptt.addReq("English Class",
					new String[]{"English", "Language Teaching"},
					new String[]{ "English Class Training"} );
		ptt.addReq("Spanish Class",
					new String[]{"Spanish", "Language Teaching"},
					new String[]{ "Spanish Class Training"} );
		ptt.addReq("Calculus Class",
					new String[]{"Calculus", "Math Teaching"},
					new String[]{ "Calculus Class Training"} );
		ptt.addReq("Geometry Class",
					new String[]{"Geometry", "Math Teaching"},
					new String[]{ "Geometry Class Training"} );
		ptt.addStaff("Jim",
					new String[]{"English", "Language Teaching"},
					new String[]{} );
		ptt.addStaff("Jane",
					new String[]{"Spanish", "Language Teaching"},
					new String[]{} );
		ptt.addStaff("Joe",
					new String[]{"Calculus", "Language Teaching"},
					new String[]{} );
		ptt.addStaff("Jay",
					new String[]{"Calculus", "Math Teaching"},
					new String[]{} );
		ptt.tryFillAllReq();
	}
}