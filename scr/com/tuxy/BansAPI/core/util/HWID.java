package com.tuxy.bansapi.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class HWID {
    public static String getMotherboardSerial() {
        String result = "";
        try {
            File file = File.createTempFile("GetMBSerial",".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs =
                    "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                            + "Set colItems = objWMIService.ExecQuery _ \n"
                            + "   (\"Select * from Win32_ComputerSystemProduct\") \n"
                            + "For Each objItem in colItems \n"
                            + "    Wscript.Echo objItem.IdentifyingNumber \n"
                            + "Next \n";

            fw.write(vbs);
            fw.close();
            Process gWMI = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(gWMI.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
                System.out.println(line);
            }
            input.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        result = result.trim();
        return result;
    }

}
