package arb.srg.filesystem.menu;

import java.util.Scanner;
import static java.lang.System.in;
import arb.srg.filesystem.manager.*;

public class ContextMenu{
    private final DirectoryManager folderManager;
    private final FileManager fileManager;

    public ContextMenu(DirectoryManager folderManager, FileManager fileManager){
        this.folderManager = folderManager;
        this.fileManager = fileManager;
    }

    public void callContextMenu (){
        Scanner sc = new Scanner(in);
        String input;

        System.out.println("Input the command please in the console. Available commands: \n");
        System.out.println("create folder - create a new folder");
        System.out.println("create file - create a new file");
        System.out.println("change folder - change current directory. Input \"../\" for opening parent folder");
        System.out.println("list - output the list of the files and folders in the current directory");
        System.out.println("delete file - delete a file");
        System.out.println("delete folder - delete a folder");
        System.out.println("rename file - rename a file");
        System.out.println("rename folder - rename a folder");
        System.out.println("exit - exit the program");

        do{
            input = sc.nextLine();
            switch (input){
                case "create folder":
                    folderManager.addNewFileSystemElement ();
                    break;
                case "create file":
                    fileManager.addNewFileSystemElement();
                    break;
                case "change folder":
                    folderManager.changeCurrentDirectory();
                    break;
                case "list":
                    fileManager.listCurrentDirectoryElements();
                    folderManager.listCurrentDirectoryElements();
                    break;
                case "delete file":
                    fileManager.removeFileSystemElement();
                    break;
                case "delete folder":
                    folderManager.removeFileSystemElement();
                    break;
                case "rename file":
                    fileManager.changeFileSystemElementName();
                    break;
                case "rename folder":
                    folderManager.changeFileSystemElementName();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Wrong input! Try again please.");
            }
        } while (!input.equals("exit"));
    }
}