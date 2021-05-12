package groot.springboot.demo.bean;

public class UploadFile {
    private Integer fileId;

    private String filePath;

    private String fileName;

    private String fileUuid;

    private String fileAnnId;

    private Integer fileType;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid == null ? null : fileUuid.trim();
    }

    public String getFileAnnId() {
        return fileAnnId;
    }

    public void setFileAnnId(String fileAnnId) {
        this.fileAnnId = fileAnnId == null ? null : fileAnnId.trim();
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}