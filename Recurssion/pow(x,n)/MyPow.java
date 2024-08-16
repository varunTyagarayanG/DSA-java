class MyPow {
    public double func(double x, int n) {
        if (n == 0) return 1;
        double half = func(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double solution(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return func(x, n);
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 2.0;
        int n = 10;
        double result = myPow.solution(x, n);
        System.out.println(x + " raised to the power of " + n + " is: " + result);

        // Test with a negative power
        n = -2;
        result = myPow.solution(x, n);
        System.out.println(x + " raised to the power of " + n + " is: " + result);
    }
}
