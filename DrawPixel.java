import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;public class DrawPixel extends Frame {    public Point mypoint = new Point();
    public static void drawPixel(Graphics g, int x, int y, int size, Paint color)
    {        Graphics2D ga = (Graphics2D)g;
        Shape circle = new Ellipse2D.Float(x, y, size, size);
        ga.setPaint(color);
        ga.draw(circle);
        ga.setPaint(color);
        ga.fill(circle);
    }    public void paint(Graphics g) {        drawPixel(g,mypoint.x, mypoint.y, 1, Color.black);
    }    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        System.out.format("Informe o valor de X: ");
        float x = entrada.nextFloat();
        System.out.format("Informe o valor de Y: ");
        float y = entrada.nextFloat();
        entrada.close();
        float dcx, dcy;
        float ndcx = x/400;
        float ndcy = y / 400;
        dcx = ndcx*1279;
        dcy = ndcy*1023;
        System.out.println(dcx);
        System.out.println(dcy);        DrawPixel frame = new DrawPixel();
        frame.mypoint.x = (int)dcx;
        frame.mypoint.y = (int)dcy;        frame.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    System.exit(0);
                }
            }
        );        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}