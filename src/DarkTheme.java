import javax.swing.*;
import java.awt.*;

public class DarkTheme extends Theme{
    Color currentColor = Color.WHITE;
    Color backgroundColor = Color.DARK_GRAY;
    Font currentFont = new Font("黑体",Font.BOLD,16);

    public void useTheme(JFrame jFrame,JButton[] buttons,JButton[] numbuttons,JTextField jtextField){
        //设置背景主题
        jFrame.getContentPane().setForeground(currentColor);
        jFrame.getContentPane().setBackground(backgroundColor);
        jFrame.getContentPane().setFont(currentFont);

        //设置按钮主题
        for (JButton button : buttons) {
            button.setForeground(currentColor); // 设置按钮文本颜色
            button.setBackground(backgroundColor);
            button.setFont(currentFont); // 设置按钮文本字体
            // 可以添加更多按钮样式设置，如背景颜色等
        }
        for (JButton numbutton : numbuttons) {
            numbutton.setForeground(currentColor); // 设置按钮文本颜色
            numbutton.setBackground(backgroundColor);
            numbutton.setFont(currentFont); // 设置按钮文本字体
            // 可以添加更多按钮样式设置，如背景颜色等
        }
        jtextField.setBackground(backgroundColor);
        jtextField.setForeground(currentColor);
        jtextField.setFont(currentFont);
        //刷新界面
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

}
