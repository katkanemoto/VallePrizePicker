package vallePrizePicker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VallePrizePicker extends JFrame {

	private JPanel contentPane;
	JLabel lblStudentpicked;
	private ValleNamePicker namePicker = new ValleNamePicker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VallePrizePicker frame = new VallePrizePicker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VallePrizePicker() {
		
		ValleNamePicker.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVallePrizePicker = new JLabel("Valle Prize Picker");
		lblVallePrizePicker.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
		lblVallePrizePicker.setForeground(new Color(255, 255, 204));
		lblVallePrizePicker.setBounds(171, 11, 224, 44);
		contentPane.add(lblVallePrizePicker);
		
		lblStudentpicked = new JLabel("studentPicked");
		lblStudentpicked.setBounds(29, 166, 469, 44);
		contentPane.add(lblStudentpicked);
		
		JButton btnNewButton = new JButton("Pick A Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indexPicked = ValleNamePicker.getIndex();
				lblStudentpicked.setText("Index of picked student is " + indexPicked);
				contentPane.paintImmediately(new Rectangle(29, 166, 469, 44));
				contentPane.repaint();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				Student studentPicked = ValleNamePicker.pickName(indexPicked);
				
				lblStudentpicked.setText(studentPicked.toString());
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnNewButton.setBounds(202, 66, 136, 39);
		contentPane.add(btnNewButton);
	}
}
