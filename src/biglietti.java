class Biglietti {
     volatile int nBiglietti = 100;
     volatile int venditoriOccupati = 0;
     int ticketVenduti=0;
     int tickinvenduti=0;
    synchronized private void comprabiglietto(){
        if(nBiglietti>0){
                nBiglietti--;
                venditoriOccupati--;
                ticketVenduti++;
                System.out.println("Sono riuscito a comprare il ticket"+Thread.currentThread().getName());
                notifyAll();
        }
        else{
            tickinvenduti++;
            System.out.println("i biglietti sono andati sold out");
            System.out.println("non sono riuscito a comprare"+Thread.currentThread().getName());
            venditoriOccupati--;
            notifyAll();
        }
    }
    synchronized void entraalbotteghino()  {
        while(venditoriOccupati>5){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        venditoriOccupati++;
        comprabiglietto();

    }

    public int getTicketVenduti() {
        return ticketVenduti;
    }

    public int getTickinvenduti() {
        return tickinvenduti;
    }
}
