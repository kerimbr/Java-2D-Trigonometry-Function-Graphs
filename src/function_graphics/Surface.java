package function_graphics;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.QuadCurve2D;

public class Surface extends JPanel {

    private int width,height;
    private boolean isSin,isCos,isTan,isCot;


    private int containerWidth, containerHeight;
    private int amplitudeY;
    private int infoTextSpace = 30;


    public Surface(int width, int height, boolean isSin, boolean isCos, boolean isTan, boolean isCot) {
        this.width = width;
        this.height = height;

        this.isSin = isSin;
        this.isCos = isCos;
        this.isTan = isTan;
        this.isCot = isCot;

        containerWidth = (int) (width - width *0.05);
        containerHeight = (int) (height - height *0.05);
        amplitudeY = height/4;

    }



    int calcSinValue(int x){
        return height/2 - (int) (amplitudeY *  Math.sin(x*Math.PI/180));
    }

    int calcCosValue(int x){
        return height/2 - (int) (amplitudeY *  Math.cos(x*Math.PI/180));
    }


    int calcTanValue(int x){
        return height/2 - (int) (amplitudeY *  Math.tan(x*Math.PI/180));
    }

    int calcCotValue(int x){
        return height/2 - (int) (amplitudeY / Math.tan(x*Math.PI/180));
    }



    void doDrawing(Graphics g){
        Graphics2D g2d = (Graphics2D) g;


        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);


        drawCoordinate(g2d);

        float[] dash = { 3f, 3f, 3f };

        BasicStroke basicStroke = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash, 2f );

        g2d.setStroke(basicStroke);

        if (isSin)
            drawSinFunctionGraphic(g2d);

        if (isCos)
            drawCosFunctionGraphic(g2d);

        if(isTan)
            drawTanFunctionGraphic(g2d);

        if (isCot)
            drawCotFunctionGraphic(g2d);


        g2d.dispose();

    }



    void drawCoordinate(Graphics2D g2d){

        g2d.drawLine(width/2, (int) (height*0.05),width/2, containerHeight);
        g2d.drawLine((int) (width*0.05),height/2,containerWidth,height/2);

        //g2d.drawString("O(0,0)",width/2 + 5,height/2 - 5);

        g2d.drawLine(width/2, (int) (height*0.05),width/2 - 10 , (int) (height*0.05) + 10);
        g2d.drawLine(width/2,(int) (height*0.05), width/2 + 10,(int) (height*0.05) + 10);

        g2d.drawString("+y",width/2 + 15 , (int) (0+height*0.05) + 5);

        g2d.drawLine(width/2,containerHeight, width/2 - 10, containerHeight-10);
        g2d.drawLine(width/2, containerHeight, width/2 + 10, containerHeight-10);

        g2d.drawString("-y",width/2 + 15 , containerHeight + 5);

        g2d.drawLine( containerWidth,height/2, containerWidth - 10, height/2 -10);
        g2d.drawLine( containerWidth,height/2, containerWidth - 10, height/2 +10);

        g2d.drawString("+x", containerWidth + 15, height/2 + 5);

        g2d.drawLine((int) (width*0.05),height/2, (int) (width*0.05 + 10), height/2 + 10);
        g2d.drawLine((int) (width*0.05),height/2, (int) (width*0.05 + 10), height/2 - 10);

        g2d.drawString("-x",(int) (width*0.05 - 15),height/2 + 10);

        float[] dash = { 5f, 5f, 5f };

        BasicStroke basicStroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash, 2f );

        g2d.setStroke(basicStroke);

        g2d.setColor(new Color(36,36,36,50));
        g2d.drawLine(0,height/2 - amplitudeY,width, height/2 - amplitudeY);
        g2d.drawLine(0,height/2 + amplitudeY,width, height/2 + amplitudeY);


        g2d.setColor(Color.MAGENTA);

        g2d.drawString("-1",width/2 + 5, height/2 - amplitudeY);
        g2d.drawString("0",width/2 + 5, height/2 );
        g2d.drawString("-1",width/2 + 5, height/2 + amplitudeY);

        g2d.drawString("2 \u03c0",width/2 + 360, height/2 - 5);
        g2d.drawString("-2 \u03c0",width/2 - 360, height/2 - 5);


        g2d.drawString("\u03c0",width/2 + 180, height/2 - 5);
        g2d.drawString("- \u03c0",width/2 - 180, height/2 - 5);

    }

    void drawSinFunctionGraphic(Graphics2D g2d) {
        GeneralPath sinPath = new GeneralPath();

        sinPath.moveTo(width/2 - 360, calcSinValue(-360));

        for (int i = -360; i <= 360; i++) {
            sinPath.lineTo(
                    width/2 + i,
                    calcSinValue(i)
            );
        }


        g2d.setColor(Color.red);

        g2d.draw(sinPath);

        g2d.drawString("- Sinus Grafiği",30,infoTextSpace);
        infoTextSpace += 20;

    }

    void drawCosFunctionGraphic(Graphics2D g2d) {
        GeneralPath cosPath = new GeneralPath();

        cosPath.moveTo(width/2 - 360,calcCosValue(-360));

        for (int i = -360; i <= 360; i++) {
            cosPath.lineTo(
                    width/2 + i,
                    calcCosValue(i)
            );
        }


        g2d.setColor(Color.BLUE);

        g2d.draw(cosPath);


        g2d.drawString("- Cosinus Grafiği",30,infoTextSpace);
        infoTextSpace += 20;
    }

    void drawCotFunctionGraphic(Graphics2D g2d) {
        GeneralPath cotPath = new GeneralPath();

        cotPath.moveTo(width/2 - 360,calcCotValue(-360));

        for (int i = -360; i <= 360; i++) {
            cotPath.lineTo(
                    width/2 + i,
                    calcCotValue(i)
            );
        }


        g2d.setColor(Color.orange);

        g2d.draw(cotPath);

        g2d.drawString("- Cotanjant Grafiği",30,infoTextSpace);
        infoTextSpace += 20;

    }

    void drawTanFunctionGraphic(Graphics2D g2d) {
        GeneralPath tanPath = new GeneralPath();

        tanPath.moveTo(width/2 - 360,calcTanValue(-360));

        for (int i = -360; i <= 360; i++) {
            tanPath.lineTo(
                    width/2 + i,
                    calcTanValue(i)
            );
        }


        g2d.setColor(Color.GREEN);

        g2d.draw(tanPath);


        g2d.drawString("- Tanjant Grafiği",30,infoTextSpace);
        infoTextSpace += 20;
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
