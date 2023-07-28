package codeforces;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TemplateSetter {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("## Get ready for the codeforces round!");

        System.out.print("=> Round #: ");
        Integer roundNumber= sc.nextInt();

        System.out.print("=> Number of problems: ");
        Integer numberOfProblems= sc.nextInt();
        if (numberOfProblems > 26) {
            System.out.println("## Check your input. Aborting...");
            return;
        }


        final String rootPath= "./src/codeforces";
        final String contestPackagePath= rootPath + "/c" + roundNumber;
        final String classFileName= "/Solution.java";
        final String templateFileName= "/template.txt";
        try {
            if ((new File(contestPackagePath)).exists()) {
                System.out.println("## Contest package already exists. Aborting...");
                return;
            }
            Files.createDirectory(Paths.get(contestPackagePath));

            for (int i=0; i < numberOfProblems; ++i) {
                String packagePath= contestPackagePath + "/" + (char)('A'+i);
                Files.createDirectory(Paths.get(packagePath));

                String filePath= packagePath + classFileName;
                (new File(filePath)).createNewFile();

                BufferedReader reader= new BufferedReader(new FileReader(rootPath + templateFileName));
                FileWriter writer= new FileWriter(filePath);
                writer.write("package "
                        + packagePath.substring(rootPath.indexOf("codeforces")).replace('/', '.')
                        + ";\n\n");
                String line;
                while ((line= reader.readLine()) != null) {
                    writer.append(line+"\n");
                }
                writer.close();
                reader.close();
            }
        } catch (IOException ex) {
            System.out.println("## Failed due to: " + ex.getMessage());
        }
        System.out.println("## Done.");
    }
}
