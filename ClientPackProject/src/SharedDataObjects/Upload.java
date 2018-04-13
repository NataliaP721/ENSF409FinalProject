package SharedDataObjects;

import java.io.Serializable;

/**
 * @author  Natalia Pavlovic
 * @version 2.0
 * @since April 11, 2018
 */

public class Upload implements Serializable{

    private byte[] content;
    private String command;
    private String fileName;
    private String fileExtension;

    public Upload(byte[] content, String fileName, String fileExtension) {
        this.content = content;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public byte[] getContent() {
        return this.content;
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String com) { this.command = com;}
    public String getFileName() { return this.fileName;}
    public String getFileExtension() {
        return this.fileExtension;
    }
}
