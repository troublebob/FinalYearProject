package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import settings.CodeFolioSettings;
import settings.CodefolioDataSource;


public class RepoObject extends RecordObject {
	public int id;
	public int userId;
	public String name;
	public String path;
	public String dueDate;
	public int assignId;
	
	public RepoObject(int userId, String name,String path,String dueDate, int assignId) {
		super();
		this.userId = userId;
		this.name = name;
		this.path = path;
		this.dueDate = dueDate;
		this.assignId = assignId;

		this.id = postRepo(this);
		
		insert();
	}
	public RepoObject(int userId, String name,String path,String dueDate) {
		this(userId, name, path, dueDate, -1);
	}	
	public RepoObject(){
		
	}
	public static List<RepoObject> getList(){//String table){
		List<RepoObject> list = new LinkedList<RepoObject>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = CodefolioDataSource.getInstance().createStatement();
			rs = stmt.executeQuery( "SELECT * FROM " + "repos" + ";" );
			while ( rs.next() ) {
				//list.add((RepoObject) rs);
				RepoObject r = new RepoObject();
				
				r.id = rs.getInt("id");
				r.userId = rs.getInt("userId");
				r.name = rs.getString("name");
				r.path = rs.getString("path");
				r.dueDate = rs.getString("dueDate");
				r.assignId = rs.getInt("assignId");
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return list;
	}
	
	public String toString(){
		return("ID "+ this.id+ " Name:" + this.name);
	}
	public void deleteRepoRecord(int id){
		String sql = String.format("DELETE FROM repos WHERE id=%d",id);
		//Need to delete from remote database here
		sqlTransaction(sql);
	}
	public int postRepo(RepoObject repo) {
		return Integer.parseInt(NetworkUtils.postJSON(CodeFolioSettings.repo, repo));
	}
	public void insert(){
		String assignIdText = "null";
		if (assignId != -1) {
			assignIdText = String.valueOf(assignId);
		}
		
		String sql = String.format("INSERT INTO repos(id,userId,assignmentId,path,dueDate,name) VALUES (%d,%d,%s,\"%s\",\"%s\",\"%s\");",
				id, userId, assignIdText, path, dueDate, name);

		System.out.println("Query: " + sql);

		super.sqlTransaction(sql);
	}
	
	public static void main(String[] args){
		if (NetworkUtils.sendLogin("rob@ucd.ie", "wordpass")) {
			RepoObject r = new RepoObject(CodeFolioSettings.userId, "Calc", "/FYP/Archives", "31-8-2015");
		
			System.out.println(r);
			//r.deleteRepoRecord(500);
		} else {
			System.out.println("Login Failed!");
		}
	}
}
