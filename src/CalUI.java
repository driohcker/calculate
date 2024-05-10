import jdk.dynalink.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalUI extends JFrame {

    private JTextField displayField; // 用于显示数字和结果的文本框
    private JButton[] numberButtons; // 数字按钮
    private JButton JiaButton, JianButton, ChengButton, ChuButton; // 二元运算符按钮
    private JButton PingfanggenButton, DaoshuButton, JueduiButton; // 一元运算符按钮
    private JButton equalsButton, clearButton; // 等于和清除按钮
    private JButton switchThemeButton; // 切换主题按钮
    private double currentResult; // 当前结果
    private String currentOperator; // 当前运算符
    private boolean startNewNumber = true; // 是否开始新数字的标志
    private boolean isDarkTheme = false; // 主题标志
    private List<Logger> loggers = new ArrayList<>();
    private double currentResult_=0;

    public CalUI(){
        setTitle("计算器");
        setSize(300,400);
        //这里设置主题

        //----------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //显示区域
        displayField = new JTextField();
        displayField.setEnabled(false);
        //这里设置主题

        //----------
        Dimension displaySize = new Dimension(300,40);
        displayField.setPreferredSize(displaySize);
        add(displayField,BorderLayout.NORTH);


        //按钮区域
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5行4列的网格布局
        buttonPanel.setOpaque(false);

        // 创建数字按钮
        numberButtons = new JButton[10];
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonListener());
            buttonPanel.add(numberButtons[i]);
        }

        // 创建运算符和其他按钮
        JiaButton = new JButton("+");
        JianButton = new JButton("-");
        ChengButton = new JButton("*");
        ChuButton = new JButton("/");
        PingfanggenButton = new JButton("√");
        JueduiButton = new JButton("||");
        DaoshuButton = new JButton("-1");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        switchThemeButton = new JButton("主题");
        //切换按钮主题

        //添加按钮至面板
        buttonPanel.add(JiaButton);
        buttonPanel.add(JianButton);
        buttonPanel.add(ChengButton);
        buttonPanel.add(ChuButton);
        buttonPanel.add(JueduiButton);
        buttonPanel.add(PingfanggenButton);
        buttonPanel.add(DaoshuButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(switchThemeButton);

        // 添加面板到界面
        add(buttonPanel, BorderLayout.CENTER);

        // 添加监听器
        addActionListeners();

        // 显示界面
        setVisible(true);

        JButton[] buttons = {JiaButton, JianButton, ChengButton, ChuButton,PingfanggenButton, DaoshuButton, JueduiButton,equalsButton, clearButton,switchThemeButton};
        new LightTheme().useTheme(CalUI.this, buttons, numberButtons, displayField);
        isDarkTheme = !isDarkTheme;
    }

    // 数字按钮监听器
    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            displayField.setText(displayField.getText() + command);
        }
    }
    private void addActionListeners() {
        // 运算符监听器
        ActionListener operatorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startNewNumber || displayField.getText().isEmpty()) {
                    try {
                        currentResult = Double.parseDouble(displayField.getText());
                    } catch (NumberFormatException ex) {
                        // 如果文本字段为空或不是数字，设置默认值
                        currentResult = 0;
                    }
                    startNewNumber = false;
                } else {
                    calculateResult();
                }
                currentOperator = e.getActionCommand();
                displayField.setText("");
            }
        };

        // 等于按钮监听器
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
                displayField.setText(String.valueOf(currentResult));
                startNewNumber = true;
            }
        });

        // 清除按钮监听器
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
                currentResult = 0;
                currentOperator = "";
                startNewNumber = true;
            }
        });

        // 切换主题按钮的监听器
        switchThemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton[] buttons = {JiaButton, JianButton, ChengButton, ChuButton,PingfanggenButton, DaoshuButton, JueduiButton,equalsButton, clearButton,switchThemeButton};
                if (!isDarkTheme) {
                    new LightTheme().useTheme(CalUI.this, buttons, numberButtons, displayField);
                    isDarkTheme = !isDarkTheme;
                    log("切换主题: LightTheme");
                } else {
                    new DarkTheme().useTheme(CalUI.this, buttons, numberButtons, displayField);
                    isDarkTheme = !isDarkTheme;
                    log("切换主题: DarkTheme");
                }
            }
        });

        // 为运算符按钮添加监听器
        JiaButton.addActionListener(operatorListener);
        JianButton.addActionListener(operatorListener);
        ChengButton.addActionListener(operatorListener);
        ChuButton.addActionListener(operatorListener);
        JueduiButton.addActionListener(operatorListener);
        PingfanggenButton.addActionListener(operatorListener);
        DaoshuButton.addActionListener(operatorListener);
    }
    private void calculateResult(){
        double numberInDisplay = Double.parseDouble(displayField.getText());

        switch (currentOperator){
            case "+":
            case "-":
            case "*":
            case "/":
                DoubleOperation doubleOperation = DoubleOperationFactory.getResult(currentOperator);
                doubleOperation.setNum1(currentResult);
                currentResult_=currentResult;
                doubleOperation.setNum2(numberInDisplay);
                currentResult =  doubleOperation.getResult();
                log("计算: " + currentResult_ + " " + currentOperator + " " + numberInDisplay + " = " + currentResult);
                currentResult_=0;
                break;
            case "-1":
            case "||":
            case "√" :
                OneOperation oneOperation = OneOperationFactory.getResult(currentOperator);
                oneOperation.setNum(numberInDisplay);
                currentResult = oneOperation.getResult();
                log("计算: " + currentOperator + " " + numberInDisplay + " = " + currentResult);
                break;
        }
    }
    private void log(String message) {
        for (Logger logger : loggers) {
            logger.log(message);
        }
    }
    public void addLogger(Logger logger) {
        loggers.add(logger);
    }
}
