package com.liudi.back.utils;


import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.liudi.back.core.base.ExcelVo;
import io.netty.util.internal.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ImportExcelUtil {
    public ImportExcelUtil() {
    }

    public static Map<String, Object> importExcel(MultipartFile file, Class classz, Boolean isNum) throws Exception {
        List<ExcelVo> listEx = ExcelVoConcertUtil.voConcert(classz);
        if (listEx == null && listEx.size() == 0) {
            return null;
        } else {
            InputStream is = file.getInputStream();
            Workbook workbook = null;
            if (file.getName().endsWith("xls")) {
                workbook = new HSSFWorkbook(is);
            } else if (file.getName().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(is);
            }

            Map<String, Object> objectMap = new HashMap();

            for(int i = 0; i < ((Workbook)workbook).getNumberOfSheets(); ++i) {
                Sheet sheet = ((Workbook)workbook).getSheetAt(i);
                if (sheet.getPhysicalNumberOfRows() > 0) {
                    List<Map<String, Object>> list = new ArrayList();
                    List<String> header = new ArrayList();

                    int j;
                    for(j = 0; j < sheet.getRow(0).getLastCellNum(); ++j) {
                        Cell cell = sheet.getRow(0).getCell(j);
                        String value = cell.getStringCellValue();
                        Iterator var14 = listEx.iterator();

                        while(var14.hasNext()) {
                            ExcelVo excelVo = (ExcelVo)var14.next();
                            if (value.equals(excelVo.getValue())) {
                                value = excelVo.getKey();
                            }
                        }

                        header.add(value);
                    }

                    for(j = 1; j <= sheet.getLastRowNum(); ++j) {
                        Row row = sheet.getRow(j);
                        if (row.getPhysicalNumberOfCells() > 0) {
                            Map<String, Object> map = new HashMap();

                            for(int k = 0; k < row.getLastCellNum(); ++k) {
                                Cell cell = row.getCell(k);
                                if (cell != null && !cell.toString().trim().equals("")) {
                                    int cellType = cell.getCellType();
                                    String cellValue = "";
                                    if (cellType == 1) {
                                        cellValue = cell.getStringCellValue().trim();
                                        cellValue = StringUtil.isNullOrEmpty(cellValue) ? "" : cellValue;
                                    }

                                    if (cellType == 0) {
                                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                            SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                            String date1 = dff.format(cell.getDateCellValue());
                                            cellValue = date1;
                                        } else {
                                            cellValue = (new DecimalFormat("#.######")).format(cell.getNumericCellValue());
                                        }
                                    }

                                    if (cellType == 4) {
                                        cellValue = String.valueOf(cell.getBooleanCellValue());
                                    }

                                    map.put(header.get(k), cellValue);
                                }
                            }

                            list.add(map);
                        }
                    }

                    objectMap.put(sheet.getSheetName(), list);
                }
            }

            return objectMap;
        }
    }

    public static List<Map<String, Object>> importExcelOneSheet(MultipartFile file, Class classz, Boolean isNum) throws Exception {
        List<ExcelVo> listEx = ExcelVoConcertUtil.voConcert(classz);
        if (listEx == null && listEx.size() == 0) {
            return null;
        } else {
            InputStream is = file.getInputStream();
            Workbook workbook = null;
            if (file.getOriginalFilename().endsWith("xls")) {
                workbook = new HSSFWorkbook(is);
            } else if (file.getOriginalFilename().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(is);
            }

            new HashMap();
            Sheet sheet = ((Workbook)workbook).getSheetAt(0);
            if (sheet.getPhysicalNumberOfRows() <= 0) {
                return null;
            } else {
                List<Map<String, Object>> list = new ArrayList();
                List<String> header = new ArrayList();

                int j;
                for(j = 0; j < sheet.getRow(0).getLastCellNum(); ++j) {
                    Cell cell = sheet.getRow(0).getCell(j);
                    String value = cell.getStringCellValue();
                    Iterator var13 = listEx.iterator();

                    while(var13.hasNext()) {
                        ExcelVo excelVo = (ExcelVo)var13.next();
                        if (value.equals(excelVo.getValue())) {
                            value = excelVo.getKey();
                        }
                    }

                    header.add(value);
                }

                for(j = 1; j <= sheet.getLastRowNum(); ++j) {
                    Row row = sheet.getRow(j);
                    if (row.getPhysicalNumberOfCells() > 0) {
                        Map<String, Object> map = new HashMap();

                        for(int k = 0; k < row.getLastCellNum(); ++k) {
                            Cell cell = row.getCell(k);
                            if (cell != null && !cell.toString().trim().equals("")) {
                                int cellType = cell.getCellType();
                                String cellValue = "";
                                if (cellType == 1) {
                                    cellValue = cell.getStringCellValue().trim();
                                    cellValue = StringUtil.isNullOrEmpty(cellValue) ? "" : cellValue;
                                }

                                if (cellType == 0) {
                                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        String date1 = dff.format(cell.getDateCellValue());
                                        cellValue = date1;
                                    } else {
                                        cellValue = (new DecimalFormat("#.######")).format(cell.getNumericCellValue());
                                    }
                                }

                                if (cellType == 4) {
                                    cellValue = String.valueOf(cell.getBooleanCellValue());
                                }

                                if (k != 0 || !isNum) {
                                    map.put(header.get(k), cellValue);
                                }
                            }
                        }

                        list.add(map);
                    }
                }

                return list;
            }
        }
    }

    public static List<String> importExcelOneSheetNoHead(MultipartFile file) throws Exception {
        InputStream is = file.getInputStream();
        Workbook workbook = null;
        if (file.getOriginalFilename().endsWith("xls")) {
            workbook = new HSSFWorkbook(is);
        } else if (file.getOriginalFilename().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(is);
        }

        Sheet sheet = ((Workbook)workbook).getSheetAt(0);
        if (sheet.getPhysicalNumberOfRows() <= 0) {
            return null;
        } else {
            List<String> list = new ArrayList();

            for(int j = 0; j <= sheet.getLastRowNum(); ++j) {
                Row row = sheet.getRow(j);
                if (row.getPhysicalNumberOfCells() > 0) {
                    for(int k = 0; k < row.getLastCellNum(); ++k) {
                        Cell cell = row.getCell(k);
                        if (cell != null && !cell.toString().trim().equals("")) {
                            int cellType = cell.getCellType();
                            String cellValue = "";
                            if (cellType == 1) {
                                cellValue = cell.getStringCellValue().trim();
                                cellValue = StringUtil.isNullOrEmpty(cellValue) ? "" : cellValue;
                            }

                            list.add(cellValue);
                        }
                    }
                }
            }

            return list;
        }
    }
}
