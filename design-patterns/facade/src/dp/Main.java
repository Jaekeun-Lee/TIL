package dp;

import dp.example.SftpClient;

public class Main {
    public static void main(String[] args) {

        SftpClient client = new SftpClient("www.google.com", 22, "/home/content", "content.tmp");
        client.connect();

        String content = "content";
        client.write(content);
        String result = client.read();
        System.out.println("----- 내용 : "+result+" -----");

        client.disConnect();
    }
}
