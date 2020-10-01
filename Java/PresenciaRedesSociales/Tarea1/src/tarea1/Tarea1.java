/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author carlo
 */
public class Tarea1 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream nombreArchivo = new FileInputStream("Presencia Redes Sociales.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(nombreArchivo);
            XSSFSheet hoja = libro.getSheetAt(0);
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;
            ArrayList faceCreci = new ArrayList();
            ArrayList twitSeg = new ArrayList();
            ArrayList twitCreci = new ArrayList();
            ArrayList youVisu = new ArrayList();

            Row fila;
            Cell celda;
            
            while (filas.hasNext()) {
                fila = filas.next();
                celdas = fila.cellIterator();
                while (celdas.hasNext()) {
                    celda = celdas.next();
                    switch (fila.getRowNum()) {
                        case 2:
                            faceCreci.add(0,celda );
                            break;
                        case 8:
                            twitSeg.add(0, celda);
                            break;
                        case 9:
                            twitCreci.add(0, celda);
                            break;
                        case 16:
                            youVisu.add(0, celda);
                            break;

                    }

//                    switch (celda.getCellType()) {
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.println(celda.getNumericCellValue());
//                            break;
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.println(celda.getStringCellValue());
//                            break;
//                    }
                }
                libro.close();

            }
   
            Float difSegFace = Float.parseFloat(faceCreci.get(6).toString()) - Float.parseFloat(faceCreci.get(11).toString());         
            System.out.println("La diferencia de seguidores en FaceBook de enero a junio es de : " + difSegFace);
            Float promCrecFace = 0.0f;
            Float promCrecTwit = 0.0f;
            for (int i = 0; i < 12; i++) {
                promCrecFace += Float.parseFloat(faceCreci.get(i).toString());
            }
            for (int i = 0; i < 12; i++) {
                promCrecTwit += Float.parseFloat(twitCreci.get(i).toString());
            }
            System.out.println("El promedio de crecimiento de segidores de FaceBook es de: " + (promCrecFace / 6));
            System.out.println("El promedio de crecimiento de segidores de Twitter es de: " + (promCrecTwit / 6));
            Scanner mes = new Scanner(System.in);
            System.out.println("Para clacular la diferencia de visualizaciones en YouTube ingrese el mes inicial: ");
            String m = mes.nextLine();
            int mes1 = 0;
            switch (m){
                case "ENERO":
                    mes1 = 11;
                break;    
                case "FEBRERO":
                    mes1 = 10;
                break;
                case "Marzo":
                    mes1 = 9;
                break;
                case "ABRIL":
                    mes1 = 8;
                break;
                case "MAYO":
                    mes1 = 7;
                break;
                case "JUNIO":
                    mes1 = 6;
                break;   
            }
            System.out.println("Ingrese el mes a comparar : ");
            m = mes.nextLine();
            int mes2 = 0;
            switch (m){
                case "ENERO":
                    mes2 = 11;
                break;    
                case "FEBRERO":
                    mes2 = 10;
                break;
                case "Marzo":
                    mes2 = 9;
                break;
                case "ABRIL":
                    mes2 = 8;
                break;
                case "MAYO":
                    mes2 = 7;
                break;
                case "JUNIO":
                    mes2 = 6;
                    break;
            }
            Float a = (Float.parseFloat(youVisu.get(mes2).toString())) - (Float.parseFloat(youVisu.get(mes1).toString()));
            System.out.println("La diferencia de visualizaciones es de: " + a);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
