package ex00;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckExtension {
    String signFile;
    String result;
    HashMap<String, String> codeMap = new HashMap<>();
    int maxLen = 0;

    public CheckExtension(String signFile, String res) {
        this.signFile = signFile;
        this.result = res;
    }

    void run() {
        scanSigns();
        scanFile();

    }

    void scanFile() {
        Scanner sc = new Scanner(System.in);
        String filePath;
        while(sc.hasNext()) {
            filePath = sc.nextLine();
            if (filePath.equals("42")) {
                break;
            }
            String fileSign = scanFile(filePath);
            String resStr = getExtension(fileSign);
            writeResFile(resStr);

        }
    }

    void writeResFile(String resStr) {
        try (FileWriter fileOut = new FileWriter(result, true)) {
            if (resStr != null) {
                fileOut.write(resStr);
                System.out.println("PROCESSED");
            } else {
                System.out.println("UNDEFINED");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    String getExtension(String fileSign) {
        String Ext = null;
        for (Map.Entry m : codeMap.entrySet()) {
            if (fileSign.startsWith((String) m.getKey())) {
                Ext = m.getValue() + "\n";
            }
        }
        return Ext;
    }

    String scanFile(String strPath) {
        StringBuilder strB = new StringBuilder();
        try (FileReader fileIn2 = new FileReader(strPath)) {
            int a;
            int length = (maxLen);
            while ((a = fileIn2.read()) != maxLen) {
                strB.append(String.format("%02X ", a));
                if (length == 0) {
                    strB.append("\n");
                    break;
                }
                --length;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strB.toString();
    }

    void scanSigns() {
        try(FileReader inputFile = new FileReader(signFile)) {
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] arrExtenshions = str.split(",");
                String strOfCode = arrExtenshions[1].trim();
                maxLen = Math.max(strOfCode.length(), maxLen);
                codeMap.put(strOfCode, arrExtenshions[0]);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
