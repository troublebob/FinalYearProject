package utils;

import settings.CodeFolioSettings;


public class CommentObject extends RecordObject {
	public int id;
	public int authorId;
	public int repoId;
	public String comment;
	
	public CommentObject(int authorid, int repoid, String comment) {
		super();
		this.authorId = authorid;
		this.repoId = repoid;
		this.comment = comment;
		
		this.id = postComment(this);
		
		insert();
	}
	public int postComment(CommentObject comment) {
		return Integer.parseInt(NetworkUtils.postJSON(CodeFolioSettings.comment, comment));
	}
	public void insert(){
		String sql = String.format("INSERT INTO comments(id,authorId,repoId,comment) VALUES(%d,%d,%d,\"%s\");",
				id, authorId, repoId, comment);
		
		System.out.println("Query: " + sql);
		
		super.sqlTransaction(sql);
	}
	public String toString() {
		return String.format("<Comment:%d - Author:%d, Repo:%d, Comment:%s>", id, authorId, repoId, comment);
		
	}
	
	public static void main(String[] args) {
		
		if (NetworkUtils.sendLogin("rob@ucd.ie", "wordpass")) {
			CommentObject comment = new CommentObject(1, 1, "Good job buddy :D");
		
			System.out.println(comment);
		} else {
			System.out.println("Login Failed!");
		}
	}
	
}
