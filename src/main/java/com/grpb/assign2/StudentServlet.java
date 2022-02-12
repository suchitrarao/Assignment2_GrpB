package com.grpb.assign2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*	Date -02/12/2022
	Author - Abhishek Vijayan Nair
	Description - This servlet reads student data from JSON and pass as session attribute to student JSP
*/
/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Create JSON Parser and Read Data from JSON file (student.json)
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(this.getServletContext().getRealPath("/") + "JsonFiles/student.json");
		List<String[]> studentData = new ArrayList<String[]>();
		try {
			Object obj = parser.parse(reader);
			JSONArray studentArray = (JSONArray) obj;

			// Iterate through the student informations and add to String Array
			for (Object o : studentArray) {
				JSONObject student = (JSONObject) o;
				String[] stud = new String[9];
				stud[0] = (String) student.get("firstname");
				stud[1] = (String) student.get("lastname");
				stud[2] = (String) student.get("address");
				stud[3] = String.valueOf(student.get("scoreSubject1"));
				stud[4] = String.valueOf(student.get("scoreSubject2"));
				stud[5] = String.valueOf(student.get("scoreSubject3"));
				stud[6] = String.valueOf(student.get("scoreSubject4"));
				stud[7] = String.valueOf(student.get("scoreSubject5"));
				stud[8] = (String) student.get("phonenumber");
				studentData.add(stud);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create Http session and add student data as a session attribute and redirect to student jsp
		HttpSession session = request.getSession(false);
		session.setAttribute("student-data", studentData);
		response.sendRedirect("students.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
