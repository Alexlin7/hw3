package com.systex.hw3.controller;

import com.systex.hw3.service.GameService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;
import java.util.LinkedList;
import java.util.Optional;


/**
 * Servlet implementation class GameController
 */
public class GameController extends HttpServlet {
	@Serial
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


		GameService gameService = new GameService(10, 3);
		HttpSession session = request.getSession();
		session.setAttribute("gameService", gameService);


		view = request.getRequestDispatcher("guess.jsp");
		view.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view;
		LinkedList<String> errorMessages = new LinkedList<>();
		request.setAttribute("errors", errorMessages);
		boolean result;
		int guess = 0;

		Optional<String> req = Optional.ofNullable(request.getParameter("guessNumber"));
		if (req.isPresent() && !req.get().isEmpty()) {
			try {
				if (req.get().contains("-")) {
					errorMessages.add("您所輸入數字為負數");
				} else {
					guess = Integer.parseInt(req.get());
				}
			} catch (NumberFormatException e) {
				errorMessages.add("您所輸入的數字並非為有效數字");
			}

		} else {
			errorMessages.add("您所輸入的數字為空");
		}

		if (!errorMessages.isEmpty()) {
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
			return;//控制權還給container
		}
		HttpSession session = request.getSession();

		GameService gameService = (GameService) session.getAttribute("gameService");
		if (gameService != null) {
			try {
				result = gameService.guessLuckNumber(guess);
				if (result) {
					view = request.getRequestDispatcher("youWin.jsp");
					view.forward(request, response);
					return;
				} else {
					if (gameService.getRemains() == 0) {
						view = request.getRequestDispatcher("youLose.jsp");
						view.forward(request, response);
						return;
					}
				}
			} catch (Exception e) {
				errorMessages.add(e.getMessage());
			}
		}


		view = request.getRequestDispatcher("guess.jsp");
		view.forward(request, response);
	}

}
