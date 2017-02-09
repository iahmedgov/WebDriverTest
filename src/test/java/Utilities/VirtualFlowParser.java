package Utilities;

import org.testng.annotations.Test;
import java.util.regex.*;
import java.util.*;


public class VirtualFlowParser {
	
	//Declare Variables
	private StringTokenizer tokens;
	private String page; 
	private String action;
	private String virtualFlow;
	
	// Define Constants for easy maintenance
	private final String startTag1 = "<";
	private final String startTag2 = "[";
	private final String endTag1 = ">";
	private final String endTag2 = "]";
	private final String Delimiter = ":";
	private final Pattern expression1 = Pattern.compile("\\[Insert.*\\]", Pattern.CASE_INSENSITIVE);
	
	public VirtualFlowParser(String vf){
			
			this.virtualFlow = "<Page:AdminLoginPage><Action:setData><Page:AdminLandingPage><Action:Click applicationName>";
			
			//<Page:AdminLoginPage><Action:setData><Page:AdminLandingPage><Action:Click logoutLink>
			
				 // Call CreateFlow twice in order to replace 
				 // Virtual Flow in both the Main and VirtualFlow table  
				// GenerateFlow();
				
				 
				tokens = new StringTokenizer(virtualFlow, startTag1);
			

		}
	
	
	public boolean parseFlow(){
		String pageToken, actionToken;
		int endTag1Pos, startPos;

					if (tokens.hasMoreTokens()) {

				pageToken = tokens.nextToken();
				page = ExtractText(pageToken, endTag1);

				actionToken = tokens.nextToken();
				action = ExtractText(actionToken, endTag1);

				return true;
			} else {
				return false;
			}
	
		}
	
	/**
	 * Retrieves the last parsed virtual flow "Page:" text.
	 * 
	 * @return	the page an action will be performed on.
	 */

	public String getPage() {
		return page;
	}
	/**
	 * Retrieves the last parsed virtual flow "Action:" text.
	 * 
	 * @return	the action that will be performed on a page.
	 */

	public String getAction() {
		return action;
	}
	
	
	
	
	
	/**
	 * Extracts a given text which appears after a delimiter
	 */
	private String ExtractText(String strText, String endTag1) {
		String strTempText = strText;
		int startPos, endPos;
		endPos = strTempText.indexOf(endTag1);
		startPos = strTempText.indexOf(Delimiter);
		strTempText = strTempText.substring(startPos + 1, endPos);
		strTempText = strTempText.trim();
		return strTempText;
	}
	
	
	
	
	
 // @Test
  /*public void f() {
  }*/
}
