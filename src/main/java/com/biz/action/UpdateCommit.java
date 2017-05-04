package com.biz.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.entity.Student;
import com.biz.service.StudentService;
import com.biz.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateCommit
 */
public class UpdateCommit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        StudentService studentService = new StudentServiceImpl();
	        Student student = new Student();
	        student.setId(request.getParameter("id"));
            student.setName(request.getParameter("name"));
            try {
				student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            student.setDescription(request.getParameter("description"));
            student.setAvgscore(Integer.parseInt(request.getParameter("avgscore").trim()));
	        studentService.updateStudent(student);
	        response.sendRedirect("ListStudent?cur_page=1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
