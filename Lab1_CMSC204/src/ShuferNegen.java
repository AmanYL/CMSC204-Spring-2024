
public class ShuferNegen {
	public static void main(String[] args) {
		GradeBook g1 = new GradeBook(5);
        g1.addScore(50);
        g1.addScore(75);

        GradeBook g2 = new GradeBook(5);
        g2.addScore(80);
        g2.addScore(90);
        g2.addScore(73);
        
        GradeBook g3 = new GradeBook(4);
        g3.addScore(g1.finalScore());
        g3.addScore(g2.sum());
        
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
	}

}
