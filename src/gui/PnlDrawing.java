public void selectShape(Point click) {
		selectedShape = null;
		Iterator<Shape> iterator = shapes.iterator();
		while (iterator.hasNext()) {
			Shape shape = iterator.next();
			shape.setSelected(false);
			if (shape.contains(click.getX(), click.getY()))
				selectedShape = shape;
		}
		if (selectedShape != null)
			selectedShape.setSelected(true);
	}