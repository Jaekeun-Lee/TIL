import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame implements ActionListener {
	BufferedReader in = null;
	BufferedWriter out = null;
	Socket socket = null;
	Receiver serverMessage;
	JTextField clientMessage;
	JScrollPane spane;
	public ChatClient() {
		setTitle("클라이언트 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		setLayout(new BorderLayout()); //BorderLayout 배치관리자의 사용
		serverMessage = new Receiver(); // 서버에서 받은 메시지를 출력할 컴퍼넌트
		serverMessage.setEditable(false); // 편집 불가
		Thread t = new Thread(serverMessage); // 서버에서 메시지 수신을 위한 스레드 생성
		clientMessage = new JTextField();
		clientMessage.addActionListener(this);
		spane = new JScrollPane(serverMessage); // 긴 텍스트를 위해  ScrollPane에서 표시
		add(spane,BorderLayout.CENTER);
		add(clientMessage,BorderLayout.SOUTH);
		setSize(400, 200); // 폭 400 픽셀, 높이 200 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		t.start();
	}
	private void setupConnection() throws IOException {
		socket = new Socket("localhost", 9999); // 클라이언트 소켓 생성
		System.out.println("연결됨");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
	}
	public static void main(String[] args) {
		ChatClient frame = new ChatClient();
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String inputMessage=null;
			while (true) {
				try {
					inputMessage = in.readLine(); // 클라이언트에서 한 행의 문자열 읽음
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				serverMessage.append("\n" + inputMessage);
				int pos = serverMessage.getText().length();
				serverMessage.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clientMessage) {
			String outputMessage = clientMessage.getText(); // 텍스트 필드에서 문자열 얻어옴
			try {
				out.write("클라이언트>" + outputMessage+"\n"); // 문자열 전송
				out.flush();
				serverMessage.append("\n클라이언트>" + outputMessage);
				int pos = serverMessage.getText().length();
				serverMessage.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				clientMessage.setText(null); // 입력창의 문자열 지움
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
}
