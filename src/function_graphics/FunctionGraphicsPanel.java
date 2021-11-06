package function_graphics;

import javax.swing.*;
import java.awt.*;

public class FunctionGraphicsPanel extends JFrame {

    private int width = 1024;
    private int heigth = 768;

    private boolean isSin,isCos,isTan,isCot;

    public FunctionGraphicsPanel(boolean isSin, boolean isCos, boolean isTan, boolean isCot){
        this.isSin = isSin;
        this.isCos = isCos;
        this.isTan = isTan;
        this.isCot = isCot;
        initUI();
    }


    void initUI(){
        Surface surface = new Surface(width,heigth,isSin,isCos,isTan,isCot);
        add(surface);
        setTitle("Fonksiyon Grafikleri");
        setSize(width+16,heigth+39);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

}
