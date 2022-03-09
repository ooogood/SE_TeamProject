package pttsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class PTT2TxtSaver implements PTTSaver {
	String filename = "FileName.txt";
	FileWriter fw;
	BufferedWriter output;
	boolean bSavingStaff = true;
	// open a txt file to write
	public void startSaving() {
		try {
			fw = new FileWriter(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// save a staff object
	public void saveStaff( Staff st ) {
		try {
			// new line if change saving item type
			if( !bSavingStaff ) {
				fw.write("\n");
				bSavingStaff = true;
			}
			// 1. save name
			String s = st.getName();
			fw.write(s, 0, s.length());
			fw.write(",");
			// 2. save job name
			Requirement y = st.getJob();
			if(y != null) {
				fw.write(y.getName(), 0, y.getName().length());
			}
			fw.write(",{");
			// 3. save all skills
			Lox<Skill>.Iterator skIt = st.getSkills().getIter();
			while (skIt.hasNext()) {
				fw.write(skIt.next().getName());
				fw.write(",");
			}
			fw.write("},{");
			// 4. save all trainings
			Lox<Training>.Iterator trIt = st.getTrainings().getIter();
			while (trIt.hasNext()) {
				fw.write(trIt.next().getName());
				fw.write(",");
			}
			fw.write("}\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveRequirement( Requirement req ) {
		try {
			// new line if change saving item type
			if( bSavingStaff ) {
				fw.write("\n");
				bSavingStaff = false;
			}
			// 1. save the requirement name
			String r = req.getName();
			fw.write(r, 0, r.length());
			fw.write(",");
			// 2. save the teacher's name
			Staff z = req.getTeacher();
			if(z != null) {
				fw.write(z.getName(), 0, z.getName().length());
			} 
			fw.write(",{");
			// 3. save all required skills
			Lox<Skill>.Iterator rqIt = req.getSkills().getIter();
			while (rqIt.hasNext()) {
				fw.write(rqIt.next().getName());
				fw.write(",");
			}
			fw.write("},{");
			// 4. save all required trainings
			Lox<Training>.Iterator trIt = req.getTrainings().getIter();
			while (trIt.hasNext()) {
				fw.write(trIt.next().getName());
				fw.write(",");
			}
			fw.write("}\n");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void endSaving() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

