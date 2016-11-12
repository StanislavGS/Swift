
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task3_FileManagement {

    static Object[] files = new Object[500];
    static int numFiles = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st;
        do {
            st = sc.nextLine();
            String[] sArr = st.split(" ");
            if (sArr[0].equals("MAKE")) {
                createFile(Arrays.copyOfRange(sArr, 1, sArr.length));
                Arrays.sort(files, 0, numFiles);
            } else if (sArr[0].equals("EXEC")) {
                execute(sArr[1]);
            } else if (sArr[0].equals("MOVE") || sArr[0].equals("INFO") || sArr[0].equals("MOD")
                    || sArr[0].equals("COPY") || sArr[0].equals("DEL")) {
                int i = Arrays.binarySearch(files, 0, numFiles,
                        new ExecutableFile(sArr[1], "", null));
                if (i >= 0) {
                    switch (sArr[0]) {
                        case "MOVE":
                            ((File) files[i]).move(sArr[2]);
                            break;
                        case "INFO":
                            System.out.println(((File) files[i]).getInfo());
                            break;
                        case "MOD":
                            ((ContentFile) files[i]).modify(sArr[2]);
                            break;
                        case "COPY":
                            files[numFiles++] = ((File) files[i]).copy(sArr[2]);
                            Arrays.sort(files, 0, numFiles);
                            break;
                        case "DEL":
                            ((File) files[i]).delete();
                    }
                }
            }

        } while (st.compareToIgnoreCase("end") != 0);
    }

    static void createFile(String... args) {
        if (args.length < 3 || !args[2].subSequence(0, 8).equals("CONTENT=")) {
            int numResurces = args.length - 2;
            DocumentContentFile trash = new DocumentContentFile("", "", "");
            for (int i = 0; i < numResurces; i++) {
                trash.setName(args[i + 2]);
                int idx = Arrays.binarySearch(files,0,numFiles, trash);
                if (idx < 0) {//Erase not exist-file from list
                    for (int j = i; j < numResurces - 1; j++) {
                        args[j + 2] = args[j + 3];
                    }
                    args[numResurces-- - 1 + 2] = null;
                    i--;
                }
            }
            String[] filesToExecute = null;
            if (numResurces > 0) {
                filesToExecute = Arrays.copyOfRange(args, 2, numResurces + 2);
            }
            files[numFiles++] = new ExecutableFile(args[0], args[1], filesToExecute);

        } else {
            String ext = args[0].substring(args[0].lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("avi")) {
                files[numFiles++] = new MediaContentFile(args[0], args[1], args[2].substring(8));
            } else {
                files[numFiles++] = new DocumentContentFile(args[0], args[1], args[2].substring(8));
            }
        }
    }

    static void execute(String name) {
        int i = Arrays.binarySearch(files, 0, numFiles,
                new ExecutableFile(name, "", null));
        if (i >= 0) {
            if (((File) files[i]).getIsDeleted()){
                return;
            }
            if (files[i] instanceof ExecutableFile) {
                String[] infoAndList = ((File) files[i]).execute().split(";");
                System.out.println(infoAndList[0]);
                for (int j = 1; j < infoAndList.length; j++) {
                    if(infoAndList[j].equals(name)){
                        System.out.println("Stuck recursion");
                        System.exit(0);
                    }else{
                        execute(infoAndList[j]);
                    }
                }
            } else {
                System.out.print(((File) files[i]).execute());
            }
        }
    }

}
