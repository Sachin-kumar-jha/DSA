
package Recursion;
public class TowerOfHanoi{
public static void towerofHanoi(int n, String src, String help,String Dest){
    if(n==1){
        System.out.println("Disk" + " " + n + " move to  "+""+ Dest+" "+"from"+" "+src);
        return;
    }
    towerofHanoi(n-1, src, Dest,help);
    System.out.println("Disk" +  n + " move to"+ Dest + "from"+src);
    towerofHanoi(n-1, help, src , Dest);
}


    public static void main(String[] args) {
        int n=2;
        towerofHanoi(n, "A", "B","C" );
    }
}