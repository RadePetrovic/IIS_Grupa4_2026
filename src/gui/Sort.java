package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Sort extends JFrame {

	private JPanel contentPane;
	private DlgDonut dlgDonut;
	private DefaultListModel<Donut> dlm;
	private ArrayList<Donut> lista1 = new ArrayList<Donut>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
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
	public Sort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		dlm = new DefaultListModel<Donut>();
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{55, 136, 41, 135, 57, 0};
		gbl_contentPane.rowHeights = new int[]{23, 163, 25, 25, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAddSort = new JLabel("Sort");
		lblAddSort.setForeground(new Color(0, 0, 0));
		lblAddSort.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		GridBagConstraints gbc_lblAddSort = new GridBagConstraints();
		gbc_lblAddSort.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddSort.gridx = 2;
		gbc_lblAddSort.gridy = 0;
		contentPane.add(lblAddSort, gbc_lblAddSort);
		
		JList<Donut> list = new JList<Donut>(dlm);
		list.setBackground(new Color(128, 255, 128));
		JScrollPane scrollPane = new JScrollPane(list);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(128, 255, 255));
		btnAdd.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgDonut = new DlgDonut();
				dlgDonut.setTitle("Add Donut");
				dlgDonut.setVisible(true);
				
				if (dlgDonut.isOk()) {
					Donut d = dlgDonut.getDonut();
					if (d != null) {
						lista1.add(d);
						dlm.addElement(d);
					}
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 2;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBackground(new Color(128, 255, 255));
		btnSort.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Bubble Sort po compareTo metodi (ili površini/poluprečniku)
				Donut temp;
				for (int i = 0; i < lista1.size() - 1; i++) {
					for (int j = 0; j < lista1.size() - i - 1; j++) {
						if (lista1.get(j).compareTo(lista1.get(j + 1)) < 0) {
							temp = lista1.get(j);
							lista1.set(j, lista1.get(j + 1));
							lista1.set(j + 1, temp);
						}
					}
				}
				
				// Osvežavanje prikaza u listi
				dlm.clear();
				for (Donut donut : lista1) {
					dlm.addElement(donut);
				}
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.anchor = GridBagConstraints.EAST;
		gbc_btnSort.insets = new Insets(0, 0, 5, 5);
		gbc_btnSort.gridx = 3;
		gbc_btnSort.gridy = 2;
		contentPane.add(btnSort, gbc_btnSort);
	}

}