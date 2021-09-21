public class TestRational {
	
	public static void main(String[] args) {
		
		Rational r1 = new Rational();
		r1.setNumerator(12);
		r1.setDenominator(24);
		Rational r2 = new Rational(3);
		Rational r3 = new Rational(158337, 133371);
		
		System.out.println("Fractions are ");
		System.out.println(r1 + " " + r2 + " " + r3);
		
		System.out.println("Numerator of r1 is " + r1.getNumerator());
		System.out.println("Denominator of r1 is " + r1.getDenominator());
		
		System.out.println("In decimal form the fractions are");
		System.out.println(r1.toDecimal() + " " + r2.toDecimal() + " " + r3.toDecimal());
		
		r1.invert();
		r2.invert();
		r3.invert();
		System.out.println("Invert the fractions. Fractions are");
		System.out.println(r1 + " " + r2 + " " + r3);
		
		System.out.println("In decimal form the new fractions are");
		System.out.println(r1.toDecimal() + " " + r2.toDecimal() + " " + r3.toDecimal());

		System.out.println("In reduced form the fractions are");
		r1.reduce();
		r2.reduce();
		r3.reduce();
		System.out.println(r1+ " " + r2 + " " + r3);
		

		//r1.test();
	}
}
	