package arb.srg.filesystem.elements;

import java.util.LinkedList;

public class Folder{
    private String name;
    private Folder parentFolder;
    private LinkedList<File> fileList = new LinkedList<File>();
    private LinkedList<Folder> folderList = new LinkedList<Folder>();

    public Folder (String name){
        this.name = name;
    }

    public Folder (String name, Folder parentFolder){
        this.name = name;
        this.parentFolder = parentFolder;
    }

    public String getFolderName (){
        return name;
    }

    public void setFolderName (String name){
        this.name = name;
    }

    public Folder getParentFolder (){
        return parentFolder;
    }

    public LinkedList<File> getFileList(){
        return this.fileList;
    }

    public LinkedList<Folder> getFolderList(){
        return this.folderList;
    }

}