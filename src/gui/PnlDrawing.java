public void delete() {
		if (selectedShape != null) {
			if (selectedShape instanceof Point) {
				int selectedOption = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete tacku?",
						"Upozorenje", JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					shapes.remove(selectedShape);
					selectedShape = null;
					repaint();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Morate selektovati oblik!", "Upozorenje",
					JOptionPane.WARNING_MESSAGE);
			else if (selectedShape instanceof Line) {
				int selectedOption = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete liniju?",
						"Upozorenje", JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION) {
					shapes.remove(selectedShape);
					selectedShape = null;
					repaint();
				}
			}
		}
	}