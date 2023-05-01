import static java.lang.Thread.sleep;

public class Parcheggio {
    private int posti;
    private int postiOccupati = 0;
    private boolean parcheggioPieno = false;

    public Parcheggio(int posti) {
        this.posti = posti;
    }

    public void parcheggia(Thread currentThread) {
        
        try {
            
            while (parcheggioPieno) {

                int waitTime = (int) (Math.random() * 10000) + 1;
                System.out.println(currentThread.getName() + " cerca parcheggio per " + waitTime + "ms");
                wait(waitTime);
            }
            
            postiOccupati++;

            if(postiOccupati >= posti)
                parcheggioPieno = true;
    
            int tempoParcheggio = (int) (Math.random() * 5000) + 1;
            System.out.println(currentThread.getName() + " rimarra' parcheggiato per " + tempoParcheggio + "ms");
            sleep(tempoParcheggio);
            postiOccupati--;

            if(postiOccupati < posti)
                parcheggioPieno = false;

            notify();

        } catch (Exception ignored){
            
        }
    }
}