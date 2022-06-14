package arb.srg.filesystem.manager;


interface FileSystemManager<T> {

    T createNewFileSystemElement ();

    void addNewFileSystemElement ();

    void removeFileSystemElement ();

    void changeFileSystemElementName ();

    void listCurrentDirectoryElements ();
}
