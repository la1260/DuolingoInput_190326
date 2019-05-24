package hu.hl.traincalc_190326;
//DuolingoInput_190326
//https://jsoup.org/download

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class Main {
	public static void main(String[] args) throws IOException {
		JTextArea textarea= new JTextArea();
		JScrollPane scrollpane= new JScrollPane(textarea);
		JFrame frame= new JFrame();
		textarea.setFont(new Font("Malgun Gothic", textarea.getFont().getStyle(), textarea.getFont().getSize()));

		textarea.setVisible(true);
		scrollpane.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.add(scrollpane);
		frame.setBounds(20, 20, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		StringBuilder stringbuilder= new StringBuilder();
		Iterator<Element> i0= Jsoup.parse(new String(Files.readAllBytes(Paths.get("C:\\Temp\\Duolingo _ Learn Korean for free.html")))).getElementsByClass("L5bZP").iterator();
		while (i0.hasNext()) {
			String sentence_k;
			String sentence_e;
			Element e= i0.next();
			sentence_k= (44032<=e.childNode(1).toString().codePointAt(0)) ?  e.childNode(1).toString() : e.getElementsByClass("_34xE3").get(1).getAllElements().get(2).text();
			sentence_e= (44032<=e.childNode(1).toString().codePointAt(0)) ?  e.getElementsByClass("_34xE3").get(1).getAllElements().get(2).text() : e.childNode(1).toString();
			stringbuilder.append(sentence_e+"\t"+sentence_k+"\r\n");
			textarea.setText(stringbuilder.toString());
		}
	}
}
