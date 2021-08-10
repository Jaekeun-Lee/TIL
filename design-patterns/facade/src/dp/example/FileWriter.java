package dp.example;

public class FileWriter {
    public FileWriter(String fileName){

    }

    public void fileConnect(){
        System.out.println("FileWriter Connected");
    }

    public void fileWrite(String content){
        System.out.println("write : "+content);
    }

    public void fileDisconnect(){
        System.out.println("FileWriter disConnected");
    }
}
