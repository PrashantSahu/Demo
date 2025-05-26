package org.prashant;

import java.util.*;

public class StudentCourseMatching {

    public void mainCaller() {
        int n=10;
        String[][] assignments = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"},
        };

        arrange(assignments);


    }

    private void arrange(String[][] assignments) {

        Map<String, Set<String>> map = new HashMap<>();

        for(String[] assignment: assignments) {
            String studentId = assignment[0];
            String course = assignment[1];

            map.putIfAbsent(studentId, new HashSet<>());
            map.get(studentId).add(course);
        }

        String[] ids = new String[map.size()];
        int index=0;
        for(String id: map.keySet()){
            ids[index++] = id;
        }

        Map<String, List<String>> res = new HashMap<>();

        for(int i=0; i<ids.length; i++) {
            for(int j=i+1; j<ids.length; j++) {

                String id1 = ids[i];
                String id2 = ids[j];
                String key = id1+","+id2;
                res.putIfAbsent(key, new ArrayList<>());

                for(String course: map.get(id1)) {
                    if(map.get(id2).contains(course)) {

                        res.get(key).add(course);
                    }
                }

            }
        }

        System.out.println(res);
        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            String pair = entry.getKey();
            List<String> commonCourses = entry.getValue();
            System.out.println("Student Pair: " + pair);
            System.out.println("  Common Courses: " + commonCourses);
        }

    }
}
