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

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldHeight;
	private JTextField textFieldWidth;
	private boolean isOk;
	private Rectangle rect;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblHeight;
	private JLabel lblWidth;

	
	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Dialog Rectangle");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 1;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			lblY = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 5;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 1;
			gbc_textFieldHeight.gridy = 5;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			lblWidth = new JLabel("Width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 7;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.gridx = 1;
			gbc_textFieldWidth.gridy = 7;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(10);
		}
		{
			{
			}
		}
		btnInnerColor = new JButton("Inner Color");
		btnInnerColor.setForeground(new Color(0, 0, 0));
		btnInnerColor.setBackground(Color.WHITE);
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = JColorChooser.showDialog(null, "Choose inner color!", btnInnerColor.getBackground());
				
				if (innerColor != null)
					btnInnerColor.setBackground(innerColor);
			}
		});
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnInnerColor.gridx = 0;
		gbc_btnInnerColor.gridy = 9;
		contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		{
			btnOutlineColor = new JButton("Outline Color");
			btnOutlineColor.setForeground(new Color(0, 0, 0));
			btnOutlineColor.setBackground(new Color(255, 255, 255));
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
							btnOutlineColor.getBackground());
					
					if (outlineColor != null)
						btnOutlineColor.setBackground(outlineColor);
				}
			});
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
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
						if (textFieldX.getText().trim().isEmpty() || textFieldY.getText().trim().isEmpty() 
								|| textFieldHeight.getText().trim().isEmpty()
								|| textFieldWidth.getText().trim().isEmpty()) {
							setOk(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(textFieldHeight.getText().toString()) <= 0
										|| Integer.parseInt(textFieldWidth.getText().toString()) <= 0
										|| Integer.parseInt(textFieldX.getText().toString()) < 0
										|| Integer.parseInt(textFieldY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Enter positive number!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									rect = new Rectangle(

											new Point(Integer.parseInt(textFieldX.getText().toString()),
													Integer.parseInt(textFieldY.getText().toString())),
											Integer.parseInt(textFieldWidth.getText().toString()),
											Integer.parseInt(textFieldHeight.getText().toString()), false,
											btnOutlineColor.getBackground(), btnInnerColor.getBackground());

									setOk(true);
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

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}
}


