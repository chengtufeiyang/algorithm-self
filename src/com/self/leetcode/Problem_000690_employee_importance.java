package com.self.leetcode;

import java.util.*;

public class Problem_000690_employee_importance {

    public static void main(String[] args) {

    }


    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (null == employees || employees.size() == 0) return 0;
        int len = employees.size();

        Map<Integer,Employee> idToEmp = new HashMap<>(); // 维护一个id与雇员信息的关系
        for (int i = 0; i < len; i++) {
            idToEmp.put(employees.get(i).id,employees.get(i));
        }
        if (null == idToEmp.get(id)) return 0; //如果此id不在信息库中，直接返回0信息
        int result  = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(id);
        while (!stack.isEmpty()){
            int currId = stack.pollFirst();
            result += idToEmp.get(currId).importance;
            for (int i = 0; i < idToEmp.get(currId).subordinates.size(); i++) {
                stack.addLast(idToEmp.get(currId).subordinates.get(i)); // 存储下属id信息
            }
        }
        return result;
    }
}
