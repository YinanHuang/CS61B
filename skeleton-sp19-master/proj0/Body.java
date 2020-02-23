public class Body{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;
	public static double G=6.67*Math.pow(10,-11);

	/** Instantiation 1: create a new Body with certain parameters*/
	public Body(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos=xP;
		this.yyPos=yP;
		this.xxVel=xV;
		this.yyVel=yV;
		this.mass=m;
		this.imgFileName=img;
	}

	/** Instantiation 2: create a copy of Body b */
	public Body(Body b){
		this.xxPos=b.xxPos;
		this.yyPos=b.yyPos; 
		this.xxVel=b.xxVel; 
		this.yyVel=b.yyVel; 
		this.mass=b.mass; 
		this.imgFileName=b.imgFileName;  
	}

	public double calcDistance(Body b){
		return Math.sqrt(Math.pow(this.xxPos-b.xxPos,2)+Math.pow(this.yyPos-b.yyPos,2));
	}

	public double calcForceExertedBy(Body b){
		return G*this.mass*b.mass/Math.pow(this.calcDistance(b),2);
	}

	public double calcForceExertedByX(Body b){
		return G*this.mass*b.mass*(b.xxPos-this.xxPos)/Math.pow(this.calcDistance(b),3);
	}

	public double calcForceExertedByY(Body b){
		return G*this.mass*b.mass*(b.yyPos-this.yyPos)/Math.pow(this.calcDistance(b),3);
	}

	public double calcNetForceExertedByX(Body[] bodies){
		double NetForceX=0;
		for(Body b : bodies){
			if(b.equals(this)){
				continue;
			}
			NetForceX+=this.calcForceExertedByX(b);
		}
		return NetForceX;
	}

	public double calcNetForceExertedByY(Body[] bodies){
		double NetForceY=0;
		for(Body b : bodies){
			if(b.equals(this)){
				continue;
			}
			NetForceY+=this.calcForceExertedByY(b);
		}
		return NetForceY;
	}

	/** update one's position and velocity after time dt */
	public void update(double dt, double fX, double fY){
		this.xxVel+=dt*fX/this.mass;
		this.yyVel+=dt*fY/this.mass;
		this.xxPos+=this.xxVel*dt;
		this.yyPos+=this.yyVel*dt; 
	}

	public void draw(){
		String imgPath="images/";
		StdDraw.picture(this.xxPos, this.yyPos, imgPath+this.imgFileName);
		//StdDraw.show();
	}

}
