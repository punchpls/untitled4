package arb.srg.filesystem.manager;

import java.util.Scanner;
import arb.srg.filesystem.elements.*;
import static java.lang.System.in;


public class FileManager implements FileSystemManager<File> {
    private Folder folder;

    public FileManager ( Folder folder ) {
        this.folder = folder;
    }

    @Override
    public File createNewFileSystemElement () {
        Scanner sc = new Scanner(in);
        String name;
        do {
            System.out.println("Input the name of the file: ");
            name = sc.nextLine();
            if (name.equals("")) {
                System.out.println("Error! The file can't have null name.");
            }
            for (File f: folder.getFileList()) {
                if (f.getFileName().equals(name)) {
                    System.out.println("Error! This folder already exists.");
                    name = "";//я считаю это гениальным решением, вот без сарказма))
                }
            }
        } while (name.equals(""));
        return new File(name);
    }

    @Override
    public void addNewFileSystemElement () {
        folder.getFileList().add(this.createNewFileSystemElement());
    }

    @Override
    public void removeFileSystemElement () {
        Scanner sc = new Scanner(in);
        System.out.println("Input the name of the file to delete: ");
        String name = sc.nextLine();
        for (File f : folder.getFileList()) {
            if (f.getFileName().equals(name)) {
                folder.getFileList().remove(f);
            } else {
                System.out.println("Error! This file doesn't exist.");
            }
        }
    }

    @Override
    public void changeFileSystemElementName () {
        Scanner sc = new Scanner(in);
        System.out.println("Input the name of the file to rename: ");
        String name = sc.nextLine();
        for (File f : folder.getFileList()) {
            if (f.getFileName().equals(name)) {
                System.out.println("Input the new name of the file: ");
                f.setFileName(sc.nextLine());
            } else {
                System.out.println("Error! The file with such name doesn't exist.");
            }
        }
    }

    @Override
    public void listCurrentDirectoryElements () {
        for (File file : folder.getFileList()) {
            System.out.println(file.getFileName());
        }
    }
}