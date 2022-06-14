package arb.srg.filesystem.elements;

public class File{
    private String name;

    public File (String name){
        this.name = name;
    }

    public String getFileName (){
        return name;
    }

    public void setFileName (String name){
        this.name = name;
    }
}