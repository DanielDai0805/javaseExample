package se.javabean;

/**
 * Created by dc on 2015/6/1.
 * this class has two property . running and mouthWidth;
 */
public class FaceBean {

    private int mMouthWidth = 90;

    //boolean property
    private boolean running;
    //an indexed property is an array instead of a single value
    private int[] testGrades;

    public int[] getTestGrades() {
        return testGrades;
    }
    //for indexed property ,the bean class also provides methods for getting and setting a specific element of the array
    public int getTestGrades(int index) {
        return testGrades[index];
    }

    public void setTestGrades(int index, int grade) {
        testGrades[index] = grade;
    }

    public void setTestGrades(int[] testGrades) {
        this.testGrades = testGrades;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getMounthWidth(){
        return mMouthWidth;
    }

    public void setMouthWidth(int mw){
        this.mMouthWidth = mw;
    }

}
