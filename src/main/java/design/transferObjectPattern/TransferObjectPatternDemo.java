package design.transferObjectPattern;

/**
 * 使用 StudentBO 来演示传输对象设计模式。
 */
public class TransferObjectPatternDemo {

    public static void main(String[] args) {
        StudentBO studentBusinessObject = new StudentBO();

        //输出所有的学生
        for (StudentVO student : studentBusinessObject.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo()+", Name : "+student.getName()+" ]");
        }

        //更新学生
        StudentVO student = studentBusinessObject.getAllStudents().get(0);
//        student.setName("Michael");
//        studentBusinessObject.updateStudent(student);
        //删除学生
        studentBusinessObject.deleteStudent(student);

        //获取学生
        studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo()+", Name : "+student.getName()+" ]");
    }
}
