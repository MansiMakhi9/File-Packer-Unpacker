import java.util.*;

class Student {
    public int Rno;
    public String name;
    public int Age;
    public int Marks;

    public static int Generator;
    static {
        Generator = 0;
    }

    public Student(String str, int X, int Y) {

        this.Rno = ++Generator;
        this.name = str;
        this.Age = X;
        this.Marks = Y;
    }

    public void Display() {
        System.out.println(this.Rno + " " + this.name + " " + this.Age + " " + this.Marks);
    }
}

class DBMS {

    public LinkedList<Student> lobj;

    public DBMS() {
        lobj = new LinkedList<Student>();
    }

    public void StartDBMS() {
        System.out.println("Marvellous DBMS Startred Successfully...");
        System.out.println("Table Schema Is Created Successfully...");
    }

    public void InsertIntoTable(String name, int Age, int marks) {
        Student Sobj = new Student(name, Age, marks);

        lobj.add(Sobj);
    }

    public void SelectFrom() {
        System.out.println("Record From the Student Table :");

        for (Student sref : lobj) {
            sref.Display();
        }
    }

    public void SelectFrom(int no) {

        for (Student sref : lobj) {

            if (sref.Rno == no) {
                sref.Display();
                break;
            }

        }
    }

    public void SelectName(String str) {

        for (Student sref : lobj) {

            if (sref.equals(sref.name)) {
                sref.Display();
                break;
            }

        }
    }

    public int Aggregate_Max() {
        int Max = 0;
        for (Student sref : lobj) {

            if (sref.Marks > Max) {
                Max = sref.Marks;
            }
        }
        return Max;
    }

    public int Aggregate_Min() {
        Student Temp = lobj.get(0);
        int Min = Temp.Marks;
        for (Student sref : lobj) {

            if (sref.Marks < Min) {
                Min = sref.Marks;
            }
        }
        return Min;
    }
}

class Program {

    public static void main(String[] args) {

        DBMS Dobj = new DBMS();

        Dobj.StartDBMS();

        Dobj.InsertIntoTable("Rahul", 23, 89);
        Dobj.InsertIntoTable("Sagar", 22, 90);
        Dobj.InsertIntoTable("Rushi", 23, 95);
        Dobj.InsertIntoTable("Mansi", 22, 96);
        Dobj.InsertIntoTable("Vipul", 23, 89);

        Dobj.SelectFrom();
        Dobj.SelectFrom(4);
        Dobj.SelectName("mansi");

        System.out.println("Maximum marks Are :" + Dobj.Aggregate_Max());

    }
}