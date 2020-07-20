package sqlLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * SQLITE是一种数据库,在JVM里面运行的
 */
public class Test {
    public static void main(String[] args) {
        try {
            //加载sqlite驱动
            Class.forName("org.sqlite.JDBC");
            // 连接数据库sqliteTest.db,不用手动创建
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sqliteTest.db");
            // 创建连接对象，是Java的一个操作数据库的重要接口
            Statement statement = connection.createStatement();
            // 判断是否有表tables的存在。有则删除
            statement.executeUpdate("drop table if exists hero");
            // 创建表
            statement.executeUpdate("create table hero(id int,name varchar(20),hp int)");
            //插入数据
            statement.executeUpdate("insert into hero values(1,'Gareen','452')");
            // 搜索数据库，将搜索的放入数据集ResultSet中
            ResultSet rSet = statement.executeQuery("select * from hero");

            while (rSet.next()) { // 遍历这个数据集
                System.out.println("id：" + rSet.getInt(1));
                System.out.println("姓名：" + rSet.getString(2));
                System.out.println("血量：" + rSet.getString(3));
            }
            rSet.close();// 关闭数据集
            connection.close();// 关闭数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
