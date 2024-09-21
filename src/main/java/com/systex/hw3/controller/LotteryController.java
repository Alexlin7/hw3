package com.systex.hw3.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

import com.systex.hw3.service.LotteryService;

/**
 * Servlet implementation class LotteryController
 */
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryController() {
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
		HashSet<Integer> excludeNumberSet = new HashSet<>();
		int group = 0;
		ArrayList<Integer>[] lotterys;
		
		//1. Retrieve Form Data
		Optional<String> req = Optional.ofNullable(request.getParameter("group"));
		
		if (req.isPresent() && !req.get().isEmpty()) {
			try {
				group = Integer.parseInt(req.get());
			} catch (NumberFormatException e) {
				errorMessages.add("您所輸入的組數並非為有效數字");
			}
			
		} else {
			errorMessages.add("您所輸入的組數為空");
		}
		

		
		req = Optional.ofNullable(request.getParameter("exclude"));
		if (req.isPresent() && !req.get().isEmpty()) {
			try {
				excludeNumberSet = LotteryService.parseExcludeNum(req.get(), excludeNumberSet);
			} catch (Exception e) {
				errorMessages.add(e.getMessage());
			}
			
		} else {
			errorMessages.add("您所輸入的排除數字為空");
		}
		
		if (!errorMessages.isEmpty()) {
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return;//控制權還給container
		}
		
		
		lotterys = new ArrayList[group];
		for (int i = 0; i < group; i++) {
			lotterys[i] = LotteryService.generateLotteryNum(excludeNumberSet);
		}
		request.setAttribute("lotterys", lotterys);
		request.setAttribute("excludeNumber", excludeNumberSet);
		view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
