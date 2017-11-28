//Sarah Dunbar
//Programming assignment 1

import java.lang.Math;

public class IntPoint2D{
private int _X;
private int _Y;

public IntPoint2D(int x, int y){
  _X=x;
  _Y=y;
}

//returns x value of IntPoint2D object
public int getX(){
  return _X;
}

//returns y value of IntPoint2D object
public int getY(){
  return _Y;
}

//Function that computes the manhattanDistance from one point to another
public int manhattanDistance(IntPoint2D i){
int diff_x=Math.abs(this.getX()-i.getX());
int diff_y=Math.abs(this.getY()-i.getY());
int md=diff_x+diff_y;
return md;
}

//Creates a string representation of IntPoint2D object
public String toString(){
  return "(" + this.getX() + "," + this.getY() + ")";
}

//Function that checks the Euclidean distance from one point to another
public double distance(IntPoint2D i){
  int _x=(int)Math.pow(this.getX()-i.getX(), 2);
  int _y=(int)Math.pow(this.getY()-i.getY(), 2);
  double dist=Math.sqrt(_x+_y);
  return dist;
}

//check if one IntPoint2D object is equal to another one
public boolean equals(IntPoint2D other){
  if (this.getX()==other.getX() && this.getY()==other.getY()){
    return true;
  }
  else{
    return false;
  }
}

//overriding hashcode function
public int hashcode(){
return (this.getX()<<16)+this.getY();
}

//main method
public static void main(String[] args){
//creating new IntPoint2D object
  IntPoint2D point_a= new IntPoint2D(1,5);
}
}
