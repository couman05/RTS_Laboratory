
public class Main {

	public static void main(String[] args) {
		Controller c = new Controller();
		Robot r = new Robot ();
		Supervisor s=new Supervisor();
		c.r = r;
		r.c = c;
		s.c=c;
		c.s=s;
		s.start();
		c.start();
		r.start();
	}
}
