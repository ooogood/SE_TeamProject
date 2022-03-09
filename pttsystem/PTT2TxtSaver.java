package pttsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class PTT2TxtSaver implements PTTSaver {

	String data = "Placeholder";
	FileWriter file;
	BufferedWriter output;

	public void startSaving() {

		try {
			file = new FileWriter("fileName.txt");
			output =new BufferedWriter(file);
		} catch (IOException e) {
		}
	}


	public void saveStaff( Staff st ) {
		String s = st.getName();
		try {
		output.write(s, 0, s.length());
		output.write(" ");
		} catch (IOException e) {

		}
	
		Requirement y = st.getJob();

		try {
			if(y == null) {
				output.write("null", 0, 4);
			} else {
				output.write(y.getName(), 0, y.getName().length());
			}
			output.write(" ");
		}catch (IOException e) {

		}

		Lox<Skill> x = st.getSkills();

		try {
			
		Lox<Skill>.Iterator it = x.getIter();
		while (it.hasNext()) {
			output.write(it.next().getName());
			output.write(",");
			}

		} catch (IOException e) {

		}

		Lox<Training> t = st.getTrainings();

		try {
			output.write(" ");
		Lox<Training>.Iterator it = t.getIter();
		while (it.hasNext()) {
			output.write(it.next().getName());
			output.write(",");
			}
		
		output.write("/n");
		} catch (IOException e) {

		}

		
		// TODO
		// save the staff as one line: 
		//  "staffName jobName sk1,sk2,... tr1,tr2,..."
	}
	public void saveRequirement( Requirement req ) {

		String r = req.getName();
		try {
			output.write(r, 0, r.length());
			output.write(" ");
		}catch (IOException e) {

		}

		Staff z = req.getTeacher();

		try {
			if(z == null) {
				output.write("null", 0, 4);
			} else {
				output.write(z.getName(), 0, z.getName().length());
			} 
			output.write(" ");
		} catch (IOException e) {

		}

		Lox<Skill> a = req.getSkills();

		try {
			
		Lox<Skill>.Iterator it = a.getIter();
		while (it.hasNext()) {
			output.write(it.next().getName());
			output.write(",");
			}

		} catch (IOException e) {

		}

		Lox<Training> b = req.getTrainings();

		try {
			output.write(" ");
		Lox<Training>.Iterator it = b.getIter();
		while (it.hasNext()) {
			output.write(it.next().getName());
			output.write(",");
			}
		
		output.write("/n");
		} catch (IOException e) {

		}




		// TODO
		// save the requirement as one line: 
		//  "reqName teacherName sk1,sk2,... tr1,tr2,..."

	
	
	}
	public void endSaving() {
		try {
			file.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//we need to safe the staff and the requirement
//Each staff and each requirement is a line thaconvert to list of string and put it in the file that was opened. 
//bufferwriter to open a file in the startSaving 
//closing means you close the open file in endSaving
//lab 3.1
