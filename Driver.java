import java.io.*;
public class Driver {
public static void main(String [] args) {
Polynomial p = new Polynomial();
System.out.println(p.evaluate(3));
double [] c1 = {6,5};
int[] e1 = {0,3};
Polynomial p1 = new Polynomial(c1,e1);
double [] c2 = {-2,-9};
int[] e2 = {1,4};
Polynomial p2 = new Polynomial(c2,e2);
double [] c3 = {0,0.5,2};
int[] e3 = {1,4,2};
Polynomial p3 = new Polynomial(c3,e3);
Polynomial s = p1.add(p2);
Polynomial s2 = p2.add(p3);
System.out.println("s(0.1) = " + s.evaluate(0.1));
if(s.hasRoot(1))
System.out.println("1 is a root of s");
else
System.out.println("1 is not a root of s");
System.out.println("------------------");
System.out.println("s2(2) = " + s2.evaluate(2));
if(s2.hasRoot(1))
System.out.println("1 is a root of s2");
else
System.out.println("1 is not a root of s2");
System.out.println("------------------");
Polynomial p11 = new Polynomial(new File("/cmshome/guoyueh1/p1"));
Polynomial p22 = new Polynomial(new File("/cmshome/guoyueh1/p2"));
Polynomial p33 = new Polynomial(new File("/cmshome/guoyueh1/p3"));
System.out.println("p11 from file is :");
p11.printPolynomial();
System.out.println("p22 from file is :");
p22.printPolynomial();
System.out.println("p33 from file is :");
p33.printPolynomial();
System.out.println("s11 is :");
Polynomial s11 = p11.add(p22);
Polynomial product12 = p11.multiply(p22);
s11.printPolynomial();
System.out.println("s22 is :");
Polynomial s22 = p22.add(p33);
Polynomial product23 = p22.multiply(p33);
s22.printPolynomial();
s11.saveToFile("/cmshome/guoyueh1/p1+p2");
s22.saveToFile("/cmshome/guoyueh1/p2+p3");
product12.saveToFile("/cmshome/guoyueh1/p1p2");
product23.saveToFile("/cmshome/guoyueh1/p2p3");
System.out.println("s11(0.1) = " + s11.evaluate(0.1));
if(s11.hasRoot(1))
System.out.println("1 is a root of s11");
else
System.out.println("1 is not a root of s11");
System.out.println("------------------");
System.out.println("s22(2) = " + s22.evaluate(2));
if(s22.hasRoot(1))
System.out.println("1 is a root of s22");
else
System.out.println("1 is not a root of s22");
try{BufferedReader br = new BufferedReader(new FileReader("/cmshome/guoyueh1/p1+p2"));
BufferedReader br2 = new BufferedReader(new FileReader("/cmshome/guoyueh1/p2+p3"));
BufferedReader br3 = new BufferedReader(new FileReader("/cmshome/guoyueh1/p1p2"));
BufferedReader br4 = new BufferedReader(new FileReader("/cmshome/guoyueh1/p2p3"));
System.out.println("p11 plus p22:\n");
System.out.println(br.readLine());
System.out.println("p22 plus p33:\n");
System.out.println(br2.readLine());
System.out.println("p11 multiply p22:\n");
System.out.println(br3.readLine());
System.out.println("p2 multiply p33:\n");
System.out.println(br4.readLine());
br.close();
br2.close();
br3.close();
br4.close();
}
catch(IOException e){}
}}
