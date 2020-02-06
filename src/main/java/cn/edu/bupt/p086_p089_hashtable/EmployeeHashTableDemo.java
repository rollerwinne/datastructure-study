package cn.edu.bupt.p086_p089_hashtable;

public class EmployeeHashTableDemo {
    public static void main(String[] args) {
        EmployeeHashTable employeeHashTable = new EmployeeHashTable(8);
        Employee employee1 = new Employee(1, "emp1");
        Employee employee2 = new Employee(3, "emp3");
        Employee employee3 = new Employee(13, "emp13");
        Employee employee4 = new Employee(13, "emp13-2");
        Employee employee5 = new Employee(8, "emp8");
        employeeHashTable.add(employee1);
        employeeHashTable.add(employee2);
        employeeHashTable.delete(employee2.id);
        employeeHashTable.add(employee3);
        employeeHashTable.update(employee4);
        employeeHashTable.add(employee5);
        employeeHashTable.list();
        System.out.println("-----");
        System.out.println(employeeHashTable.findById(13));
    }

}

class EmployeeHashTable {
    private static int SIZE;
    private EmployeeLinkedList[] employeeHashTable;

    public EmployeeHashTable() {
        SIZE = 7;
        employeeHashTable = new EmployeeLinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            employeeHashTable[i] = new EmployeeLinkedList();
        }
    }

    public EmployeeHashTable(int size) {
        SIZE = size;
        employeeHashTable = new EmployeeLinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            employeeHashTable[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        int num = hashFun(employee.id);
        employeeHashTable[num].add(employee);
    }

    public boolean update(Employee employee) {
        int num = hashFun(employee.id);
        return employeeHashTable[num].update(employee);
    }

    public boolean delete(int id) {
        int num = hashFun(id);
        return employeeHashTable[num].delete(id);
    }

    public void list() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("第" + i + "号链表：");
            employeeHashTable[i].list();
        }
    }

    public Employee findById(int id) {
        int num = hashFun(id);
        return employeeHashTable[num].findById(id);
    }

    private int hashFun(int id) {
        return id % SIZE;
    }
}

class EmployeeLinkedList {
    Employee head = null;

    public void add(Employee employee) {
        if (head == null) {
            head = employee;
            return;
        }
        Employee temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = employee;
    }

    public boolean update(Employee employee) {
        if (head == null)
            return false;
        if (employee.id == head.id) {
            head = employee;
            return true;
        }
        Employee temp = head;
        while (temp.next != null) {
            if (employee.id == temp.next.id) {
                employee.next = temp.next.next;
                temp.next = employee;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean delete(int id) {
        if (head == null)
            return false;
        if (id == head.id) {
            head = null;
            return true;
        }
        Employee temp = head;
        while (temp.next != null) {
            if (id == temp.next.id) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void list() {
        Employee temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public Employee findById(int id) {
        Employee temp = head;
        while (temp != null) {
            if (id == temp.id)
                return temp;
        }
        return null;
    }
}

class Employee {
    int id;
    String name;
    Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
