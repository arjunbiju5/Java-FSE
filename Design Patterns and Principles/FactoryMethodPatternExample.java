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
abstract class DocumentFactory{
    abstract void createDocument(){
        
    }
}
public class FactoryMethodPatternExample {
    
}
