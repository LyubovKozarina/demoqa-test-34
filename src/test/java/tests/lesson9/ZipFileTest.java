package tests.lesson9;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZipFileTest {
    private final ClassLoader cl = ZipFileTest.class.getClassLoader();

    @Test
    void parsePdfTest() throws Exception {
        try (InputStream is = getFileFromZip("files.zip", ".pdf")) {
            assertNotNull(is, "Файл .pdf не найден в архиве");
            PDF pdf = new PDF(is);
            assertTrue(pdf.text.contains("Hello"), "PDF-файл не содержит 'Hello'");
        }
    }

    @Test
    void parseExcelTest() throws Exception {
        try (InputStream is = getFileFromZip("files.zip", ".xlsx")) {
            assertNotNull(is, "Файл .xlsx не найден в архиве");

            XLS xls = new XLS(is.readAllBytes());

            boolean containsHello = xls.excel.sheetIterator()
                    .next()
                    .rowIterator()
                    .hasNext() && xls.excel.getSheetAt(0)
                    .rowIterator()
                    .next()
                    .cellIterator()
                    .hasNext() && xls.excel.getSheetAt(0)
                    .rowIterator()
                    .next()
                    .cellIterator()
                    .next()
                    .toString()
                    .contains("Hello");

            assertTrue(containsHello, "Excel-файл не содержит 'Hello'");
        }
    }


    @Test
    void parseCsvTest() throws Exception {
        try (InputStream is = getFileFromZip("files.zip", ".csv");
             InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReader(reader)) {

            assertNotNull(is, "Файл .csv не найден в архиве");
            List<String[]> csvData = csvReader.readAll();

            boolean containsHello = csvData.stream()
                    .flatMap(row -> List.of(row).stream())
                    .anyMatch(cell -> cell.contains("Hello"));

            assertTrue(containsHello, "CSV-файл не содержит 'Hello'");
        }
    }

    private InputStream getFileFromZip(String zipFileName, String fileExtension) throws IOException {
        try (InputStream is = cl.getResourceAsStream(zipFileName);
             ZipInputStream zis = new ZipInputStream(is)) {

            assertNotNull(is, "Архив " + zipFileName + " не найден");
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(fileExtension)) {
                    return new ByteArrayInputStream(zis.readAllBytes());
                }
            }
        }
        return null;
    }
}


