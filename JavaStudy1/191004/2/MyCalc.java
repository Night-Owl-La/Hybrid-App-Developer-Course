class MyCalc implements MyCalc_Interface
{
	public int abs(int n){ return (n<0) ? -n : n; }
	public int max(int a, int b){	return (a>b) ? a : b; }
	public int min(int a, int b){	return (a<b) ? a : b; }
	public int hap_even(int n){
		int even_sum=0;
		for (int i=2; i<=n; i++)
			if(i%2==0) even_sum+=i;
		return even_sum;
	} // n까지의 짝수의 합.

	public int hap_odd(int n){
		int odd_sum=1;
		for (int i=3; i<=n; i++)
			if(i%2!=0) odd_sum+=i;
		return odd_sum;
	} // n까지의 홀수의 합.

	public int hap(int n, int m){
		int sum=0;
		for (int i=1; i<=n; i++)
			if(i%m==0) sum+=i;
		return sum;
	} // n까지의 수 중에서 m의 배수의 합 구하기.

	public double factorial(double n){
		if(n==0) return 1;
		return n*(factorial(n-1));
	} // n! 구하기.

	public void sosu(int n){
		System.out.print("1 ");
		System.out.print("2 ");
		System.out.print("3 ");
		for (int i=4; i<=n; i++){
			if(i%2==0) continue;
			else if(i%3==0) continue;
			System.out.print(i+" ");
		}
	} // n까지의 수 중 소수를 모두 출력.
}
