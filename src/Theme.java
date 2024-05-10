import javax.swing.*;
import java.awt.*;

public class Theme {
    public Color currentColor;
    public Font currentFont;


    public Color getCurrentColor(){
        return currentColor;
    }
    public void setCurrentColor(Color color){
        currentColor = color;
    }

    public Font getCurrentFont(){return  currentFont;};
    public void setCurrentFont(Font font){currentFont = font;};


}
