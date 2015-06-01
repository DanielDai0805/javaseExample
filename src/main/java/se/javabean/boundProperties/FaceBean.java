package se.javabean.boundProperties;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by dc on 2015/6/1.
 * link: https://docs.oracle.com/javase/tutorial/javabeans/writing/properties.html
 * A bound property notifies listeners when its value changes. This has two implications:
 *      The bean class includes addPropertyChangeListener() and removePropertyChangeListener() methods for managing the bean's listeners.
 *      When a bound property is changed, the bean sends a PropertyChangeEvent to its registered listeners.
 *
 */
public class FaceBean {
    public static void main(String args[]){
        FaceBean fb =  new FaceBean();
        fb.setMouthWidth(10);
    }

    private int mMouthWidth = 90;
    private PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    public int getMouthWidth() {
        return mMouthWidth;
    }
    public void setMouthWidth(int mw){
        int oldMouthWdith = mw;
        mMouthWidth = mw;
        mPcs.firePropertyChange("mounthWidth",oldMouthWdith,mw);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        mPcs.addPropertyChangeListener(listener);
    }

    public void  removePropertyChangeListener(PropertyChangeListener listener) {
        mPcs.removePropertyChangeListener(listener);
    }
}
