import java.util.ArrayList;
import java.util.HashMap;

import pttsystem.PTTSystem;

public class Controller {
    
    private PTTSystem ptt;
    private View view; 

    public Controller( View view, PTTSystem ptt ){
        this.ptt = ptt;
        this.view = view;
        view.setController( this );
    }

    public void systemStart(){
        view.getInfo();
    }

    public void process( int service ){
        switch( service ){
            case 0:
                inputRequirements();
                break;
            case 1:
                inputStaff();
                break;
            case 2:
                matchReqAndStafff();
                break;
            case 3:
                outputDataBase();
            }
    }

    public void inputRequirements(){
        boolean continuous = true;
        while ( continuous ){

            String req = view.askForRequirementName();
            HashMap<String, ArrayList<String []>> inputMap = new HashMap<String, ArrayList<String []>>();
            inputMap.put( req, new ArrayList<String []>() );

            String skills = view.askForNeededSkills( req );
            addInputIntoMap( skills, inputMap, req );

            String trainings = view.askForNeededTrainings( req );
            addInputIntoMap( trainings, inputMap, req );

            ptt.addReq( req, inputMap.get( req ).get(0), inputMap.get( req ).get(1) );

            String ifCon = view.askIfOtherReq();

            if ( !( ifCon.equals("Y") || ifCon.equals("y") || ifCon.equals("yes")) ){
                continuous = false;
            }
        }
    }
    
    public void inputStaff(){
        boolean continuous = true;
        while ( continuous ){
            
            String staffName = view.askForStaffName();
            HashMap<String, ArrayList<String []>> inputMap = new HashMap<String, ArrayList<String []>>();
            inputMap.put( staffName, new ArrayList<String []>() );

            String hadSkills = view.askForHadSkills( staffName );
            addInputIntoMap( hadSkills, inputMap, staffName );

            ptt.addStaff( staffName, inputMap.get( staffName ).get(0), new String[]{} );
    
            String IfCon = view.askIfOtherStaff();
            if ( !( IfCon.equals("Y") || IfCon.equals("y") || IfCon.equals("yes")) ){
                continuous = false;
            }
        }
    }

    public void matchReqAndStafff(){
        ptt.tryFillAllReq();
    }

    public void outputDataBase(){
        view.showDataBase();
    }

    public void addInputIntoMap( String inputData, HashMap<String, ArrayList<String []>> inputMap, String req ){
        String [] input = inputData.split(",");
        ArrayList<String []> value = inputMap.get( req );
        value.add( input );
        inputMap.put( req, value );
    }        

}
