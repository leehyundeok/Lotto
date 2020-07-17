import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
//extends 메소드 뿐만 아니라 변수까지 상속가능, implements는 다중상속을 할수가 있다
import org.json.simple.JSONObject;
import org.junit.Test;


class Cal{
	public int sum(int a, int b) {
		return a+b;
	}
	public double div(int a, int b) {
		return (double)a/b;
	}
}
public class Lotto extends JFrame implements MouseListener, KeyListener{
	int[] arr =new int[7];
	MyButton[] mbt = new MyButton[7];
	
	
	JTextField[] RotNo = new JTextField[7];
	
	JLabel label = new JLabel("수동입력");
	
	JButton checkBtn= new JButton("해당회차로");
	JTextField turnTxt = new JTextField();	
	JLabel titleLbl = new JLabel("로또번호");
	JLabel turnLbl = new JLabel("");
	JLabel plusLbl = new JLabel(new ImageIcon("image/pluse.png"));
	JLabel turnRbl = new JLabel("1등 당첨금액  : ");
	JLabel turnRb2 = new JLabel("1등 당첨자 수 : ");
	JLabel turnRb3 = new JLabel("총 판매액 	   : ");
	JLabel FirstAcc = new JLabel("");
	JLabel Date = new JLabel("");
	JLabel FirstPrz = new JLabel("");
	JLabel totalSell = new JLabel("");
	
	Random random = new Random();
	int[]arr1 = new int[7];
	MyButton[] rbt = new MyButton[7];
	
	
	JButton checkBtn2 = new JButton("랜덤번호받기");
	
	JLabel UserRank = new JLabel("");
	
	
	
	
	
	
	@Test
	public void JSum() {
		Cal c= new Cal();
		int a = c.sum(50, 60);
		assertEquals(100, a);
		double b = c.div(50, 60);
		assertEquals((double)50/60, b);
		
	}	
		
	@Test	
	public void JReader() throws Exception {
		JsonReader jReader = new JsonReader();
		JSONObject jobj = jReader.connectionUrlToJSON("100");
	    assertEquals("fail", jobj.get("reaturnValue"));
	//if(String.)
}
	public void init() {
		getContentPane().setLayout(null); //JFrame 설정
		for(int i=0; i<mbt.length-1; i++) {
			mbt[i] = new MyButton(""+(i+1)); 
			int w = 65;
			mbt[i].setBounds((10+w*i), 50, 50, 50);
			getContentPane().add(mbt[i]);
			
		}
		mbt[6]=new MyButton(""+(7));
		mbt[6].setBounds(10+(65*7), 50, 50, 50);
		getContentPane().add(mbt[6]);
		plusLbl.setBounds(10+(65*6), 50, 50, 50);
		getContentPane().add(plusLbl);
		titleLbl.setBounds(10, 10, 150, 30);
		getContentPane().add(titleLbl);		
	
		turnLbl.setBounds(20, 200, 400, 50);
		getContentPane().add(turnLbl);
		turnTxt.setColumns(10);
		turnTxt.setBounds(20, 250, 150, 50);
		getContentPane().add(turnTxt);
		
		checkBtn.setBounds(300, 250, 180, 50);
		getContentPane().add(checkBtn);
		turnRbl.setBounds(300, 180, 300, 100);
		getContentPane().add(turnRbl);
		
		FirstAcc.setBounds(465, 180, 400, 100);
		getContentPane().add(FirstAcc);
		Date.setBounds(200, 10, 150, 30);
		getContentPane().add(Date);
		
		turnRb2.setBounds(125,300, 300, 100);
		getContentPane().add(turnRb2);
		turnRb3.setBounds(125,350, 300, 100);
		getContentPane().add(turnRb3);
		FirstPrz.setBounds(315,300, 300, 100);
		getContentPane().add(FirstPrz);
		totalSell.setBounds(315, 350, 300, 100);
		getContentPane().add(totalSell);
		
		for(int j=0; j<rbt.length-1; j++) {
			rbt[j] = new MyButton(""+(j+1));
			int w1 = 65;
			rbt[j].setBounds((10+w1*j), 430, 50, 50);
			getContentPane().add(rbt[j]);
		}
		rbt[6]=new MyButton(""+(7));
		rbt[6].setBounds(10+(65*7), 430, 50, 50);
		getContentPane().add(rbt[6]);
		
		checkBtn2.setBounds(300, 500, 180, 50);
		getContentPane().add(checkBtn2);
		UserRank.setBounds(20, 500, 180, 50);
		getContentPane().add(UserRank);
				
		for(int i=0; i<RotNo.length; i++) {
			RotNo[i] = new JTextField(""+(i));
			int w1=65;
			RotNo[i].setBounds((10+w1*i), 120, 50, 50);
			getContentPane().add(RotNo[i]);
		}
		
		label.setBounds(500,120, 150, 50);
		getContentPane().add(label);
		}
	public void event() {
		checkBtn.addMouseListener(this);
		mbt[0].addMouseListener(this);
		turnTxt.addKeyListener(this);
		checkBtn2.addMouseListener(this);
	}
	void clearNumber() {
		for(int i =0; i<mbt.length; i++) {
			mbt[i].setText("");
		}
		
	}
	void clearTurnLbl() {
		turnLbl.setText("");
	}
	void clearTurnTxt() {
		turnTxt.setText("");
	}
	
