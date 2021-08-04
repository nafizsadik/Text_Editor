import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class TextEditor extends JFrame implements ActionListener{

	JTextArea textArea;
	JScrollPane scrollPane;
	JLabel fontLabel ;
	JSpinner fontSizeSpinner;
	JButton fontColorButton;

	TextEditor(){
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setTitle("Text Editor");
  this.setSize(500, 500);
  this.setLayout(new FlowLayout());
  this.setLocationRelativeTo(null);
  
  textArea = new JTextArea();
  textArea.setLineWrap(true);
  textArea.setWrapStyleWord(true);
  textArea.setFont(new Font("Arial", Font.PLAIN,20));
  
  scrollPane = new JScrollPane(textArea);
  scrollPane.setPreferredSize(new Dimension(450, 450));
  scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
  
  fontLabel = new JLabel("Font: ");
  
  fontSizeSpinner = new JSpinner();
  fontSizeSpinner.setPreferredSize(new Dimension(50,25));
  fontSizeSpinner.setValue(20);
  fontSizeSpinner.addChangeListener(new ChangeListener() {
	  @Override
	  public void stateChanged(ChangeEvent e) {
		  textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int) fontSizeSpinner.getValue()));
	  }
  });
  
  fontColorButton = new JButton("Color");
  fontColorButton.addActionListener(this);
  this.add(fontLabel);
  this.add(fontSizeSpinner);
  this.add(fontColorButton);
  this.add(scrollPane);
  this.setVisible(true);
 }
  
 @Override
 public void actionPerformed(ActionEvent e) {
  
	 if(e.getSource()==fontColorButton) {
		 JColorChooser colorChooser = new JColorChooser();
		 
		 Color color = colorChooser.showDialog(null, "Choose a color", Color.black);
		 textArea.setForeground(color);
	 }

 }
}
