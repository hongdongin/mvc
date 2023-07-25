package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.MovieInfoRepository;

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MovieInfoRepository miRepo = new MovieInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/";

		if ("list".equals(uri)) {
			path += "movie-info/list.jsp";
			request.setAttribute("MovieInfoList", miRepo.selectMovieInfoList());
		} else if ("view".equals(uri)) {
			String miNum = request.getParameter("miNum");
			Map<String, String> movieInfo = miRepo.selectMovieInfo(miNum);
			request.setAttribute("movie-info", movieInfo);
		} else if ("insert".equals(uri)) {
			path += "movie-info/insert.jsp";
		} else if ("update".equals(uri)) {
			path += "movie-info/update.jsp";
		} else if ("delete".equals(uri)) {
			path += "movie-info/delete.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";
		if ("insert".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("miTitle", request.getParameter("miTitle"));
			param.put("miDesc", request.getParameter("miDesc"));
			param.put("miGenre", request.getParameter("miGenre"));
			param.put("miCredat", request.getParameter("miCredat"));
			param.put("miCnt", request.getParameter("miCnt"));
			int result = miRepo.insertMovieInfo(param);
			request.setAttribute("msg", "영화등록이 실패하였습니다.");
			if (result == 1) {
				request.setAttribute("msg", "영화등록이 성공하였습니다!");
				request.setAttribute("/url", "/movie-Info/list");
			}
		} else if ("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("miTitle", request.getParameter("miTitle"));
			param.put("miDesc", request.getParameter("miDesc"));
			param.put("miGenre", request.getParameter("miGenre"));
			param.put("miCredat", request.getParameter("miCredat"));
			param.put("miCnt", request.getParameter("miCnt"));
			int result = miRepo.insertMovieInfo(param);
			request.setAttribute("msg", "영화수정이 실패하였습니다.");
			if (result == 1) {
				request.setAttribute("msg", "영화수정이 성공하였습니다!");
				request.setAttribute("/url", "/movie-Info/list");
			}
			}else if("delete".equals(uri)) {
				String miNum = request.getParameter("miNum");
				int result = miRepo.deleteMovieInfo(miNum);
				request.setAttribute("msg", "회원삭제가 실패하였습니다.");
				request.setAttribute("url", "/movie-info/view?uiNum=" + request.getParameter("miNum"));
				if(result==1) {
					request.setAttribute("msg", "회원삭제가 성공하였습니다.");
					request.setAttribute("url", "/movie-info/list");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}

	}
