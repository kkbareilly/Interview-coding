package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeadDepartment implements  Department{
    private int departmentId;
    private String departmentName;

    List<Department> departments;
    HeadDepartment(int departmentId,String departmentName){
        this.departmentId=departmentId;
        this.departmentName=departmentName;
        this.departments=new ArrayList<>();
    }
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void printDepartment() {
       // System.out.println(departments.stream().map(s->s.printDepartment()).collect(Collectors.joining(",")));
    }
    private void addDepartment(Department department){
        departments.add(department);
    }

    private void removeDepartment(Department department){
        departments.remove(department);
    }
}
