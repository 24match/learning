package swing;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * @Author
 * @Date 2019/10/11 9:53
 * @Version
 */
public class HelloWroldSwing {

    public static void createShowGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello world" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        invokeLater(new Runnable() {
            public void run() {
                createShowGUI();
            }
        });
    }

}
