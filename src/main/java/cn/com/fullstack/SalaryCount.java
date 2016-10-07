package cn.com.fullstack;

/**
 * Created by JM on 2016-10-2.
 */
public class SalaryCount {
    private String name;
    private long SlaryAdd;
    private int numbers;

    public SalaryCount(String name, long slaryAdd, int numbers) {
        this.name = name;
        SlaryAdd = slaryAdd;
        this.numbers = numbers;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSlaryAdd() {
        return SlaryAdd;
    }

    public void setSlaryAdd(long slaryAdd) {
        SlaryAdd = slaryAdd;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "SalaryCount{" +
                "name='" + name + '\'' +
                ", SlaryAdd=" + SlaryAdd +
                ", numbers=" + numbers +
                '}';
    }
}
