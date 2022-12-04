public enum CountAndRoman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    private final int value;
    private CountAndRoman(int value){
        this.value = value;
    }

    public int toInt() {
        return value;
    }
}
