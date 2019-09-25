package design.TransferObjectPattern;

/**
 * 传输对象模式
 * 创建传输对象。
 */
public class StudentVO {
    private String name;
    private int rollNo;

    StudentVO(String name,int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public StudentVO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
