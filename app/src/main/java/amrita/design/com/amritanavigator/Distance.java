package amrita.design.com.amritanavigator;

public class Distance {
    public String inte(float f) {
        String num = Integer.toString((int) f);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Distance : ");
        stringBuilder.append(num);
        stringBuilder.append(" meters.");
        return stringBuilder.toString();
    }

    public String abc(int i) {
        return Integer.toString(i);
    }
}
