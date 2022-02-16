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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*	Date -02/12/2022
	Author - Sanjay / Kevin
	Description - This servlet reads height, base of triangle and side of square from JSON and 
					calculate area for both, pass as session attribute to area JSP
*/
/**
* Servlet implementation class StudentServlet
*/
/**
 * Servlet implementation class CalculateAreaServlet
 */
@WebServlet("/CalculateAreaServlet")
public class CalculateAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculateAreaServlet() {
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

		// Read Json from system
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(this.getServletContext().getRealPath("/") + "JsonFiles/area.json");
		try {
			Object obj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;

			Double height = (Double) jsonObject.get("height");
			Double base = (Double) jsonObject.get("base");
			Double side = (Double) jsonObject.get("side");

			// Calculate area of triangle and square
			Double triangleArea = (0.5) * (base * height);
			Double squareArea = side * side;

			// Creating HTTP Session and setting attributes
			HttpSession session = request.getSession(false);
			session.setAttribute("height", height);
			session.setAttribute("base", base);
			session.setAttribute("triangle-area", triangleArea);
			session.setAttribute("side", side);
			session.setAttribute("square-area", squareArea);

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Redirecting to Area JSP File
		response.sendRedirect("area.jsp");
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
