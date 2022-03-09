import java.util.Scanner;

import pttsystem.PTTSystem;

public class View {

    private Scanner sc;
    
    private PTTSystem ptt;
    private Controller controller;

    public View( PTTSystem ptt ){
        this.sc = new Scanner( System.in );
        this.ptt = ptt;
        this.controller = null;
    }

    public void getInfo(){
        while( true ){

            System.out.println( "Please input the number to represent the service you want:\n" + 
                                "0 = Input a list of teaching requirements\n" +
                                "1 = Input a list of staff\n" +
                                "2 = Match the requirements and staff\n" +
                                "3 = Show the data" );
            
            controller.process( Integer.parseInt( sc.nextLine() ) );
        }
    }

    public void setController ( Controller controller ){
        this.controller = controller;
    }

    public String askForRequirementName(){
        System.out.println( "Please input a requirement" );
        String req = sc.nextLine();
        return req;
    }

    public String askForNeededSkills( String req ){
        System.out.println( "Please input the needed skills of "+ req + ", saperate them by a comma");
        String skill = sc.nextLine();
        return skill;
    }

    public String askForNeededTrainings( String req ){
        System.out.println( "Please input the needed training of "+ req + ", saperate them by a comma");
        String training = sc.nextLine();
        return training;
    }

    public String askIfOtherReq(){
        System.out.println( "Input another requirement? Y(yes)/N(no)");
        String ifCon = sc.nextLine();
        return ifCon;
    }

    public String askForStaffName(){
        System.out.println( "Please input a name of staff " );
        String staffName = sc.nextLine();
        return staffName;
    }

    public String askForHadSkills( String staffName ){
        System.out.println( "Please input the skills of "+ staffName + ", saperate them by a comma");
        String hadSkills = sc.nextLine();
        return hadSkills;
    }

    public String askIfOtherStaff(){
        System.out.println( "Input another staff? Y(yes)/N(no)");
        String ifCon = sc.nextLine();
        return ifCon;
    }

    public void showDataBase(){
        
        System.out.println( ptt.toString() );
    }
}