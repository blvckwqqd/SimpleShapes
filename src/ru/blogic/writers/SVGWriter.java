package ru.blogic.writers;

import ru.blogic.enums.Shape;
import ru.blogic.items.Item;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public class SVGWriter {
    private PrintWriter pw;
    private String filename;


    public SVGWriter(String filename) {
        if(filename.endsWith(".svg")){
            this.filename = filename;
        }else{
            this.filename = filename.concat(".svg");
        }
        try{
            File tempFile = new File(this.filename);
            if(tempFile.createNewFile()){
                this.pw = new PrintWriter(tempFile);
            } else {
                Files.deleteIfExists(Path.of(filename));
                tempFile.createNewFile();
                this.pw = new PrintWriter(tempFile);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeHeader(int w, int h){
        this.pw.println("<?xml version=\"1.0\"?>");
        this.pw.format("<svg width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\"\n", w, h, w, h);
        this.pw.println("xmlns=\"http://www.w3.org/2000/svg\">");

    }
    public void writeRect(int x, int y, int w, int h, String lineColor, String fillColor){
        this.pw.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" style=\"fill:%s;stroke:%s\"/>\n",x,y,w,h,fillColor,lineColor);
    }
    public void writeRoundRect(int x, int y, int w, int h,int r1, int r2, String lineColor, String fillColor){
        this.pw.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" rx=\"%d\" ry=\"%d\"\n" +
                "style=\"fill:%s;stroke:%s\"/>\n", x,y,w,h,r1,r2,fillColor,lineColor);
    }
    public void writeEllipse(int cx, int cy, int rx, int ry, String lineColor, String fillColor){
        this.pw.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" style=\"fill:%s;stroke:%s;stroke-" +
                "width:1px\"/>\n", cx,cy,rx,ry,fillColor,lineColor);
    }

    public void writeText(int x, int y, String text){
        this.pw.format("<text x=\"%d\" y=\"%d\">%s</text>",x,y,text);
    }

    public void writeFooter(){
        this.pw.println("</svg>");
        this.pw.flush();
        this.pw.close();
    }

}


