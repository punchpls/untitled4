package arb.srg.filesystem.executableclass;

import arb.srg.filesystem.elements.*;
import arb.srg.filesystem.manager.*;
import arb.srg.filesystem.menu.*;

public class DirectorySystem {
    public static void main(String[] args) {
        Folder initialFolder = new Folder("/");
        DirectoryManager directoryManager = new DirectoryManager(initialFolder);
        FileManager fileManager = new FileManager(initialFolder);
        ContextMenu menu = new ContextMenu(directoryManager, fileManager);
        menu.callContextMenu();
    }
}
