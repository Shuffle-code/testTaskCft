package entity;

public class FileName {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileName)) return false;

        FileName fileName1 = (FileName) o;

        return getFileName() != null ? getFileName().equals(fileName1.getFileName()) : fileName1.getFileName() == null;
    }

    @Override
    public int hashCode() {
        return getFileName() != null ? getFileName().hashCode() : 0;
    }
}
