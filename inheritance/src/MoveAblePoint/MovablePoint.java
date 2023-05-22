package MoveAblePoint;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint(){
    }

    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[] {xSpeed,ySpeed};
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed =xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return super.toString() + "+ speed: (" + this.xSpeed + "," + this.ySpeed + ")" + "\n";
    }
    public Point move() {
        this.setX(this.getX() + this.xSpeed);
        this.setX(this.getY() + this.ySpeed);
        return this;
    }
}
