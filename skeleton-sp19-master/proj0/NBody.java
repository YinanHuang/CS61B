public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		in.readInt();
		return in.readDouble();
	}
	public static Body[] readBodies(String fileName){
		int i=0;
		In in = new In(fileName);
		int number = in.readInt(); // number of planets
		//System.out.println(number);
		in.readDouble(); // pass "radius of universe"
		Body[] bodies = new Body[number];
		while(i<number) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			Body b = new Body(xxPos,yyPos,xxVel,yyVel,mass,img);
			bodies[i++] = b;
			}
		return bodies;
	}

	/** draw all the planets */
	public static void draw(Body[] bodies){
		for(Body b : bodies){
			b.draw();
		}
	}

	public static void main(String[] args){

		double T=Double.valueOf(args[0]); // total time in running
		double dt=Double.valueOf(args[1]); // time step
		double t; // time variable
		String fileName=args[2];
		double universeRadius=NBody.readRadius(fileName);
		Body[] bodies=NBody.readBodies(fileName);
		double[] xForces=new double[bodies.length];
		double[] yForces=new double[bodies.length];

		/** draw backgroud*/
		String background="images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-universeRadius, universeRadius);
		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		StdDraw.picture(0, 0, background);
		for (t=0;t<T;t+=dt){
			for (int i=0;i<bodies.length;i++){
				xForces[i]=bodies[i].calcNetForceExertedByX(bodies);
				yForces[i]=bodies[i].calcNetForceExertedByY(bodies);
			}
			for (int j=0;j<bodies.length;j++){
				bodies[j].update(dt,xForces[j],yForces[j]);
			}
			StdDraw.clear();
			StdDraw.picture(0, 0, background);
			NBody.draw(bodies);
			StdDraw.show();
		}

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.pause(2000);
	}
}
