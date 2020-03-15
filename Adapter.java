package com.company.pattern;
import java.io.FileNotFoundException;
public class Adapter {
    public static void main(String[] args)  {
       //1способ через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaser();
        g1.drawLine();
        g1.drawSquare();
       //2способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaser();
        g2.drawLine();
        g2.drawSquare();

    }
}
interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}
class RasterGraphics {
    void drawRasterLine (){
        System.out.println("РИСУЕМ ЛИНИЮ");
    }
    void drawRasterSquare (){
        System.out.println("РИСУЕМ КВАДРАТ");
    }
}
class VectorAdapterFromRaser extends RasterGraphics implements VectorGraphicsInterface {
    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRaser2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}