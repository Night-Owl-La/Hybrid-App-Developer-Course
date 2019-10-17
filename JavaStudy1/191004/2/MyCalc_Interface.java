interface MyCalc_Interface
{
	int abs(int n); // 절대값
	int max(int a, int b); // 두 수 중 큰 수 리턴.
	int min(int a, int b); // 두 수 중 작은 수 리턴.
	int hap_even(int n); // n까지의 짝수의 합.
	int hap_odd(int n); // n까지의 홀수의 합.
	int hap(int n, int m); // n까지의 수 중에서 m의 배수의 합 구하기.
	double factorial(double n); // n! 구하기.
	void sosu(int n); // n까지의 수 중 소수를 모두 출력.
}