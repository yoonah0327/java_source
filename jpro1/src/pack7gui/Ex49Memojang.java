package pack7gui;

import java.awt.*; //이렇게 묶어서 *처리해줄수있다!
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Ex49Memojang extends JFrame implements ActionListener {
	private JTextArea txtMemo = new JTextArea("", 10, 30);
	private String copyText; //복사한문자열 잠시보관용

	private JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	private JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel, mnuFontSize;
	private JMenuItem mnuAbout, mnuEtc1, mnuEtc2;
	
	private JPopupMenu popup; // 팝업메뉴용 전역변수
	private JMenuItem m_white, m_blue, m_yellow;

	public Ex49Memojang() {
		super("메모장");// super.가장 선두에 적어야한다! 자바RULE.
		initLayout();
		menuLayout();
		setBounds(200, 200, 400, 350);
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		addWindowListener(new WindowAdapter() { //addwindowlistener와 addwindow"focus"listenerd의 차이? 
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Ex49Memojang.this, "정말 종료할거야?", "종료", JOptionPane.YES_NO_OPTION);
				// 내부 무명클래스에선 this 못찾으니 클래스명 명시해주자
				if (result == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});

	}

	public void initLayout() {
		JScrollPane scrollPane = new JScrollPane(txtMemo); // 스크롤바 생성
		txtMemo.setFont(new Font("돋움", Font.PLAIN, 16));// 글씨 크기 조절
		add("Center", scrollPane); // 스크롤바가 생성된 글씨칸을 가운데에 넣기
	}

	public void menuLayout() { // 디자인
		JMenuBar menuBar = new JMenuBar(); // 메뉴바

		JMenu mnuFile = new JMenu("파일"); // 주메뉴1
		mnuNew = new JMenuItem("새문서"); // 부메뉴
		mnuOpen = new JMenuItem("열기...");
		mnuSave = new JMenuItem("저장...");
		mnuExit = new JMenuItem("종료");
		mnuFile.add(mnuNew); // 메뉴에 부메뉴 등록
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator(); // 구분선
		mnuFile.add(mnuExit);

		JMenu mnuEdit = new JMenu("편집"); // 주메뉴2
		mnuCopy = new JMenuItem("복사");
		mnuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // 단축키예시
		// vk_c여서 단축키 ctrlc가 생성. a라고 바꿔보니 a로 바뀜.
		mnuPaste = new JMenuItem("붙여넣기");
		mnuCut = new JMenuItem("잘라내기");
		mnuDel = new JMenuItem("삭제");
		mnuFontSize = new JMenuItem("글꼴 크기..");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuDel);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuFontSize);

		JMenu mnuShow = new JMenu("보기"); // 주메뉴3
		mnuAbout = new JMenuItem("메모장이란?");
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("카페");
		mnuShow.add(mnuAbout);
		mnuShow.addSeparator();
		mnuShow.add(mnuEtc1);
		mnuShow.add(mnuEtc2);

		menuBar.add(mnuFile); // 메뉴바에 주메뉴1 등록
		menuBar.add(mnuEdit); // 메뉴바에 주메뉴2 등록
		menuBar.add(mnuShow); // 메뉴바에 주메뉴3 등록
		setJMenuBar(menuBar); // JFrame에 메뉴바 등록

		// 메뉴에 리스너 달기
		mnuNew.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuSave.addActionListener(this);
		mnuExit.addActionListener(this);
		mnuCopy.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuFontSize.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuDel.addActionListener(this);
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);
		
		// 팝업메뉴 
		popup= new JPopupMenu();
		JMenu menuColor= new JMenu("배경색선택");
		m_white= new JMenuItem("하양");
		m_blue= new JMenuItem("파랑");
		m_yellow= new JMenuItem("노랑");
		menuColor.add(m_white);
		menuColor.add(m_blue);
		menuColor.add(m_yellow);
		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		popup.add(menuColor);
		txtMemo.add(popup); // txtmemo에 팝업메뉴추가
		
		txtMemo.addMouseListener(new MouseAdapter() {
			// 마우스오른쪽버튼 클릭시 해당 지점에 팝업띄우기
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) == MouseEvent.BUTTON3_DOWN_MASK) {
			popup.show(txtMemo, e.getX(), e.getY());
		}
				// 구버젼 
