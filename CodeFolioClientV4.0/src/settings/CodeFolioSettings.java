package settings;

import utils.NetworkUtils;

public class CodeFolioSettings {

	private static CodeFolioSettings thisInstallation;
	public static int userId;
	
	//Python Paths
	public final static String pythonInstallPath ="C:/Users/rober_000/pycharmprojects/FYP_Python/";
	public final static String pythonRemove = pythonInstallPath+"deleteRepo.py";
	public final static String pythonArchive = pythonInstallPath+"zipRepo.py";
	public final static String pythonInitRepo = pythonInstallPath+"initialiseRepo.py";
	public final static String pythonUnzipRepo = pythonInstallPath+"unzipRepo.py";
	//URL Paths
	public final static String REMOTE_HOST = "http://[::1]:8000/";
	public final static String login = REMOTE_HOST+"api/login";
	public final static String comment=REMOTE_HOST+"api/comment";
	public final static String repo=REMOTE_HOST+"api/repo";
	public final static String repos=REMOTE_HOST+"api/repos";
	public final static String modules=REMOTE_HOST+"api/modules";
	
	public final static String archiveSubmitRepo="";
	public final static String database = "codefolio.db";
	
	
	
	public static CodeFolioSettings getInstance() {
		if (thisInstallation == null) {
			thisInstallation = new CodeFolioSettings();
		}
		return thisInstallation;
	}

	public static int getUserId() {
		return userId;
	}

	public static void setUserId(int userId) {
		CodeFolioSettings.userId = userId;
	}
}
