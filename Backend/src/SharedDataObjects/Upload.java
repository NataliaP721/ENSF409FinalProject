package SharedDataObjects;

public class Upload {

    private byte[] content;
    private String command;
    private String fileName;

    public Upload(byte[] content, String fileName) {
        this.content = content;
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return this.content;
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String com) { this.command = com;}
    public String getFileName() { return this.fileName;}
}
