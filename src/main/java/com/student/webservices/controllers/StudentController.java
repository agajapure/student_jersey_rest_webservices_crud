package com.student.webservices.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.student.webservices.model.Student;
import com.student.webservices.services.StudentService;

@Path("/student")
public class StudentController {

	private StudentService studentService = new StudentService();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStudent(Student student) {
		studentService.saveStudent(student);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentByNo(@PathParam("no") int no) {
		Student student = studentService.getStudentByNo(no);
		return Response.ok().entity(student).build();
	}

	@PUT
	@Path("/{no}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateStudentByNo(@PathParam("no") long no, Student student) {
		studentService.updateStudentByNo(no, student.getName(), student.getDob(), student.getDoj());
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{no}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteStudentByNo(@PathParam("no") long no) {
		studentService.deleteStudentByNo(no);
		return Response.status(202).entity("Student deleted successfully !!").build();
	}

}
