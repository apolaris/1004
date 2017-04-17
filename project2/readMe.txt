Beichen Zhang
bz2309
project2


P5.8 Year.class
	isLeapYear():
		As we know, the truth-values whether the year can be divided by 4, 100, 400 with no remainder dicide whether it is a LeapYear. So, I use some if to judge the year. Besides, this program also allows a nagetive input, which will be regarded as the B.C. year(Before Christ).

P6.4 FactorGenerator
	FactorGenerator(int input): As we know, if the input is 0 or 1, it doesn't have any factors. Besides, if the input is nagetive, we also can't divide it into positive factors, so, the program only allows an int input that bigger than 1.
	isPrime(int x): Use all the positive numbers that no bigger than sqrt(x) to divide x. If all of them can't divide it exactly, it is prime, else, it is not.
	hasMoreFactors(): Test all the numbers between "out" and "n" whether they are prime, if there are prime, return Yes and the "out" will be the prime number. Else, return false.
	int nextFactor(): Test all the numbers between "out" and "n" whether they are prime, if there are prime, return it and the "n" will be divided by the prime number. Else, return 0.

P6.5 PrimeGenerator.class
	PrimeGenerator(): Initialize the p to 1.
	isPrime(int x): Use all the positive numbers that no bigger than sqrt(x) to divide x. If all of them can't divide it exactly, it is prime, else, it is not.
	nextPrime(): Test values bigger than "p" one by one, if find a prime number, return it and assign "p" as the prime numebr.
	
PrimePrinter.class
	main(Strings[] argv): First it will exam whether the input is an integer, if not, you have to input again. Then, I use a for-loop to output all the prime that less than the input. Besides, nagetive input is allowed, but all the prime number bigger than them, so the output is NULL(nothing to print).