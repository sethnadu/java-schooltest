package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.SchoolApplicationTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void deleteFound()
    {
        courseService.delete(1);
        assertEquals(5, courseService.findAll().size());
    }

    @Test
    public void deleteNotFound()
    {
        courseService.delete(100);
        assertEquals(5, courseService.findAll().size());
    }
}