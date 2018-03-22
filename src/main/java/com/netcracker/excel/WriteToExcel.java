package com.netcracker.excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

/** The class for writing in excel-file
 * @author Tiutiunyk
 * @version 1.0
 */
public class WriteToExcel {

/** The method for writing in excel-file analytics data
 * {@link com.netcracker.analytics.Analytics#reflection(int, int, int)}
 * @param file - name of file witch will be created
 * @param numberOfValues - number of values in working array
 * @param timeResult - analytics data of time-running results
 * **/
    @SuppressWarnings("deprecation")
    public static void excelFile(String file, int numberOfValues, ArrayList<Long> timeResult) throws FileNotFoundException, IOException {
        Workbook book1 = new XSSFWorkbook();
        Sheet sheet1 = book1.createSheet("sortedArray");
        Sheet sheet2 = book1.createSheet("unsortedArray");
        Sheet sheet3 = book1.createSheet("randomArray");
        Sheet sheet4 = book1.createSheet("sortedArrayWithRandom");
        Sheet sheet = sheet1;

        int k = 0;
        for (int i =0; i<4; i++) {
            if(i==1){ sheet1 = sheet2; ++k;}
            if(i==2){ sheet1 = sheet3; ++k;}
            if(i==3){ sheet1 = sheet4; ++k;}

            Row row = sheet1.createRow(0);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue("Sorts");
            Cell cell11 = row.createCell(1);
            cell11.setCellValue(numberOfValues);

            Row row2 = sheet1.createRow(1);
            Cell cell2 = row2.createCell(0);
            cell2.setCellValue("Quick Sort");
            Cell cell22 = row2.createCell(1);
            cell22.setCellValue(timeResult.get(k));

            Row row3 = sheet1.createRow(2);
            Cell cell3 = row3.createCell(0);
            cell3.setCellValue("Merge Sort");
            Cell cell33 = row3.createCell(1);
            cell33.setCellValue(timeResult.get(++k));

            Row row4 = sheet1.createRow(3);
            Cell cell4 = row4.createCell(0);
            cell4.setCellValue("BubbleSortToMin To Max Sort");
            Cell cell44 = row4.createCell(1);
            cell44.setCellValue(timeResult.get(++k));

            Row row5 = sheet1.createRow(4);
            Cell cell5 = row5.createCell(0);
            cell5.setCellValue("BubbleSortToMin To Min Sort");
            Cell cell55 = row5.createCell(1);
            cell55.setCellValue(timeResult.get(++k));

        }

        for (int j = 0; j < 4; j++) {
            if(j==1){ sheet = sheet2;}
            if(j==2){ sheet = sheet3;}
            if(j==3){ sheet = sheet4;}
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = drawing.createAnchor(1, 1, 1, 1, 1, 7, 11, 16);
            Chart chart = drawing.createChart(anchor);
            ChartLegend legend = chart.getOrCreateLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);

            LineChartData data = chart.getChartDataFactory().createLineChartData();

            ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 1, 1, 1));
            ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 4, 1, 1));

            data.addSeries(xs, ys);
            chart.plot(data, bottomAxis, leftAxis);
        }

        book1.write(new FileOutputStream(file));
        book1.close();
    }
}
