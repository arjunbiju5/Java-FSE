class Logger {
    private static Logger instance;
    private Logger(){

    }
    public static Logger newInstance(){
        if(instance==null)
            instance = new Logger();
        return instance;
    }
}
class SingletonPatternExample{
    public static void main(String[] args) {
        Logger l1 = Logger.newInstance();    
    }
}