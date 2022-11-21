import java.util.*;
public class MissFinder	
{
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			long n = 0, k = 0;
			
			while((n<=2) || (n>=12)) {
			    System.out.println("Enter n value 'n' between [2,12]!");
			    n = sc.nextLong();
			}
			while(k<=10) {	
			    System.out.println("Enter x, y limit value 'k' where k>10");
			    k = sc.nextLong();
			}
			
			long mis = Long.MAX_VALUE;		
			double rel_mis = Long.MAX_VALUE;	

			for(long x = 10;x<=k;x++) {		
			    for(long y = 10;y<=k;y++) {		
					
			        long pow_sum = (long)(Math.pow(x,n) + Math.pow(y,n));
			        
					if(pow_sum<0) {						
			            System.out.println("OverFlow \nEnter the lower values of power and k");
			            return;
			        }
			        long z = (long)(Math.pow(pow_sum, 1.0/n)), zn = (long)(Math.pow(z, n)), t_mis;	
			        long z1n = (long)(Math.pow(zn>pow_sum?z-1:z+1,n));		
			        
					if(Math.abs(pow_sum-zn) < Math.abs(pow_sum-z1n)) {
			            t_mis = Math.abs(pow_sum-zn);
			        } else {
			            t_mis = Math.abs(pow_sum-zn);
			            z += 1;
			        }

			        double t_rel = (100.0*t_mis)/pow_sum;	
					if(t_rel<rel_mis) {
			            mis = t_mis;
			            rel_mis = t_rel;
			        }
					System.out.printf("for [ %d^%d + %d^%d <> %d^%d ], the miss is %d and %.6f\n",x,n,y,n,z,n,mis,rel_mis);		
			    }
			}
			sc.close();
		}
	}
}