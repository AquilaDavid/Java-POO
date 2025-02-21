package Atividade8;

public class CalculoBalance {
    


    public class Main {
        public static void main(String[] args) {
            String[][] dataSets = {
                {"1001,D,300", "1002,C,200", "1001,D,300"},
                {"1001,D,300", "1002,C,200"}
            };
            
            for (String[] data : dataSets) {
                System.out.println("Balance -> " + balance(data));
            }
        }
    
        public static int balance(String[] transactions) {
            int total = 0;
            for (String t : transactions) {
                String[] parts = t.split(",");
                total += parts[1].equals("D") ? -Integer.parseInt(parts[2]) : Integer.parseInt(parts[2]);
            }
            return total;
        }
    }
    

}
