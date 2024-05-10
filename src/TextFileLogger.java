import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class TextFileLogger implements Logger {
    private String filePath;

    public TextFileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("日志记录失败: " + e.getMessage());
        }
    }
}