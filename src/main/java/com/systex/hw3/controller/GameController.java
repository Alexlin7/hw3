package com.systex.hw3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;



/**
 * Servlet implementation class GameController
 */
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view;
		LinkedList<String> errorMessages = new LinkedList<>();
		request.setAttribute("errors", errorMessages);
		
		//1. Retrieve Form Data
		int group;
		Object object = request.getParameter("grounp");
		if (object instanceof Integer) {
			group = (int)object;
		} else {
			errorMessages.add("您輸入的組數資料並非為數字");
		}
		if (!errorMessages.isEmpty()) {
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return;//控制權還給container
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
