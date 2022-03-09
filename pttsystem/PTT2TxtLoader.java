package pttsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the loader in PTT2Txt kit.
 * It extends SRManagement so that it can read txt at once and use itself as a buffer.
 */

public class PTT2TxtLoader extends SRManagement implements PTTLoader {
	String filename = "data.txt";
	BufferedReader objReader;

	public void startLoading() {
		try {
			FileReader file = new FileReader(filename);
			objReader = new BufferedReader(file);
		} catch (FileNotFoundException e) {
			// not reading anything
			return;
		}

		//Read file
		String strCurrentLine;
		try {
			boolean isStaff = true;
			while ((strCurrentLine = objReader.readLine()) != null) {

				//File separation fror staff and requirements blocks
				if(strCurrentLine.trim().isEmpty()){
					isStaff = false;
					continue;
				}
				String[] object = getObjectAttributes(strCurrentLine);
				String[] skills = getListFromAttribute(object[2]);
				String[] trainings = getListFromAttribute(object[3]);
				//Adding Staff block
				if(isStaff){
					//Adding job as requirement
					if(object[1] != null){
						addReq(object[1], skills, trainings);
					}
					addStaff( object[0], skills, trainings);
				}
				//Adding a Requirement
				else{
					addReq(object[0], skills, trainings);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
			 	if (objReader != null)
			  	objReader.close();
			} catch (IOException ex) {
			 	ex.printStackTrace();
			}
		}
	}
	public Lox<Staff> getStaffs() {
		return this.lost;
	}
	public Lox<Requirement> getRequirements() {
		return this.lorq;
	}

	public void endLoading() {
		try {
			objReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// Convert an inline object  to a list of attributes
	private String[] getObjectAttributes(String strCurrentLine){

		List<String> arrays = new ArrayList<String>();
		Pattern bracketsRegex = Pattern.compile("\\{(.*?)\\}");
		Matcher regexMatcher = bracketsRegex.matcher(strCurrentLine);

		while (regexMatcher.find()) {//Finds Matching Pattern in String
			arrays.add(regexMatcher.group(1));//Fetching Group from String
		}
		String[] singleAttributes = strCurrentLine.replaceAll("\\{.*\\}", "").split(",");
		
		String[] object = new String[4];
		for(int i = 0; i < 2 && i < singleAttributes.length; i++){
			object[i] = i<singleAttributes.length ? singleAttributes[i] : null;
		}
		for(int i = 0; i < 2 && i < arrays.size(); i++){
			object[i+2] = i<arrays.size() ? arrays.get(i) : null;
		}
		
		return object;
	}
	private String[] getListFromAttribute(String line){
		return line == null || line.trim().isBlank() ? new String[0] : line.replaceAll("\\{", "").replaceAll("\\}", "").split(",");
	}
}
