interface Document {
    void openDocument();
}

class WordDocument implements Document {
    @Override
    public void openDocument() {
        System.out.println("Opening Word Document... ");
    }
}

class PdfDocument implements Document {
    @Override
    public void openDocument() {
        System.out.println("Opening PDF Document... ");
    }
}

class ExcelDocument implements Document {
    @Override
    public void openDocument() {
        System.out.println("Opening Excel Document... ");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.openDocument();

        DocumentFactory pdfFactory = new PdfFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.openDocument();

        DocumentFactory excelFactory = new ExcelFactory();
        Document myExcelDoc = excelFactory.createDocument();
        myExcelDoc.openDocument();
    }
}