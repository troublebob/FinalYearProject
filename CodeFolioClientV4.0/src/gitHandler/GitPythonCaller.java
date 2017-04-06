package gitHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import settings.CodeFolioSettings;

public class GitPythonCaller{
	
	public String remove(File p) throws IOException{
		String pythonPath = CodeFolioSettings.pythonRemove;
		
		String[] cmd = new String[3];
		cmd[0] = "python";
		cmd[1] = pythonPath;
		cmd[2] = p.getAbsolutePath().toString();
		
		System.out.println(cmd);
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);
		 
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while((line = bfr.readLine()) != null) {
		// display each output line form python script
			System.out.println(line);
		}
		return line;

	}
	public String archive(File p, String moduleCode, String assignmentId, String userId) throws IOException{
		String pythonPath = CodeFolioSettings.pythonArchive;
		
		String[] cmd = new String[5];
		cmd[0] = "python";
		cmd[1] = pythonPath;
		cmd[2] = p.getAbsolutePath().toString();
		cmd[3] = moduleCode;
		cmd[4] = assignmentId;
		cmd[5] = userId;
		
		System.out.println(cmd);
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);
		 
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while((line = bfr.readLine()) != null) {
		// display each output line form python script
		System.out.println(line);
		}
		return line;

	}
	public String initialiseRepo(File p, String language) throws IOException{
		System.out.println(CodeFolioSettings.pythonInstallPath);
		String pythonPath = CodeFolioSettings.pythonInitRepo;
		System.out.println(pythonPath);
		String[] cmd = new String[4];
		cmd[0] = "python";
		cmd[1] = pythonPath;
		cmd[2] = p.getAbsolutePath().toString();
		cmd[3] = language;
		
		System.out.println(cmd);
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);
		 
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while((line = bfr.readLine()) != null) {
		// display each output line form python script
		System.out.println(line);
		}
		return line;

	}
	public String unZipRepo(File p, File r, String s) throws IOException{
		System.out.println(CodeFolioSettings.pythonInstallPath);
		String pythonPath = CodeFolioSettings.pythonUnzipRepo;
		System.out.println(pythonPath);
		String[] cmd = new String[5];
		cmd[0] = "python";
		cmd[1] = pythonPath;
		cmd[2] = p.getAbsolutePath().toString();
		cmd[3] = r.getAbsolutePath().toString();
		cmd[4] = s;
		
		System.out.println(cmd);
		// create runtime to execute external command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);
		 
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while((line = bfr.readLine()) != null) {
		// display each output line form python script
		System.out.println(line);
		}
		return line;
	}
}