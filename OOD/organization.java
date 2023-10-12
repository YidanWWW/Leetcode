package OOD;

import java.util.*;

class OrgChart{
public static void main(String[] args) {
    OrgChart orgChart = new OrgChart();

    String[] testOperations = {
        "add,1,Johnson Drye,-1",
        "add,2,Cristy Sprow,-1",
        // 添加其他操作...
        "remove,3",
        "remove,4",
        "remove,5",
        "add,3,Natacha Seligman,-1",
        "add,4,Brittny Wicks,-1",
        "add,5,Crissy Carden,-1",
        "print"
    };

    for (String operation : testOperations) {
        String[] parts = operation.split(",");
        String command = parts[0];
        
        if (command.equals("add")) {
            // 解析添加操作
            String id = parts[1];
            String name = parts[2];
            String managerId = parts[3];
            orgChart.add(id, name, managerId);
        } else if (command.equals("remove")) {
            // 解析移除操作
            String employeeId = parts[1];
            orgChart.remove(employeeId);
        } else if (command.equals("print")) {
            // 打印操作
            orgChart.print();
        } else if(command.equals("move")){
            orgChart.move(parts[1], parts[2]);
        }else if(command.equals("count")) {
            orgChart.count(parts[1]);
        }
    }
}


    Map<String, List<Employee>> managerEmployeeMap = new HashMap<>(); // managerId
    LinkedHashMap<String, Employee> allEmployeesMap = new LinkedHashMap<>();

    public void add(String id, String name, String managerId){
        // if an employee with an id has been added, 
        //then subsequent additions of employees with the same id are ignored
        if (allEmployeesMap.containsKey(id)) {
            return;
        }
        Employee employee = new Employee(id, name, managerId);
        allEmployeesMap.put(id, employee);
        if(!managerId.equals("-1")) {
            //if this employee has a manager
            // if (managerEmployeeMap.containsKey(managerId)) {
            //     managerEmployeeMap.get(managerId).add(employee);
            // } else {
            //     List<Employee> employees = new ArrayList<>();
            //     employees.add(employee);
            //     managerEmployeeMap.put(managerId, employees);
            // }
            managerEmployeeMap.computeIfAbsent(managerId, k -> new ArrayList<>()).add(employee);
        }
    }

    public void print() {
        for (String managerId : managerEmployeeMap.keySet()) {
            Employee manager = allEmployeesMap.get(managerId);
            System.out.println(manager.getName() + " [" + managerId + "]");
            dfs(managerId, 1); // 调用递归方法来打印报告员工
        }
    }

    private void dfs(String managerId, int depth) {
        List<Employee> reports = managerEmployeeMap.get(managerId);
        if (reports == null) {
            return; // 如果没有报告员工，返回
        }

        for (Employee report : reports) {
            String indentation = " ".repeat(depth); // 缩进
            System.out.println(indentation + report.getName() + " [" + report.getId() + "]");
            dfs(report.getId(), depth + 1); // 递归打印报告员工的报告员工
        }
    }


    public void remove(String employeeId) {
        if(!allEmployeesMap.containsKey(employeeId)) return;
        
        Employee employee = allEmployeesMap.get(employeeId);
        allEmployeesMap.remove(employeeId);
        if(managerEmployeeMap.containsKey(employeeId)) {
            // if this emloyee is a manager
            List<Employee> reports = managerEmployeeMap.get(employeeId);
            String managerId = employee.getManagerId();

            if(!managerId.equals("-1")) {
                managerEmployeeMap.get(managerId).addAll(reports);
            }

            for (Employee report: reports) {
                report.setManagerId("managerId"); //set new manager id
            }
        }
    }

    public void move(String employeeId, String newManagerId) {
        //If an employee of that id does not exist, then do nothing.
        if(!allEmployeesMap.containsKey(employeeId)) return;

        //If an employee with the new manager id does not exist, then do nothing.
        if(!managerEmployeeMap.containsKey(newManagerId)) return;

        Employee employee = allEmployeesMap.get(employeeId);

        //remove
        String oldManager = employee.getManagerId();
        if(!oldManager.equals("-1")) {
            List<Employee> oldManagerEmployees = managerEmployeeMap.get(oldManager);
            oldManagerEmployees.remove(employee);
        }
        //update employee
        employee.setManagerId(newManagerId);

        //add employee to new manager
        managerEmployeeMap.get(newManagerId).add(employee);
    }

    public int count(String employeeId){
        // 首先检查指定的员工是否存在
        int res = 0;
        if (!allEmployeesMap.containsKey(employeeId)) {
            return 0;
        }
        if(managerEmployeeMap.containsKey(employeeId)) {
            List<Employee> directReports = managerEmployeeMap.get(employeeId);
            // 递归计算下级报告员工的数量
            for (Employee report : directReports) {
                res++; // 包括直接下级报告员工
                res += count(report.getId()); // 递归计算间接下级报告员工
            }
        }
        return res;
    }

 

    static class Employee {
        String id;
        String name;
        String managerId;

        public Employee(String id, String name, String managerId) {
            super();
            this.id = id;
            this.name = name;
            this.managerId = managerId;
        }

        public String getId() {
            return id;
        }


        public String getName() {
            return name;
        }
        public String getManagerId() {
            return managerId;
        }

        public void setManagerId(String newManagerId) {
            this.managerId = newManagerId;
        }

    }
}

