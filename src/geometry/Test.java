package geometry;

public class Test {

/*	public static void main(String[] args) {
		
		Point point1 = new Point();
		
		//point1.x = 4;
		//point1.y = 5; Nije moguca zbog specifikatora pristupa 
		
		point1.setX(4);
		point1.setY(5);
		point1.setSelected(false);
		
		System.out.println("X kordinata je: " + point1.getX()); 
		System.out.println("Y kordinata je: " + point1.getY());
		System.out.println("Selected kordinata je: " + point1.isSelected());
		
		double distanceResult = point1.distance(8, 7);
		System.out.println("Udaljenost tacaka je: " + distanceResult);
		
		System.out.println("Vezbe 3");
		
		Point p2 = new Point();
		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();
		
		p2.setX(10);
		p2.setY(15);
		
		//1. inicijalizovati x koordinatu tacke point1 na vrednost y koordinate tacke p2
		System.out.println("X koordinata tacke point1: " + point1.getX());
		point1.setX(p2.getY());
		System.out.println("X koordinata tacke point1: " + point1.getX());
		
		//2. postaviti za pocetnu tacku linije l1 tacku point1, a za krajnju tacku linije l1 tacku p2
		l1.setStartPoint(point1);
		l1.setEndPoint(p2);
		System.out.println("X koordinata pocetne tacke l1: " + l1.getStartPoint().getX());
		System.out.println("Y koordinata pocetne tacke l1: " + l1.getStartPoint().getY());
		
		System.out.println("X koordinata krajnje tacke l1: " + l1.getEndPoint().getY());
		
		//3. postaviti y koordinatu krajnje tacke linije l1 na 23
		l1.getEndPoint().setY(23);
		System.out.println("Y koordinata krajnje tacke l1: " + l1.getEndPoint().getY());
		
		//4. inicijalizovati x koordinatu pocetne tacke linije l1 na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("X koordinata pocetne tacke l1: " + l1.getStartPoint().getX());
		
		//5. postaviti x koordinatu krajnje tacke linije l1 na vrednost duzine linije l1 umanjene za vrednost zbira x i y koordinate
		//pocetne tacke linije l1
		l1.getEndPoint().setX( (int) l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY()));
		System.out.println("X koordinata krajnje tacke l1: " + l1.getEndPoint().getX());
		
		//6. postaviti x koordinatu tacke gore levo pravougaonika r1 na vrednost 10 i y koordinatu na vrednost 15
		r1.setUpperLeftPoint(new Point());
		r1.getupperLeftPoint().setX(10);
		r1.getupperLeftPoint().setY(15);
		System.out.println("X vrednost za pravougaonik: " + r1.getupperLeftPoint().getX());
		System.out.println("Y vrednost za pravougaonik: " + r1.getupperLeftPoint().getY());
		
		r1.setWidht(20);
		r1.setHeight(10);
		System.out.println("povrsina pravougaonika je: " + r1.area());
		
		//7. postaviti centar kruga c1 na koordinate tacke gore levo pravougaonika r1
		c1.setCenter(r1.getupperLeftPoint());
		
		//8. postaviti x koordinatu centra kruga c1 na vrednost razlike povrsine pravougaonika r1 i y koordinate pocetne tacke
		//linije l1
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("Centar kruga c1: (" + c1.getCenter().getX() + "," + c1.getCenter().getY() + ")");
		
		//Vezbe 4
		
		System.out.println(point1);
		System.out.println(l1);
		System.out.println(c1);
		System.out.println(r1);
		
		int a = 5; //int je primitivni tip podataka
		int b = 5; 
		System.out.println(a == b); //poredjenje po vrednosti
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1 == s2); //poredjenje po referenci
		System.out.println(s1.equals(s2)); //poredjenje po vrednosti
		
		Point p3 = new Point(23, 5);
		System.out.println(point1 == p3);
		System.out.println(point1.equals(p3));
		
	}
*/
}
