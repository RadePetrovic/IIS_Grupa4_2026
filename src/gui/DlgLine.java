package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX1;
	private JTextField textFieldY1;
	private JTextField textFieldX2;
	private JTextField textFieldY2;
	private Line line;
	private boolean isOk;
	private JButton btnOutlineColor;
	private Color color = Color.red;
	private JLabel lblX1;
	private JLabel lblY1;
	private JLabel lblX2;
	private JLabel lblY2;
	
	
	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTextFieldX1() {
		return textFieldX1;
	}

	public void setTextFieldX1(JTextField textFieldX1) {
		this.textFieldX1 = textFieldX1;
	}

	public JTextField getTextFieldY1() {
		return textFieldY1;
	}

	public void setTextFieldY1(JTextField textFieldY1) {
		this.textFieldY1 = textFieldY1;
	}

	public JTextField getTextFieldX2() {
		return textFieldX2;
	}

	public void setTextFieldX2(JTextField textFieldX2) {
		this.textFieldX2 = textFieldX2;
	}

	public JTextField getTextFieldY2() {
		return textFieldY2;
	}

	public void setTextFieldY2(JTextField textFieldY2) {
		this.textFieldY2 = textFieldY2;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Dialog Line");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public DlgLine() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblX1 = new JLabel("X1 coordinate");
			GridBagConstraints gbc_lblX1 = new GridBagConstraints();
			gbc_lblX1.insets = new Insets(0, 0, 5, 5);
			gbc_lblX1.gridx = 0;
			gbc_lblX1.gridy = 1;
			contentPanel.add(lblX1, gbc_lblX1);
		}
		{
			textFieldX1 = new JTextField();
			GridBagConstraints gbc_textFieldX1 = new GridBagConstraints();
			gbc_textFieldX1.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX1.gridx = 1;
			gbc_textFieldX1.gridy = 1;
			contentPanel.add(textFieldX1, gbc_textFieldX1);
			textFieldX1.setColumns(10);
		}
		{
			lblY1 = new JLabel("Y1 coordinate");
			GridBagConstraints gbc_lblY1 = new GridBagConstraints();
			gbc_lblY1.insets = new Insets(0, 0, 5, 5);
			gbc_lblY1.gridx = 0;
			gbc_lblY1.gridy = 3;
			contentPanel.add(lblY1, gbc_lblY1);
		}
		{
			textFieldY1 = new JTextField();
			GridBagConstraints gbc_textFieldY1 = new GridBagConstraints();
			gbc_textFieldY1.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY1.gridx = 1;
			gbc_textFieldY1.gridy = 3;
			contentPanel.add(textFieldY1, gbc_textFieldY1);
			textFieldY1.setColumns(10);
		}
		{
			lblX2 = new JLabel("X2 coordinate");
			GridBagConstraints gbc_lblX2 = new GridBagConstraints();
			gbc_lblX2.insets = new Insets(0, 0, 5, 5);
			gbc_lblX2.gridx = 0;
			gbc_lblX2.gridy = 5;
			contentPanel.add(lblX2, gbc_lblX2);
		}
		{
			textFieldX2 = new JTextField();
			GridBagConstraints gbc_textFieldX2 = new GridBagConstraints();
			gbc_textFieldX2.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX2.gridx = 1;
			gbc_textFieldX2.gridy = 5;
			contentPanel.add(textFieldX2, gbc_textFieldX2);
			textFieldX2.setColumns(10);
		}
		{
			lblY2 = new JLabel("Y2 coordinate");
			GridBagConstraints gbc_lblY2 = new GridBagConstraints();
			gbc_lblY2.insets = new Insets(0, 0, 5, 5);
			gbc_lblY2.gridx = 0;
			gbc_lblY2.gridy = 7;
			contentPanel.add(lblY2, gbc_lblY2);
		}
		{
			textFieldY2 = new JTextField();
			GridBagConstraints gbc_textFieldY2 = new GridBagConstraints();
			gbc_textFieldY2.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY2.gridx = 1;
			gbc_textFieldY2.gridy = 7;
			contentPanel.add(textFieldY2, gbc_textFieldY2);
			textFieldY2.setColumns(10);
		}
		{
			btnOutlineColor = new JButton("Outline Color");
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
							btnOutlineColor.getBackground());
					if (outlineColor != null)
						btnOutlineColor.setBackground(outlineColor);
				}
			});
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.anchor = GridBagConstraints.WEST;
			gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOutlineColor.gridx = 1;
			gbc_btnOutlineColor.gridy = 9;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldX1.getText().trim().isEmpty() || textFieldY1.getText().trim().isEmpty()
								||textFieldX2.getText().trim().isEmpty() || textFieldY2.getText().trim().isEmpty()) {
							setOk(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(textFieldX1.getText().toString()) < 0
										|| Integer.parseInt(textFieldY1.getText().toString()) < 0
										||Integer.parseInt(textFieldX2.getText().toString()) < 0
										|| Integer.parseInt(textFieldY2.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Enter positive number!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									line = new Line(

											new Point(Integer.parseInt(textFieldX1.getText().toString()),
													Integer.parseInt(textFieldY1.getText().toString())),
											new Point(Integer.parseInt(textFieldX2.getText().toString()),
													Integer.parseInt(textFieldY2.getText().toString())),
											false, btnOutlineColor.getBackground());
									isOk = true;
									setVisible(false);

								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
