import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
@SuppressWarnings("serial")
public class MyButton extends JButton{
	private Color txtColor = Color.white;
	private Color bgColor = Color.black;
	public MyButton(String text) {
		super(text);
		setBorderPainted(false); //배경 테두리 설정
		setOpaque(false); // 투명하게 설정		
	}
	public void setTxtColor(Color c) {
		txtColor = c;
	}
	public void setBgColor(Color c) {
		bgColor = c;
	}
	@Override
	public void paint(Graphics g) { //그래픽을 구현하는 클래스
		int w=getWidth();
		int h=getHeight();
		g.setColor(bgColor);
		g.fillRoundRect(0, 0, w, h, 20, 20);
		
		g.setColor(txtColor);
		g.drawString(getText(), getWidth()/2-12, getHeight()/2+5);
			
	}
}