	void clearRotNo() {
		for(int i=0;i<7;i++) {
			RotNo[i].setText("");
		}
	}
	void showResult(){
		int count =0;
		String turnNum = turnTxt.getText();
		try {
		
		int a = Integer.parseInt(turnNum);
			System.out.println(a);
			if(a<0 || a>10000) {
				turnLbl.setText("번호 다시 입력해 주세요");
				turnTxt.setText("");
				return;
			}
		}catch (Exception e) {
			turnLbl.setText("번호 다시 입력해 주세요");
			turnTxt.setText("");
			return;
		}
		try {
		JsonReader jr = new JsonReader();
		JSONObject jo = jr.connectionUrlToJSON(turnTxt.getText());
		if(jo==null) {
			turnLbl.setText("접속에 실패하였습니다. 다시 시도해주세요");
			return;
		}
		if(String.valueOf(jo.get("returnValue")).equals("fail")){
			turnLbl.setText("회차정보가 없습니다.");
			clearNumber();
			
			return;
		}
		String[] RotNu = new String[7];
		int[] a = new int[7];
		try {
			for(int i=0;i<7;i++) {
				RotNu[i] = RotNo[i].getText();
				if(a[i]<0 || a[i]>45){
					label.setText("번호를 다시 입력하세요");
					clearRotNo();
					clearTurnLbl();
					clearTurnTxt();
					return;
				}
			}
			
		}catch(Exception e){
			label.setText("숫자를 입력하세요");
			clearRotNo();
			clearTurnLbl();
			clearTurnTxt();
			return;
		}
		
		for(int i=0; i<arr.length-1; i++) {
			 arr[i] = Integer.parseInt(String.valueOf(jo.get("drwtNo"+(i+1))));
				if(arr[i]>40) {				
					mbt[i].setBgColor(Color.red);
					mbt[i].setTxtColor(Color.orange);				
				}else if(arr[i]>30) {
					mbt[i].setBgColor(Color.yellow);
					mbt[i].setTxtColor(Color.green);
				}else if(arr[i]>20) {
					mbt[i].setBgColor(Color.blue);
					mbt[i].setTxtColor(Color.pink);
				}else if(arr[i]>1) {
					mbt[i].setBgColor(Color.gray);
					mbt[i].setTxtColor(Color.white);
				}		
		}		
		for(int i=0; i<mbt.length-1; i++) {
			mbt[i].setText(String.valueOf(jo.get("drwtNo"+(i+1))));
			System.out.println(jo.get("drwtNo"+(i+1)));
		}
		mbt[6].setText(String.valueOf(jo.get("bnusNo")));			
		turnLbl.setText(turnTxt.getText() + "회차");		
		FirstAcc.setText(String.valueOf(jo.get("firstAccumamnt")+"원"));
		Date.setText(String.valueOf(jo.get("drwNoDate")));
		FirstPrz.setText(String.valueOf(jo.get("firstPrzwnerCo")+"명"));
		totalSell.setText(String.valueOf(jo.get("totSellamnt")+"원"));
		
		clearTurnTxt();
		
		compareRotNo();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				if(arr[i]==arr1[j]) {
				count++;
				}
			}
		}
		switch(count) {
		case 6:
			UserRank.setText(String.valueOf("1등 축하드립니다." ));
			break;
		case 5:
			UserRank.setText(String.valueOf("2등"+count+"개 당첨" ));
			break;
		case 4:
			UserRank.setText(String.valueOf("3등"+count+"개 당첨" ));
			break;
		case 3:
			UserRank.setText(String.valueOf("4등"+count+"개 당첨" ));
			break;
		case 2:
			UserRank.setText(String.valueOf("5등"+count+"개 당첨" ));
			break;
		case 1:
			UserRank.setText(String.valueOf("6등"+count+"개 당첨" ));
			break;
		case 0:
			UserRank.setText(String.valueOf("꼴등"+count+"개 당첨" ));
		}		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			turnLbl.setText("예기치 못한 오류가 발생했습니다. 다시 시도해주세요");
			return;
		}
	}
	void showResult2() {
		for(int j=0; j<arr1.length; j++) {
			arr1[j] = random.nextInt(45)+1;
			for(int i=0; i<j; i++) {
				if(arr1[j] == arr1[i]) {
					j--;
				}
			}
		}
		for(int j=0; j<rbt.length; j++) {
			rbt[j].setText(String.valueOf(arr1[j]));
		}
	}
	void compareRotNo() {
		int cont = 0;
		for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				if(RotNo[i].getText().equals(mbt[j].getText())) {
					cont++;
				}
			}
		}
		switch(cont) {
		case 6:
			UserRank.setText(String.valueOf("1등 축하드립니다." ));
			break;
		case 5:
			UserRank.setText(String.valueOf("2등"+cont+"개 당첨" ));
			break;
		case 4:
			UserRank.setText(String.valueOf("3등"+cont+"개 당첨" ));
			break;
		case 3:
			UserRank.setText(String.valueOf("4등"+cont+"개 당첨" ));
			break;
		case 2:
			UserRank.setText(String.valueOf("5등"+cont+"개 당첨" ));
			break;
		case 1:
			UserRank.setText(String.valueOf("6등"+cont+"개 당첨" ));
			break;
		case 0:
			UserRank.setText(String.valueOf("꼴등"+cont+"개 당첨" ));
		}	
		
	}
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) { //키 바로 앞에 데이타가 들어있는지를 체크
			Object key = keys.nextElement(); //  키를 가리키고 있는 데이타-객체(Object)-를 리턴해주고 키의 위치를 다음 칸으로 옮깁
			Object value = UIManager.get(key); // key에 적용된 값value을 꺼냄
			if(value instanceof FontUIResource) // FontUIResource 에 값이 적용되어있는지 확인
				UIManager.put(key, f);
		}
		
	}

	Lotto(){
		super("로또번호 조회");
		//화면구성 component 들을 초기화		
		init();
		//event를 등록
		event();
		
		setSize(800,800); // 넓이,높이
		setVisible(true); // 생성 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램이 종료
	}		
	public static void main(String[] args) throws Exception {
		String fType = "GothicA1-Regular.ttf";	
		
		Font f1 = Font.createFont(Font.TRUETYPE_FONT, new File(fType)); //  메소드에 throw를 추가해줌
		setUIFont(new FontUIResource(f1.deriveFont(25f))); // 숫자뒤에 f를 붙히면 실수를 나타냄
		
		new Lotto();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			// 회차 결과를 버튼 1-7에 보여주기
			showResult();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE) {
			// 화면을 초기화한다. textField
			clearNumber();
			clearTurnLbl();
			clearTurnTxt();
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
		if(e.getSource()==checkBtn) {
			showResult();
		}
		if(e.getSource()==checkBtn2) {
			showResult2();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Exited");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed");
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
		
	}

}
