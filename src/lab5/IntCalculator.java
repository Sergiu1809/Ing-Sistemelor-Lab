package lab5;

public class IntCalculator {
    protected int state;

    public IntCalculator(int initialValue){
        this.state = initialValue;
    }

    public IntCalculator add(int value){
        this.state = this.state + value;
        return this;
    }

    public IntCalculator sub(int value){
        this.state = this.state - value;
        return this;
    }

    public IntCalculator multiply(int value){
        this.state = this.state * value;
        return this;
    }

    public int result(){
        return state;
    }
}
