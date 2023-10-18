/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Course;

import Business.Profiles.FacultyProfile;
import Business.Profiles.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhangjinming
 */
public class CourseMappingDirectory {
    //Key值是Course Id 每门课对应学生集合，老师（一门课多个老师上）集合
    // + + 判断， 判断学生是不是选了这门课，老师是否教了这门课
    
    //通过课程查学生
    public static Map<String, ArrayList<StudentProfile>> courseStudentMap = new HashMap<>(); //Password 011 其他类可以访问，范围扩大（static）
   
    //通过学生找课程
    public static Map<String, ArrayList<Course>> studentCourseMap = new HashMap<>();
    
    //通过课程查老师 For admin / prof，（一门课多个老师）
    public static Map<String, ArrayList<FacultyProfile>> courseFacultyMap = new HashMap<>();
   
    //通过老师查课程 For admin / prof， （老师与课程关系）（通过老师查课程）
   public static Map<String, ArrayList<Course>> facultyCourseMap = new HashMap<>();
   
   //每次学生注册课程，调用此方法。。
   //Course course 只传id
   //封装
   public static void addStudentProfileForCourse (Course course, StudentProfile studentProfile){
       courseStudentMap.get(course.getId()).add(studentProfile);
   }
   
   //加一个方法帮他门操作两次
   
   //每次老师发布课程
    public static void addFacultyProfileForCourse (Course course, FacultyProfile facultyProfile){
       courseFacultyMap.get(course.getId()).add(facultyProfile);
   }
    
    //教授每发布一个课程，调用此方法
     public static void addCourse (Course course, FacultyProfile faculty){
       facultyCourseMap.get(faculty.getPerson().getName()).add(course);
   }
     
     //学生退课。29
      public static void dropStudentProfileForCourse (Course course, StudentProfile studentProfile){
       courseStudentMap.get(course.getId()).remove(studentProfile);
   }
}

