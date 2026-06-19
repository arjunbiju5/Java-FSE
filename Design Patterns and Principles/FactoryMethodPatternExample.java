interface Document{
    void openDocument();
}
public class WordDocument implements Document{
    @Override
    public void openDocument(){
        System.out.println("Opening Word");
    }
}
public class PdfDocument implements Document{
    @Override
    public void openDocument(){
        System.out.println("Opening Word");
    }
}
public class ExcelDocument implements Document{
    @Override
    public void openDocument(){
        System.out.println("Opening Word");
    }
}
public abstract class DocumentFactory{
    public abstract void createDocument();
}
public class WordFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
public class PdfFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
public class ExcelFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args) {

        DocumentFactory word = new WordFactory();
        word.displayDocument();

        DocumentFactory pdf = new PdfFactory();
        pdf.displayDocument();

        DocumentFactory excel = new ExcelFactory();
        excel.displayDocument();
    }
}
