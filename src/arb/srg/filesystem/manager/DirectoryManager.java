package arb.srg.filesystem.manager;

import java.util.Scanner;
import arb.srg.filesystem.elements.*;
import static java.lang.System.in;


public class DirectoryManager implements FileSystemManager<Folder> {
    private Folder folder;

    public DirectoryManager ( Folder folder ) {
        this.folder = folder;
    }

    @Override
    public Folder createNewFileSystemElement () {
        Scanner sc = new Scanner(in);
        String name;
        do {
            System.out.println("Input the name of the folder: ");
            name = sc.nextLine();
            if (name.equals("")) {
                System.out.println("Error! The folder can't have null name.");
            }
            if (name.equals("../")) {
                System.out.println("Error! The folder can't have parent folder call as name.");
            }
            for (Folder f: folder.getFolderList()) {
                if (f.getFolderName().equals(name)) {
                    System.out.println("Error! This folder already exists.");
                    name = "";//я считаю это гениальным решением, вот без сарказма))
                }
            }
        } while (name.equals("") || name.equals("../"));
        return new Folder(name, this.folder);
    }

    @Override
    public void addNewFileSystemElement () {
        folder.getFolderList().add(createNewFileSystemElement());
    }

    @Override
    public void removeFileSystemElement () {
        Scanner sc = new Scanner(in);
        System.out.println("Input the name of the folder to delete: ");
        String name = sc.nextLine();
        for (Folder f : folder.getFolderList()) {
            if (f.getFolderName().equals(name)) {
                folder.getFolderList().remove(f);
            } else {
                System.out.println("Error! This folder doesn't exist.");
            }
        }
    }


    @Override
    public void listCurrentDirectoryElements () {
        for (Folder f : folder.getFolderList()) {
            System.out.println(f.getFolderName());
        }
    }

    @Override
    public void changeFileSystemElementName () {
        Scanner sc = new Scanner(in);
        System.out.println("Input the name of the folder to rename: ");
        String name = sc.nextLine();
        for (Folder f : folder.getFolderList()) {
            if (f.getFolderName().equals(name)) {
                System.out.println("Input the new name of the folder: ");
                f.setFolderName(sc.nextLine());
            } else {
                System.out.println("Error! The folder with such name doesn't exist.");
            }
        }
    }

    public void changeCurrentDirectory () throws NullPointerException {
        Folder childFolder = null;
        Scanner sc = new Scanner(in);
        System.out.println("Input the name of the folder to open: ");
        String name = sc.nextLine();
        try {
            if (name.equals("../")) {
                childFolder = this.folder;
                this.folder = this.folder.getParentFolder();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (this.folder == null) {
                System.out.println("Initial folder / reached.");
                this.folder = childFolder;
            }
        }
        for (Folder f : folder.getFolderList()) {
            if (f.getFolderName().equals(name)) {
                this.folder = f;
            } else if ((!f.getFolderName().equals(name) && (!name.equals("../")))) {
                System.out.println("Error! The folder with such name doesn't exist.");
            }
        }
    }
}
