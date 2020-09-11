import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;

public class MonsterGameApplet extends JApplet {
	JPanel gamePanel; // 게임 패널, 컨텐트팬으로 사용한다.
	AudioClip clip=null; // 연주할 배경 음악 정보를 가진 오디오 클립 객체
	
	public void init() {
		
		// 아바타와 괴물로 사용할 문자열과, 종료키, 괴물이 잠자는 시간 등에 대한  디폴트 값을 설정한다.
		String avatarChar="@";
		String monsterChar="M";
		long monsterDelay=200;
		
		try {
			avatarChar = getParameter("avatar");
			monsterChar =  getParameter("monster");
			monsterDelay = Integer.parseInt(getParameter("delay"));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Format Error","<param> Number Format Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	
		gamePanel = new GamePanel(avatarChar, monsterChar, 'q', monsterDelay);
		setContentPane(gamePanel); // GamePanel을 컨텐트팬으로 사용한다.

		// 오디오 클립을 생성한다.
		URL audioURL = getClass().getResource("wtc2-10f.mid");
		clip  = Applet.newAudioClip(audioURL);
	}
	
	public void start() {
		gamePanel.requestFocus(); // GamePanel이 키를 입력받을 수 있도록 포커스를 설정한다.
		if(clip != null)
			clip.play(); // 오디오 연주를 시작한다.
	}
	
	public void stop() {
		if(clip != null)
			clip.stop(); // 오디오 연주를 중단한다.
	}
	
	public void destroy() {
		if(clip != null)
			clip.stop(); // 오디오 연주를 중단한다.
	}
}

// 게임이 진행되는 패널. 배치관리자를 null로 설정
class GamePanel extends JPanel {
	String avatarChar;
	String monsterChar;
	char quitChar; // 의미 없다.
	long monsterDelay;
	JLabel avatar;// 아바타를 위한 레이블
	JLabel monster; // 괴물을 위한 레이블
	final int AVATAR_MOVE = 10; // 아바타가 한번에 움직이는 픽셀 수

	public GamePanel(String avatarChar, String monsterChar, char quitChar, long monsterDelay) {
		this.avatarChar = avatarChar;
		this.monsterChar = monsterChar;
		this.quitChar = quitChar; // 특별히 의미 없음
		this.monsterDelay = monsterDelay;
		
		// 아바타와 괴물 레이블 생성
		avatar = new JLabel(avatarChar); 
		monster = new JLabel(monsterChar);
		
		setLayout(null); // 아타바 레이블과 괴물 레이블의 위치를 마음대로 지정할 수 있도록 null로 설정
		addKeyListener(new MyKeyListener()); // 키 리스너 등록
		
		// 아바타 레이블의 위치와 크기 설정 및 팬에 부착
		avatar.setLocation(50,50);
		avatar.setSize(15,15);
		avatar.setForeground(Color.RED);
		add(avatar);
		
		// 괴물 레이블의 위치와 크기 설정 및 팬에 부착
		monster.setLocation(200,5);
		monster.setSize(15,15);
		add(monster);
		
		// 괴물을 움직이는 스레드 생성 및 시작 
		MonsterThread th = new MonsterThread(monster, avatar, monsterDelay);
		th.start();

	}
	
	// GamePanel에 등록된 키 리스너. 상, 하, 좌, 우 키만 처리하고 종료 키 처리하지 않음
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {		
			int keyCode = e.getKeyCode(); // 상, 하, 좌, 우 키는 유니코드 키가 아님
			
			// 키에 따라 아바타 레이블을 AVATAR_MOVE 픽셀 만큼 움직인다.
			switch(keyCode) {
			case KeyEvent.VK_UP: 
				avatar.setLocation(avatar.getX(), avatar.getY()-AVATAR_MOVE); 
				break;
			case KeyEvent.VK_DOWN: 
				avatar.setLocation(avatar.getX(), avatar.getY()+AVATAR_MOVE); 
				break;
			case KeyEvent.VK_LEFT: 
				avatar.setLocation(avatar.getX()-AVATAR_MOVE, avatar.getY()); 
				break;
			case KeyEvent.VK_RIGHT: 
				avatar.setLocation(avatar.getX()+AVATAR_MOVE, avatar.getY()); 
				break;
			}
			
			avatar.getParent().repaint(); // 아바타의 위치가 변경되었으므로 다시 그리기
			// 아바타가 있는 패널에는 이전의 위치에 있었던 아바타를 지워야 하기 때문에 
			// 아바타의 부모 패널에게 다시그리기를 지시함
		}
	}
}

// 괴물 레이블을 움직이는 200ms 당 5 픽셀을 움직이면서 끊임없이 아바타를 추적하는 스레드
// 생성자는 두 개의 레이블 컴포넌트를 전달받는다. 첫번째 from이 두번째 to 레이블을 추적한다.
class MonsterThread extends Thread {
	JLabel from; // 좇아가는 레이블. 괴물 레이블
	JLabel to; // 도망가는 레이블. 아바타 레이블
	long monsterDelay;
	final int MONSTER_MOVE = 5; // from 레이블이 한번에 이동하는 거리
	
	MonsterThread(JLabel from, JLabel to, long monsterDelay) {
		this.from = from;
		this.to = to;
		this.monsterDelay = monsterDelay;
	}
	
	public void run() {
		int x=from.getX(),y=from.getY(); // 현재 괴물의 위치
		
		while(true) {
			if(to.getX() < from.getX()) // 아바타가 괴물의 왼쪽이 있는 경우 
				x = from.getX() - MONSTER_MOVE;
			else 						// 아바타가 괴물의 오른쪽이 있는 경우
				x = from.getX() + MONSTER_MOVE;
			
			if(to.getY() < from.getY()) // 아바타가 괴물의 위쪽이 있는 경우
				y = from.getY() - MONSTER_MOVE;
			else 						// 아바타가 괴물의 아래쪽이 있는 경우
				y = from.getY() + MONSTER_MOVE;			
			
			// 괴물의 위치 수정
			from.setLocation(x, y);
			
			// 괴물의 위치가 변경되었기 때문에 괴물을 포함하는 패널을 다시 그리도록 함
			from.getParent().repaint();
			
			// 200ms 동안 잠을 잔다.
			try {
				sleep(monsterDelay);
			}catch(InterruptedException e) {
				return;
			}
		}
	}
}