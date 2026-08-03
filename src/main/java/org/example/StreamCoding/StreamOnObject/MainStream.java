package org.example.StreamCoding.StreamOnObject;

import java.util.*;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) throws Exception {
        MainStream mainStream = new MainStream();
        List<Employee> employees = Arrays.asList(
                new Employee("Kishan", "SD", 43000),
                new Employee("Yogesh", "SD", 40000),
                new Employee("Akshay", "SD", 50000),
                new Employee("Amit", "Payroll", 24000),
                new Employee("Akshay", "Support", 20000),
                new Employee("Aniket", "Support", 45000),
                new Employee("Manish", "SD", 200000),
                new Employee("Dinesh", "Support", 45000),
                new Employee("Amol", "SD", 20000),
                new Employee("Ganesh", "SD", 43000)

        );
        mainStream.findFirstEmployeeWhoesSalaryGreaterThan50000(employees);
        mainStream.findTop2EmployeeWithHighestSalary(employees);
        mainStream.sortBySalaryAndName(employees);
        mainStream.countEmployeeDepartmentWise(employees);
        mainStream.finAvgSalaryDepartmentWise(employees);
        mainStream.findHighestSalaryEachDepartment(employees);

        System.out.println("************* Categories **********");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction("Food", 43000),
                new Transaction("Shopping", 40000),
                new Transaction("Bills", 50000),
                new Transaction("Shopping", 24000),
                new Transaction("Food", 20000),
                new Transaction("Fuel", 45000),
                new Transaction("Fuel", 200000),
                new Transaction("Bills", 45000),
                new Transaction("Food", 20000),
                new Transaction("Food", 43000)

        );
        mainStream.findTotalAmountTransactionWise(transactionList);
    }

    private void findHighestSalaryEachDepartment(List<Employee> employees) {
        System.out.println("***** findHighestSalaryEachDepartment ****");

        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.maxBy(Comparator.comparingInt(e -> e.getSalary()))));

        System.out.println(map);
    }

    private void finAvgSalaryDepartmentWise(List<Employee> employees) {
        System.out.println("***** Avg ****");
        Map<String, Double> map = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingInt(el -> el.getSalary())));
        System.out.println(map);
    }

    private void findTotalAmountTransactionWise(List<Transaction> transactionList) {
        Map<String, Integer> collect = transactionList.stream()
                .collect(Collectors.groupingBy(e -> e.getCategory(), Collectors.summingInt(el -> el.getAmount())));
        System.out.println(collect);
    }

    private void countEmployeeDepartmentWise(List<Employee> employees) {
        Map<String, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        System.out.println(collect);
    }

    private void sortBySalaryAndName(List<Employee> employees) {
        System.out.println("***** Sorting ****");
        List<Employee> collect = employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getSalary() > e2.getSalary()) {
                        return 1;
                    } else if (e1.getSalary() < e2.getSalary()) {
                        return -1;
                    } else {
                        return e1.getName().compareTo(e2.getName());
                    }
                })
                .collect(Collectors.toList());

        collect.stream()
                .forEach(System.out::println);
    }

    private void findTop2EmployeeWithHighestSalary(List<Employee> employees) {
        List<Employee> collect = employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getSalary() * -1))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private void findFirstEmployeeWhoesSalaryGreaterThan50000(List<Employee> employees) throws Exception {
        Employee employee = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .findFirst()
                .orElseThrow(Exception::new);
        System.out.println(employee.getName());
    }

}
