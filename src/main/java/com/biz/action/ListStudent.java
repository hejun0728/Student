package com.biz.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.entity.Student;

import com.biz.service.StudentService;
import com.biz.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class ListStudent
 */

public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        String cur_page = request.getParameter("cur_page");
	        StudentService studentService = new StudentServiceImpl();
	        int totalPage = studentService.getTotalPage();
	      
	       
	            List<Student> studentList = null;
			
			try {
				studentList = studentService.getOnePage(Integer.parseInt(cur_page));
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    request.setAttribute("studentList", studentList);
	            request.setAttribute("totalPage", totalPage);
	            request.setAttribute("cur_page", cur_page);
	            request.getRequestDispatcher("list.jsp").forward(request, response);
	      
	    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
