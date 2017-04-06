package utils;

import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;

import settings.CodeFolioSettings;
import settings.CodefolioDataSource;

public class RecordObject {
	//protected String url = CodeFolioSettings.REMOTE_HOST;
	//public int id;
	
	public String toJSON(){
		Gson gson = new Gson();
        String jsonString = gson.toJson(this);
		return jsonString;
	}
	// to be honest, I don't think the different records should interit from a common object
	// because Repositories, and Users shouldn't share anything. They are completely separate concepts, they
	// just happen to have a common field called ID... I know the common code for sql transaction is the only thing comments
	//and repos share really I was trying to write list code that could call both becausse it was quite similar but would end up
	//taking more code so I might just bin this superclass
	// literally no need for it at the moment. like if you had different user roles, where admin inherits from user, or something
	// it would make sense, but it seems likes its adding obsure OO for the sake of it.
	// and with nobody ever going to look at the code, its probably better to aim for working rather that OO strictness
	//Actually I can use it like now just get rid of the fields
	
	public void sqlTransaction(String sql){
		try {
			Statement stmt = CodefolioDataSource.getInstance().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
