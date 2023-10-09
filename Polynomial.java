
import java.io.*;
public class Polynomial{
	double[] coefficients;
	int[] exponents;
	
	Polynomial(){
		coefficients = new double[1];
		exponents = new int[1];
	}
	
	Polynomial(double[] coefficients, int[] exponents){
		this.coefficients = coefficients;
		this.exponents = exponents;
	}
	
	Polynomial(File f){
		 try
    {
        BufferedReader b = new BufferedReader(new FileReader(f));      
		String p = b.readLine();
		b.close();
		String[] terms = p.split("(?<=.)(?=(\\+|\\-))");
		this.coefficients = new double[terms.length];
		this.exponents = new int[terms.length];
		for(int i = 0 ; i < terms.length; i++){
			String[] term_values = terms[i].split("x",-1);
			if (term_values.length == 1){
				this.coefficients[i] = Double.parseDouble(term_values[0]);
				this.exponents[i] = 0;
			}
			else if(!term_values[0].equals("") && !term_values[1].equals("")){
				this.coefficients[i] = Double.parseDouble(term_values[0]);
				this.exponents[i] = Integer.parseInt(term_values[1]);
			}
			else if(term_values[0].equals("") && term_values[1].equals("")){
				this.coefficients[i] = 1;
				this.exponents[i] = 1;
			}
			else if(term_values[0].equals("") && !term_values[1].equals("")){
				this.coefficients[i] = 1;
				this.exponents[i] = Integer.parseInt(term_values[1]);
			}
			else {
				this.coefficients[i] = Double.parseDouble(term_values[0]);
				this.exponents[i] = 1;
			}
		
		}
		}
    catch (IOException ex) {}
	}
	
	public Polynomial add(Polynomial P){
		double[] result_co = new double[this.coefficients.length];
		int[] result_ex = new int[this.exponents.length];
		for(int i = 0; i < this.coefficients.length; i++){
			result_co[i] = this.coefficients[i];
			result_ex[i] = this.exponents[i];}
		int l = this.coefficients.length;
		for(int i = 0; i < P.coefficients.length; i++){
			for(int j = 0; j < l; j++){
				if(P.exponents[i] == result_ex[j]){
					result_co[j] = result_co[j] + P.coefficients[i];
					break;
				}
				else if(P.exponents[i] != result_ex[j] && j==(l-1)){
					double[] new_co = new double[result_co.length + 1];
					int[] new_ex = new int[result_ex.length+1];
					for (int k = 0; k < result_co.length; k++){
						new_co[k] = result_co[k];
						new_co[result_co.length] = P.coefficients[i];
						new_ex[k] = result_ex[k];
						new_ex[result_ex.length] = P.exponents[i];
					}
					result_co = new_co;
					result_ex = new_ex;
				}
			}
		}
		Polynomial result_P = new Polynomial(result_co, result_ex);
		return result_P;
	}
	
	public double evaluate(double x){
		double result = 0;
		for(int i =0; i < this.coefficients.length; i++){
			result = result + this.coefficients[i]*Math.pow(x,this.exponents[i]); 
		}
		return result;
	}
	
	public boolean hasRoot(double x){
		return this.evaluate(x)==0;}
		
	public Polynomial multiply(Polynomial P){
		Polynomial result = new Polynomial();
		for (int i = 0; i < this.coefficients.length; i++){
			for (int j = 0; j < P.coefficients.length; j++){
				double[] term_co = new double[1];
				int[] term_ex = new int[1];
				term_co[0] = this.coefficients[i]*P.coefficients[j];
				term_ex[0] = this.exponents[i]+P.exponents[j];
				Polynomial term = new Polynomial(term_co, term_ex);
				result = result.add(term);
			}
		}
		return result;
	}
	
	public void saveToFile(String fname){
		try{FileWriter fw = new FileWriter(fname);
		for(int i = 0; i < this.coefficients.length; i++){
			if(this.exponents[i] == 0){
				if(this.coefficients[i]==0){
				}
				else if(this.coefficients[i]>0){
					fw.write("+" + Double.toString(this.coefficients[i]));
				}
				else{
					fw.write(Double.toString(this.coefficients[i]));
				}
			}
			else if(this.exponents[i] == 1){
				if(this.coefficients[i]==0){
				}
				else if(this.coefficients[i]==1){
					fw.write("+x");
				}
				else if(this.coefficients[i]==-1){
					fw.write("-x");
				}
				else if(this.coefficients[i]>0){
					fw.write("+" + Double.toString(this.coefficients[i]) + "x");
				}
				else{
					fw.write(Double.toString(this.coefficients[i]) + "x");
				}
	
			}
			else{
				if(this.coefficients[i]==0){
				}
				else if(this.coefficients[i]==1){
					fw.write("+x" + Integer.toString(this.exponents[i]));
				}
				else if(this.coefficients[i]==-1){
					fw.write("-x" + Integer.toString(this.exponents[i]));
				}
				else if(this.coefficients[i]>0){
					fw.write("+" + Double.toString(this.coefficients[i]) + "x" + Integer.toString(this.exponents[i]));
				}
				else{
					fw.write(Double.toString(this.coefficients[i]) + "x" + Integer.toString(this.exponents[i]));
				}
	
			}
			
		}
		fw.close();
	}
	catch(IOException e){}
}

	public void printPolynomial(){
		System.out.println("coefficients:");
		for (double c : this.coefficients){
			System.out.println(c);
			System.out.println("\n");}
		System.out.println("exponents:");
		for (int e : this.exponents){
			System.out.println(e);
			System.out.println("\n");}
		}
}
