package com.example.first.controller;

import com.example.first.entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Mycontroller {
    List<Course>list=new ArrayList<Course>();
    @GetMapping("/home")
    public String homePage(){
        return "This is Home Page";
    }
    //get all courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return list;
    }
    //get courses by courseId
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable long courseId){
        Course c1=null;
        for(Course c:list){
            if(c.getId()==courseId){
                c1=c;
                break;
            }
        }
        return c1;
    }
    //post data
    @PostMapping("/courses")
    public List<Course> postCourse(@RequestBody Course course){
        list.add(course);
        return list;
    }
    //delete data
    @DeleteMapping("/courses/{courseId}")
    public List<Course>deleteCourse(@PathVariable long courseId){
        List<Course>dp=new ArrayList<Course>();
        for(Course c:list){
            if(c.getId()!=courseId){
                dp.add(c);
            }
        }
        list=dp;
        return list;
    }
}
