import java.lang.Math;
public class IntGrid2D implements IIntGrid2D{

private int upper_left_x;
private int upper_left_y;
private int lower_right_x;
private int lower_right_y;
private char fill;
private char[][] grid;

public IntGrid2D(int ul_x, int ul_y, int lr_x, int lr_y, char fill_){
upper_left_x=ul_x;
upper_left_y=ul_y;
lower_right_x=lr_x;
lower_right_y=lr_y;
fill=fill_;

//creates length of rows and columns, add one to the difference of points to
//get correctlength

int grid_row=Math.abs(ul_x-lr_x)+1;
int grid_column=Math.abs(ul_y-lr_y)+1;
grid=new char[grid_row][grid_column];

//fills grid with input fill value

for(int i=0; i<grid_row; i++){
  for(int j=0; j<grid_column; j++){
    grid[i][j]=fill_;
  }
}
}

//takes an IInpoint2D object and places it at the correct index in the grid
//must subtract the upper left x and lower right y in order to get the correct
//positive indexes for the 2D array

public void setPoint(IIntPoint2D p, char v){
  grid[p.getX()-upper_left_x][p.getY()-lower_right_y]=v;
}

//gets the character value for a certain IIntPoint2D index on the grid, again
//we must subtract the upper left x and lower right y to map this index to the
//correct value in the 2D array

public char getPoint(IIntPoint2D p){
  return grid[p.getX()-upper_left_x][p.getY()-lower_right_y];
}

//Returns the IIntPoint2D index value in the upperleft corner

public IIntPoint2D getUpperLeftCorner(){
  IIntPoint2D upper_left= new IntPoint2D(upper_left_x,upper_left_y);
  return upper_left;
}

//Returns the IIntPoint2D index value in the lower right corner

public IIntPoint2D getLowerRightCorner(){
  IIntPoint2D lower_right= new IntPoint2D(lower_right_x,lower_right_y);
  return lower_right;
}

}
