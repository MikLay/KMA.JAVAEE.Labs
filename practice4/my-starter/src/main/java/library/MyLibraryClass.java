package library;

public class MyLibraryClass {
    private String customInfo;

    public MyLibraryClass() {
    }

    public MyLibraryClass(final String customInfo) {
        this.customInfo = customInfo;
    }

    public void printInfo(Runnable my_class_from_library) {
        if (customInfo != null) {
            System.out.println(customInfo);
        } else {
            my_class_from_library.run();
        }
    }
}
