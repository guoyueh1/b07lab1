public class Polynomial{
	double[] coefficients;
	Polynomial(){
		coefficients = new double[1];
}
	Polynomial(double[] coefficients){
		this.coefficients = coefficients;
}
	public Polynomial add(Polynomial P){
		double[] result = new double[Math.max(this.coefficients.length, P.coefficients.length)];
		for(int i = 0; i < this.coefficients.length; i++){
			result[i] = result[i] + this.coefficients[i];}
		for(int i = 0; i < P.coefficients.length; i++){
			result[i] = result[i] + P.coefficients[i];}
		Polynomial resulting_p = new Polynomial(result);
		return resulting_p;}
	public double evaluate(double x){
		double result = 0;
		for (int i =0; i <this.coefficients.length; i++){
			result =  result + this.coefficients[i]*Math.pow(x,i);}
		return result;}
	public boolean hasRoot(double x){
		return this.evaluate(x)==0;}
}
