package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Stack extends JFrame {

	private JPanel contentPane;
	private DlgDonut dlgDonut;
	private DefaultListModel<Donut> dlm;
	private ArrayList<Donut> lista = new ArrayList<Donut>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setTitle("Rade Petrovic IT 55/2025");
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		// Naslov centriran preko obje kolone
		JLabel lblStack = new JLabel("Stack");
		lblStack.setHorizontalAlignment(SwingConstants.CENTER);
		lblStack.setForeground(new Color(0, 0, 0));
		lblStack.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		GridBagConstraints gbc_lblStack = new GridBagConstraints();
		gbc_lblStack.gridwidth = 2;
		gbc_lblStack.insets = new Insets(0, 0, 10, 0);
		gbc_lblStack.gridx = 0;
		gbc_lblStack.gridy = 0;
		contentPane.add(lblStack, gbc_lblStack);
		
		// Lista i ScrollPane
		dlm = new DefaultListModel<Donut>();
		JList<Donut> list = new JList<Donut>(dlm);
		list.setBackground(new Color(128, 255, 128));
		
		JScrollPane scrollPane = new JScrollPane(list);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 10, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		// Dugme Add
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 255, 64));
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgDonut = new DlgDonut();
				dlgDonut.setTitle("Add Donut");
				dlgDonut.setVisible(true);
				
				if (dlgDonut.isOk()) {
					Donut d = dlgDonut.getDonut();
					if (d != null) {
						lista.add(d);
						dlm.add(0, d);
					}
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 2;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		// Dugme Pop
		JButton btnPop = new JButton("Pop");
		btnPop.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnPop.setBackground(new Color(0, 255, 64));
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Stack is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				Donut d = lista.get(lista.size() - 1);
				
				DlgDonut dlgPop = new DlgDonut();
				dlgPop.setTitle("Pop Donut");
				dlgPop.setDonut(d); 
				dlgPop.setVisible(true);
				
				if (dlgPop.isOk()) {
					lista.remove(lista.size() - 1);
					dlm.remove(0);
				}
			}
		});
		GridBagConstraints gbc_btnPop = new GridBagConstraints();
		gbc_btnPop.anchor = GridBagConstraints.EAST;
		gbc_btnPop.gridx = 1;
		gbc_btnPop.gridy = 2;
		contentPane.add(btnPop, gbc_btnPop);
	}
}