package hr.unipu.java.topic3.staticmethods;

public class Point {	
	private double x, y;
	
	public double getX(){		
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public Point(Point p){
		this(p.x, p.y);
	}

	// Težište triju točaka
	public static Point centerOf(Point a, Point b, Point c){		
		double x = (a.getX() + b.getX() + c.getX()) / 3.;
		double y = (a.getY() + b.getY() + c.getY()) / 3.;
		Point p = new Point(x, y);
		return p;		
	}

	// Težište više točaka – rješenje s varijabilnim brojem argumenata
	public static Point centerOf(Point a, Point b, Point... points){		
		double x = a.getX() + b.getX();
		double y = a.getY() + b.getY();		
		for(Point p : points){
			x += p.getX();
			y += p.getY();
		}		
		int len = points.length + 2;	//points.length and also a and b
		Point p = new Point(x / len, y / len);
		return p;		
	}

	// Težište više točaka – rješenje s korištenjem polja
	public static Point centerOf(Point[] points){		
		double x = 0, y = 0;
		int len = points.length;
//		for(int i=0; i<len; i++){
//			x += points[i].getX();
//			y += points[i].getY();
//		}
		for(Point p : points){		//FOREACH oblik FOR petlje
			x += p.getX();
			y += p.getY();
		}
		
		Point p = new Point(x / len, y / len);
		return p;		
	}
	
	@Override		
	public String toString(){
		return "(" + x + ", " + y + ")";		
	}
}
