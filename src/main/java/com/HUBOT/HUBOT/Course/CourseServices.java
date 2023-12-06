package com.HUBOT.HUBOT.Course;

import com.HUBOT.HUBOT.Enum.CourseType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServices {

    private CourseRepositry courseRepositry;

    public Course addCourse(Course course) {
        Course course1 = courseRepositry.findByCourseNumber(course.getCourseNumber());
        if (course1 == null)
            return courseRepositry.insert(course);
        else
            return null;
    }

    public List<Course> getAllCourses() {
        return courseRepositry.findAll();
    }

    public Course getCourseByCourseNumber(int courseNumber) {
        return courseRepositry.findByCourseNumber(courseNumber);
    }
    public List<Course> getAllCoursesInDepartment(String departmentId) {
        return courseRepositry.findCourseByDepartmentDepartmentId(departmentId);
    }
    public Course updateCourseName(int courseNumber, String CourseName) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        course.setCourseName(CourseName);
        courseRepositry.save(course);
        return course;
    }



    public Course updateCourseNumber(int courseNumber,int courseNewNumber) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if (course != null ){
            course.setCourseNumber(courseNewNumber);
            return course;
        }
        else
            return null;
    }



    public Course updateCourseKeyword(int courseNumber, String newKeyword) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if (course != null){
            course.setKeyword(newKeyword);
            return course;
        }
        else
            return null;
    }
    public Course updateCourseDescription(int courseNumber, String description) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if (course != null) {
            course.setDescription(description);
            return courseRepositry.save(course);
        }
        return null;
    }

    public Course updatePointsOfDifficulty(int courseNumber, int pointsOfDifficulty) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if (course != null) {
            course.setPointsOfDifficulty(pointsOfDifficulty);
            return courseRepositry.save(course);
        }
        return null;
    }

    public Course updateCreditHours(int courseNumber, int creditHours) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if (course != null) {
            course.setCreditHours(creditHours);
            return courseRepositry.save(course);
        }
        return null;
    }
    public Course deleteCourse(int courseNumber) {
        Course course = courseRepositry.findByCourseNumber(courseNumber);
        if(course == null)
            return null;
        else {
            courseRepositry.deleteByCourseNumber(courseNumber);
            return course;
        }
    }

    //used to find specific courses by type in any department
//    public List<Course> getAllObligatoryCoursesByDepartment(String departmentId, CourseType courseType) {
//        return courseRepositry.fineCourseByCourseTypAndDepartment(courseType,departmentId);
//    }
}
