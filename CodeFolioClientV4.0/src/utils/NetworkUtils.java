package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.ServiceConfigurationError;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.message.HeaderGroup;
import org.apache.http.util.EntityUtils;

import settings.CodeFolioSettings;

import com.google.gson.Gson;

public class NetworkUtils {

	private static Gson gson = new Gson();
	private final static boolean DEBUG = true;

	private static AuthToken token = null;
	private static UserObject user = null;


	public static String getJSON(String url) {
		if (token == null) {
			System.err.println("No Auth Token present, please login, and try again!");
			return "";
		}

		if (DEBUG) {
			System.out.println("\nSending 'GET' request to: " + url);
		}

		try {

			HttpResponse response = Request.Get(url)
					.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken())
					.execute()
					.returnResponse();

			int status = response.getStatusLine().getStatusCode();

			if (DEBUG) {
				System.out.println("Response Code Received: " + status);
			}

			if (status == 200) {

				String responseBody = EntityUtils.toString(response.getEntity());

				if (DEBUG) {
					System.out.println("Response: " + responseBody);
				}

				return responseBody;

			} else {

				return String.valueOf(status);
			}

		} catch (IOException e) {

			return "";
		}
	}

	public static String postJSON(String url, String json) {
		if (token == null) {
			System.err.println("No Auth Token present, please login, and try again!");
			return "";
		}

		if (DEBUG) {
			System.out.println("\nSending 'POST' request to: " + url);
		}

		try {

			HttpResponse response = Request.Post(url)
					.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken())
					.bodyString(json, ContentType.APPLICATION_JSON)
					.execute()
					.returnResponse();

			int status = response.getStatusLine().getStatusCode();

			if (DEBUG) {
				System.out.println("Response Code Received: " + status);
			}

			if (status == 200) {

				String responseBody = EntityUtils.toString(response.getEntity());

				if (DEBUG) {
					System.out.println("Response: " + responseBody);
				}

				return responseBody;

			} else if (DEBUG) {

				try {
					String responseBody = EntityUtils.toString(response.getEntity());
					System.out.println("Response: " + responseBody);
				} catch (Exception e) {}

				
			}

			return String.valueOf(status);	

		} catch (IOException e) {

			return "";
		}
	}


	public static String postFile(String url, File file) {
		if (token == null) {
			System.err.println("No Auth Token present, please login, and try again!");
			return "";
		}

		if (DEBUG) {
			System.out.println("\nSending 'POST' request to: " + url);
		}

		try {

			HttpResponse response = Request.Post(url)
					.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken())
					.bodyFile(file, ContentType.APPLICATION_OCTET_STREAM)
					.execute()
					.returnResponse();

			int status = response.getStatusLine().getStatusCode();

			if (DEBUG) {
				System.out.println("Response Code Received: " + status);
			}

			if (status == 200) {

				String responseBody = EntityUtils.toString(response.getEntity());

				if (DEBUG) {
					System.out.println("Response: " + responseBody);
				}

				return responseBody;

			} else {

				return String.valueOf(status);
			}

		} catch (IOException e) {

			return "";
		}
	}


	public static boolean sendLogin(String username, String password) {

		try {

			List<NameValuePair> payload = Form.form().add("email", username).add("password", password).build(); 

			HttpResponse response = Request.Post(CodeFolioSettings.login)
					.bodyForm(payload)
					.execute()
					.returnResponse();

			int status = response.getStatusLine().getStatusCode();

			if (status == 200) {

				String responseBody = EntityUtils.toString(response.getEntity());
				String userObjectJson = new String(Base64.getDecoder().decode(responseBody.split("\\.")[1]));

				if (DEBUG) {
					System.out.println("Response: " + responseBody);
					System.out.println("JSON Response: " + userObjectJson);
				}

				user = gson.fromJson(userObjectJson, UserObject.class);
				token = gson.fromJson(responseBody, AuthToken.class);

				CodeFolioSettings.setUserId(user.getUserID());
				
				if (DEBUG) {
					System.out.println("User ID: " + user.getUserID());
				}

				return true;
			}

			return false;

		} catch (IOException e) {
			return false;
		}
	}
	public static String postJSON(String remoteHost, Object record) {
		return postJSON(remoteHost, gson.toJson(record));

	}
	public static void main(String[] args) {
		if (NetworkUtils.sendLogin("rob@ucd.ie", "wordpass")) {
			System.out.println("Received Token: " + token.getToken());

			System.out.println(NetworkUtils.getJSON(CodeFolioSettings.REMOTE_HOST + "/api/modules"));
		}
	}
}