//				if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
//					popup.show(txtMemo, e.getX(), e.getY());
//				}
					
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand()); // 개발자입장에서 확인해보는것. 명령문이 콘솔창에 뜬다. 예) 보기
		// System.out.println(e.getSource()); //개발자용. 소스가 콘솔창에 뜬다.
		// 예)javax.swing.JMenuItem[,1,3,89x21,...
		if (e.getSource() == mnuNew) { // 새문서
			txtMemo.setText("");
			setTitle("내용없음");
		} else if (e.getSource() == mnuOpen) { // 열기
			// 파일 열기를 위해 경로명,파일명 얻기는 os 지원창 사용
			FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
			dialog.setDirectory("."); // .: 현작업위치인 jpro가 뜨게된다.
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile();
			System.out.println(dfName);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(dfName));
				txtMemo.setText("");
				String line = "";
				while ((line = reader.readLine()) != null) {
					txtMemo.append(line + "\n");
				}
				reader.close();
				setTitle(dialog.getFile());
			} catch (Exception e2) {
				// System.out.println(e2.getMessage()); // 개발자가 보기위해
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자에게 보여주는것
			}

		} else if (e.getSource() == mnuSave) { // 저장
			// 파일 저장을 위해 경로명,파일명 얻기는 os 지원창 사용
			FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
			dialog.setDirectory("."); // .: 현작업위치인 jpro가 뜨게된다.
			dialog.setVisible(true);
			if (dialog.getFile() == null)
				return;
			String dfName = dialog.getDirectory() + dialog.getFile();
			System.out.println(dfName);

			try {
				// BufferedWriter writer = new BufferedWriter(new FileWriter("c:/work/a.txt"));
				// bufferedwriter:
				// 윈도우 타입으로 경로 및 파일저장: c:\\work\\a.txt
				// 파일명이 이대로 고정되어버림. 보통은 팝업창이 뜨며 파일명을 입력할수있게함. 메세지다일로그창에서 파일명기입,저장해주면
				// 거기서 저장버튼으로 저장되는게아니라, 그 저장주소 이 코드에 갖고와 저장하게 되는것!
				BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
				writer.write(txtMemo.getText());
				writer.close();
				setTitle(dialog.getFile());
			} catch (Exception e2) {
				// System.out.println(e2.getMessage()); // 개발자가 보기위해
				JOptionPane.showMessageDialog(this, e2.getMessage(), "에러", JOptionPane.WARNING_MESSAGE); // 사용자에게 보여주는것
			}
			
		} else if (e.getSource() == mnuExit) { // 나가기
			int result = JOptionPane.showConfirmDialog(this, "정말 종료할거야?", "종료", JOptionPane.YES_NO_OPTION);
			
			if (result == JOptionPane.YES_OPTION)
			System.exit(0);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			// 창의 종료버튼에선 먹히는데 여기선 왜 안먹히는 걸까? 윈도우이벤트에서만 먹는 코드. 
			
			else;
			
		} else if (e.getSource() == mnuCopy) { // 복사
			//System.out.println(txtMemo.getSelectedText()); // 범위지정한 부분만 받아오기. 
			copyText = txtMemo.getSelectedText();
		} else if (e.getSource() == mnuPaste) { // 붙여넣기
			//txtMemo.setText(copyText); 원본을 다 대체하고 붙여넣는 내용만뜨게 됨
			int position = txtMemo.getCaretPosition();
			txtMemo.insert(copyText, position);
		} else if (e.getSource() == mnuCut) { // 잘라내기
			copyText = txtMemo.getSelectedText();
			// copyText에 저장된부분은 txtMemo에서 지워져야한다
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource() == mnuDel) { // 삭제
			int start = txtMemo.getSelectionStart();
			int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		} else if (e.getSource() == mnuFontSize) { // 글꼴크기
			String fontSize= JOptionPane.showInputDialog(this, "글자크기: ", "16");
			if(fontSize != null) {
				try {
					int fSize= Integer.parseInt(fontSize);
					txtMemo.setFont(new Font(
							txtMemo.getFont().getName(),
							txtMemo.getFont().getStyle(),
							fSize));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "글자크기를 정확히 입력하시오");
				}
			}
			
		} else if (e.getSource() == mnuAbout) { // 메모장이란
			new Ex49MemoAbout(this); //자기(Memojang클래스)를들고가야하기에 this
			System.out.println("About호출 후 상황"); //modal,modeless를 구분하려고 출력지시내려줌
		} else if (e.getSource() == mnuEtc1) { // 기타1
			// exe (실행파일) 실행하기
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("calc.exe");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}
		} else if (e.getSource() == mnuEtc2) { // 기타2
			// 브라우져 실행하기
			try {
				/*
				 * Desktop 클래스는 Java 응용 프로그램 URI 나 파일을 처리하기 위해 기본 등록된 관련 응용 프로그램을 실행 할 수 있습니다.
				 * 지원하는 기능은 아래와 같습니다.
				 * 1. 기본 브라우저를 통해서 URL 전시2. 메일 클라이언트 실행3. 기본 응용프로그램을 통해서 파일을 열거나 편집.
				 */
				String url = "https://cafe.daum.net/flowlife";
				//DeskTop지원확인
				if(Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop(); // getDesktop() 싱글톤이기에 new 생략가 
					if(desktop.isSupported(Desktop.Action.BROWSE)) { 
						//url은 문자열, 특정리소스를 의미
						desktop.browse(new URI(url));
					}
					else {
						JOptionPane.showMessageDialog(this, "브라우져 지원안함");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}
		}else if(e.getSource() == m_white) {
			txtMemo.setBackground(Color.WHITE);
		}else if(e.getSource() == m_blue) {
			txtMemo.setBackground(Color.BLUE);
		}else if(e.getSource() == m_yellow) {
			txtMemo.setBackground(Color.YELLOW);
		}
		

	}

	public static void main(String[] args) {
		// 간단한 메모장 만들기
		new Ex49Memojang();

	}

}
