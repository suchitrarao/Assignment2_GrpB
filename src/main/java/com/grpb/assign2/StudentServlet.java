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

		String[] firstname = null;
		String[] lastname = null;
		String[] address = null;
		String[] subject1 = null;
		String[] subject2 = null;
		String[] subject3 = null;
		String[] subject4 = null;
		String[] subject5 = null;
		String[] phonenumber = null;

		try {
			Object obj = parser.parse(reader);
			JSONObject studentDetails = (JSONObject) obj;
			JSONArray firstnameList = null;
			JSONArray lastnameList = null;
			JSONArray addressList = null;
			JSONArray subject1List = null;
			JSONArray subject2List = null;
			JSONArray subject3List = null;
			JSONArray subject4List = null;
			JSONArray subject5List = null;
			JSONArray phonenumberList = null;

			// Converting JSONArray to String[]
			firstnameList = (JSONArray) studentDetails.get("firstname");
			firstname = new String[5];
			for (int i = 0; i < firstname.length; i++) {
				firstname[i] = (String) firstnameList.get(i);
			}

			// Converting JSONArray to String[]
			lastnameList = (JSONArray) studentDetails.get("lastname");
			lastname = new String[5];
			for (int i = 0; i < lastname.length; i++) {
				lastname[i] = (String) lastnameList.get(i);
			}

			// Converting JSONArray to String[]
			addressList = (JSONArray) studentDetails.get("address");
			address = new String[5];
			for (int i = 0; i < address.length; i++) {
				address[i] = (String) addressList.get(i);
			}

			// Converting JSONArray to String[]
			subject1List = (JSONArray) studentDetails.get("scoreSubject1");
			subject1 = new String[5];
			for (int i = 0; i < subject1.length; i++) {
				subject1[i] = String.valueOf(subject1List.get(i));
			}

			// Converting JSONArray to String[]
			subject2List = (JSONArray) studentDetails.get("scoreSubject2");
			subject2 = new String[5];
			for (int i = 0; i < subject2.length; i++) {
				subject2[i] = String.valueOf(subject2List.get(i));
			}

			// Converting JSONArray to String[]
			subject3List = (JSONArray) studentDetails.get("scoreSubject3");
			subject3 = new String[5];
			for (int i = 0; i < subject3.length; i++) {
				subject3[i] = String.valueOf(subject3List.get(i));
			}

			// Converting JSONArray to String[]
			subject4List = (JSONArray) studentDetails.get("scoreSubject4");
			subject4 = new String[5];
			for (int i = 0; i < subject4.length; i++) {
				subject4[i] = String.valueOf(subject4List.get(i));
			}

			// Converting JSONArray to String[]
			subject5List = (JSONArray) studentDetails.get("scoreSubject5");
			subject5 = new String[5];
			for (int i = 0; i < subject5.length; i++) {
				subject5[i] = String.valueOf(subject5List.get(i));
			}

			// Converting JSONArray to String[]
			phonenumberList = (JSONArray) studentDetails.get("phonenumber");
			phonenumber = new String[5];
			for (int i = 0; i < phonenumber.length; i++) {
				phonenumber[i] = (String) phonenumberList.get(i);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create Http session and add student data as a session attribute and redirect
		// to student jsp
		HttpSession session = request.getSession(false);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("address", address);
		session.setAttribute("subject1", subject1);
		session.setAttribute("subject2", subject2);
		session.setAttribute("subject3", subject3);
		session.setAttribute("subject4", subject4);
		session.setAttribute("subject5", subject5);
		session.setAttribute("phonenumber", phonenumber);
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
