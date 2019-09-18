package com.lambdaschool.school.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.controller.CourseController;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CourseController.class, secure = false)
public class CourseControllerUnitTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception
    {
        courseList = new ArrayList<>();

        Instructor i1 = new Instructor("Sally");
        Instructor i2 = new Instructor("Lucy");
        Instructor i3 = new Instructor("Charlie");

        Student s1 = new Student("John");
        Student s2 = new Student("Julian");
        Student s3 = new Student("Mary");
        Student s4 = new Student("Julian");
        Student s5 = new Student("Tyler");
        Student s6 = new Student("Kim");
        Student s7 = new Student("Juan");
        Student s8 = new Student("Robby");
        Student s9 = new Student("Roberto");
        Student s10 = new Student("Bob");
        Student s11 = new Student("Liz");
        Student s12 = new Student("June");
        Student s13 = new Student("April");

        Course c1 = new Course("Data Science", i1);
        Course c2 = new Course("JavaScript", i1);
        Course c3 = new Course("Node.js", i1);
        Course c4 = new Course("Java Back End", i2);
        Course c5 = new Course("Mobile IOS", i2);
        Course c6 = new Course("Mobile Android", i3);

        s1.getCourses().add(c1);
        s1.getCourses().add(c4);
        s2.getCourses().add(c2);
        s3.getCourses().add(c3);
        s3.getCourses().add(c1);
        s3.getCourses().add(c6);

       courseList.add(c1);
       courseList.add(c2);
       courseList.add(c3);
       courseList.add(c4);
       courseList.add(c5);
       courseList.add(c6);

        System.out.println("CourseList" + courseList);

    }

    @After
    public void tearDown() throws Exception
    {
    }

//    @Test
//    public void listAllCourses() throws Exception
//    {
//        String apiUrl = "/courses/courses";
//
//        Mockito.when(courseService.findAll()).thenReturn(courseList);
//
//        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
//        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
//        String tr = r.getResponse().getContentAsString();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String er = mapper.writeValueAsString(courseList);
//
//        System.out.println("Expected" + tr);
//        System.out.println("Actual " + er);
//
//        assertEquals("Rest API Returns List", er, tr);
//    }


}
