package PatronProxy;

public abstract class GoogleDrive {
    public GoogleDrive() {
    }

    public abstract String entregarDoc(String id, String url, String nombre, String email);
}
