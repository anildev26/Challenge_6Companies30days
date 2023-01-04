package challenge_6Company_30Days;

import java.util.*;

public class mCourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //create adjacency list
        ArrayList<Integer>[] courses = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            courses[i] = new ArrayList();
        }
        for(int[] p : prerequisites){
            courses[p[0]].add(p[1]);
        }

        boolean[] processing = new boolean[numCourses];
        boolean[] checkedNoCycle = new boolean[numCourses];

        for(int currCourse = 0; currCourse < numCourses; currCourse++){
            //check current course causing cycle
            if(isCycle(currCourse, courses, processing, checkedNoCycle)) return false;
        }

        return true;
    }

    private static boolean isCycle(int currCourse, ArrayList<Integer>[] courses, boolean[] processing, boolean[] checkedNoCycle){
        //Is this course already passed cycle detection
        if(checkedNoCycle[currCourse]) return false;

        //currently processing means cycle detected
        if(processing[currCourse]) return true;

        //current courses is not dependent upon any other course
        if(courses[currCourse].size() == 0) return false;

        //mark current course as processing
        processing[currCourse] = true;

        for(int neighbor : courses[currCourse]){
            if(isCycle(neighbor, courses, processing, checkedNoCycle)) {
                return true;
            }
        }

        //now processing of current course is finished
        processing[currCourse] = false;

        //mark current course as checked and not found cycle
        checkedNoCycle[currCourse] = true;

        return false;
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{1, 0},{0, 1}};
        System.out.println(canFinish(numCourses,prerequisites));

    }
}
