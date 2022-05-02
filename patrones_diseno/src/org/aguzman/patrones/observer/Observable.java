package org.aguzman.patrones.observer;

import java.util.ArrayList;
import java.util.List;

abstract public class Observable {
    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        notifyObservers(null);
    }

    public void notifyObservers(Object obj){
        for(Observer obs: this.observers){
            obs.update(this, obj);
        }
    }
}
